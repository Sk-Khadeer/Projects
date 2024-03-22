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
    $email_template = "<h2>you have registered with email </h2> 
    <h5>verify your email to login  with the below given link</h5></br>
    <a href ='http://localhost/RegsitrationWithEmail/verifyEmail.php?token=$verifyToken'>click here</a>";

    $mail->Body = $email_template;

    $mail->send();
    echo "Mail has been sent successfully!";
}
if (isset($_POST['register_btn'])) {
    $name = $_POST['name'];
    $phone = $_POST['phone'];
    $email = $_POST['email'];
    $gender = $_POST['type'];
    $country = $_POST['country'];
    $state = $_POST['state'];
    $city = $_POST['city'];
    $file = $_FILES['photo'];
    $password = $_POST['password'];
    $hash = password_hash(
        $password,
        PASSWORD_DEFAULT
    );
    $verifyToken = md5(rand());

    $_SESSION['hash_pwd'] = $hash;
    $country_name = "select name from country where id='$country' ";
    $ccountry_name_run = mysqli_query($con, $country_name);
    if (mysqli_num_rows($ccountry_name_run) > 0) {
        $row = mysqli_fetch_array($ccountry_name_run);
        $cname = $row['name'];

    }
    $state_name = "select name from state where id='$state' ";
    $state_name_run = mysqli_query($con, $state_name);
    if (mysqli_num_rows($state_name_run) > 0) {
        $row = mysqli_fetch_array($state_name_run);
        $sname = $row['name'];

    }
    $city_name = "select name from city where id='$city' ";
    $city_name_run = mysqli_query($con, $city_name);
    if (mysqli_num_rows($city_name_run) > 0) {
        $row = mysqli_fetch_array($city_name_run);
        $ctyname = $row['name'];

    }
    // email exists or not
    $check_email = "select email from user where email='$email' LIMIT 1";
    $check_email_run = mysqli_query($con, $check_email);

    $filename = $file['name'];
    $filepath = $file['tmp_name'];
    $fileerror = $file['error'];

    if ($fileerror == 0) {
        $destFile = 'images/' . $filename;
        move_uploaded_file($filepath, $destFile);
    } else {
        echo "not uploaded a file";
    }


    if (mysqli_num_rows($check_email_run) > 0) {
        $_SESSION['status'] = "Email id already registered";
        header("Location: register.php");
    } else {
        $query = "insert into user(first_name,phone,email,password,verify_token,gender,country,state,city,imagePath) values('$name','$phone','$email','$hash','$verifyToken','$gender','$cname','$sname','$ctyname','$destFile')";
        $query_run = mysqli_query($con, $query);
        if ($query_run) {
            sendEmail($name, $email, $verifyToken);
            $_SESSION['status'] = "Successfully Registered..!! Please Verify Your Email Address";
            header("Location:register.php");
        } else {
            $_SESSION['status'] = "Registration Failed";
            header("Location:register.php");
        }
    }
}
?>