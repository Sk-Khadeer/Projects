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
                <div class="container-fluid px-4">
                    <h1 class="mt-4 ">Dashboard</h1>
                    <!-- <?php
                    $mail = $_SESSION['email'];
                    $user = "select * from admin where email='$mail'";
                    $user_run = mysqli_query($con, $user);
                    while ($result = mysqli_fetch_array($user_run)) { ?>
                        <div class="row">
                            <div class="col-xl-5 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">Welcome Back
                                        <?php echo $result['first_name']; ?>
                                    </div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="profile.php">View Profile</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <?php } ?>
                    -->
                    <hr />
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">New User</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="completename" class="form-label">Name</label>
                                        <input type="text" class="form-control" id="completename"
                                            placeholder="Enter Your name">
                                    </div>
                                    <div class="mb-3">
                                        <label for="completeemail" class="form-label">Email</label>
                                        <input type="text" class="form-control" id="completeemail"
                                            placeholder="Enter Your Email">
                                    </div>
                                    <div class="mb-3">
                                        <label for="completemobile" class="form-label">Mobile No</label>
                                        <input type="text" class="form-control" id="completemobile"
                                            placeholder="Enter Your Mobile No">
                                    </div>
                                    <div class="mb-3">
                                        <label for="completeplace" class="form-label">Place</label>
                                        <input type="text" class="form-control" id="completeplace"
                                            placeholder="Enter Your Place">
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-dark" id="save-button">Submit</button>
                                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                                </div>
                                <div id="error"
                                    style="position:absolute; background-color:#DEF1D8;color:red;padding:5px;margin:5px;right:10rem;display:none;top:15px">
                                </div>
                            </div>
                        </div>
                    </div>



                    <!-- update model -->

                    <div class="modal fade" id="updateModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Update Details</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label class="form-label">Name</label>
                                        <input type="text" class="form-control" id="updatename"
                                            placeholder="Enter Your name">
                                    </div>
                                    <div class="mb-3">
                                        <label for="updateemail" class="form-label">Email</label>
                                        <input type="text" class="form-control" id="updateemail"
                                            placeholder="Enter Your Email">
                                    </div>
                                    <div class="mb-3">
                                        <label for="updatemobile" class="form-label">Mobile No</label>
                                        <input type="text" class="form-control" id="updatemobile"
                                            placeholder="Enter Your Mobile No">
                                    </div>
                                    <div class="mb-3">
                                        <label for="updateplace" class="form-label">Place</label>
                                        <input type="text" class="form-control" id="updateplace"
                                            placeholder="Enter Your Place">
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-dark" id="update-button">Update</button>
                                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                                    <input type="hidden" id="hiddenData">
                                </div>
                                <div id="updateerror"
                                    style="position:absolute; background-color:#DEF1D8;color:red;padding:5px;margin:5px;right:10rem;display:none;top:15px">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container my-3">


                        <!-- Button trigger modal -->
                        <div style=" padding: 10px; margin: 20px ;">
                            <button type="button" class="btn btn-dark" data-bs-toggle="modal"
                                data-bs-target="#exampleModal">
                                Add New Users
                            </button>
                            <div id="search-bar" style="height: 20px; float: right; ">
                                <label>Search</label>
                                <input type="text" id="search" autocomplete="off">
                            </div>
                        </div>
                        <div class="container" id="displayDataTable"></div>

                    </div>
                </div>

        </div>
        </main>

    </div>


    </div>
    </div>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"></script>
    <script>
        //once the document is ready once refresh it shouldnt varnish
        $(document).ready(function () {
            displayData();

            // saving data into json file


            // add user
            $('#save-button').on("click", function (e) {
                e.preventDefault();
                var nameAdd = $('#completename').val();
                var emailAdd = $('#completeemail').val();
                var mobileAdd = $('#completemobile').val();
                var placeAdd = $('#completeplace').val();
                //ajax will take four parameters(url,type,data,success)
                if (nameAdd == "" || emailAdd == "" || mobileAdd == "" || placeAdd == "") {
                    $('#error').html("All fields are required").slideDown();
                } else {
                    $.ajax({
                        url: "insertemployee.php",
                        type: 'post',
                        data: {
                            nameSend: nameAdd,
                            emailSend: emailAdd,
                            mobileSend: mobileAdd,
                            placeSend: placeAdd
                        },
                        //success will take as callback function with two paramters.
                        success: function (data, status) {
                            //function to display data;
                            // console.log(status);if success our data has to display on web page
                            $('#exampleModal').modal("hide");
                            displayData();
                        }
                    });
                }
            });
            // update record
            $('#update-button').on("click", function (e) {
                e.preventDefault();
                var updatename = $('#updatename').val();
                var updateemail = $('#updateemail').val();
                var updatemobile = $('#updatemobile').val();
                var updateplace = $('#updateplace').val();
                var hiddenData = $('#hiddenData').val();

                var a = false;
                var data = "";
                if (updatename == "") {
                    a = true;
                    data = data.concat("and Name ");
                }
                if (updateemail == "") {
                    a = true;
                    data = data.concat("and Email ");
                }
                if (updatemobile == "") {
                    a = true;
                    data = data.concat("and Mobile");
                }
                if (updateplace == "") {
                    a = true;
                    data = data.concat("and Place");
                }
                if (a) {
                    $('#updateerror').html(data.substring(3, data.length) + " Should not be empty").slideDown();
                } else {
                    $.ajax({
                        url: "update.php",
                        type: 'post',
                        data: {
                            updatename: updatename,
                            updateemail: updateemail,
                            updatemobile: updatemobile,
                            updateplace: updateplace,
                            hiddenData: hiddenData
                        }, success: function (data, status) {
                            $('#updateModal').modal("hide");
                            setTimeout(function () {
                                $('#updateerror').fadeOut();
                            }, 2000);
                            displayData();
                        }
                    });
                }
            });
            //search operation
            $('#search').on("keyup", function () {
                var searchterm = $(this).val();
                $.ajax({
                    url: "search.php",
                    type: 'post',
                    data: {
                        searchterm: searchterm
                    }, success: function (data) {
                        $('#displayDataTable').html(data);
                    }
                });
            });

            //pagination
            function loadTable(page) {
                $.ajax({
                    url: "display.php",
                    type: "POST",
                    data: { page_no: page },
                    success: function (data) {
                        $("#displayDataTable").html(data);
                    }
                });
            }
            loadTable();

            //Pagination Code
            $(document).on("click", "#pagination a", function (e) {
                e.preventDefault();
                var page_id = $(this).attr("id");

                loadTable(page_id);
            })

        });



        // ready fumction complete till up from here userdefined functions

        //display function
        function displayData() {
            var displayData = "true";
            $.ajax({
                url: "display.php",
                type: 'post',
                data: {
                    displaySend: displayData
                }, success: function (data, status) {
                    $('#displayDataTable').html(data);
                }
            });
        }


        //delete record
        function DeleteUser(deleteSlno) {

            $.ajax({
                url: "delete.php",
                type: 'post',
                data: {
                    deleteSend: deleteSlno
                },

                //success will take as callback function with two paramters.
                success: function (data, status) {
                    //function to display data;
                    // console.log(status);if success our data has to display on web page
                    displayData();
                }
            })
        }

        //UPDATE FUNCTION
        function getDetails(updateid) {
            $('#hiddenData').val(updateid);
            $.post("update.php", { updateid: updateid }, function (data, status) {
                var userid = JSON.parse(data);
                $('#updatename').val(userid.name);
                $('#updateemail').val(userid.email);
                $('#updatemobile').val(userid.mobile);
                $('#updateplace').val(userid.place);
            });
            $('#updateModal').modal("show");
        }
    </script>
</body>
<?php include('inc/footer.php'); ?>

</html>
<?php //} ?>