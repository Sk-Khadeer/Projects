<?php
session_start();
$page_title = "Login Form";
include('includes/header.php');
include('includes/navbar.php');
include('includes/db.php');
include('includes/config.php');

// if (isset($_SESSION['authenticated'])) {
//     $_SESSION['status'] = "You Are Already Logged In";
//     header("Location: login.php");
//     exit(0);
// }

$msg = '';
if (isset($_POST['submit'])) {
    if (!empty(trim($_POST['email'])) && !empty(trim($_POST['password']))) {
        $time = time() - 30;
        $ip_address = getIpAddr();

        $check_login_row = mysqli_fetch_assoc(mysqli_query($con, "select count(*) as total_count from login_attempts where try_time>$time and ip_address='$ip_address'"));
        $total_count = $check_login_row['total_count'];
        if ($total_count == 3) {
            $msg = "To many failed login attempts. Please login after some time";
        } else {
            $email = mysqli_real_escape_string($con, $_POST['email']);
            $login_password = mysqli_real_escape_string($con, $_POST['password']);
            $login_query = "select * from register where email='$email' LIMIT 1";
            $login_query_run = mysqli_query($con, $login_query);
            $_SESSION['email'] = $email;
            if (mysqli_num_rows($login_query_run) > 0) {
                $row = mysqli_fetch_array($login_query_run);
                $db_hash_password = $row['password'];

                $loginhash = password_hash(
                    $_POST['password'],
                    PASSWORD_DEFAULT
                );
                // echo $login_password . "<br>";
                // echo $db_hash_password . "<br>";
                // echo $loginhash . "<br>";
                // if (password_verify($login_password, $db_hash_password)) {
                //     echo 'Password is valid!';
                // } else {
                //     echo 'Invalid password.';
                // }
                $verifyPassword = password_verify($login_password, $db_hash_password);

                if ($verifyPassword) {
                    if ($row['verify_status'] == 1) {
                        $_SESSION['authenticated'] = TRUE;
                        $_SESSION['IS_LOGIN'] = 'yes';
                        $_SESSION['email'] = $email;
                        mysqli_query($con, "delete from login_attempts where ip_address='$ip_address'");
                        $_SESSION['status'] = "You are Logged in Successfully";
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
                    mysqli_query($con, "insert into login_attempts(ip_address,try_time) values('$ip_address','$try_time')");
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


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>User Login | Registration and Login System</title>
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
        crossorigin="anonymous"></script>

    <style type="text/css">
        #message {
            color: red;
            margin-top: 20px;
        }

        #result {
            color: red;
        }
    </style>
</head>

<body class="bg-primary">
    <div id="layoutAuthentication">
        <div id="layoutAuthentication_content">
            <main>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-5">
                            <div class="card shadow-lg border-0 rounded-lg mt-5">

                                <div class="card-header">

                                    <h3 class="text-center font-weight-light my-4">User Login</h3>
                                </div>
                                <div class="card-body">
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
                                    <form method="post">

                                        <div class="form-floating mb-3">
                                            <input class="form-control" name="email" type="email"
                                                placeholder="name@example.com" required />
                                            <label for="inputEmail">Email address</label>
                                        </div>


                                        <div class="form-floating mb-3">
                                            <input class="form-control" name="password" type="password"
                                                placeholder="Password" required />
                                            <label for="inputPassword">Password</label>
                                        </div>
                                        <!-- <input type="password" name="password" autocomplete="current-password"
                                            required="" id="id_password">
                                        <i class="far fa-eye" id="togglePassword"
                                            style="margin-left: -30px; cursor: pointer;"></i> -->


                                        <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                            <a class="small" href="password-recovery.php">Recovery Password?</a>
                                            <a class="small" href="forgotpassword.php">Forgot Password?</a>
                                            <button class="btn btn-primary" name="submit" type="submit">Login</button>
                                            <button class="btn btn-primary" name="reset" type="reset">Reset</button>

                                        </div>

                                        <div class="d-flex align-items-center justify-content-between mt-4 mb-0">

                                        </div>



                                        <div class="card-footer text-center py-3">
                                            <div class="small"><a href="register.php">Need an account? Sign up!</a>
                                            </div>
                                            <div class="small"><a href="index.php">Back to Home</a></div>
                                        </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </main>
        </div>
    </div>
    <?php include('includes/footer.php'); ?>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script src="C:\xampp\htdocs\RegsitrationWithEmail\script.js"></script>


</body>

</html>