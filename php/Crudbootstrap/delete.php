<?php
include 'db_connect.php';

if (
    isset($_POST['deleteSend'])
) {
    $unique = $_POST['deleteSend'];

    $sql = "delete from `users` where id=$unique";
    $result = mysqli_query($conn, $sql);

}
?>