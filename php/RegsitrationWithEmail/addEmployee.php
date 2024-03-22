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
                    <h2 class="mb-4 pb-2 pb-md-0 mb-md-5 offset-4">Add New Employee</h2>
                    <form class="post-form" action="insertemployee.php" method="post">

                        <div class="row">
                            <div class="col-md-4 mb-4">
                                <div class="form-outline">
                                    <b> <label class="form-label" for="firstName">First Name</label> </b>
                                    <input class="form-control" id="fname" name="fname" type="text"
                                        placeholder="Enter your first name" required />
                                </div>

                            </div>
                            <div class="col-md-4 mb-4">
                                <div class="form-outline">
                                    <b> <label class="form-label" for="lastName">Last Name</label> </b>
                                    <input class="form-control" id="lname" name="lname" type="text"
                                        placeholder="Enter your last name" required />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 mb-4">
                                <div class="form-outline">
                                    <b> <label class="form-label" for="email">Email</label> </b>
                                    <input class="form-control" id="email" name="email" type="email"
                                        placeholder="Enter your email" required />
                                </div>
                            </div>
                            <div class="col-md-4 mb-4">
                                <div class="form-outline">
                                    <b> <label class="form-label" for="phone">Phone</label> </b>
                                    <input class="form-control" id="phone" name="phone" type="number"
                                        placeholder="Enter your mobile no" required />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 mb-4">
                                <div class="form-outline">
                                    <b> <label class="form-label" for="place">Place</label> </b>
                                    <input class="form-control" id="place" name="place" type="text"
                                        placeholder="Enter your address" required />
                                </div>
                            </div>
                            <div class="col-md-4 mb-4">
                                <div class="form-outline">
                                    <b> <label class="form-label" for="date">Joining Date</label> </b>
                                    <input class="form-control" id="date" name="joining_date" type="date"
                                        placeholder="Enter joining date" required />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 mb-4">
                                <div class="form-outline">
                                    <b> <label class="form-label" for="domain">Domain</label> </b>
                                    <select name="domain">
                                        <option value="" selected>Select Domain</option>
                                        <option value="Backend Developer">Backend Developer</option>
                                        <option value="Frontend Developer">Frontend Developer</option>
                                        <option value="Full Stack Developer">Full Stack Developer</option>
                                        <option value="Manual Testing">Manual Testing</option>
                                        <option value="Automation Testing">Automation Testing</option>
                                        <option value="DevOps">DevOps</option>
                                        <option value="System Admin">System Admin</option>
                                        <option value="Hr">Hr</option>
                                        <option value="Business Analyst">Business Analyst</option>
                                        <option value="Finance">Finance</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-md-4 mb-4">
                                <div class="form-outline">
                                    <b> <label class="form-label" for="Blood Group">Blood Group</label> </b>
                                    <select name="bloodgroup">
                                        <option value="" selected>Select Group</option>
                                        <option value="A+">A+</option>
                                        <option value="A-">A-</option>
                                        <option value="B+">B+</option>
                                        <option value="B-">B-</option>
                                        <option value="AB+">AB+</option>
                                        <option value="AB-">AB-</AB-></option>
                                        <option value="0+">0+</option>
                                        <option value="0-">0-</option>
                                    </select>
                                </div>

                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-4 mb-4">
                                <div class="form-outline">
                                    <b> <label class="form-label" for="domain">Designation</label> </b>
                                    <select name="designation">
                                        <option value="" selected>Select Designation</option>
                                        <option value="trainee">trainee </option>
                                        <option value="junior">junior</option>
                                        <option value="senior">senior</option>
                                        <option value="team lead">team lead</option>
                                        <option value="project manager">project manager</option>
                                        <option value="architect">Architect</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-4">
                                <div class=" mb-2 pb-1">
                                    <b> <label class="form-outline" for="Gender">Gender :</label></b>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="gender" id="maleGender"
                                            value="male" />
                                        <label class="form-check-label" for="maleGender">Male</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="gender" id="femaleGender"
                                            value="female" />
                                        <label class="form-check-label" for="femaleGender">Female</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="gender" id="otherGender"
                                            value="other" />
                                        <label class="form-check-label" for="otherGender">Other</label>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-2 mb-3">
                                <div class="form-outline">
                                    <div class="d-grid">
                                        <button type="submit" class="btn btn-primary btn-block" name="submit">Save
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
                </div>
            </main>
        </div>
    </div>
</body>

</html>