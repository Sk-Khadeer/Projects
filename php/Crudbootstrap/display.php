<?php
include 'db_connect.php';
$limit_per_page = 10;
if (isset($_POST["page_no"])) {
    $page = $_POST["page_no"];
} else {
    $page = 1;
}

$offset = ($page - 1) * $limit_per_page;
$num = ($page - 1) * $limit_per_page + 1;

$sql = "SELECT * FROM users LIMIT {$offset},{$limit_per_page}";
$result = mysqli_query($conn, $sql) or die("Query Unsuccessful.");
$output = "";

if (mysqli_num_rows($result) > 0) {
    $output .= '<table border="1" class="table table-striped" width="100%" cellspacing="0" cellpadding="10px" >
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

    while ($row = mysqli_fetch_assoc($result)) {
        $slno = $row['id'];
        $name = $row['name'];
        $email = $row['email'];
        $mobile = $row['mobile_no'];
        $place = $row['place'];

        $output .= '
        <tr>
        <td scope="row">' . $num . '</td>
        <td scope="row">' . $name . '</td>
        <td scope="row">' . $email . '</td>
        <td scope="row">' . $mobile . '</td>
        <td scope="row">' . $place . '</td>
        <td>
        <button class="btn btn-dark" onclick="getDetails(' . $slno . ')">Update</button>
        <button class="btn btn-danger" onclick="Deleteusers(' . $slno . ')">Delete</button>
        </td>
        </tr>';

        $num++;
    }
    $output .= '</table>';


    $sql_total = "SELECT * FROM users";
    $records = mysqli_query($conn, $sql_total) or die("Query Unsuccessful.");
    $total_record = mysqli_num_rows($records);
    $total_pages = ceil($total_record / $limit_per_page);

    $output .= '<div id="pagination">';

    for ($i = 1; $i <= $total_pages; $i++) {
        if ($i == $page) {
            $class_name = "active";
        } else {
            $class_name = "";
        }
        $output .= "<a class='{$class_name}' id='{$i}' href=''>{$i}</a>";

    }
    $output .= '</div>';

    echo $output;
} else {
    echo "<h2>No Record Found.</h2>";
}
?>