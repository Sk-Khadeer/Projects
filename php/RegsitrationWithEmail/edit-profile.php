<?php session_start();
include('includes/db.php');
include_once('includes/config.php');
// if (strlen($_SESSION['id'] == 0)) {
//     header('location:logout.php');
// } else {
//Code for Updation 
if (isset($_POST['update'])) {
    $mail = $_SESSION['email'];
    $fname = $_POST['fname'];
    $lname = $_POST['lname'];
    // $email = $_POST['email'];
    $phone = $_POST['phone'];
    $profile_updated_time = $_POST['updated_date'];
    $msg = mysqli_query($con, "update register set first_name='$fname',last_name='$lname',profile_updated_time='$profile_updated_time',phone='$phone' where email='$mail'");
    if ($msg) {
        echo "<script type='text/javascript'> document.location = 'profile.php'; </script>";
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
    <title>Edit Profile | Registration and Login System</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
        crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
    <?php include_once('inc/navbar.php'); ?>
    <div id="layoutSidenav">
        <?php include_once('inc/sidebar.php');
        ?>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <?php
                    include_once('includes/config.php');
                    $mail = $_SESSION['email'];
                    $user = "select * from register where email='$mail'";
                    $user_run = mysqli_query($con, $user);
                    while ($result = mysqli_fetch_array($user_run)) {
                        ?>
                        <h1 class="mt-4">
                            <?php echo $result['first_name']; ?>'s Profile
                        </h1>
                        <div class="card mb-4">
                            <form method="post">
                                <div class="card-body">
                                    <table class="table table-bordered">
                                        <tr>
                                            <th>First Name</th>
                                            <td><input class="form-control" id="name" name="fname" type="text"
                                                    value="<?php echo $result['first_name']; ?>" required /></td>
                                        </tr>
                                        <tr>
                                            <th>Last Name</th>
                                            <td><input class="form-control" id="name" name="lname" type="text"
                                                    value="<?php echo $result['last_name']; ?>" required /></td>
                                        </tr>
                                        <tr>
                                            <th>Email</th>
                                            <td><input class="form-control" id="email" name="email" type="email"
                                                    value="<?php echo $result['email']; ?>" readonly="readonly" required />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Contact No.</th>
                                            <td colspan="2"><input class="form-control" id="phone" name="phone" type="text"
                                                    value="<?php echo $result['phone']; ?>" pattern="[0-9]{10}"
                                                    title="10 numeric characters only" maxlength="10" required /></td>
                                        </tr>
                                        <tr>
                                            <th>Profile updated date</small></th>
                                            <td><input class="form-control" id="updated_date" name="updated_date"
                                                    type="text" value="<?php
                                                    date_default_timezone_set('Asia/Kolkata');
                                                    $date_clicked = date('Y-m-d H:i:sa');
                                                    echo $date_clicked
                                                        ?>" required readonly="readonly" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="4" style="text-align:center ;"><button type="submit"
                                                    class="btn btn-primary btn-block" name="update">Update</button></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </form>
                        </div>
                    <?php } ?>

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