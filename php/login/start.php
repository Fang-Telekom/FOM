<!DOCTYPE html>

<html>

<head>
	<meta charset ="UTF-8" />
	<title> Login </title>
<style>
	.error{
		color: red;
	}
	.code{
		color: green;
	}
</style>

</head>

<body>
	<h1> FOM Köln </h1>
	<?php
		if(isset($_GET['error']) && $_GET['error'] == 1){
			echo "<p class='error'> Login-Daten sind nicht korrekt! </p>";
		} else if(isset($_GET['code']) && $_GET['code'] == 1){
			echo "<p class='code'> Nutzer wurde erschaffen! </p>";
		}
	?>
	<form action="login.php" method="post">
		Ihr Name: <br />
		<input type="text" name="name" size="20">
		<br />
		Passwort: <br />
		<input type="password" name="pass" size="20">
		<br />
		<input type="submit" value="Login">
		<input type="reset" value="Reset">
	</ form>		
	<br />
	<p> <a href="register.php"> Ich möchte mich regristieren! </a></p>	

</body>

</html>

