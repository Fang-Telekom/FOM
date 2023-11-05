<!DOCTYPE html>

<html>

<head>
	<meta charset ="UTF-8" />
	<title> Login </title>
<style>
	.error{
		color: red;
	}
</style>

</head>

<body>

	<?php
		if(isset($_GET['error']) && $_GET['error'] == 1){
			echo "<p class='error'> Login-Daten sind nicht korrekt! </p>";
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

