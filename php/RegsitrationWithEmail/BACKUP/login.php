<?php
session_start();
$page_title = "Login Form";
include('includes/header.php');
include('includes/navbar.php');
include('includes/db.php');
include('includes/config.php');

if (isset($_SESSION['authenticated'])) {
    $_SESSION['status'] = "You Are Already Logged In";
    header("Location: dashboard.php");
    exit(0);
}
if (isset($_SESSION['authenticated'])) {
    $_SESSION['status'] = "You Are Already Logged In";
    header("Location: dashboard.php");
    exit(0);
}

$msg = '';
if (isset($_POST['submit'])) {
    if (!empty(trim($_POST['username'])) && !empty(trim($_POST['password']))) {
        $time = time() - 30;
        $ip_address = getIpAddr();

        $check_login_row = mysqli_fetch_assoc(mysqli_query($con, "select count(*) as total_count from login_log where try_time>$time and ip_address='$ip_address'"));
        $total_count = $check_login_row['total_count'];
        if ($total_count == 3) {
            $msg = "To many failed login attempts. Please login after some time";
        } else {
            $email = mysqli_real_escape_string($con, $_POST['username']);
            $password = mysqli_real_escape_string($con, $_POST['password']);
            $login_query = "select * from user where email='$email' LIMIT 1";
            $login_query_run = mysqli_query($con, $login_query);

            if (mysqli_num_rows($login_query_run) > 0) {
                $row = mysqli_fetch_array($login_query_run);
                $pwd = $row['password'];
                $verify = password_verify($password, $pwd);
                if ($verify) {
                    if ($row['verify_status'] == 1) {
                        $_SESSION['authenticated'] = TRUE;
                        $_SESSION['auth_user'] = [
                            'username' => $row['name'],
                            'phone' => $row['phone'],
                            'email' => $row['email'],
                        ];
                        $link = "<a href ='piechart.php'>click here to view gender count</a>";
                        $_SESSION['IS_LOGIN'] = 'yes';
                        mysqli_query($con, "delete from login_log where ip_address='$ip_address'");
                        $_SESSION['status'] = "You are Logged in Successfully";
                        $_SESSION['emailby'] = $email;
                        include "phpqrcode/qrlib.php";
                        $TEMP_DIR = 'temp/';
                        if (!file_exists($TEMP_DIR))
                            mkdir($TEMP_DIR);

                        $_SESSION['filename'] = $TEMP_DIR . $_SESSION['auth_user']['username'] . '.jpeg';
                        $filename = $_SESSION['filename'];
                        $codeString = $_SESSION['auth_user']['username'];
                        $codeString .= $_SESSION['auth_user']['email'];
                        $codeString .= $_SESSION['auth_user']["phone"];
                        QRcode::png($codeString, $filename);
                        $_SESSION['qrcode'] = '<img src="' . $TEMP_DIR . basename($filename) . '" />';
                        header("Location: dashboard.php");
                        exit(0);
                    } else {
                        $_SESSION['status'] = "Please verify your email address to login";
                        header("Location: login.php");
                        exit(0);
                    }
                } else {
                    $total_count++;
                    $rem_attm = 3 - $total_count;
                    if ($rem_attm == 0) {
                        $msg = "To many failed login attempts. Please login after 30 sec";
                    } else {
                        $msg = "Please enter valid login details.$rem_attm attempts remaining";
                    }
                    $try_time = time();
                    mysqli_query($con, "insert into login_log(ip_address,try_time) values('$ip_address','$try_time')");
                }
            } else {
                $_SESSION['status'] = "Invalid Email Address";
                header("Location: login.php");
                exit(0);
            }
        }
    } else {
        $_SESSION['status'] = "All fields are required";
        header("Location: login.php");
        exit(0);
    }
}

function getIpAddr()
{
    if (!empty($_SERVER['HTTP_CLIENT_IP'])) {
        $ipAddr = $_SERVER['HTTP_CLIENT_IP'];
    } elseif (!empty($_SERVER['HTTP_X_FORWARDED_FOR'])) {
        $ipAddr = $_SERVER['HTTP_X_FORWARDED_FOR'];
    } else {
        $ipAddr = $_SERVER['REMOTE_ADDR'];
    }
    return $ipAddr;
}
?>

<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">
    <title>Login Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
            background-color: #17a2b8;
            height: 100vh;
        }

        #login .container #login-row #login-column {
            margin-top: 40px;
            max-width: 600px;
            height: 450px;
            border: 1px solid #9C9C9C;
            background-color: #EAEAEA;
        }

        #message {
            color: red;
            margin-top: 20px;
        }

        #login .container #login-row #login-column #login-box #login-form {
            padding: 40px;
        }

        #result {
            color: red;
        }
    </style>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<div id="login">
    <h3 class="text-center text-white pt-4">Login form</h3>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <div class="container" id="message">
                        <?php
                        if (isset($_SESSION['status'])) {
                            echo "<h6>" . $_SESSION['status'] . "</h6>";
                            unset($_SESSION['status']);
                        }
                        ?>
                    </div>
                    <div class="container" id="result">
                        <?php
                        echo "<h6>" . $msg . "</h6>"; ?>
                    </div>

                    <form id="login-form" class="form" method="post">
                        <div class="form-group">
                            <label for="username" class="text-info">Username:</label><br>
                            <input type="email" name="username" id="username" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="password" class="text-info">Password:</label><br>
                            <input type="password" name="password" id="password" class="form-control" required>
                        </div>


                        <div class="form-group mb-3">
                            <input type="submit" name="submit" class="btn btn-info btn-md" value="Submit">
                            <td> <button type="reset" class="btn btn-secondary">Reset
                                </button></td>
                        </div>

                        <div class="form-group mb-3">
                            <label for="">Didnt receive verification email?</label>
                            <a href="resendEmail.php">Resend</a>
                        </div>
                        <div class="form-group mb-3">
                            <label for="">New User ?</label>
                            <a href="register.php">SignUp here</a>
                        </div>
                        <div class="form-group mb-3">
                            <label for="">Forgot Password?</label>
                            <a href="forgotpassword.php">Forgot Password</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>