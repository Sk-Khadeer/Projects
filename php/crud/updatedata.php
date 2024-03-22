<?php
$st_id = $_POST['id'];
$st_name = $_POST['name'];
$st_add = $_POST['address'];
$st_class = $_POST['class'];
$st_phone = $_POST['phone'];
$st_gender = $_POST['gender'];
include 'config.php';
$sql = "update student set name='{$st_name}',address='{$st_add}',class='{$st_class}',phone='{$st_phone}',gender='{$st_gender}' where id={$st_id}";
$result = mysqli_query($conn, $sql) or die("Query Unsuccessfull...");
header("Location:http://localhost/crud/index.php");
mysqli_close($conn);

?>