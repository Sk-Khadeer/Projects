$(document).ready(function () {
//radio button for role check and uncheck
  $('input[type=radio][name=role]').on('click', function() {
    // Check if the radio button was previously checked
    if ($(this).hasClass('checked')) {
        $(this).prop('checked', false);
        $(this).removeClass('checked');
    } else {
        // Add checked class to the radio button
        $('input[type=radio][name=role]').removeClass('checked');
        $(this).addClass('checked');
    }
});


  // First name validation
  $("#firstname, #lastname, #fathername").on("input", function () {
    const regex = /^[a-zA-Z\s]{1,30}$/;
    if (!regex.test($(this).val())) {
        $(this)
            .next(".error-message")
            .text("Enter a valid name (each word should have 1-30 characters and alphabets only)");
    } else {
        $(this).next(".error-message").text("");
    }
});


  // Phone number validation

  
  $("#phoneno").on("input", function () {
    const regex = /^\d{10}$/;
    if (!regex.test($(this).val())) {
      $(this)
        .next(".error-message")
        .text("Enter a valid 10-digit phone number");
    } else {
      $(this).next(".error-message").text("");
    }
  });
  $("#confirmPassword").prop("disabled", true);

  const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

  $("#password").on("input", function () {

      // Check if the entered password matches the regex
      if (!regex.test($(this).val())) {
          $("#passwordError").text("Must contain at least one number, one uppercase, one lowercase letter, one special character, and at least 8 or more characters");
          $("#confirmPassword").prop("disabled", true);
      } else {
          $("#passwordError").text("");
          $("#confirmPassword").prop("disabled", false);
      }

  });

  

  // Email validation
  $("#email").on("input", function () {
    const regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (!regex.test($(this).val())) {
      $(this).next(".error-message").text("Enter a valid email address");
    } else {
      $(this).next(".error-message").text("");
    }
  });

  // Till Current Date
  let today = new Date().toISOString().split("T")[0];
  $("#dob").attr("max", today);

  // Date validation
  $("#dob").on("blur", function () {
    const selectedDate = new Date($(this).val());
    const today = new Date();

    if (selectedDate > today) {
      $(this)
        .next(".error-message")
        .text("Date of birth cannot be in the future.");
    } else {
      $(this).next(".error-message").text("");
    }
  });

  // Pincode validation
  $("#pincode").on("blur", function () {
    const regex = /^\d{6}$/;
    if (!regex.test($(this).val())) {
      $(this).next(".error-message").text("Enter a valid 6-digit pincode");
    } else {
      $(this).next(".error-message").text("");
    }
  });
  // SUB Designation validation

  $("#subDesignation").on("change", function () {
    // Only validate if subDesignation is visible
    if ($(this).is(":visible")) {
      if ($(this).val() === "") {
        $(this).next(".error-message").text("Sub Designation is mandatory.");
      } else {
        $(this).next(".error-message").text("");
      }
    } else {
      // Clear any error messages if subDesignation is not visible
      $(this).next(".error-message").text("");
    }
  });

  // Designation validation
  $("#designation").on("change", function () {
    if ($(this).val() === "") {
      $(this).next(".error-message").text("Please select a valid designation.");
    } else {
      $(this).next(".error-message").text("");
    }
  });

  $("#designation").change(function () {
    var selectedValue = $(this).val();
    var options = [];

    // Clear current options
    $("#subDesignation")
      .empty()
      .append(new Option("Please select an option...", "", true, true))
      .hide();
    $("#subDesignationLabel").hide();

    if (selectedValue === "Software Developer") {
      options = ["FrontEnd", "BackEnd", "FullStack"];
    } else if (selectedValue === "Database Administrator") {
      options = ["MySQL", "Oracle", "SQL Server"];
    } else if (selectedValue === " Cloud Solutions Architect") {
      options = ["AWS", "AZURE"];
    } else if (selectedValue === "Mobile APP Developer") {
      options = ["Android", "IOS"];
    }

    // Generate options based on the selected designation
    if (options.length > 0) {
      for (var i = 0; i < options.length; i++) {
        $("#subDesignation").append(new Option(options[i], options[i]));
      }
      $("#subDesignation, #subDesignationLabel").show();
    }
  });

  // On form submission
  $("#submit").on("click", function (e) {
    // Trigger blur to ensure all fields are validated
    $("input").blur();

    // Check if there are any errors
    let hasError = false;
    $(".error-message").each(function () {
      if ($(this).text() !== "") {
        hasError = true;
      }
    });

    if (hasError) {
      e.preventDefault(); // prevent form submission
      alert("Please fix the errors before submitting.");
    }
  });
});

// password visible and hide
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

// Auto-fetch and populate state and district based on pincode
$("#pincode").on("input", function () {
  if ($(this).val().length === 6) {
    createTextFields();

    $.getJSON(
      "https://api.postalpincode.in/pincode/" + $(this).val(),
      function (data) {
        if (data[0].PostOffice && data[0].PostOffice.length) {
          $("#district").val(data[0].PostOffice[0].District);
          $("#state").val(data[0].PostOffice[0].State);
        } else {
          alert("Enter a valid pincode");
          $("#addressRow").remove();
        }
      }
    );
  } else {
    $("#addressRow").remove();
  }
});

function createTextFields() {
  if (!$("#district").length && !$("#state").length) {
    let addressRow = `
            <div id="addressRow" class="row">
                <div class="col-md-6 mb-4">
                    <div class="form-outline">
                        <label class="form-label" for="district">District</label>
                        <input type="text" id="district" class="form-control form-control-lg" name="district" disabled />
                    </div>
                </div>
                <div class="col-md-6 mb-4">
                    <div class="form-outline">
                        <label class="form-label" for="state">State</label>
                        <input type="text" id="state" class="form-control form-control-lg" name="state" disabled />
                    </div>
                </div>
            </div>`;
    $(addressRow).insertAfter($("#pincode").closest(".row"));
  }
}

// Handle form submission
$("#registrationForm").on("submit", function (e) {
  e.preventDefault();

  // Passwords match check
  const password = $("#password").val();
  const confirmPassword = $("#confirmPassword").val();
  if (password !== confirmPassword) {
    alert("Passwords do not match!");
    return;
  }

  if (!$("#subDesignation").is(":visible")) {
    var designationValue = $("#designation").val();

    // Here, you can choose your desired logic:
    // Set subDesignation to null (or empty string for the purpose of form submission)
    //$('#subDesignation').val('');

    // OR

    // Set subDesignation to the value of designation
    $("#subDesignation").val(designationValue);
  }
  const selectedRole = $("input[name='role']:checked").val();
  const formData = {
    firstname: $("#firstname").val(),
    lastname: $("#lastname").val(),
    fathername: $("#fathername").val(),
    phoneno: $("#phoneno").val(),
    password: $("#password").val(),
    email: $("#email").val(),
    designation: $("#designation").val(),
    subdesignation: $("#subDesignation").val(),
    gender: $("input[name='inlineRadioOptions']:checked").val(),
    // role:$("input[name='role']:checked").val(),
    role: selectedRole ? selectedRole : null, // This handles the optional role
    state: $("#state").val(),
    city: $("#district").val(),
    pincode: $("#pincode").val(),
    dob: $("#dob").val(),
    loginOption: $("input[name='loginLinkOption']:checked").val(),
  };

  if (!$("#subDesignation").is(":visible")) {
    formData.subdesignation = $("#designation").val(); // Set it to designation value when hidden
  }

  let hasEmptyFields = false;
  for (let key in formData) {
    // If subDesignation is not visible, skip the validation for it
    if (key === "subdesignation" && !$("#subDesignation").is(":visible")||key === "role") {
      continue;
    }

    let inputElement = $(`#${key}`);
    if (!formData[key] || formData[key].trim() === "") {
      hasEmptyFields = true;
      inputElement.next(".error-message").text("This field cannot be empty.");
      console.log("Empty field detected:", key);
  } else if (inputElement.attr("pattern")) {
      let pattern = new RegExp(inputElement.attr("pattern"));
      if (!pattern.test(formData[key])) {
          hasEmptyFields = true;
          inputElement
              .next(".error-message")
              .text(inputElement.attr("title") || "Invalid input.");
          console.log("Field not matching pattern:", key);
      }
  }
  
  }
  if (hasEmptyFields) {
    alert("Please fill all mandatory fields.");
    return;
  }



  $.ajax({
    url: "http://localhost:8080/saveEmployee",
    type: "POST",
    data: JSON.stringify(formData),
    contentType: "application/json",
    success: function (data) {
      console.log(data.status);
      


      // alert("Success: " + data.status.firstname);
      alert(
        "Registration Successful! Please check your email for confirmation."
      );

      // $("#registrationForm")[0].reset  ();
    },
    error: function (xhr, status, error) {
      // This is where you handle errors sent from the server.
      if (xhr.responseJSON && xhr.responseJSON.error) {
        console.log(xhr.responseJSON.error);
        console.log(status);
        alert(xhr.responseJSON.error); // Display the error to the user
      } else {
        console.log("Error occurred:", error);
        alert("An error occurred during registration.");
      }
    },
  });
});
