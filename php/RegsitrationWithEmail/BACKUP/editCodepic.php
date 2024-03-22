<?php
session_start();
include('includes/config.php');
if (isset($_POST['update'])) {
    $a = $_SESSION['auth_user']['email'];
    $file = $_FILES['photo'];
    $filename = $file['name'];
    $filepath = $file['tmp_name'];
    $fileerror = $file['error'];

    if ($fileerror == 0) {
        $destFile = 'images/' . $filename;
        move_uploaded_file($filepath, $destFile);
    } else {
        echo "Not uploaded a file";
    }
    $update = "update user set imagePath='$destFile' where email='$a'";
    $update_run = mysqli_query($con, $update);

    $_SESSION['UPDATE'] = "Updated Successfully!!";
    header("Location: dashboard.php");
}
?>