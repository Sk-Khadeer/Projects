<?php

$conn = mysqli_connect("127.0.0.1:3307", "root", "1234", "crud") or die("Connection failed");

$limit_per_page = 5;

$page = "";
if (isset($_POST["page_no"])) {
  $page = $_POST["page_no"];
} else {
  $page = 1;
}

$offset = ($page - 1) * $limit_per_page;

$sql = "SELECT * FROM student LIMIT {$offset},{$limit_per_page}";
$result = mysqli_query($conn, $sql) or die("Query Unsuccessful.");
$output = "";
if (mysqli_num_rows($result) > 0) {
  $output .= '<table border="1" width="100%" cellspacing="0" cellpadding="10px">
      <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Address</th>
      <th>Class</th>
      <th>Phone</th>
      <th>Gender</th> 
      </tr>';
  while ($row = mysqli_fetch_assoc($result)) {
    $output .= "<tr>
    <td>{$row["id"]}</td>
    <td>{$row["name"]} </td>
    <td>{$row["address"]}</td>
    <td>{$row["class"]} </td>
    <td>{$row["phone"]}</td>
    <td>{$row["gender"]}</td>
  
    </tr>";
  }
  $output .= "</table>";
  $sql_total = "SELECT * FROM student";
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