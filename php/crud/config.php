<?php
$servername = "127.0.0.1:3307";
$username = "root";
$password = "1234";
$database = "crud";
$conn = mysqli_connect($servername, $username, $password, $database);
if (!$conn) {
    die("Sorry we failed to connect :" . mysqli_connect_error());
}

?>