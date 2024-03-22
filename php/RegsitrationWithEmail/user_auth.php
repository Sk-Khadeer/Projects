<?php
session_start();
include('includes/config.php');
if (!isset($_SESSION['authenticated'])) {
	$_SESSION['status'] = "Please Login to Access User Dashboard";
	header("Location: login.php");
	exit(0);
}
if (isset($_POST['type']) && $_POST['type'] == 'ajax') {
	if ((time() - $_SESSION['LAST_ACTIVE_TIME']) > 1000000000000000) {
		echo "logout";
	}
} else {
	if (isset($_SESSION['LAST_ACTIVE_TIME'])) {
		if ((time() - $_SESSION['LAST_ACTIVE_TIME']) > 100000000000000) {
			header('location:logout.php');
			die();
		}
	}
	$_SESSION['LAST_ACTIVE_TIME'] = time();
	if (!isset($_SESSION['IS_LOGIN'])) {
		header('location:index.php');
		die();
	}
}
?>