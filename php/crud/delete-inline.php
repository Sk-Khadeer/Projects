<?php
$stu_id = $_GET['id'];
include 'config.php';
$sql = "delete from student where id={$stu_id}";
$result = mysqli_query($conn, $sql) or die("Query Unsuccessful...");
header("Location:http://localhost/crud/index.php");
mysqli_close($conn);

?>