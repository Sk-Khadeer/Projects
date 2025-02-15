<?php
$con = new PDO("mysql:host=localhost;dbname=registrationwithemail", "root", "");
$sql = "select count(country) as count,country from user group by country";
$stmt = $con->prepare($sql);
$stmt->execute();
$arr = $stmt->fetchAll(PDO::FETCH_ASSOC);
?>
<html>

<head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', { 'packages': ['corechart'] });
        google.charts.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Gender', 'Count'],
                <?php foreach ($arr as $key => $val) { ?>
                    ['<?php echo $val['country'] ?>', <?php echo $val['count'] ?>], <?php } ?>
            ]);
            var options = {
                title: 'Country List',
                // is3D: true,
            };
            var chart = new google.visualization.PieChart(document.getElementById('piechart'));
            chart.draw(data, options);
        }
    </script>
</head>

<body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
</body>

</html>