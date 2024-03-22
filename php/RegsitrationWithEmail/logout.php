<!-- <?php
session_start();
session_destroy();
?>
<script language="javascript">
    document.location = "index.php";
</script> -->
<?php
session_start();
unset($_SESSION['authenticated']);
unset($_SESSION['auth_user']);
$_SESSION['status'] = "You Logged Out Successfully";
header("Location: login.php");
?>