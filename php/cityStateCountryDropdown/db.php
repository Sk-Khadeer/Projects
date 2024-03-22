<?php

$mysql_db_database = "cityStateCountry";
try {
	$con = new PDO("mysql:host=localhost;dbname=$mysql_db_database", "root", "");
} catch (PDOExection $e) {
	echo $e->getMessage();
}
?>