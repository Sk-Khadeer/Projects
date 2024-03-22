<?php
echo "welcome to world of cookies.";
//setCookie
setcookie("category", "books", time() + 86400, "/");
echo " The cookie is set.<br>";


//getting cookies
$c = $_COOKIE['category'];
echo "here is the list of all $c";
?>