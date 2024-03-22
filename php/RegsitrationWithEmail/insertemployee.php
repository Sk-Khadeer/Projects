<?php
include('includes/config.php');

session_start();
if (
    isset($_POST['fname'])
    && isset($_POST['lname'])
    && isset($_POST['email'])
    && isset($_POST['phone'])
    && isset($_POST['place'])
    && isset($_POST['joining_date'])
    && isset($_POST['domain'])
    && isset($_POST['bloodgroup'])
    && isset($_POST['gender'])
    && isset($_POST['designation']
)
) {
    $fname = $_POST['fname'];
    $lname = $_POST['lname'];
    $email = $_POST['email'];
    $phone = $_POST['phone'];
    $place = $_POST['place'];
    $joining_date = $_POST['joining_date'];
    $domain = $_POST['domain'];
    $bloodgroup = $_POST['bloodgroup'];
    $gender = $_POST['gender'];
    $designation = $_POST['designation'];

    $sql = "select * from designation where designation='{$designation}'";

    $result = mysqli_query($con, $sql) or die("Query Unsuccessfull...");
    $num = mysqli_num_rows($result);
    if ($num > 0) {
        while ($row = mysqli_fetch_assoc($result)) {
            $salary = $row['salary'];
        }
    }

    $sql = "insert into `user`(first_name,last_name,email,phone,place,joining_date,domain,bloodgroup,gender,designation,salary) values('$fname','$lname','$email','$phone','$place','$joining_date','$domain','$bloodgroup','$gender','$designation','$salary')";
    $result = mysqli_query($con, $sql);
    if ($result) {
        $_SESSION['status'] = "Successfully Saved..!! ";
        header("Location:dashboard.php");
    } else {
        $_SESSION['status'] = "Employee  Failed";
        header("Location:addEmployee.php");
    }
}
?>