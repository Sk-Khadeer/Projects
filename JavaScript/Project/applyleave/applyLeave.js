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
 


// Assuming you're storing the remaining leaves in local storage:
let remainingSickLeaves = parseInt(localStorage.getItem('remainingSickLeaves'));
let remainingCasualLeaves = parseInt(localStorage.getItem('remainingCasualLeaves'));



let token,userEmail,userEmpCode;
// Page Initialization
function initializePage() {
     token = localStorage.getItem('userToken');
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
  
document.addEventListener("DOMContentLoaded", function () {
    initializePage();
    initializeEventListeners();
   
    const leaveTypeSelect = document.getElementById("leaveType");
    const sickInput = document.getElementById("sickInput");
    const casualInput = document.getElementById("casualInput");

    if (remainingSickLeaves === 0) {
        leaveTypeSelect.querySelector("option[value='sick']").remove();
        sickInput.hidden = true;
    }

    if (remainingCasualLeaves === 0) {
        leaveTypeSelect.querySelector("option[value='casual']").remove();
        casualInput.hidden = true;
    }
     // Set the min attribute for startDate and endDate input fields
     let today = new Date().toISOString().split('T')[0];
     document.getElementById("startDate").setAttribute('min', today);
     document.getElementById("endDate").setAttribute('min', today);
    fetchUserLeaveByEmpCode(userEmpCode, token);
    fetchUserProfileByEmail(userEmail, token);
    fetchAppliedLeavesByEmpCode(userEmpCode, token);
});


function fetchUserLeaveByEmpCode(userEmpCode, token) {
    $.ajax({
        url: `http://localhost:8080/getUserLeave?emp_code=${encodeURIComponent(userEmpCode)}`,
        type: "GET",
        headers: {
            'Authorization': 'Bearer ' + token
        },
        success: function (data) {
            populateLeaveDetails(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
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
<div class="col-md-12 text-center py-2"><button class="btn btn-primary" id="applyLeaveBtn">Apply Leave</button></div>
`;

    localStorage.setItem('remainingSickLeaves', leave.remainingSickLeaves);
    localStorage.setItem('remainingCasualLeaves', leave.remainingCasualLeaves);
     let applyLeaveBtn = document.getElementById("applyLeaveBtn");

    if (leave.remainingSickLeaves === 0 && leave.remainingCasualLeaves === 0) {
        applyLeaveBtn.disabled = true;
        applyLeaveBtn.textContent = "No Leaves Remaining";
        applyLeaveBtn.classList.remove('btn-primary');
        applyLeaveBtn.classList.add('btn-secondary');
        applyLeaveBtn.href = 'javascript:void(0);';
    } else {
        applyLeaveBtn.addEventListener('click', function (e) {
            e.preventDefault();
            document.getElementById('leave-details').style.display = 'none';
            document.getElementById('leave-form').style.display = 'block';

            // Handle dropdown or text input display logic
            if (remainingSickLeaves === 0) {
                document.getElementById("leaveType").hidden = true;
                document.getElementById("casualInput").hidden = false;
            } else if (remainingCasualLeaves === 0) {
                document.getElementById("leaveType").hidden = true;
                document.getElementById("sickInput").hidden = false;
            } else {
                document.getElementById("leaveType").hidden = false;
                document.getElementById("sickInput").hidden = true;
                document.getElementById("casualInput").hidden = true;
            }
            fetchUserLeaveByEmpCode(userEmpCode, token);
        });
    }
    updateLeaveOptions(leave.remainingSickLeaves, leave.remainingCasualLeaves);
}


function updateLeaveOptions(sickLeaves, casualLeaves) {
    const leaveTypeSelect = document.getElementById("leaveType");
    const sickInput = document.getElementById("sickInput");
    const casualInput = document.getElementById("casualInput");

    // Reset options first
    sickInput.hidden = true;
    casualInput.hidden = true;
    leaveTypeSelect.hidden = false;
    let sickOption = leaveTypeSelect.querySelector("option[value='sick']");
    let casualOption = leaveTypeSelect.querySelector("option[value='casual']");
    if (!sickOption) {
        let newSickOption = document.createElement("option");
        newSickOption.value = "sick";
        newSickOption.innerText = "Sick Leave";
        leaveTypeSelect.appendChild(newSickOption);
    }
    if (!casualOption) {
        let newCasualOption = document.createElement("option");
        newCasualOption.value = "casual";
        newCasualOption.innerText = "Casual Leave";
        leaveTypeSelect.appendChild(newCasualOption);
    }

    // Then hide options if unavailable
    if (sickLeaves === 0) {
        leaveTypeSelect.querySelector("option[value='sick']").remove();
        sickInput.hidden = true;
    }
    if (casualLeaves === 0) {
        leaveTypeSelect.querySelector("option[value='casual']").remove();
        casualInput.hidden = true;
    }

    if (sickLeaves > 0 && casualLeaves === 0) {
        leaveTypeSelect.hidden = true;
        sickInput.hidden = false;
    }

    if (casualLeaves > 0 && sickLeaves === 0) {
        leaveTypeSelect.hidden = true;
        casualInput.hidden = false;
    }
}

document.querySelector('.btn-cancel-leave').addEventListener('click', function () {
    document.getElementById('leave-form').style.display = 'none';
    document.getElementById('leave-details').style.display = 'block';
});


document.querySelector('.btn-submit-leave').addEventListener('click', function () {
    let hasError = false; // Initialize a flag for errors
let leaveType,startDate,endDate,leaveDays,leaveReason;
if (document.getElementById("leaveType").hidden) { // If dropdown is hidden
    if (!document.getElementById("sickInput").hidden) {
        leaveType = "sick";
    } else if (!document.getElementById("casualInput").hidden) {
        leaveType = "casual";
    }
} else { // If dropdown is visible
    leaveType = document.getElementById("leaveType").value;
    if (!leaveType) {
        document.getElementById("leaveTypeError").textContent = 'Please select a leave type.';
        hasError = true;
    } else {
        document.getElementById("leaveTypeError").textContent = ''; // Clear error message if value exists
    }
}

     startDate = document.getElementById("startDate").value; 
    if (!startDate) {
        document.getElementById("startDateError").textContent = 'Please select a start date.';
        hasError = true;
    } else {
        document.getElementById("startDateError").textContent = '';
    }

     endDate = document.getElementById("endDate").value; 
    if (!endDate) {
        document.getElementById("endDateError").textContent = 'Please select an end date.';
        hasError = true;
    } else {
        document.getElementById("endDateError").textContent = '';
    }

     leaveDays = document.getElementById("leaveDays").value;
    if (!leaveDays) {
        document.getElementById("leaveDaysError").textContent = 'Please enter the number of days.';
        hasError = true;
    } else {
        document.getElementById("leaveDaysError").textContent = '';
    }

     leaveReason = document.getElementById("leaveReason").value;
    if (!leaveReason) {
        document.getElementById("leaveReasonError").textContent = 'Please provide a reason for the leave.';
        hasError = true;
    } else {
        document.getElementById("leaveReasonError").textContent = '';
    }

    if(hasError) {
        return; // Exit function if any error exists
    }
   
    if (document.getElementById("leaveType").hidden) { // If dropdown is hidden
        if (!document.getElementById("sickInput").hidden) {
            leaveType = "sick";
        } else if (!document.getElementById("casualInput").hidden) {
            leaveType = "casual";
        }
    } else { // If dropdown is visible
        leaveType = document.getElementById("leaveType").value;
    }

    if (!leaveType) {
        alert('Please select a type of leave.');
        return;
    }

     startDate = document.getElementById("startDate").value; // Extracting start date
     endDate = document.getElementById("endDate").value;     // Extracting end date

    if (!startDate || !endDate) {
        alert('Please select the start and end dates.');
        return;
    }

    // Ensure the start date is not after the end date
    if (new Date(startDate) > new Date(endDate)) {
        alert('Start date should not be after the end date.');
        return;
    }


    // The rest of your logic
     leaveDays = document.getElementById("leaveDays").value;


    if (!leaveDays || parseInt(leaveDays) <= 0) {
        alert('Please enter a valid number of days greater than zero.');
        return;
    }

     leaveReason = document.getElementById("leaveReason").value;
    let leaveData = {
        empCode: userEmpCode,
        type: leaveType,
        startDate: startDate,
        endDate: endDate,
        days: parseInt(leaveDays),
        reason: leaveReason
    };

    $.ajax({
        url: 'http://localhost:8080/applyLeave',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(leaveData),
        success: function (data) {
             // Refresh the leave details and the applied leaves table immediately after applying leave
             fetchUserLeaveByEmpCode(userEmpCode, token);
             fetchAppliedLeavesByEmpCode(userEmpCode, token);
             
             clearForm();
             document.getElementById('leave-form').style.display = 'none';
             document.getElementById('leave-details').style.display = 'block';
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.error('Error applying for leave:', jqXHR.responseText, textStatus, errorThrown);
            alert('Failed to apply for leave.');
        }
    });
});
function clearForm() {
    document.getElementById("leaveType").selectedIndex = 0; // Set the dropdown back to the default
    document.getElementById("leaveDays").value = "";       // Clear the number of days
    document.getElementById("leaveReason").value = "";     // Clear the reason
    document.getElementById("startDate").value = ""; 
    document.getElementById("endDate").value = ""; 
}


// Fetch applied leaves by employee code
function fetchAppliedLeavesByEmpCode(empCode, token) {
  $.ajax({
      url: `http://localhost:8080/getAppliedLeaves?emp_code=${encodeURIComponent(empCode)}`,
      type: "GET",
      headers: {
          'Authorization': 'Bearer ' + token
      },
      success: function (data) {
        console.log("Received applied leaves:", data);
        if (data.length > 0) {
            populateLeaveRecords(data);
            document.getElementById('leave-actions').style.display = 'block'; // Display the "Leave Actions" section
        } else {
            document.getElementById('leave-actions').style.display = 'none';
        }
    },
      error: function (jqXHR, textStatus, errorThrown) {
          console.log("Error fetching applied leaves:", jqXHR.responseText, textStatus, errorThrown);
      }
  });
}

// Display the leaves and options to approve/reject
function populateLeaveRecords(leaves) {
    console.log("Received leaves data:", leaves); // This will show you the structure of the received data

    let leaveRecordsDiv = document.getElementById("leave-records");

    if (!leaveRecordsDiv) {
        console.error("Unable to find the 'leave-records' element.");
        return;
    }

    leaveRecordsDiv.innerHTML = "";  // Clear previous records

    if (leaves.length === 0) {
        document.getElementById("leave-actions").style.display = "none";
        return;
    } else {
        document.getElementById("leave-actions").style.display = "block";
    }


    leaves.forEach(leave => {
        let row = document.createElement('tr');
        
        row.innerHTML = `
        <td>${leave.id}</td>
        <td>${leave.type}</td>
        <td>${leave.startDate}</td>
        <td>${leave.endDate}</td>
        <td>${leave.days}</td>
        <td>${leave.reason}</td>
        <td >${leave.status}</td>
          <td>
    ${leave.status === 'PENDING' ? `
    <button class="btn btn-success btn-sm" data-empcode="${leave.empCode}" data-id="${leave.id}" onclick="approveLeave('${leave.empCode}','${leave.id}')">Approve</button>
    <button class="btn btn-danger btn-sm" data-empcode="${leave.empCode}" data-id="${leave.id}" onclick="rejectLeave('${leave.empCode }','${leave.id}')">Reject</button>
    ` : ""}
</td>

      `;
      leaveRecordsDiv.appendChild(row);
  });
}
document.getElementById("leave-actions").addEventListener("click", function(event) {
  // Check if the clicked element is an "Approve" button
  if (event.target.classList.contains("btn-success")) {
      let empCode = event.target.getAttribute("data-empcode");
      let id = event.target.getAttribute("data-id");
      approveLeave(empCode,id);
  }
  if (event.target.classList.contains("btn-danger")) {
    let empCode = event.target.getAttribute("data-empcode");
    let startDate = event.target.getAttribute("data-startDate");
    rejectLeave(empCode,startDate);
}
});


// Approve leave by ID
function approveLeave(empCode,id) { 
  $.ajax({
      url: `http://localhost:8080/approveLeave`,
      type: "POST",
      contentType: 'application/json',
      data: JSON.stringify({ empCode: empCode ,id:id}),
      headers: {
          'Authorization': 'Bearer ' + token
      },
      success: function () {       
        alert('Successfully approve the leave!');
           // Update the table row to show "APPROVED"
           let rowToUpdate = document.querySelector(`button[data-id='${id}']`).closest('tr');
           if (rowToUpdate) {
               let statusCell = rowToUpdate.querySelector("td:nth-child(7)"); // Assuming status is the 7th column
               if (statusCell) {
                   statusCell.textContent = "APPROVED";
               }
               // Optionally, hide the action buttons for that row after updating
               let actionCell = rowToUpdate.querySelector("td:nth-child(8)"); // Assuming actions are the 8th column
               if (actionCell) {
                   actionCell.innerHTML = ""; 
               }
           }      
        
    },
      error: function (jqXHR, textStatus, errorThrown) {
          console.error('Error approving leave:', jqXHR.responseText, textStatus, errorThrown);
          alert('Failed to approve leave.');
      }
  });
}

// Reject leave by ID
function rejectLeave(empCode,id) {
  $.ajax({
      url: `http://localhost:8080/rejectLeave`,
      type: "POST",
      contentType: 'application/json',
      data: JSON.stringify({ empCode: empCode ,id:id}),
      headers: {
          'Authorization': 'Bearer ' + token
      },
      success: function () {
          alert('Successfully rejected the leave!');
          fetchUserLeaveByEmpCode(userEmpCode, token);  // Refresh the leave records
          let rowToUpdate = document.querySelector(`button[data-id='${id}']`).closest('tr');
          if (rowToUpdate) {
              let statusCell = rowToUpdate.querySelector("td:nth-child(7)"); // Assuming status is the 7th column
              if (statusCell) {
                  statusCell.textContent = "REJECTED";
              }
              // Optionally, hide the action buttons for that row after updating
              let actionCell = rowToUpdate.querySelector("td:nth-child(8)"); // Assuming actions are the 8th column
              if (actionCell) {
                  actionCell.innerHTML = ""; 
              }
          }      
      },
      error: function (jqXHR, textStatus, errorThrown) {
          console.error('Error rejecting leave:', jqXHR.responseText, textStatus, errorThrown);
        //   alert('Failed to reject leave.');
      }
  });
}

