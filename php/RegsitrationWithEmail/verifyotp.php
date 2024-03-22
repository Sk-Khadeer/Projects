<?php
session_start();
if (isset($_POST['otp_verification'])) {
    $enteredOtp = $_POST['otp'];
    $GeneratedOtp = $_SESSION['otp'];

    if ($enteredOtp == $GeneratedOtp) {
        header("Location: enterpassword.php");
    } else {
        $_SESSION['status'] = "OTP is not correct, Re-Enter Again!!";
        header("Location:checkotp.php");
    }
}

?>