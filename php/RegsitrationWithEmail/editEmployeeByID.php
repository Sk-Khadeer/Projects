<?php session_start();
include('includes/config.php');

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
    <style>
        body {
            background: linear-gradient(180deg, lightyellow, blue);
            /* linear-gradient(to right, rgba(50, 50, 50, 50), rgba(50, 50, 50, 50)); */
            color: white;
            opacity: 0.95;
        }

        h2 {
            text-align: center;
        }

        label {
            color: black;
        }
    </style>
</head>

<body class="sb-nav-fixed">
    <?php include_once('inc/navbar.php'); ?>
    <div id="layoutSidenav">
        <?php include_once('inc/sidebar.php'); ?>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid">
                    <h2 class="mb-4 pb-2 pb-md-0 mb-md-5 ">Edit Employee Details</h2>
                    <?php
                    include 'includes/config.php';
                    $id = $_GET['id'];
                    $sql = "select * from user where id={$id}";

                    $result = mysqli_query($con, $sql) or die("Query Unsuccessfull...");
                    $num = mysqli_num_rows($result);
                    if ($num > 0) {
                        while ($row = mysqli_fetch_assoc($result)) {
                            ?>
                            <form class="post-form" action="updateEmpData.php" method="post">
                                <div class="form-group">
                                    <input type="hidden" name="id" value=" <?php echo $row['id']; ?>" />
                                </div>
                                <div class="row">
                                    <div class="col-md-4 mb-4">
                                        <div class="form-outline">
                                            <b> <label class="form-label" for="firstName">First Name</label> </b>
                                            <input class="form-control" id="fname" name="fname"
                                                value=" <?php echo $row['first_name']; ?>" />
                                        </div>
                                    </div>
                                    <div class=" col-md-4 mb-4">
                                        <div class="form-outline">
                                            <b> <label class="form-label" for="lastName">Last Name</label> </b>
                                            <input class="form-control" id="lname" name="lname"
                                                value=" <?php echo $row['last_name']; ?>" />
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4 mb-4">
                                        <div class="form-outline">
                                            <b> <label class="form-label" for="email">Email</label> </b>
                                            <input class="form-control" id="email" name="email"
                                                value=" <?php echo $row['email']; ?>" />
                                        </div>
                                    </div>
                                    <div class="col-md-4 mb-4">
                                        <div class="form-outline">
                                            <b> <label class="form-label" for="phone">Phone</label> </b>
                                            <input class="form-control" id="phone" name="phone"
                                                value=" <?php echo $row['phone']; ?>" />
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4 mb-4">
                                        <div class="form-outline">
                                            <b> <label class="form-label" for="place">Place</label> </b>
                                            <input class="form-control" id="place" name="place"
                                                value=" <?php echo $row['place']; ?>" />
                                        </div>
                                    </div>
                                    <div class="col-md-4 mb-4">
                                        <div class="form-outline">
                                            <b> <label class="form-label" for="date">Joining Date</label> </b>
                                            <input class="form-control" id="date" name="joining_date" readonly
                                                value=" <?php echo $row['joining_date']; ?>" />
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4 mb-4">
                                        <div class="form-outline">
                                            <b> <label class="form-label" for="salary">Salary</label> </b>
                                            <input class="form-control" id="salary" name="salary"
                                                value=" <?php echo $row['salary']; ?>" />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-outline">
                                            <b> <label class="form-label" for="domain">Domain</label> </b>
                                            <?php
                                            $sql1 = "select * from domains";
                                            $result1 = mysqli_query($con, $sql1) or die("Query Unsuccessfull...");
                                            $num = mysqli_num_rows($result1);
                                            if ($num > 0) {
                                                echo ' <select name="domain">';
                                                while ($row1 = mysqli_fetch_assoc($result1)) {
                                                    if ($row['domain'] == $row1['domain']) {
                                                        $select = "selected";
                                                    } else {
                                                        $select = "";
                                                    }
                                                    echo "<option {$select} value='{$row1['domain']}'>{$row1['domain']}</option>";
                                                }
                                                echo '</select>';
                                            }
                                            ?>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-outline">
                                            <b> <label class="form-label" for="Blood Group">Blood Group</label> </b>
                                            <?php
                                            $sql1 = "select * from blood";
                                            $result1 = mysqli_query($con, $sql1) or die("Query Unsuccessfull...");
                                            $num = mysqli_num_rows($result1);
                                            if ($num > 0) {
                                                echo ' <select name="bloodgroup">';
                                                while ($row1 = mysqli_fetch_assoc($result1)) {
                                                    if ($row['bloodgroup'] == $row1['bloodgroup']) {
                                                        $select = "selected";
                                                    } else {
                                                        $select = "";
                                                    }
                                                    echo "<option {$select} value='{$row1['bloodgroup']}'>{$row1['bloodgroup']}</option>";
                                                }
                                                echo '</select>';
                                            }
                                            ?>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <b> <label class="form-label" for="Designation">Designation</label> </b>
                                                <?php
                                                $sql2 = "select * from designation";
                                                $result2 = mysqli_query($con, $sql2) or die("Query Unsuccessfull...");
                                                $num = mysqli_num_rows($result2);
                                                if ($num > 0) {
                                                    echo ' <select name="designation">';
                                                    while ($row1 = mysqli_fetch_assoc($result2)) {
                                                        if ($row['designation'] == $row1['designation']) {
                                                            $select = "selected";
                                                        } else {
                                                            $select = "";
                                                        }
                                                        echo "<option {$select} value='{$row1['designation']}'>{$row1['designation']}</option>";
                                                    }
                                                    echo '</select>';
                                                }
                                                ?>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div class=" mb-2 pb-1">
                                                <b> <label class="form-outline" for="Gender">Gender :</label></b>
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="gender" id="maleGender"
                                                        value="male" <?php if ($row['gender'] == "male") {
                                                            echo "checked";
                                                        }
                                                        ?>>
                                                    <label class="form-check-label" for="maleGender">Male</label>
                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="gender" id="femaleGender"
                                                        value="female" <?php if ($row['gender'] == "female") {
                                                            echo "checked";
                                                        }
                                                        ?>><label class="form-check-label" for="femaleGender">Female</label>
                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="gender" id="otherGender"
                                                        value="other" <?php if ($row['gender'] == "other") {
                                                            echo "checked";
                                                        }
                                                        ?>>
                                                    <label class="form-check-label" for="otherGender">Other</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-2 mb-3">
                                            <div class="form-outline">
                                                <div class="d-grid">
                                                    <button type="submit" class="btn btn-primary btn-block" name="submit">Update
                                                        Details
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-2 mb-2">
                                            <div class="form-outline">
                                                <div class="d-grid"><button type="reset" class="btn btn-primary btn-block"
                                                        name="reset">Reset</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                            </form>

                            <?php
                        }
                    }
                    ?>
                </div>
        </div>
</body>

</html>