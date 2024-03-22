<?php session_start();
include('includes/config.php');
// if (strlen($_SESSION['id']==0)) {
//   header('location:logout.php');
//   } else{

?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Dashboard | Registration and Login System</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
        crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
    <?php include_once('inc/navbar.php'); ?>
    <div id="layoutSidenav">
        <?php include_once('inc/sidebar.php'); ?>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid">
                    <div class="container" id="message">
                        <?php
                        if (isset($_SESSION['status'])) {
                            echo "<h5>" . $_SESSION['status'] . "</h5>";
                            unset($_SESSION['status']);
                        }
                        ?>
                    </div>

                    <?php
                    if (isset($_POST['deletebtn'])) {
                        include 'includes/config.php';
                        $stu_id = $_POST['id'];
                        $sql = "delete from user where id={$stu_id}";
                        $result = mysqli_query($con, $sql) or die("Query Unsuccessfull...");
                        header("Location:welcome.php");
                        mysqli_close($con);
                    }
                    ?>


                    <div id="main-content">
                        <h2 class="mb-4 pb-2 pb-md-0 mb-md-5 offset-10">Delete Record</h2>
                        <form class="post-form" action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
                            <div class="form-group">
                                <label>Id</label>
                                <input type="text" name="id" />
                            </div>
                            <input class="submit" type="submit" name="deletebtn" value="Delete" />
                        </form>
                    </div>
                </div>
            </main>
        </div>
    </div>
</body>

</html>