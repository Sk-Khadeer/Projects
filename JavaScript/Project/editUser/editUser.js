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
    // $(document.body).on("click", closeProfileSidebarOnOutsideClick);
    $("#right-sidebar").on("click", preventEventPropagation);
    attachValidationListeners();
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

function attachValidationListeners() {
    $("#firstname, #lastname, #fathername").blur(validateName);
    $("#phoneno").blur(validatePhone);
    $("#designation, #subDesignation").blur(validateDesignation);
}

function validateName() {
    const regex = /^[a-zA-Z]{1,30}( [a-zA-Z]{1,30})*$/;
    if (!regex.test($(this).val())) {
        $(this).next(".error-message").text("Enter a valid name (each word should have 1-30 characters and alphabets only)");
    } else {
        $(this).next(".error-message").text("");
    }
}

function validatePhone() {
    const regex = /^[0-9]{10}$/;
    if (!regex.test($(this).val())) {
        $(this).next(".error-message").text("Enter a valid phone number of 10 digits.");
    } else {
        $(this).next(".error-message").text("");
    }
}

function validateDesignation() {
    if ($(this).val() === "") {
        $(this).next(".error-message").text("Please select a valid option.");
    } else {
        $(this).next(".error-message").text("");
    }
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

  

  // $("#user-details .btn-edit").on('click', loadEditForm);
  $("#user-details .btn-edit").on('click', function() {
    loadEditForm(employee);
});

}

function loadEditForm(originalEmployee) {
   // Extract the current values from the user details div
   const designations = [
    'IT Director', 'IT Manager', 'Project Manager', 'Software Developer', 'Web Developer', 'Mobile App Developer',
    'Systems Analyst', 'Network Engineer', 'Systems Administrator', 'Cloud Solutions Architect', 'Database Administrator',
    'Data Scientist', 'Machine Learning Engineer', 'Quality Assurance Analyst', 'Technical Support Specialist',
    'Technical Writer', 'Help Desk Technician', 'Security Analyst', 'Cybersecurity Expert', 'DevOps Engineer',
    'Scrum Master', 'Data Analyst', 'Business Intelligence Analyst', 'Business Analyst', 'UX/UI Designer',
    'Product Manager', 'IT Consultant', 'IT Auditor'
];
// document.getElementById("your").innerText="Edit your profile";


  let currentValues = document.getElementById("user-details").querySelectorAll('div');
    let firstName = currentValues[0].textContent.replace("First Name:", "").trim();
    let lastName = currentValues[1].textContent.replace("Last Name:", "").trim();
    let fatherName = currentValues[2].textContent.replace("Father's Name:", "").trim();
    let phoneNo = currentValues[3].textContent.replace("Phone No:", "").trim();
    let email = currentValues[5].textContent.replace("Email:", "").trim();
    let designation = currentValues[6].textContent.replace("Designation:", "").trim();
    let subDesignation = currentValues[7].textContent.replace("Sub Designation:", "").trim();
  


    let designationOptions = designations.map(d => 
      `<option value="${d}" ${designation === d ? 'selected' : ''}>${d}</option>`
  ).join('');
    
  // Now, generate the form using these values
  let userDetailsDiv = document.getElementById("user-details");
  userDetailsDiv.innerHTML = `
        <div class="row">  <!-- No centering class here -->
            <div class="col-md-6 mb-4">
                <label>First Name:</label>
                <input type="text" class="form-control" id="firstname" value="${firstName}" />
                <span class="error-message"></span>
            </div>
            <div class="col-md-6 mb-4">
                <label>Last Name:</label>
                <input type="text" class="form-control" id="lastname" value="${lastName}" />
                <span class="error-message"></span>
            </div>
            <div class="col-md-6 mb-4">
                <label>Father's Name:</label>
                <input type="text" class="form-control" id="fathername" value="${fatherName}" />
                <span class="error-message"></span>
            </div>
            <div class="col-md-6 mb-4">
                <label>Phone No:</label>
                <input type="number" class="form-control" id="phoneno" value="${phoneNo}" />
                <span class="error-message"></span>
            </div>
            <div class="col-md-6 mb-4">
                <label>Email:</label>
                <input type="email" class="form-control" id="email" value="${email}" disabled />
                <span class="error-message"></span>
            </div>
            <div class="col-md-6 mb-4">
                <label>Designation:</label>
                <select class="form-control" id="designation">
                    <option value="">Select a Designation</option>
                    ${designationOptions}
                </select>
                <span class="error-message"></span>
            </div>
            <div class="col-md-6 mb-4" id="subDesignationContainer">
                <label>Sub Designation:</label>
                <select class="form-control" id="subDesignation"></select>
                <span class="error-message"></span>
            </div>
            <div class="col-md-12 py-2 text-center">
                <button class="btn btn-success btn-save">Save</button>
                <button class="btn btn-danger btn-cancel">Cancel</button>
            </div>
        </div>
    `;
      // Clear current subDesignation options
      function updateSubDesignationOptions(selectedValue, isInitialLoad) {
        let options = [];
        switch (selectedValue) {
          case 'Software Developer':
            options = ["FrontEnd", "BackEnd", "FullStack"];
            break;
        case 'Database Administrator':
            options = ["MySQL", "Oracle", "SQL Server"];
            break;
        case 'Cloud Solutions Architect':
            options = ["AWS", "AZURE"];
            break;
        case 'Mobile App Developer':
            options = ["Android", "IOS"];
            break;
        default:
            options = [];
        }

        const subDesignationDropdown = document.getElementById("subDesignation");
        const subDesignationContainer = document.getElementById("subDesignationContainer");
        subDesignationDropdown.innerHTML = '<option value="">Please select an option...</option>';

        if (options.length) {
            subDesignationContainer.style.display = ''; // Show the dropdown and label
            options.forEach(option => {
              let opt = document.createElement('option');
              opt.value = option;
              opt.textContent = option;
              if (isInitialLoad && option === subDesignation) {
                  opt.selected = true;
              }
              subDesignationDropdown.appendChild(opt);
            });
        } else {
          if (isInitialLoad && subDesignation && subDesignation !== "") {
              // If there's a pre-existing subDesignation, show it
              subDesignationDropdown.innerHTML = `<option value="${subDesignation}" selected>${subDesignation}</option>`;
              subDesignationContainer.style.display = ''; // Show the dropdown and label
          } else {
              // If there's no pre-existing subDesignation, hide the dropdown and label
              subDesignationContainer.style.display = 'none';
          }
      }
  }  



    document.getElementById("subDesignationContainer").style.display = "block"; // Always display the subDesignation dropdown initially

      
  // Initially populate subDesignation dropdown based on the current designation value
  updateSubDesignationOptions(designation,true);

  // Add an event listener to update subDesignation dropdown when designation changes
  document.getElementById("designation").addEventListener('change', function() {
      updateSubDesignationOptions(this.value);
  });

  userDetailsDiv.querySelector('.btn-cancel').addEventListener('click', function() {
    event.stopPropagation();
    populateDetails(originalEmployee);
  });

  
$('.btn-save').on('click', function() {
  let updatedEmployee = {
      firstname: $('#firstname').val(),
      lastname: $('#lastname').val(),
      fathername: $('#fathername').val(),
      phoneno: $('#phoneno').val(),
      email: $('#email').val(),
      designation: $('#designation').val(),
      subdesignation: $('#subDesignation').val()
      // Add more fields as necessary
  };

  
    
  let hasEmptyFields = false;
  for (let key in updatedEmployee) {
    
    if (key === 'subdesignation' && $('#subDesignationContainer').css('display') === 'none') {
      continue; // Skip validation for hidden subDesignation
  }

    let inputElement = $(`#${key}`);
    if (!updatedEmployee[key] || updatedEmployee[key].trim() === "") {
      hasEmptyFields = true;
      inputElement.next(".error-message").text("This field cannot be empty.");
    } else if (inputElement.attr("pattern")) {
      let pattern = new RegExp(inputElement.attr("pattern"));
      if (!pattern.test(formData[key])) {
        hasEmptyFields = true;
        inputElement
          .next(".error-message")
          .text(inputElement.attr("title") || "Invalid input.");
      }
    }
  }
  if ($('#subDesignationContainer').css('display') !== 'none' && !$('#subDesignation').val()) {
    hasEmptyFields = true;
    $('#subDesignation').next(".error-message").text("Please select a sub-designation.");
}
  if (hasEmptyFields) { 
    return;
  }
  if (!updatedEmployee.subdesignation || updatedEmployee.subdesignation.trim() === "") {
    updatedEmployee.subdesignation = updatedEmployee.designation;
}

  $.ajax({
      url: `http://localhost:8080/updateByEmail`,
      method: 'PUT',
      contentType: 'application/json',
      data: JSON.stringify(updatedEmployee),
      success: function(response) {
          alert('Successfully updated!');
          // You can then refresh the details view or do other necessary actions
          populateDetails(response);
          // document.getElementById("your").innerText="Your details";
      },
      error: function(error) {
          console.error('Error updating employee:', error);
          alert('Failed to update employee. Please try again.');
      }
  });
});

}
function fetchUserLeaveByEmpCode(userEmpCode, token) {
  $.ajax({
      url: `http://localhost:8080/getUserLeave?emp_code=${encodeURIComponent(userEmpCode)}`,
      type: "GET",
      headers: {
          'Authorization': 'Bearer ' + token
      },
      success: function(data) {
        
          populateLeaveDetails(data);
      },
      error: function(jqXHR, textStatus, errorThrown) {
          console.log("Error fetching user leave:", jqXHR.responseText, textStatus, errorThrown);
      }
  });
}

function populateLeaveDetails(leave) {
  let leaveDetailsDiv = document.getElementById("leave-details");
  leaveDetailsDiv.innerHTML = `
      <div class="col-md-12 text-center py-2"><strong>Leave ID:</strong> ${leave.leaveId}</div>
      <div class="col-md-12 text-center py-2"><strong>Employee Code:</strong> ${leave.empCode}</div>
      <div class="col-md-12 text-center py-2"><strong>Sick Leave:</strong> ${leave.totalSickLeave}</div>
      <div class="col-md-12 text-center py-2"><strong>Casual Leave:</strong> ${leave.totalCasualLeave}</div>
      <div class="col-md-12 text-center py-2"><strong>Remaining Sick Leaves:</strong> ${leave.remainingSickLeaves}</div>
      <div class="col-md-12 text-center py-2"><strong>Remaining Casual Leaves:</strong> ${leave.remainingCasualLeaves}</div>
      <div class="col-md-12 text-center py-2"><a href="applyleave.html" class="btn btn-primary" id="applyLeaveBtn">Apply Leave</a></div>
      `;


      localStorage.setItem('remainingSickLeaves', leave.remainingSickLeaves);
localStorage.setItem('remainingCasualLeaves', leave.remainingCasualLeaves);

      let applyLeaveBtn = document.getElementById("applyLeaveBtn");

      if(leave.remainingSickLeaves === 0 && leave.remainingCasualLeaves === 0) {
        applyLeaveBtn.disabled = true;
        applyLeaveBtn.textContent = "No Leaves Remaining";
        applyLeaveBtn.classList.remove('btn-primary');
        applyLeaveBtn.classList.add('btn-secondary');
        applyLeaveBtn.href = 'javascript:void(0);';
    } else {
        // If you want to reset the href when leaves are available
        applyLeaveBtn.href = 'applyleave.html';
    }
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
  fetchUserProfileByEmail(userEmail, token);
  fetchUserLeaveByEmpCode(userEmpCode, token);
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
