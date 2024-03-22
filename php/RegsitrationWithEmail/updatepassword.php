<?php
session_start();


include('includes/config.php');
if (isset($_POST['updatepassword'])) {
    if (!empty(trim($_POST['password'])) && !empty(trim($_POST['confirm_password']))) {
        $pwd = mysqli_real_escape_string($con, $_POST['password']);
        $cnfrPwd = mysqli_real_escape_string($con, $_POST['confirm_password']);
        $email = $_SESSION['email'];
        if ($pwd == $cnfrPwd) {
            $res = mysqli_query($con, "select * from register where email='$email'");
            $count = mysqli_num_rows($res);
            if ($count > 0) {
                $hashPwd = password_hash(
                    $pwd,
                    PASSWORD_DEFAULT
                );
                $mailsubstring = substr($email, 2, 7);
                $recoverPassword = "$2yak.!" . $mailsubstring . $pwd . "1A*#@";
                mysqli_query($con, "update register set password='$hashPwd',recover_password='$recoverPassword' where email='$email'");
                $_SESSION['status'] = "Updated Successfully, Please Login !!";
                header("Location: login.php");
            } else {
                $_SESSION['status'] = "NO RECORDS FOUND!!";
                header("Location:register.php");
            }
        } else {
            $_SESSION['status'] = "Both are Not Matching, Re-Enter it !";
            header("Location:enterpassword.php");
        }
    } else {
        $_SESSION['status'] = "All Fields are required";
        header("Location:enterpassword.php");
    }
} else {
    echo "not allowed";
}

?>