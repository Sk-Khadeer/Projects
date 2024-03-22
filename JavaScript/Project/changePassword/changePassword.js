
// DOM Loaded and Event Listeners
let token,userEmpCode,userEmail,profileSrc, currentPasswordValidated = "";;
document.addEventListener("DOMContentLoaded", function() {
    initializeEventListeners();
    initializePage();
});

// Page Initialization
function initializePage() {
     token = localStorage.getItem('userToken');
    verifyToken(token);
    userEmail = localStorage.getItem('userEmail');
    verifyEmail(userEmail);
    userEmpCode = localStorage.getItem('userEmpCode');
  verifyEmpCode(userEmpCode);
     profileSrc = document.getElementById('profileImage').src;
    setProfileImage(profileSrc);
    fetchUserProfileByEmail(userEmail, token);
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
  

function initializeEventListeners() {
    $("#profileLogoutButton").on("click", logout);
    $("#profileIcon").on("click", toggleProfileSidebar);
    // $(document.body).on("click", closeProfileSidebarOnOutsideClick);
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
  function fetchUserProfileByEmail(userEmail, token) {
    $.ajax({
      url: `http://localhost:8080/getUserProfile?email=${encodeURIComponent(userEmail)}`,
      type: "GET",
      headers: {
        'Authorization': 'Bearer ' + token
      },
      success: function(data) {
        // console.log(data);
        $("#profileName").text(data.firstname);
        $("#profileEmail").text(data.email);
        $("#profilePhone").text(data.phoneno);
        if (data.profileImage) {
          setProfileImage("data:image/png;base64," + data.profileImage);  // This will display the image and update the link text accordingly
          $("#addProfileImageLink").text("Edit Image");
        } else {
          setProfileImage(null);  // Show default image and "Add Image" link
      }
      
    
        populateDetails(data);
        setProfileImage($("#profileImage").attr("src"));
        
      },
      error: function(jqXHR, textStatus, errorThrown) {
        console.log("Error fetching user profile:", jqXHR.responseText, textStatus, errorThrown);
      }
    });
  }
  function populateDetails(employee) {
    let userDetailsDiv = document.getElementById("user-details");
    userDetailsDiv.innerHTML = `
        <div class="col-md-12 text-center  py-2"><strong>First Name:</strong> ${employee.firstname}</div>
        <div class="col-md-12 text-center py-2"><strong>Last Name:</strong> ${employee.lastname}</div>
        <div class="col-md-12  text-center py-2"><strong>Father's Name:</strong> ${employee.fathername}</div>
        
        <div class="col-md-12  text-center   py-2"><strong>Phone No:</strong> ${employee.phoneno}</div>
        <div class="col-md-12  text-center  py-2"><strong>Password:</strong> ********</div>
        <div class="col-md-12  text-center  py-2"><strong>Email:</strong> <span class="email-field">${employee.email}</span></div>
        
        <div class="col-md-12  text-center  py-2"><strong>Designation:</strong> ${employee.designation}</div>
        <div class="col-md-12  text-center  py-2"><strong>Sub Designation:</strong> ${employee.subdesignation}</div>
        <div class="col-md-12  text-center  py-2"><strong>DOB:</strong> ${employee.dob}</div>
        
        <div class="col-md-12  text-center  py-2"><strong>Gender:</strong> ${employee.gender}</div>
        <div class="col-md-12  text-center   py-2"><strong>Pincode:</strong> ${employee.pincode}</div>
        
        <div class="col-md-12  text-center  py-2 "><button class="btn btn-primary btn-edit">Edit</button></div>
    `;
  
  }

  $(document).ready(function(){
    const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

    function validateInput(inputField, errorMessageField) {
        if (!regex.test($(inputField).val())) {
            $(errorMessageField).text("Must contain at least one number, one uppercase, one lowercase letter, one special character, and at least 8 or more characters");
        } else {
            $(errorMessageField).text("");
        }
    }

   
    
    $("#currentPassword").on("input", function () {
        $("#currentPassword").css("border", "");  // Reset border color
        $("#currentPasswordError").text("");  // Clear the error message

        validateInput(this, "#currentPasswordError");
    });


    $("#newPassword").on("input", function () {
        $("#newPassword").css("border", "");  // Reset border color
        $("#ReenterPasswordError").text("");  // Clear the error message

        // Check if the entered password matches the regex
        if (!regex.test($(this).val())) {
            $("#newPasswordError").text("Must contain at least one number, one uppercase, one lowercase letter, one special character, and at least 8 or more characters");
            $("#reEnterPassword").prop("disabled", true);
        } else if ($(this).val() === currentPasswordValidated) {   // Check if it's the same as the current password
            $("#newPasswordError").text("New password cannot be the same as the current password.");
            $("#reEnterPassword").prop("disabled", true);
        } else {
            $("#newPasswordError").text("");
            $("#reEnterPassword").prop("disabled", false);
        }
    });

    $("#reEnterPassword").on("input", function () {
        $("#reEnterPassword").css("border", "");  // Reset border color
        $("#ReenterPasswordError").text("");  // Clear the error message
    });


    $(".toggle-password").click(function () {
        let input = $($(this).attr("toggle"));
        if (input.attr("type") === "password") {
            input.attr("type", "text");
            $(this).removeClass("fa-eye").addClass("fa-eye-slash");
        } else {
            input.attr("type", "password");
            $(this).removeClass("fa-eye-slash").addClass("fa-eye");
        }
    });

    $("#submit").click(function () {
        var changePassword = $("#currentPassword").val();

        $.ajax({
            url: "http://localhost:8080/changePassword",
            type: "POST",
            data: JSON.stringify({
                email: userEmail,
                password: changePassword
            }),
            contentType: "application/json",
            success: function (response) {
                console.log(response);
                if (response.status === "Password is correct") {
                    // Update the card title and description
                    $(".card-body .card-title").text("Create a new Password").addClass("text-center");
                    currentPasswordValidated = $("#currentPassword").val();
                    $("#currentPasswordDiv").hide();
                    $("#submit").hide();
                    $("#updatePasswordFields").show();  // Show the new password and re-enter password fields
                } else {
                    $("#currentPassword").css("border", "1px solid red").val('');  // Set the input border to red and clear the input value
                    $("#currentPasswordError").text("Incorrect password! Please re-enter.");  // Display error message below the input field
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Server error: " + jqXHR.responseText);
            }
        });
    });


    $("#updatePasswordButton").click(function () {
        var newPassword = $("#newPassword").val();
        var reEnterPassword = $("#reEnterPassword").val();

        // Clear previous error indications
        $("#newPassword").css("border", "");
        $("#reEnterPassword").css("border", "");
        $("#newPasswordError").text("");

        // Basic validation: check if passwords match and are not empty
        if (newPassword !== reEnterPassword) {

            $("#reEnterPassword").css("border", "1px solid red").val('');  // Set the input border to red and clear the input value
            $("#ReenterPasswordError").text("Passwords do not match!");  // Display error message below the input field
            return;
        }


        if (!newPassword || !reEnterPassword) {
            $("#newPassword").css("border", "1px solid red");  // Set the input border to red if newPassword is empty
            $("#reEnterPassword").css("border", "1px solid red");  // Set the input border to red if reEnterPassword is empty
            $("#newPasswordError").text("Please fill in both password fields.");  // Display error message below the input field
            return;
        }

        // Send the data to your Java backend
        $.ajax({
            url: "http://localhost:8080/updatePassword",
            type: "POST",
            data: JSON.stringify({
                email: userEmail,
                newPassword: newPassword
            }),
            contentType: "application/json",
            success: function (response) {
                if (response.status === "success") {
                    alert("Password updated successfully!");
                    window.location.href = "../login/login.html"; // redirect to login page or wherever you like
                } else {
                    $("#newPassword").css("border", "1px solid red").val('');  // Set the input border to red and clear the input value
                    $("#ReenterPasswordError").text("Error updating password: " + response.message);  // Display error message below the input field
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Server error: " + jqXHR.responseText);
            }
        });
    });

});