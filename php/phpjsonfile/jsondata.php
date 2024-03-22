<?php
$servername = "localhost";
$username = "root";
$password = "";
$database = "crudbootstrap";
$conn = mysqli_connect($servername, $username, $password, $database);
if (!$conn) {
    die("Sorry we failed to connect :" . mysqli_connect_error());
}
$sql = "SELECT * FROM crud";
$result = mysqli_query($conn, $sql) or die("Query Unsuccessful.");
$output = mysqli_fetch_all($result, MYSQLI_ASSOC);
// $json_data = json_encode($output); we have to pass second paramter because we will get file in readble in good format.
$json_data = json_encode($output, JSON_PRETTY_PRINT);
$file_name = "my-" . date("d-m-y") . ".json";
//if file not exits, it will create by $file_name automatically.
if (file_put_contents("{$file_name}", $json_data)) {
    echo $file_name . "File Created.";
} else {
    echo "Can't insert data in json file";
}
?>