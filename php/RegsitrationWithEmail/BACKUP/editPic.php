<?php
session_start();
$a = $_GET['email'];
$page_title = "Edit Picture";
include('includes/header.php');
include('includes/navbar.php');
?>

<head>
    <title>Edit Picture</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
            background-color: #17a2b8;
            height: 100vh;
        }

        #login .container #login-row #login-column {
            margin-top: 60px;
            max-width: 350px;
            height: 100px;
            border: 1px solid #9C9C9C;
            background-color: #EAEAEA;
        }

        #message {
            color: red;
            margin-top: 20px;
        }

        #login .container #login-row #login-column #login-box #login-form {
            padding: 40px;
        }

        #result {
            color: red;
        }
    </style>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>


<div id="login">
    <h3 class="text-center text-white pt-4">Edit Picture</h3>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <div class="card-body">
                        <form action="editCodepic.php" method="post" enctype="multipart/form-data">
                            <table>
                                <tr>
                                    <td> <label for="image">Image</label> </td>
                                    <td> <input type="file" name="photo" /></td>
                                </tr>
                                <tr>
                                    <div class="form-group mb-3">
                                        <td></td>
                                        <td> <button type="submit" name="update" class="btn btn-primary">Update
                                                Now</button></td>
                                    </div>
                                </tr>
                            </table>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>