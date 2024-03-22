<?php
session_start();
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;
use PHPMailer\PHPMailer\SMTP;

require 'vendor/autoload.php';
include('includes/config.php');


function smtp_mailer($to, $subject, $msg)
{
    $mail = new PHPMailer(true);
    $mail->isSMTP();
    $mail->SMTPDebug = 1;
    $mail->SMTPAuth = true;
    $mail->CharSet = 'UTF-8';
    $mail->Host = 'smtp.gmail.com;';
    $mail->Username = '944shaikkhadeer@gmail.com';
    $mail->Password = 'wzkoouhgfuznxjim';
    $mail->SMTPSecure = 'tls';
    $mail->Port = 587;
    $mail->setFrom('r@kc.om', $to);
    $mail->isHTML(true);
    $mail->Subject = $subject;
    $mail->Body = $msg;
    $mail->AddAddress($to);
    $mail->send();

}

if (isset($_POST['send'])) {
    if (!empty(trim($_POST['email']))) {
        $email = mysqli_real_escape_string($con, $_POST['email']);
        $res = mysqli_query($con, "select * from register where email='$email'");
        $count = mysqli_num_rows($res);
        if ($count > 0) {
            $otp = rand(0, 999999);
            mysqli_query($con, "update register set otp='$otp' where email='$email'");
            $html = "Your otp verification code is " . $otp;
            $_SESSION['email'] = $_POST['email'];
            $_SESSION['otp'] = $otp;
            smtp_mailer($email, 'OTP Verification', $html);
            header("Location: checkotp.php");
            echo "yes";
        } else {
            $_SESSION['status'] = "Invalid Email, Not registered, Try again !!";
            header("Location: forgotpassword.php");
            exit(0);
        }
    }
}
?>