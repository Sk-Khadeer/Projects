<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Php Bootstrap Model</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">New User</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="completename" class="form-label">Name</label>
                        <input type="text" class="form-control" id="completename" placeholder="Enter Your name">
                    </div>
                    <div class="mb-3">
                        <label for="completeemail" class="form-label">Email</label>
                        <input type="email" class="form-control" id="completeemail" placeholder="Enter Your Email">
                    </div>
                    <div class="mb-3">
                        <label for="completemobile" class="form-label">Mobile No</label>
                        <input type="text" class="form-control" id="completemobile" placeholder="Enter Your Mobile No">
                    </div>
                    <div class="mb-3">
                        <label for="completeplace" class="form-label">Place</label>
                        <input type="text" class="form-control" id="completeplace" placeholder="Enter Your Place">
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

    <div class="modal fade" id="updateModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Update Details</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label class="form-label">Name</label>
                        <input type="text" class="form-control" id="updatename" placeholder="Enter Your name">
                    </div>
                    <div class="mb-3">
                        <label for="updateemail" class="form-label">Email</label>
                        <input type="email" class="form-control" id="updateemail" placeholder="Enter Your Email">
                    </div>
                    <div class="mb-3">
                        <label for="updatemobile" class="form-label">Mobile No</label>
                        <input type="text" class="form-control" id="updatemobile" placeholder="Enter Your Mobile No">
                    </div>
                    <div class="mb-3">
                        <label for="updateplace" class="form-label">Place</label>
                        <input type="text" class="form-control" id="updateplace" placeholder="Enter Your Place">
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

        <h1 class=" text-center">PHP CRUD Operations</h1>
        <!-- Button trigger modal -->
        <div style=" padding: 10px; margin: 20px ;">
            <button type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Add New Users
            </button>
            <div id="search-bar" style="height: 20px; float: right; ">
                <label>Search</label>
                <input type="text" id="search" autocomplete="off">
            </div>
        </div>
        <div class="container" id="displayDataTable"></div>

    </div>


    <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script> -->
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
                        url: "insert.php",
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
        function Deleteusers(deleteSlno) {

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

</html>