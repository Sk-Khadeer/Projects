<?php
session_start();
$page_title = "Registration Form";
include('includes/header.php');
include('includes/navbar.php');
include('includes/db.php');
$sql = "select id,name from country";
$stmt = $con->prepare($sql);
$stmt->execute();
$arrCountry = $stmt->fetchAll(PDO::FETCH_ASSOC);
?>

<head>
    <title>Registration Form</title>
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
            max-width: 500px;
            height: 380px;
            border: 1px solid #9C9C9C;
            background-color: #EAEAEA;
        }

        #message {
            color: green;
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
    <h3 class="text-center text-white pt-4">Registration form</h3>
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
                    <div class="card-body">
                        <form action="code.php" method="post" enctype="multipart/form-data">
                            <table>
                                <tr>
                                    <div class="form-group mb-3">
                                        <td><label for="">Name</label></td>
                                        <td> <input type="text" name="name" class="form control" required></td>
                                    </div>
                                </tr>
                                <tr>
                                    <div class="form-group mb-3">
                                        <td> <label for="">Phone Number</label></td>
                                        <td> <input type="text" name="phone" class="form control" required></td>
                                    </div>
                                </tr>

                                <tr>
                                    <div class="form-group mb-3">
                                        <td> <label for="">Email Address</label></td>
                                        <td> <input type="text" name="email" class="form control"></td>
                                    </div>
                                </tr>
                                <tr>
                                    <div class="form-group mb-3">
                                        <td><label for="">Password</label></td>
                                        <td> <input type="text" name="password" class="form control">
                                        </td>
                                    </div>
                                <tr>
                                <tr>
                                    <div class="form-group mb-3">
                                        <td> <label for="">Gender </label></td>
                                        <td> <input type="radio" value="female" name="type" class="form control">Female

                                            <input type="radio" value="male" name="type" class="form control">Male
                                        </td>
                                    </div>
                                </tr>
                                <tr>

                                    <td><label for="country">Country</label> </td>
                                    <td> <select id="country" name="country">
                                            <option value="-1">Select Country</option>
                                            <?php
                                            foreach ($arrCountry as $country) {
                                                ?>
                                                <option value="<?php echo $country['id'] ?>">
                                                    <?php echo $country['name'] ?></option>
                                            <?php } ?>
                                        </select> </td>
                                </tr>
                                <tr>

                                    <td> <label for="state">State</label> </td>
                                    <td> <select id="state" name="state">
                                            <option>Select State</option>
                                        </select> </td>
                                </tr>
                                <tr>
                                    <td> <label for="city">City</label> </td>
                                    <td> <select id="city" name="city">
                                            <option>Select City</option>
                                        </select> </td>
                                </tr>

                                </tr>
                                <tr>
                                    <td> <label for="image">Image</label> </td>
                                    <td> <input type="file" name="photo" /></td>
                                </tr>
                                <tr>
                                    <div class="form-group mb-3">
                                        <td> </td>
                                        <td> <input type="submit" name="register_btn" class="btn btn-info btn-md"
                                                value="Submit">
                                            <button type="reset" class="btn btn-secondary">Reset
                                            </button>
                                        </td>
                                    </div>
                                </tr>
                                <tr>
                                    <div class="form-group mb-3">
                                        <td></td>
                                        <td> <label for="">Didnt receive verification email?</label>
                                            <a href="resendEmail.php">Resend</a>
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


<div id="divLoading"></div>
<style>
    #divLoading {
        display: none;
    }

    #divLoading.show {
        display: block;
        position: fixed;
        z-index: 100;
        background-image: url('http://loadinggif.com/images/image-selection/3.gif');
        background-color: #666;
        opacity: 0.4;
        background-repeat: no-repeat;
        background-position: center;
        left: 0;
        bottom: 0;
        right: 0;
        top: 0;
    }

    #loadinggif.show {
        left: 50%;
        top: 50%;
        position: absolute;
        z-index: 101;
        width: 32px;
        height: 32px;
        margin-left: -16px;
        margin-top: -16px;
    }
</style>
<script>
    $(document).ready(function () {
        jQuery('#country').change(function () {
            var id = jQuery(this).val();
            if (id == '-1') {
                jQuery('#state').html('<option value="-1">Select State</option>');
            } else {
                $("#divLoading").addClass('show');
                jQuery('#state').html('<option value="-1">Select State</option>');
                jQuery('#city').html('<option value="-1">Select City</option>');
                jQuery.ajax({
                    type: 'post',
                    url: 'get_data.php',
                    data: 'id=' + id + '&type=state',
                    success: function (result) {
                        $("#divLoading").removeClass('show');
                        jQuery('#state').append(result);
                    }
                });
            }
        });
        jQuery('#state').change(function () {
            var id = jQuery(this).val();
            if (id == '-1') {
                jQuery('#city').html('<option value="-1">Select City</option>');
            } else {
                $("#divLoading").addClass('show');
                jQuery('#city').html('<option value="-1">Select City</option>');
                jQuery.ajax({
                    type: 'post',
                    url: 'get_data.php',
                    data: 'id=' + id + '&type=city',
                    success: function (result) {
                        $("#divLoading").removeClass('show');
                        jQuery('#city').append(result);
                    }
                });
            }
        });
    });
</script>

<?php
include('includes/footer.php');
?>