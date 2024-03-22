<?php
include 'includes/config.php';
$id = $_POST['id'];
$fname = $_POST['fname'];
$lname = $_POST['lname'];
$email = $_POST['email'];
$phone = $_POST['phone'];
$place = $_POST['place'];
$domain = $_POST['domain'];
$bloodgroup = $_POST['bloodgroup'];
$gender = $_POST['gender'];
$designation = $_POST['designation'];
$salary = $_POST['salary'];

$sql = "update user set first_name='{$fname}',
last_name='{$lname}',
email='{$email}',
place='{$place}',
phone='{$phone}',
domain='{$domain}',
bloodgroup='{$bloodgroup}',
gender='{$gender}',designation='{$designation}',salary='{$salary}' where id={$id}";
$result = mysqli_query($con, $sql) or die("Query Unsuccessfull...");
header("Location:manageemployees.php");
mysqli_close($con);

?>