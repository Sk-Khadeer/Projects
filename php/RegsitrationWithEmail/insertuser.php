<?php
session_start();
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;
use PHPMailer\PHPMailer\SMTP;

include('includes/config.php');
require 'vendor/autoload.php';
// inuujkerdkrvstsa
function sendEmail($name, $email, $verifyToken)
{
    $mail = new PHPMailer(true);
    // $mail->SMTPDebug = 2;
    $mail->isSMTP();
    $mail->Host = 'smtp.gmail.com;';
    $mail->SMTPAuth = true;
    $mail->Username = '944shaikkhadeer@gmail.com';
    $mail->Password = 'wzkoouhgfuznxjim';
    $mail->SMTPSecure = 'tls';
    $mail->Port = 587;
    $mail->setFrom('r@kc.om', $name);
    $mail->addAddress($email);
    $mail->isHTML(true);
    $mail->Subject = 'Email verification for registering into an application';
    $email_template = "<h2>You have registered with email </h2> 
    <h5>Verify your email to login  with the below given link</h5></br>
    <a href ='http://localhost/RegsitrationWithEmail/verifyEmail.php?token=$verifyToken'>click here</a>";
    $mail->Body = $email_template;
    $mail->send();
    echo "Mail has been sent successfully!";
}

if (isset($_POST['submit'])) {

    $fname = $_POST['fname'];
    $lname = $_POST['lname'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    $phone = $_POST['phone'];
    $gender = $_POST['gender'];
    $hash = password_hash(
        $password,
        PASSWORD_DEFAULT
    );
    $verifyToken = md5(rand());
    $mailsubstring = substr($email, 2, 7);
    $recoverPassword = "$2yak.!" . $mailsubstring . $password . "1A*#@";
    // echo substr($recoverPassword, 7, -5);

    $_SESSION['hash_pwd'] = $hash;
    $_SESSION['email'] = $email;
    $_SESSION['pwd'] = $password;
    // email exists or not
    $check_email = "select email from register where email='$email' LIMIT 1";
    $check_email_run = mysqli_query($con, $check_email);


    if (mysqli_num_rows($check_email_run) > 0) {
        $_SESSION['status'] = "Email id is already registered";
        header("Location: register.php");
    } else {
        $query = "insert into register(first_name,last_name,email,phone,password,gender,verify_token,recover_password) values('$fname','$lname','$email','$phone','$hash','$gender','$verifyToken','$recoverPassword')";
        $query_run = mysqli_query($con, $query);
        if ($query_run) {
            sendEmail($name, $email, $verifyToken);
            $_SESSION['status'] = "Successfully Registered..!! Please Verify Your Email Address before login";
            header("Location:register.php");
        } else {
            $_SESSION['status'] = "Registration Failed";
            header("Location:register.php");
        }
    }
}
?>