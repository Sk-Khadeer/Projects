<?php

try {
	$con = new PDO("mysql:host=localhost:3307;dbname=email", "root", "");
} catch (PDOExection $e) {
	echo $e->getMessage();
}
?>