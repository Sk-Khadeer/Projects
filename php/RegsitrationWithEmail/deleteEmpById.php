<?php
$id = $_GET['id'];
include 'includes/config.php';
$sql = "delete from user where id={$id}";
$result = mysqli_query($con, $sql) or die("Query Unsuccessful...");
header("Location:manageemployees.php");
mysqli_close($con);
?>