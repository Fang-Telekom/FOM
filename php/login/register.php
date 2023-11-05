

<html>

<head>
	<meta charset="UTF-8">
	<title> Regristrierung </title>
	
	<style>
		.error{
			color: red;
		}
	</style>

</head>

<body>
	
	<?php 
		if(isset($_GET['error']) && $_GET['error'] == 1){
			?><p class="error"> Bitte füllen Sie alles aus </p> <?php
		}
	?>

	<h1> Regristrierung </h1>
	<form action="newUser.php" method="post">
		Name <br />
		<input type="text" name="name"> <br />
		Passwort <br />
		<input type="password" name="pass"> <br />
		Kapital <br />
		<input type="number" name="kapital"> <br />
		E-Mail <br />
		<inpt type="text" name="mail"> <br />
		<input type="submit" value="Anmelden"> <input type="reset">
	</form>
</body>

</html>

