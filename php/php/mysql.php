<?php
echo "We are ready to get Connected to a database <br>";
$servername = "localhost";
$username = "root";
$password = "";
$database = "practice";
//create a connection
$conn = mysqli_connect($servername, $username, $password, $database);

if (!$conn) {
    die("Sorry we failed to connect :" . mysqli_connect_error());
} else {
    echo "Connected";
}



//create a db

$sql = "create database test2";
//passing two arguments connection and query for mysqli_query() function.
// mysqli_qu    ery($conn, $sql); //executed a query

//create a table
$sql = "CREATE TABLE test (
    id INT(6)  AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    )";

// mysqli_query($conn, $sql);

//inserting vlaues
$sql = "INSERT INTO test (firstname, lastname)
VALUES ('John', 'Doe')";
// mysqli_query($conn, $sql);

//by using varaibles we can pass values in insert query
$firstname = "sridhar";
$lastname = "akkaraju";
$sql = "INSERT INTO test (firstname, lastname)
VALUES ('$firstname', '$lastname')";
mysqli_query($conn, $sql);
?>