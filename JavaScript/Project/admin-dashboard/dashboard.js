document.getElementById("menuToggle").addEventListener("click", function (event) {
  toggleSidebar();
  event.stopPropagation();
});

let userEmail;

$(document).ready(function() {
let token = localStorage.getItem('userToken');

if (!token) {
window.location.href = '../login/login.html';  // If no token, redirect to login
return;
}

userEmail = localStorage.getItem('userEmail');

if(!userEmail) {
console.error("User email not found in local storage.");
return;
}

// Setup event listener for profile icon click
document.getElementById("profileIcon").addEventListener("click", function(event) {
event.preventDefault();

// Fetch user profile and update the sidebar
fetchUserProfile(token, userEmail);  // Pass userEmail to the function

toggleProfileSidebar();
event.stopPropagation();
});

});

function fetchUserProfile(token, userEmail) {  // Add userEmail as a parameter
$.ajax({
url: "http://localhost:8080/getUserProfile?email=" + encodeURIComponent(userEmail), // Use userEmail
type: "GET",
headers: {
    'Authorization': 'Bearer ' + token
},
success: function(data) {
    document.getElementById("profileEmail").textContent = data.email;
    document.getElementById("profileName").textContent = data.firstname;
    document.getElementById("profilePhone").textContent = data.phoneno;
    console.log(data.email);
},
error: function(jqXHR, textStatus, errorThrown) {
    console.log("Error fetching user profile:", jqXHR.responseText, textStatus, errorThrown);
}
});
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

$(document).ready(function () {
  $('#searchInput').on('input', function () {
    const firstname = $(this).val().trim(); // Trim whitespace from input
    if (firstname.length >= 1) { // Check if there's at least one character
      fetchEmployeesByFirstname(firstname);
    } else {

      fetchAllEmployees();
    }
  });
});

function fetchEmployeesByFirstname(firstname) {
  $.ajax({
    url: `http://localhost:8080/search?firstname=${firstname}`,
    type: "GET",
    success: function (data) {
      populateTable(data);
    }
  });
}

function fetchAllEmployees() {
  $.ajax({
    url: "http://localhost:8080/getEmployees",
    type: "GET",
    success: function (data) {
      if (data && data.length > 0) {
        populateTable(data);
        console.log(data);
        document.querySelector("table thead").style.display = 'table-header-group'; // Show table headers if there's data
      } else {
        showTableMessage("No records found.");
      }
    },
    error: function (jqXHR, textStatus, errorThrown) {
      console.log("Error details:", jqXHR.responseText, textStatus, errorThrown);
      showMessage("Server Error. Please try again later.");
      hideElement('searchForm');
      hideElement('tableHeader');
    }
    });
}

function showTableMessage(message) {
  let tableBody = document.querySelector("tbody");
  tableBody.innerHTML = `<tr><td colspan='12' class='text-center'>${message}</td></tr>`;
  // Hide table headers
  document.querySelector("table thead").style.display = 'none';
}

function hideElement(elementId) {
  document.getElementById(elementId).style.display = 'none';
}

function showElement(elementId) {
  document.getElementById(elementId).style.display = '';
}

function showMessage(message) {
  let tableBody = document.querySelector("tbody");
  tableBody.innerHTML = `<tr><td colspan='12' class='text-center'>${message}</td></tr>`;
}

function resetUI() {
  showElement('searchForm');
  showElement('tableHeader');
}

function populateTable(employees) {
  resetUI();

  let tableBody = document.querySelector("tbody");
  tableBody.innerHTML = "";

  let adminRecord = null;
  let otherRecords = [];

  employees.forEach((employee) => {
      if (employee.email === userEmail) {
          adminRecord = employee;
      } else {
          otherRecords.push(employee);
      }
  });

  if (adminRecord) {
      let row = document.createElement("tr");
      row.innerHTML = `
          <td>${adminRecord.firstname}</td>
          <td>${adminRecord.lastname}</td>
          <td>${adminRecord.fathername}</td>
          <td>${adminRecord.phoneno}</td>
          <td>********</td>
          <td>${adminRecord.email}</td>
          <td>${adminRecord.designation}</td>
          <td>${adminRecord.subdesignation}</td>
          <td>${adminRecord.dob}</td>
          <td>${adminRecord.gender}</td>
          <td>${adminRecord.pincode}</td>
          <td><button class="btn btn-info" disabled>You are the admin</button></td>
      `;
      tableBody.appendChild(row);
  }

  otherRecords.forEach((employee) => {
      let row = document.createElement("tr");
      let deleteButton = `<button class="btn btn-danger" onclick="deleteEmployee('${employee.email}')">Delete</button>`;
      row.innerHTML = `
          <td>${employee.firstname}</td>
          <td>${employee.lastname}</td>
          <td>${employee.fathername}</td>
          <td>${employee.phoneno}</td>
          <td>********</td>
          <td>${employee.email}</td>
          <td>${employee.designation}</td>
          <td>${employee.subdesignation}</td>
          <td>${employee.dob}</td>
          <td>${employee.gender}</td>
          <td>${employee.pincode}</td>
          <td>${deleteButton}</td>
      `;
      tableBody.appendChild(row);
  });

  if (employees.length === 0) {
      showMessage("No record found");
      hideElement('searchForm');
      hideElement('tableHeader');
  }
}

function deleteEmployee(employeeEmail) {
  $.ajax({
    url: `http://localhost:8080/deleteEmployee/${encodeURIComponent(employeeEmail)}`,
    type: "DELETE",
    success: function (data) {
      console.log("deleted");
      // After successful deletion, fetch the updated list of employees

      fetchAllEmployees();
    },
    error: function (jqXHR, textStatus, errorThrown) {
      console.log("Error details:", jqXHR.responseText, textStatus, errorThrown);
    }
  });
}

function logout() {
  // Clear local storage or cookies if necessary
  // localStorage.removeItem("userToken");

  // Redirect to the login page
  console.log("login");
  window.location.href = "../login/login.html";
}

document.addEventListener("DOMContentLoaded", function () {
  fetchAllEmployees(); // Load all employees on initial page load
});
window.onload = fetchAllEmployees;

document.addEventListener("DOMContentLoaded", function () {
  let logoutButton = document.getElementById("logoutButton");

  if (logoutButton) {
    logoutButton.addEventListener("click", function (event) {
      event.preventDefault();
      logout();
    });
  } else {
    console.error("Logout button not found!");
  }
});
