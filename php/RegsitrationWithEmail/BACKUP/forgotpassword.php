<?php
session_start();
$page_title = "Login Form";
include('includes/header.php');
include('includes/navbar.php');
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
            height: 300px;
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
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center pt-4">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <div class="container" id="message">
                        <?php
                        $a = "<div class=form-group mb-3>
                         Click here for
                          <a href=register.php>Register</a>
                      </div>";
                        if (isset($_SESSION['status'])) {
                            echo "<h6>" . $_SESSION['status'] . "</h6>";
                            echo $a;
                            unset($_SESSION['status']);
                        }
                        ?>
                    </div>
                    <div class="card shadow">
                        <div class="card-header">
                            <h5 class="text-center "> Otp Sending For Email</h5>
                        </div>
                        <div class="card-body">
                            <form action="sendOtp.php" method="POST">
                                <table>
                                    <tr>
                                        <div class="form-group mb-3">
                                            <td><label for="">
                                                    <h6>Email Address</h6>
                                                </label></td>
                                            <td> <input type="email" name="email" class="form control"></td>
                                        </div>
                                    </tr>
                                    <tr>
                                        <div class="form-group mb-3">
                                            <td></td>
                                            <td> <button type="submit" name="otp_btn" class="btn btn-primary">Send
                                                </button>
                                                <button type="reset" class="btn btn-secondary">Reset
                                                </button>
                                            </td>
                                        </div>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<?php
include('includes/footer.php');
?>