

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
		} else if(isset($_GET['error']) && $_GET['error'] == 2){
			?><p class="error"> Name existiert bereits </p> <?php
		}
	?>

	<h1> Regristrierung </h1>
	<form action="newUser.php" method="post">
		Kreditnehmer
		<input type="radio" id="kreditnehmer" name="request" value="true" checked>
		Kreditgeber
		<input type="radio" id="kreditgeber" name="request" value="false">
		<br />
		Name <br />
		<input type="text" name="name"> <br />
		Passwort <br />
		<input type="password" name="pass"> <br />
		Kapital <br />
		<input type="number" name="kapital"> <br />
		E-Mail <br />
		<input type="text" name="mail"> <br />

		<input type="submit" value="Anmelden"> <input type="reset">
	</form>
</body>

</html>

