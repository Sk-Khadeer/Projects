$(document).ready(function () {

    const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

    $("#newPassword").on("input", function () {

        // Check if the entered password matches the regex
        if (!regex.test($(this).val())) {
            $("#newPasswordError").text("Must contain at least one number, one uppercase, one lowercase letter, one special character, and at least 8 or more characters");
            $("#reEnterPassword").prop("disabled", true);
        } else {
            $("#newPasswordError").text("");
            $("#reEnterPassword").prop("disabled", false);
        }

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

    $("#submitButton").click(function (e) {

        e.preventDefault();  // Prevent default behavior

        var email = $("#email").val();

        if (email === "") {
            $("#emailError").text("Email is required!");
            return;
        } else {
            $("#emailError").text(""); // Clear any error if the field is filled
        }


        sendOTP();
    });

    // Resend OTP when the link is clicked
    $("#resendLink").click(function (e) {
        e.preventDefault();
        sendOTP();
    });
    // Add this for verifying the OTP


    // Function to send OTP
    function sendOTP() {
        var otpToEmail = $("#email").val();

        // Send otp request
        $.ajax({
            url: "http://localhost:8080/otpToEmail",
            type: "POST",
            data: JSON.stringify({ email: otpToEmail }),
            contentType: "application/json",
            success: function (response) {
                if (response.status === "success") {
                    alert("OTP sent successfully!");
                    // Update the card title and description
                    $(".card-body .card-title").text("Verify OTP").addClass("text-center");
                    $(".card-body p").text("Please enter the OTP sent to your email address.");


                    // Hide email input and submit button
                    $("#email").prop("disabled", true);
                    $("#submitButton").hide();

                    // Show OTP input, verify button, and resend link
                    $("#otpField").show();
                    $("#verifyButton").show();
                    $("#resendLink").show();


                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Server error: " + jqXHR.responseText);
            },
        });
    }

    // Add this for verifying the OTP
    $("#verifyButton").click(function () {
        var otpEntered = $("#otp").val();
        var email = $("#email").val(); // Assuming email field has ID 'email'

        if (!otpEntered) {
            alert("Please enter the OTP first.");
            return;
        }

        $.ajax({
            url: "http://localhost:8080/verifyOtp",
            type: "POST",
            data: JSON.stringify({ email: email, otp: otpEntered }),
            contentType: "application/json",
            success: function (response) {
                alert(response); // This will display the message from the server. Adjust as needed.

                // If OTP verification is successful
                if (response.includes("successfully")) {
                    // Update the card title and description
                    $(".card-body .card-title").text("Create a new Password").addClass("text-center");
                    $(".card-body p").text("Please enter your new password.");

                    // Hide the OTP fields and buttons
                    $("#otpField").hide();
                    $("#verifyButton").hide();
                    $("#resendLink").hide();

                    // Show the reset password fields and button
                    $("#passwordResetFields").show();
                } else {
                    // If OTP verification fails

                    $(".card-body .card-title").text("Verify OTP").removeClass("text-center");
                    $("#otp").val(''); // Clear the OTP input
                    alert("Incorrect OTP. Please try again.");
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                if (jqXHR.responseText.includes("Invalid OTP")) {
                    // Clear the OTP input
                    $("#otp").val('');
                    alert("Incorrect OTP. Please try again.");
                } else {
                    // Handle other errors differently
                    alert("Error verifying OTP: " + jqXHR.responseText);
                }
            }

        });
    });

    $("#resetPasswordButton").click(function () {
        var newPassword = $("#newPassword").val();
        var reEnterPassword = $("#reEnterPassword").val();
        var email = $("#email").val(); // retrieve the email

        // Basic validation: check if passwords match and are not empty
        if (newPassword !== reEnterPassword) {
            alert("Passwords do not match!");
            return;
        }

        if (!newPassword || !reEnterPassword) {
            alert("Please fill in both password fields.");
            return;
        }

        // Send the data to your Java backend
        $.ajax({
            url: "http://localhost:8080/updatePassword",
            type: "POST",
            data: JSON.stringify({
                email: email,
                newPassword: newPassword
            }),
            contentType: "application/json",
            success: function (response) {
                if (response.status === "success") {
                    alert("Password updated successfully!");
                    window.location.href = "../login/login.html"; // redirect to login page or wherever you like
                } else {
                    alert("Error updating password: " + response.message);
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Server error: " + jqXHR.responseText);
            }
        });
    });

});