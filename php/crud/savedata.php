<?php
echo $st_name = $_POST['name'];
echo $st_add = $_POST['address'];
echo $st_class = $_POST['class'];
echo $st_phone = $_POST['phone'];
echo $st_gender = $_POST['gender'];
include 'config.php';
$sql = "insert into student(name,address,class,phone,gender) values('{$st_name}','{$st_add}','{$st_class}','{$st_phone}','{$st_gender}')";
$result = mysqli_query($conn, $sql) or die("Query Unsuccessfull...");
$message = "Record  Successfully";
header("Location:http://localhost/crud/index.php");
mysqli_close($conn);
?>