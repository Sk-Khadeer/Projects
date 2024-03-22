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

<style>
    /* body {
        background: linear-gradient(140deg, #EADEDB 0%, #BC70A4 50%, #BFD641 75%);
        color: white;
        opacity: 0.95;
    } */

    .backgroundGradient {
        background: linear-gradient(to bottom, white, #4682B4);
        color: white;
        opacity: 0.95;
    }
</style>

<body class="sb-nav-fixed" style="background-color: #B8DC6F;">
    <?php include_once('inc/navbar.php'); ?>
    <div id="layoutSidenav">
        <?php include_once('inc/sidebar.php'); ?>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4 " style="margin-bottom: 50px;">Employee's Dashboard</h1>
                    <div class="row">
                        <div id="menu" style="margin-bottom: 10px; padding-bottom: 10px; max-width: 600px;"
                            class="backgroundGradient col">
                            <ul>
                                <li>
                                    <a href="addEmployee.php">Add Employee</a>
                                </li>
                            </ul>

                            <ul>
                                <li>
                                    <a href="manageemployees.php">All Employees</a>
                                </li>

                            </ul>
                            <ul>

                                <li>
                                    <a href="updateEmployee.php">Update Employee</a>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <a href="deleteEmployee.php">Delete Employee</a>
                                </li>

                            </ul>
                        </div>


                        <div class="col"
                            style="background-color: #FFE34C; margin-bottom: 10px; margin-left:40px;padding-bottom: 10px;max-width: 600px;">
                            <h4 style="width:200px;">Designation List</h4>
                            <ul>
                                <li>
                                    <div>
                                        <a href='trainee.php'>Trainee</a>
                                    </div>
                                </li>
                                <li>
                                    <div>
                                        <a href='junior.php'>Junior</a>
                                    </div>
                                </li>
                                <li>
                                    <div>
                                        <a href='senior.php'>Senior</a>
                                    </div>
                                </li>
                                <li>
                                    <div>
                                        <a href='teamlead.php'>Team Lead</a>
                                    </div>
                                </li>
                            </ul>

                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>
</body>
<?php include('inc/footer.php'); ?>

</html>
<?php //} ?>