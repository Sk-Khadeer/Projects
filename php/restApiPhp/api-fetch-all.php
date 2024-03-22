<?php

header('Content-Type:application/json');
header('Access-Control-Allow-origin:*');

include 'db_connect.php';
$sql = "select * from crud";
$result = mysqli_query($conn, $sql) or die("Query Unsuccessful.");
$output = "";

if (mysqli_num_rows($result) > 0) {


    $output = mysqli_fetch_all($result, MYSQLI_ASSOC);
    echo json_encode($output, JSON_PRETTY_PRINT);

} else {
    echo json_encode(array('message' => ' No record found.', 'status' => false));


}
?>