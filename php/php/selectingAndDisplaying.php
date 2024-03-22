<?php
$servername = "localhost";
$username = "root";
$password = "";
$database = "practice";
//create a connection
$conn = mysqli_connect($servername, $username, $password, $database);

if (!$conn) {
    die("Sorry we failed to connect :" . mysqli_connect_error());
} else {
    echo "Connection was successfull<br>";
}
$sql = "select * from employee";
$result = mysqli_query($conn, $sql);

//find the number of rows returned
$num = mysqli_num_rows($result);
echo $num . " records found in database <br>";


//Displaying the records returned by sql query
while ($row = mysqli_fetch_assoc($result)) {
    echo $row['sno'] . ". Hello " . $row['name'] . " your role is " . $row['role'] . " from " . $row['date'] . "<br>";
}
echo "<br>";
echo "<br>";
echo "<br>";
echo "<br>";

//UPDATE record using where clause
$sql = "UPDATE `employee` SET `name` = 'aswanth' WHERE `employee`.`sno` = 3";
$result = mysqli_query($conn, $sql);

$aff = mysqli_affected_rows($conn);
echo "<br>Number of affected rows : $aff <br>";
if ($result) {
    echo "We updated the record sucessfully";

} else {
    $err = mysqli_error($conn);
    echo "Not updated record due to this error ---> $err";
}


echo "<br>";
echo "<br>";
echo "<br>";
echo "<br>";

//DELETE record using where clause
$sql = "DELETE FROM `employee` WHERE  `employee`.`sno` = 3";

$result = mysqli_query($conn, $sql);

$aff = mysqli_affected_rows($conn);
echo "<br>Number of affected rows : $aff <br>";
if ($result) {
    echo "Deleted sucessfully";

} else {
    $err = mysqli_error($conn);
    echo "Not deleted record due to this error ---> $err";
}




?>