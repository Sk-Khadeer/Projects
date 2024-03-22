<?php
$page_title = "Dash Board";
include('includes/header.php');
require("user_auth.php");
include('includes/config.php');
?>

<head>
    <title>Edit Picture</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
            background-color: #17a2b8;
            height: 100vh;
        }

        #login .container #login-row #login-column {
            margin-top: 60px;
            max-width: 600px;
            height: 500px;
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
<div class="bg-dark">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <nav class="navbar navbar-expand-lg navbar-dark">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">Php By Sridhar</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                                <li class="nav-item">
                                    <a class="nav-link active" href="index.php">HOME</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="Dashboard.php">DASHBOARD</a>
                                </li>


                                <?php if (isset($_SESSION['authenticated'])): ?>
                                    <li class="nav-item">
                                        <a class="nav-link" href="logout.php">LOGOUT</a>
                                    </li>
                                <?php endif ?>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</div>

<div id="login">
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <div class="container" id="message">
                        <?php
                        if (isset($_SESSION['UPDATE'])) {
                            echo "<h6>" . $_SESSION['UPDATE'] . "</h6>";
                            unset($_SESSION['UPDATE']);
                        }
                        if (isset($_SESSION['status'])) {
                            echo "<h6>" . $_SESSION['status'] . "</h6>";
                            unset($_SESSION['status']);
                        }
                        ?>
                    </div>
                    <div class="card">
                        <div class="card-header">
                            <h3 class="text-center text-dark pt-4">User Details</h3>
                        </div>
                        <div class="card-body">
                            <form method="get" enctype="multipart/form-data">
                                <table>
                                    <tr>
                                        <td>
                                            <h5> Username : </h5>
                                        </td>
                                        <td>
                                            <h6>
                                                <?= $_SESSION['auth_user']['username']; ?>
                                            </h6>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <h5> Phone : </h5>
                                        </td>
                                        <td>
                                            <h6>
                                                <?= $_SESSION['auth_user']['phone']; ?>
                                            </h6>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <h5> Email : </h5>
                                        </td>
                                        <td>
                                            <h6>
                                                <?= $_SESSION['auth_user']['email']; ?>
                                            </h6>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <h5> Image : </h5>
                                        </td>
                                        <td>
                                            <h6>
                                                <img src="<?php
                                                $mail = $_SESSION['emailby'];
                                                $user = "select * from user where email='$mail'";
                                                $user_run = mysqli_query($con, $user);

                                                if (mysqli_num_rows($user_run) > 0) {
                                                    $row = mysqli_fetch_array($user_run);
                                                    echo $row['imagePath'];
                                                } ?>" width="100" height="150">
                                            </h6>
                                            <a href="editPic.php?email=  <?= $_SESSION['auth_user']['email']; ?>">Edit
                                                Pic</a>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                            <?php
                            echo "<a href ='qrcode.php'>Click here to Generate QRCode</a></br>";
                            echo "<a href ='genderChart.php'>Click here to see Gender count</a></br>";
                            echo "<a href ='countryChart.php'>Click here to see Country count</a>";
                            ?>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
    setInterval(function () {
        check_user();
    }, 2000);
    function check_user() {
        jQuery.ajax({
            url: 'user_auth.php',
            type: 'post',
            data: 'type=ajax',
            success: function (result) {
                if (result == 'logout') {
                    window.location.href = 'logout.php';
                }
            }
        });
    }
</script>


<?php
include('includes/footer.php');
?>