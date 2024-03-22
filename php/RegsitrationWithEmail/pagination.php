<?php

include('includes/config.php');

$limit_per_page = 5;

$page = "";
if (isset($_POST["page_no"])) {
  $page = $_POST["page_no"];
} else {
  $page = 1;
}

$offset = ($page - 1) * $limit_per_page;

$sql = "SELECT * FROM employee LIMIT {$offset},{$limit_per_page}";
$result = mysqli_query($con, $sql) or die("Query Unsuccessful.");
$output = "";
if (mysqli_num_rows($result) > 0) {
  $output .= '<table border="1" width="100%" cellspacing="0" cellpadding="10px">
      <tr>
      <th>Id</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Email</th>     
      <th>Phone</th>
      <th>Domain</th>
      <th>Blood Group</th>
      <th>Gender</th>
      <th>place</th>
      </tr>';
  while ($row = mysqli_fetch_assoc($result)) {
    $output .= "<tr>
    <td>{$row["id"]}</td>
    <td>{$row["fname"]} </td>
    <td>{$row["lname"]}</td>
    <td>{$row["email"]} </td>
    <td>{$row["phone"]}</td>
    <td>{$row["domain"]}</td>
    <td>{$row["bloodgroup"]}</td>
    <td>{$row["gender"]}</td>
    <td>{$row["place"]}</td>
    </tr>";
  }
  $output .= "</table>";
  $sql_total = "SELECT * FROM employee";
  $records = mysqli_query($conn, $sql_total) or die("Query Unsuccessfuly...");
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