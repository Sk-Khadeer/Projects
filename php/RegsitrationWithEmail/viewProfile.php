<?php

include_once('includes/config.php');
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Profile | Registration and Login System</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
        crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed" style="background: linear-gradient(140deg, #EADEDB 0%, #BC70A4 50%, #BFD641 75%);">
    <?php include_once('inc/navbar.php'); ?>
    <div id="layoutSidenav">
        <?php include_once('inc/sidebar.php'); ?>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <?php
                    $id = $_GET['id'];
                    $user = "select * from user where id='$id'";
                    $user_run = mysqli_query($con, $user);
                    while ($result = mysqli_fetch_array($user_run)) {

                        ?>
                        <h1 class="mt-4">
                            <?php echo $result['first_name']; ?>'s details
                        </h1>
                        <div class="card mb-4">
                            <div class="card-footer text-right py-3">

                                <div class="small"><a href="manageemployees.php">Back</a></div>
                            </div>
                            <div class="card-body">
                                <!-- <a href="edit-profile.php">Edit</a> -->
                                <table class="table table-bordered">
                                    <tr>
                                        <th>First Name</th>
                                        <td>
                                            <?php echo $result['first_name']; ?>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Last Name</th>
                                        <td>
                                            <?php echo $result['last_name']; ?>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Email</th>
                                        <td>
                                            <?php echo $result['email']; ?>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>place</th>
                                        <td colspan="3">
                                            <?php echo $result['place']; ?>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Contact No.</th>
                                        <td colspan="3">
                                            <?php echo $result['phone']; ?>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Joining Date</th>
                                        <td colspan="3">
                                            <?php echo $result['joining_date']; ?>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Domain</th>
                                        <td colspan="3">
                                            <?php echo $result['domain']; ?>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Blood Group</th>
                                        <td colspan="3">
                                            <?php echo $result['bloodgroup']; ?>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Designation</th>
                                        <td colspan="3">
                                            <?php echo $result['designation']; ?>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Salary</th>
                                        <td colspan="3">
                                            <?php echo $result['salary']; ?>
                                        </td>
                                    </tr>


                                    </tbody>
                                </table>
                            </div>
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