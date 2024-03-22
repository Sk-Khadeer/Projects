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
        table,
        th,
        td {
            border: 2px solid black;
            border-collapse: collapse;
            width: 300px;
        }
    </style>

</head>

<body class="sb-nav-fixed">
    <?php include_once('inc/navbar.php'); ?>
    <div id="layoutSidenav">
        <?php include_once('inc/sidebar.php'); ?>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4 ">Team Leads List</h1>
                    <div id="main-content">

                        <?php
                        include 'includes/config.php';
                        $sql = "select * from user where designation='team lead'";
                        $result = mysqli_query($con, $sql) or die("Query Unsuccessful...");
                        $num = mysqli_num_rows($result);
                        if ($num > 0) {
                            ?>
                            <table cellpadding="7px">
                                <thead>
                                    <th>Id</th>
                                    <th>FirstName</th>
                                    <th>LastName</th>
                                    <th>Email</th>
                                    <th>phone</th>
                                    <th>domain</th>
                                </thead>
                                <tbody>
                                    <?php
                                    while ($row = mysqli_fetch_assoc($result)) {
                                        ?>
                                        <tr>
                                            <td>
                                                <?php echo $row['id']; ?>
                                            </td>
                                            <td>
                                                <?php echo $row['first_name']; ?>
                                            </td>
                                            <td>
                                                <?php echo $row['last_name']; ?>
                                            </td>
                                            <td>
                                                <?php echo $row['email']; ?>
                                            </td>

                                            <td>
                                                <?php echo $row['phone']; ?>
                                            </td>
                                            <td>
                                                <?php echo $row['domain']; ?>
                                            </td>


                                        </tr>
                                        <?php
                                    }
                                    ?>
                                </tbody>
                            </table>
                            <?php
                        } else {
                            echo "<h2>No Employees Found<h2>";
                        }
                        mysqli_close($con);

                        ?>
                    </div>
                </div>
            </main>
        </div>
    </div>
</body>