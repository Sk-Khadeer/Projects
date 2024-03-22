<?php
include 'db_connect.php';

if (
    isset($_POST['updateid'])
) {
    $user_id = $_POST['updateid'];

    $sql = "select * from `users` where id=$user_id";

    $result = mysqli_query($conn, $sql);
    $response = array();
    while ($row = mysqli_fetch_assoc($result)) {
        $response = $row; ///inside insert.php we passing data in string format
    }

    // converting php object to json format by using bulidin function
    echo json_encode($response);
} else {
    $response['status'] = 200;
    $response['message'] = "Invalid or data not found";
}



//update query
if (
    isset($_POST['hiddenData'])
) {
    $uniqueId = $_POST['hiddenData'];
    $name = $_POST['updatename'];
    $email = $_POST['updateemail'];
    $mobile = $_POST['updatemobile'];
    $place = $_POST['updateplace'];

    $sql = "update `users` set name='$name', email='$email',mobile_no='$mobile',place='$place' where id=$uniqueId";

    $result = mysqli_query($conn, $sql);


}
?>