<?php
include 'db_connect.php';
extract($_POST);

if (
    isset($_POST['nameSend'])
    && isset($_POST['emailSend'])
    && isset($_POST['mobileSend'])
    && isset($_POST['placeSend'])
) {
    // echo "b";
    $nameSend = $_POST['nameSend'];
    $emailSend = $_POST['emailSend'];
    $mobileSend = $_POST['mobileSend'];
    $placeSend = $_POST['placeSend'];
    $sql = "insert into `users`(name,email,mobile_no,place) values('$nameSend','$emailSend','$mobileSend','$placeSend')";
    $result = mysqli_query($conn, $sql);
}
?>