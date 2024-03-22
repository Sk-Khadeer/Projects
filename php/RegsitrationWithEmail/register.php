<?php
session_start();
$page_title = "Registration Form";
include('includes/header.php');
include('includes/navbar.php');
?>

<head>
    <title>Registration Form</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
            background-color: gray;
            height: 100vh;
        }

        #message {
            color: Red;

        }

        #login .container {
            padding: 20px;
        }

        #result {
            color: red;
        }
    </style>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<div>

    <section class="vh-80 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row justify-content-center align-items-center h-100">
                <div class="col-12 col-lg-9 col-xl-7">
                    <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                        <div class="card-body p-4 p-md-5">
                            <div class="container" id="message">
                                <?php
                                if (isset($_SESSION['status'])) {
                                    echo "<h5>" . $_SESSION['status'] . "</h5>";
                                    unset($_SESSION['status']);
                                }
                                ?>
                            </div>
                            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5" style="text-align:center; color:rgba(0, 0, 198, 198)">
                                <b> Registration
                                    Form</b>
                            </h3>

                            <form method="post" action="insertuser.php" name="signup" onsubmit="return checkpass();">

                                <div class="row">
                                    <div class="col-md-6 mb-4">

                                        <div class="form-outline">
                                            <b> <label class="form-label" for="firstName">First Name</label> </b>
                                            <input class="form-control" id="fname" name="fname" type="text"
                                                placeholder="Enter your first name" required />

                                        </div>

                                    </div>
                                    <div class="col-md-6 mb-4">

                                        <div class="form-outline">
                                            <b> <label class="form-label" for="lastName">Last Name</label> </b>
                                            <input class="form-control" id="lname" name="lname" type="text"
                                                placeholder="Enter your last name" required />

                                        </div>

                                    </div>
                                </div>
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
                                            <b> <label class="form-label" for="lastName">Confirm password</label>
                                            </b>
                                            <input class="form-control" id="confirmpassword" name="confirmpassword"
                                                type="password" placeholder="Confirm password"
                                                pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
                                                title="at least one number and one uppercase and lowercase letter, and at least 6 or more characters"
                                                required />
                                        </div>

                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-6 mb-4 pb-2">

                                        <div class="form-outline">
                                            <b> <label class="form-label" for="emailAddress">Email</label> </b>
                                            <input class="form-control" id="email" name="email" type="email"
                                                placeholder="abc@gmail.com" required />

                                        </div>

                                    </div>
                                    <div class="col-md-6 mb-4 pb-2">

                                        <div class="form-outline">
                                            <b> <label class="form-label" for="phoneNumber">Phone Number</label>
                                            </b>
                                            <input type="tel" id="phone" name="phone"
                                                class="form-control form-control-lg" pattern="[0-9]{3}[0-9]{3}[0-9]{4}"
                                                required title="Only Numbers" />
                                        </div>
                                    </div>
                                </div>


                                <div class="col-md-6 mb-4">

                                    <div class=" mb-2 pb-1">
                                        <b> <label class="form-outline" for="Gender">Gender :</label></b>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" id="maleGender"
                                                value="male" />
                                            <label class="form-check-label" for="maleGender">Male</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" id="femaleGender"
                                                value="female" />
                                            <label class="form-check-label" for="femaleGender">Female</label>
                                        </div>

                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" id="otherGender"
                                                value="other" />
                                            <label class="form-check-label" for="otherGender">Other</label>
                                        </div>

                                    </div>

                                    <div class="row">
                                        <div class="col-md-6 mb-4">

                                            <div class="form-outline">
                                                <div class="d-grid">
                                                    <button type="submit" class="btn btn-primary btn-block"
                                                        name="submit">Create Account</button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4">

                                            <div class="form-outline">
                                                <div class="d-grid"><button type="reset"
                                                        class="btn btn-primary btn-block" name="reset">Reset</button>
                                                </div>
                                            </div>

                                        </div>
                                    </div>


                            </form>
                            <div class="col-md-8 mb-4">
                                <a href="login.php">Have an account? Go to login</a>
                            </div>
                            <div class="col-md-6 mb-4 pb-2">
                                <a href="index.php">Back to Home</a>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>
</div>
</section>
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