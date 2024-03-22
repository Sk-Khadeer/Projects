<?php
include 'db_connect.php';

$search_value = $_POST['searchterm'];

$table = '<table border="1" class="table table-striped" width="100%" cellspacing="0" cellpadding="10px" >
<thead style="background:#27ae60;
color: #fff;">
  <tr>
    <th width="100px">Slno</th>
    <th>Name</th>
    <th>Email</th>
    <th>Mobile</th>
    <th>Place</th>
    <th>Operations</th>
  </tr>  
  </thead>';
$sql = "select * from `users` where name like '%{$search_value}%'";
$result = mysqli_query($conn, $sql);
$num = 1; //for displaying  serialwise numbers in table
if (mysqli_num_rows($result) > 0) {
  while ($row = mysqli_fetch_assoc($result)) {
    $slno = $row['id'];
    $name = $row['name'];
    $email = $row['email'];
    $mobile = $row['mobile_no'];
    $place = $row['place'];
    $table .= '
                <tr>
                <td scope="row">' . $num . '</td>
                <td scope="row">' . $name . '</td>
                <td scope="row">' . $email . '</td>
                <td scope="row">' . $mobile . '</td>
                <td scope="row">' . $place . '</td>
                <td>
        <button class="btn btn-dark" onclick="getDetails(' . $slno . ')">Update</button>
        <button class="btn btn-danger" onclick="DeleteUsers(' . $slno . ')">Delete</button>
        </td>
                </tr>';
    $num++;
  }
  $table .= '</table>';
  echo $table;
} else {
  echo "<h2>No Record Found.</h2>";
}
?>