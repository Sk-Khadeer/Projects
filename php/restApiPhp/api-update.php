<?php

header('Content-Type:application/json');
header('Access-Control-Allow-origin:*');
header('Access-Control-Allow-Methods:PUT');
header('Access-Control-Allow-Headers:Access-Control-Allow-Headers,Content-Type,Access-Control-Allow-Methods,Authorization,X-Requested-With ');

$data = json_decode(file_get_contents("php://input"), true);
$slno = $data['slno'];
$name = $data['name'];
$email = $data['email'];
$place = $data['place'];

include 'db_connect.php';

$sql = "update crud set name='{$name}',email='{$email}' ,place='{$place}'where slno={$slno}";
if (mysqli_query($conn, $sql)) {
    echo json_encode(array('message' => '  record updated successfully.', 'status' => true));

} else {
    echo json_encode(array('message' => ' Data not updated...', 'status' => false));


}
?>