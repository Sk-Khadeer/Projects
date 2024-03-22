<?php
include 'db_connect.php';
$sql = "select * from `crud`";
$result = mysqli_query($conn, $sql);
$num = 1; //for displaying  serialwise numbers in table
if (mysqli_num_rows($result) > 0) {
    $output = '<table id="main" border="1" width="100%" cellpadding="10px" cellspacing="0">
        <tr>
        <th>id</th>
        <th>Name</th>
        <th>EMAIL</th>
        </tr>';
    while ($row = mysqli_fetch_assoc($result)) {
        // $slno = $row['slno'];
        // $name = $row['name'];
        // $email = $row['email'];
        // $mobile = $row['mobile'];
        // $place = $row['place'];
        $output .= "
                        <tr>
                        <td > {$row["slno"]}</td> <td > {$row["name"]}</td> <td > {$row["email"]}</td>
                        </tr>";
    }
    $output .= "</table>";
    mysqli_close($conn);
    echo $output;
} else {
    echo "<h2>Record NOT FOUND</h2>";
}
?>