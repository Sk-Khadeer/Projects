<?php

//what is session?
//used to manage informartion across differnet pages.


//session start
session_start();
$_SESSION['name'] = "sridhar";
$_SESSION['role'] = "java";
echo "We have saved the session <br><br>";


//getting the session data
echo "getting data from session";
echo "Welcome " . $_SESSION['name'];
echo "<br> Your role is " . $_SESSION['role'] . "<br>";
?>