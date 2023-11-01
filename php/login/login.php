<?php
	session_start();

	if(isset($_POST['name']) && $_POST['name']=="Hans" &&
		$_POST['pass']="Passwort"){
		$_SESSION['name']="Hans";
		$_SESSION['login']="1";
		header("Location: willkomen.php"); //Header für die Umleitung
		exit;
	}else{
		header("Location: start.php?error=1"); //Setzung des Errors
		exit;
	}
?>

	
