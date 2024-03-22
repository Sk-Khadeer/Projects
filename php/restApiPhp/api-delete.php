<?php

header('Content-Type:application/json');
header('Access-Control-Allow-origin:*');

header('Access-Control-Allow-Methods:DELETE');
header('Access-Control-Allow-Headers:Access-Control-Allow-Headers,Content-Type,Access-Control-Allow-Methods,Authorization,X-Requested-With ');


$data = json_decode(file_get_contents("php://input"), true);
$slno = $data['slno'];


include 'db_connect.php';

$sql = "delete from crud where slno={$slno}";
$result = mysqli_query($conn, $sql) or die("Query Unsuccessful.");
$output = "";
if (mysqli_query($conn, $sql)) {
    echo json_encode(array('message' => '  record deleted successfully.', 'status' => true));

} else {
    echo json_encode(array('message' => ' record not deleted...', 'status' => false));


}
?>