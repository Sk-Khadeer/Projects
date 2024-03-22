<?php
session_start();
$page_title = "Registration Form";
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
            height: 280px;
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
                        if (isset($_SESSION['status'])) {
                            echo "<h6>" . $_SESSION['status'] . "</h6>";
                            unset($_SESSION['status']);
                        }
                        ?>
                    </div>
                    <div class="card-header">
                        <h5 class="text-center">Update Password</h5>
                    </div>
                    <div class="card-body">
                        <form action="updatepassword.php" method="post">
                            <table>
                                <div class="row">
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <b> <label class="form-label" for="password">Password</label> </b>
                                            <input class="form-control" id="password" name="password" type="password"
                                                placeholder="Create a password"
                                                pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
                                                title="at least one number and one uppercase and lowercase letter, and at least 6 or more characters"
                                                required />
                                            <input type="checkbox" onclick="myFunction()">Show Password
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <b> <label class="form-label" for="confirmpassword">Confirm
                                                    password</label>
                                            </b>
                                            <input class="form-control" id="confirmpassword" name="confirm_password"
                                                type="password" placeholder="Confirm password"
                                                pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
                                                title="at least one number and one uppercase and lowercase letter, and at least 6 or more characters"
                                                required />
                                        </div>
                                    </div>
                                </div>
                                <tr>
                                    <div class="form-group mb-3">
                                        <td></td>
                                        <td> <button type="submit" name="updatepassword" class="btn btn-primary">Submit
                                                now</button>
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
<script>
    function myFunction() {
        var x = document.getElementById("password");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }
    function checkpass() {
        if (document.signup.password.value != document.signup.confirmpassword.value) {
            alert(' Password and Confirm Password field does not match');
            document.signup.confirmpassword.focus();
            return false;
        }
        return true;
    }
</script>


<?php
include('includes/footer.php');
?>