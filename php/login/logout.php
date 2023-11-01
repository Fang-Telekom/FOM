<?php
	session_start();
	$_SESSION = array(); //auf ein leeres Array setzen -> löschen
	if (isset($_COOKIE[session_name()])){ //Cookie löschen
		setcookie(session_name(), "", time() -420000, "/");
	}
	session_destroy();

	$host = htmlspecialchars($_SERVER["HTTP_HOST"]);
	$url = rtrim(dirname(htmlspecialchars($_SERVER["PHP_SELF"])), "/\\");

	$extra = "start.php";
	header("Location: http://$host$uri/$extra");
?>
