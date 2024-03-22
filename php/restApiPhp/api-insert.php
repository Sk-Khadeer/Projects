<?php

header('Content-Type:application/json');
header('Access-Control-Allow-origin:*');
header('Access-Control-Allow-Methods:POST');
header('Access-Control-Allow-Headers:Access-Control-Allow-Headers,Content-Type,Access-Control-Allow-Methods,Authorization,X-Requested-With ');

$data = json_decode(file_get_contents("php://input"), true);
// $slno = $data['slno'];
$name = $data['name'];
$email = $data['email'];


include 'db_connect.php';

$sql = "insert into crud(name,email) values('{$name}','{$email}')";
if (mysqli_query($conn, $sql)) {
    echo json_encode(array('message' => '  record inserted successfully.', 'status' => true));

} else {
    echo json_encode(array('message' => ' Data not inserted...', 'status' => false));


}
?>