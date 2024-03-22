<?php
session_start();
use PHPMailer\PHPMailer\PHPMailer;

use PHPMailer\PHPMailer\Exception;
use PHPMailer\PHPMailer\SMTP;

include('includes/config.php');


require 'vendor/autoload.php';
function resendEmailVerify($name, $email, $verifyToken)
{
    $mail = new PHPMailer(true);
    // $mail->SMTPDebug = 2;
    $mail->isSMTP();
    $mail->Host = 'smtp.gmail.com;';
    $mail->SMTPAuth = true;
    $mail->Username = '944shaikkhadeer@gmail.com';
    $mail->Password = 'hoycmexgsiuwqkdz';
    $mail->SMTPSecure = 'tls';
    $mail->Port = 587;

    $mail->setFrom('r@kc.om', $name);
    $mail->addAddress($email);

    $mail->isHTML(true);
    $mail->Subject = 'Resend Email verification for registering into an application';
    $email_template = "<h2>you have registered with email </h2> 
    <h5>verify your email to login  with the below given link</h5></br>
    <a href ='http://localhost/RegsitrationWithEmail/verifyEmail.php?token=$verifyToken'>click here</a>";

    $mail->Body = $email_template;
    $mail->send();
    echo "Mail has been sent successfully!";
}
if (isset($_POST['resend_Email_btn'])) {
    if (!empty(trim($_POST['email']))) {
        $email = mysqli_real_escape_string($con, $_POST['email']);
        $email_query = "select * from user where email='$email' LIMIT 1";
        $email_query_run = mysqli_query($con, $email_query);
        if (mysqli_num_rows($email_query_run) > 0) {
            $row = mysqli_fetch_array($email_query_run);
            if ($row['verify_status'] == '0') {
                $name = $row['name'];
                $email = $row['email'];
                $verify_token = $row['verify_token'];
                resendEmailVerify($name, $email, $verify_token);
                $_SESSION['status'] = "verification link has been send to your email address";
                header("Location: login.php");
                exit(0);
            } else {
                $_SESSION['status'] = "Email already verified, Please login now";
                header("Location: login.php");
                exit(0);
            }
        } else {
            $_SESSION['status'] = "Email is not registered, Please Register now";
            header("Location: register.php");
            exit(0);
        }
    } else {
        $_SESSION['status'] = "Please Enter the Email address";
        header("Location: resendEmail.php");
        exit(0);
    }
}


?>