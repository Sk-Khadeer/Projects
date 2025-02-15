<?php session_start();
include_once('includes/config.php');
// if (strlen($_SESSION['id'] == 0)) {
//     header('location:logout.php');
// } else {
//Code for Updation 
// for  password change   
if (isset($_POST['update'])) {
    $oldpassword = $_POST['currentpassword'];
    $newpassword = $_POST['newpassword'];

    $mail = $_SESSION['email'];

    $password_execute_query = mysqli_query($con, "SELECT * FROM register where email='$mail'");
    if (mysqli_num_rows($password_execute_query) > 0) {
        $row = mysqli_fetch_array($password_execute_query);
        $db_hash_password = $row['password'];

        $currentpassword = password_hash(
            $oldpassword,
            PASSWORD_DEFAULT
        );
        $new_password_hash = password_hash(
            $newpassword,
            PASSWORD_DEFAULT
        );

        $verifyPassword = password_verify($oldpassword, $db_hash_password);
        if ($verifyPassword) {
            $ret = mysqli_query($con, "update register set password='$new_password_hash' where email='$mail'");
            echo "<script>alert('Password Changed Successfully !!');</script>";
            echo "<script type='text/javascript'> document.location = 'change-password.php'; </script>";
        } else {
            echo "<script>alert('Old Password not match !!');</script>";
            echo "<script type='text/javascript'> document.location = 'change-password.php'; </script>";
        }
    }
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
    <title>Change password | Registration and Login System</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
        crossorigin="anonymous"></script>
    <script language="javascript" type="text/javascript">
        function valid() {
            if (document.changepassword.newpassword.value != document.changepassword.confirmpassword.value) {
                alert("Password and Confirm Password Field do not match  !!");
                document.changepassword.confirmpassword.focus();
                return false;
            }
            return true;
        }
    </script>
</head>

<body class="sb-nav-fixed" style="background: linear-gradient(#e66465, #9198e5);">
    <?php include_once('inc/navbar.php'); ?>
    <div id="layoutSidenav">
        <?php include_once('inc/sidebar.php'); ?>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Change Password</h1>
                    <div class="card mb-4">
                        <form method="post" name="changepassword" onSubmit="return valid();">
                            <div class="card-body">
                                <table class="table table-bordered">
                                    <tr>
                                        <th>Current Password</th>
                                        <td><input class="form-control" id="currentpassword" name="currentpassword"
                                                type="password" value="" required /></td>
                                    </tr>
                                    <tr>
                                        <th>New Password</th>
                                        <td><input class="form-control" id="newpassword" name="newpassword"
                                                type="password" value="" required /></td>
                                    </tr>
                                    <tr>
                                        <th>Confirm Password</th>
                                        <td colspan="3"><input class="form-control" id="confirmpassword"
                                                name="confirmpassword" type="password" required /></td>
                                    </tr>

                                    <tr>
                                        <td colspan="4" style="text-align:center ;"><button type="submit"
                                                class="btn btn-primary btn-block" name="update">Change</button></td>

                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </form>
                    </div>


                </div>
            </main>
            <?php include('inc/footer.php'); ?>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="assets/demo/chart-area-demo.js"></script>
    <script src="assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="js/datatables-simple-demo.js"></script>
</body>

</html>
<?php //} ?>