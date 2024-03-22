<?php
$page_title = "Home Page";
include('includes/header.php');
include('includes/navbar.php');
?>

<div class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <h1 class="mt-4">
                    User Registration & Login With Email Verification
                </h1>
            </div>
        </div>
    </div>
</div>
<!DOCTYPE html>
<html lang="en">

<body style="background-color:#c0c0c0" ;>
    <div class=" row">
        <div class="col-xl-4 col-md-6 offset-2">
            <div class="card bg-primary text-white mb-4">
                <div class="card-body">
                    New User
                </div>
                <div class="card-footer d-flex align-items-center justify-content-between">
                    <a class="small text-white stretched-link" href="register.php">
                        Signup Here
                    </a>
                    <div class="small text-white">
                        <i class="fas fa-angle-right"></i>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-4 col-md-6">
            <div class="card bg-dark text-white mb-4">
                <div class="card-body">
                    Already Registered
                </div>
                <div class="card-footer d-flex align
                '-items-center justify-content-between">
                    <a class="small text-white stretched-link" href="login.php">
                        Login Here
                    </a>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
<?php
include('includes/footer.php');
?>