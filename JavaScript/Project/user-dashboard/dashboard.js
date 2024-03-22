// Declarations
let userEmail, userEmpCode;

// DOM Loaded and Event Listeners
document.addEventListener("DOMContentLoaded", function() {
    initializeEventListeners();
    initializePage();
});

function initializeEventListeners() {
    $("#profileLogoutButton").on("click", logout);
    $("#profileIcon").on("click", toggleProfileSidebar);
    $("#right-sidebar").on("click", preventEventPropagation);
    $("#addProfileImageLink").on("click", initiateImageUpload);
    $("#menuToggle").on("click", toggleSidebar);
}

// Utility and Helper Functions
function logout() {
    localStorage.removeItem('userToken');
    localStorage.removeItem('userEmail');
    localStorage.removeItem('userRole');
    localStorage.removeItem('userEmpCode');
    localStorage.removeItem('firstname');
    window.location.href = "../login/login.html";
}

function toggleProfileSidebar() {
    let sidebar = $("#right-sidebar");
    if (sidebar.css('right') === "0px") {
        sidebar.css('right', '-250px');
    } else {
        sidebar.css('right', '0');
    }
}


document.addEventListener("click", function (event) {
  let leftSidebar = document.getElementById("sidebar");
  let rightSidebar = document.getElementById("right-sidebar");

  if (!leftSidebar.contains(event.target) && !document.getElementById("menuToggle").contains(event.target) && document.body.classList.contains("sidebar-open")) {
    toggleSidebar();
  }

  if (!rightSidebar.contains(event.target) && !document.getElementById("profileIcon").contains(event.target) && rightSidebar.style.right === "0px") {
    toggleProfileSidebar();
  }
});

function toggleSidebar() {
  let body = document.body;
  if (body.classList.contains("sidebar-open")) {
    body.classList.remove("sidebar-open");
  } else {
    body.classList.add("sidebar-open");
  }
}

function toggleProfileSidebar() {
  let sidebar = document.getElementById("right-sidebar");
  if (sidebar.style.right === "0px" || sidebar.style.right === "") {
    sidebar.style.right = "-250px";
  } else {
    sidebar.style.right = "0";
  }
}

function preventEventPropagation(event) {
    event.stopPropagation();
}

// Image Handling
function setProfileImage(imageSrc) {
  const profileImage = document.getElementById('profileImage');
  const defaultProfileIconContainer = document.getElementById('defaultProfileIconContainer');
  const addProfileImageLink = document.getElementById('addProfileImageLink');

  if (imageSrc && imageSrc.startsWith('data:image')) {  // checking if it's a base64 image
      profileImage.src = imageSrc;
      profileImage.style.display = "block";
      defaultProfileIconContainer.style.display = "none";
      addProfileImageLink.textContent = "Edit Image";  // Change link text to 'Edit Image'
      addProfileImageLink.style.display = "block";  // ensure the link is visible
  } else {
    profileImage.src = ''; 
      profileImage.style.display = "none";
      defaultProfileIconContainer.style.display = "block";
      addProfileImageLink.textContent = "Add Image";  // Change link text to 'Add Image'
      addProfileImageLink.style.display = "block";  // ensure the link is visible
  }
}

function initiateImageUpload(event) {
  event.preventDefault();
  $('<input type="file" accept="image/*">').on("change", function() {
      uploadProfileImage(this.files[0]);
  }).click(); 
}
function uploadProfileImage(file) {
  let userEmail = localStorage.getItem('userEmail');
  
  if (!userEmail) {
      console.error("User email not found in local storage.");
      alert("User email not found. Please log in again.");
      return;
  }

  // Compress the image using Compressor.js before sending
  new Compressor(file, {
    quality: 0.6, // The compression quality, range from 0 to 1 (1 means original quality)
    success(result) {
      let formData = new FormData();
      formData.append("file", result, result.name);
      formData.append("email", userEmail); // Add email to the form data

      $.ajax({
        url: "http://localhost:8080/uploadImage",
        type: "POST",
        data: formData,
        processData: false,
        contentType: false,
        success: function(data) {
           const uploadedImageSrc = "data:image/png;base64," + data.profileImage;
    setProfileImage(uploadedImageSrc); // Use the setProfileImage function to update the display
    $("#addProfileImageLink").text("Edit Image");
          $("#profileImage").attr("src", URL.createObjectURL(result)); // Display the compressed image instantly
          // Display the compressed image instantly
          $("#addProfileImageLink").hide();
            
          // Add or Modify this section
          $("#addProfileImageLink").text("Edit Image"); // Changing the text to 'Edit Image'
          $("#addProfileImageLink").show(); // 
        },
        error: function(jqXHR, textStatus, errorThrown) {
          console.error("Error uploading profile image:", jqXHR.responseText, textStatus, errorThrown);
          alert("Failed to upload image. Please try again.");
        }
      });
    },
    error(err) {
      console.error(err.message);
      alert("Error compressing image. Please try a different image.");
    },
  });
}


// Data Fetching and Populating
function fetchUserProfileByEmail(userEmail, token,callback) {
  $.ajax({
    url: `http://localhost:8080/getUserProfile?email=${encodeURIComponent(userEmail)}`,
    type: "GET",
    headers: {
      'Authorization': 'Bearer ' + token
    },
    success: function(data) {
      if (typeof callback === 'function') {
          callback(data);
          console.log(data);
      } else {
          console.error('Expected callback to be a function but got:', callback);
      }
  },
    error: function(jqXHR, textStatus, errorThrown) {
      console.log("Error fetching user profile:", jqXHR.responseText, textStatus, errorThrown);
    }
  });
}




// Page Initialization
function initializePage() {
  let token = localStorage.getItem('userToken');
  verifyToken(token);
  userEmail = localStorage.getItem('userEmail');
  verifyEmail(userEmail);
  userEmpCode = localStorage.getItem('userEmpCode');
  verifyEmpCode(userEmpCode);
  let profileSrc = document.getElementById('profileImage').src;
  setProfileImage(profileSrc);
  // Add event listener for the attendance button


  let today = new Date().toISOString().split('T')[0];
  document.getElementById("attendanceDate").setAttribute('min', today);
  document.getElementById("attendanceDate").setAttribute('max', today);
  document.getElementById("attendanceDate").setAttribute('value', today);

  document.getElementById("attendanceBtn").addEventListener("click", handleAttendance);
// document.getElementById("attendanceInBtn").addEventListener("click", markAttendance);
  // validateAttendanceButton();
  displayAttendanceHistory();

}

function handleAttendance() {
  const dateInput = document.getElementById("attendanceDate");
  const attendanceBtn = document.getElementById("attendanceBtn");

  const selectedDate = dateInput.value;
  const currentButtonText = attendanceBtn.innerText;

  const currentTime = new Date().toISOString(); // Capture the current time
  const userEmail = localStorage.getItem('userEmail');
  if (currentButtonText === "In") {
      // Save the login time
      markAttendance(selectedDate, "In", currentTime, null,userEmail); 
      attendanceBtn.innerText = "Out";
  } else if (currentButtonText === "Out") {
      // Save the logout time
      markAttendance(selectedDate, "Out", null, currentTime);
      attendanceBtn.innerText = "In";
  }
}

function markAttendance(date, status, login, logout,email) {
  // Your existing AJAX logic to save the attendance goes here
  $.ajax({
      url: `http://localhost:8080/markAttendance`,
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify({
          date: date,
          status: status,
          employee_email: email,
          login: login,  // Login timestamp
          logout: logout  // Logout timestamp
      }),
      headers: {
          'Authorization': 'Bearer ' + localStorage.getItem('userToken')
      },
      success: function(response) {
          alert("Attendance marked successfully!");
          displayAttendanceHistory();
      },
      error: function(jqXHR, textStatus, errorThrown) {
          console.error("Error marking attendance:", jqXHR.responseText, textStatus, errorThrown);
          alert("Failed to mark attendance. Please try again.");
      }
  });
}

// Add this function to validate the time window
function validateAttendanceButton() {
  const currentHour = new Date().getHours();
  const currentMinutes = new Date().getMinutes();
  const btn = document.getElementById("attendanceInBtn");
  if (currentHour === 16 && currentMinutes <= 50) {
      btn.removeAttribute("disabled");
  } else {
      btn.setAttribute("disabled", "disabled");
  }
  console.log("validateAttendanceButton function called."); // 
}

// // Add this function to handle the button click and send data to the backend
// function markAttendance() {
//   const userEmail = localStorage.getItem('userEmail');
//   const currentDate = new Date().toDateString();
//   $.ajax({
//     url: `http://localhost:8080/markAttendance`,
//     type: "POST",
//     contentType: "application/json",
//     data: JSON.stringify({
//         date: currentDate,
//         status: "Present",
//         userEmail:userEmail
//     }),
//     headers: {
//         'Authorization': 'Bearer ' + localStorage.getItem('userToken')
//     },
//     success: function(response) {
//         alert("Attendance marked successfully!");
//         displayAttendanceHistory();
//     },
//     error: function(jqXHR, textStatus, errorThrown) {
//         console.error("Error marking attendance:", jqXHR.responseText, textStatus, errorThrown);
//         alert("Failed to mark attendance. Please try again.");
//     }
// });

// }
function displayAttendanceHistory() {
  const userEmail = localStorage.getItem('userEmail');
  const token = localStorage.getItem('userToken');

  if (!userEmail || !token) {
      console.error("Missing user email or token in local storage.");
      return;
  }

  $.ajax({
      url: `http://localhost:8080/history`,
      type: "GET",
      headers: {
          'Authorization': 'Bearer ' + token, 'userEmail': userEmail
      },
      data:{userEmail:userEmail},
      success: function(data) {
          const tableBody = $("#attendanceHistory");
          tableBody.empty(); // Clear existing rows

          data.forEach(record => {
              tableBody.append(`
                  <tr>
                      <td>${record.date}</td>
                      <td>${record.status}</td>
                  </tr>
              `);
          });
      },
      error: function(jqXHR, textStatus, errorThrown) {
          console.error("Error fetching attendance history:", jqXHR.responseText, textStatus, errorThrown);
          alert("Failed to fetch attendance history. Please try again.");
      }
  });
}






function verifyToken(token) {
  if (!token) {
      alert('Please login first.');
      window.location.href = '../login/login.html';
      return;
  }
}

function verifyEmail(email) {
  if (!userEmail) {
      console.error("User email not found in local storage.");
      return;
  }
}

function verifyEmpCode(empCode) {
  if (!userEmpCode) {
      console.error("User empcode not found in local storage.");
      return;
  }
}
// When the document is ready
$(document).ready(function() {
    
  // Fetching profile data
  const userEmail = localStorage.getItem('userEmail');
    const token = localStorage.getItem('userToken');

    if (!userEmail || !token) {
        console.error("Missing user email or token in local storage.");
        return;
    }

    fetchUserProfileByEmail(userEmail, token, function(data) {
        // Update the UI with the user data here.
        $("#profileName").text(data.firstname);
        $("#profileEmail").text(data.email);
        $("#profilePhone").text(data.phoneno);
        
        if (data.profileImage) {
            setProfileImage("data:image/png;base64," + data.profileImage);  // This will display the image and update the link text accordingly
            $("#profileImage").text("Edit Image");
        } else {
            setProfileImage(null);  // Show default image and "Add Image" link
        }

        // populateDetails(data);
        setProfileImage($("#profileImage").attr("src"));
    });

  // function populateUserProfile() {
  //     const userData = fetchUserProfileByEmail();
      
  //     $('#profileNameDashboard').text(userData.name);
  //     $('#profilePosition').text(userData.position);
  //     $('#profileEmailDashboard').text(userData.email);
  //     $('#profilePhoneDashboard').text(userData.phone);
      
  //     // Check if there's a valid image URL before assigning to prevent broken images
  //     if (userData.profileImage) {
  //         $('#profileImageDashboard').attr('src', userData.profileImage);
  //     }
  // }
  
  // // Fetch notifications (simulated for the sake of this example)
  // function fetchNotifications() {
  //     return [
  //         "Your leave request has been approved.",
  //         "Your recent report received a positive feedback.",
  //         "Team meeting scheduled for tomorrow at 3 PM."
  //     ];
  // }
  
  // function populateNotifications() {
  //     const notifications = fetchNotifications();
  //     notifications.forEach(notification => {
  //         const listItem = $('<li>', {
  //             class: 'list-group-item',
  //             text: notification
  //         });
  //         $('.list-group').append(listItem);
  //     });
  // }
  
  // // Event handler for Quick Actions
  // $('.btn-primary').on('click', function() {
  //     alert('Submitting report...');
  //     // Add logic here
  // });
  
  // $('.btn-success').on('click', function() {
  //     alert('Redirecting to leave request page...');
  //     // Add logic here like redirecting to a specific page
  //     // window.location.href = '/leave-request-url';
  // });
  
  // $('.btn-info').on('click', function() {
  //     alert('Redirecting to schedule meeting page...');
  //     // Add logic here
  // });
  
  // // Call the functions to populate data
  // populateUserProfile();
  // populateNotifications();
 
});

