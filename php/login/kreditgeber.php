<?php
	session_start();
	if(isset($_SESSION['login']) &&
		$_SESSION['login'] == 1){
?>
<!DOCTYPE html>

<html>

<head>

	<meta charset="UTF-8" />
	<title> Willkommen Kreditgeber </title>
	<?php include "header.php"; ?>
	
	<style>
		.code{
			color:green;
		}
	</style>
</head>



<body>
	

<?php
		echo "<h1>Willkommen Kreditgeber {$_SESSION['name']} </h1>";
		echo "<p> Kapital: " . $_SESSION['kapital'] . "</p>";
		echo "<p> ID: " . $_SESSION['id'] . "</p>";
?>
		<h3> Geld überweisen </h3>

		<?php 
		if(isset($_GET['code']) && $_GET['code'] == 0){
			?><p class="code"> Bitte füllen Sie alles aus </p> <?php
		} else if(isset($_GET['code']) && $_GET['code'] == 1){
			?><p class="code"> Es besteht keine Verbindung zum Datenbank</p> <?php
		}else if(isset($_GET['code']) && $_GET['code'] == 2){
			?><p class="code"> Die Summe konnte nicht überwiesen werden</p> <?php
		}else if(isset($_GET['code']) && $_GET['code'] == 3){
			?><p class="code"> Die Transaktion war erfolgreich</p> <?php
		}else if(isset($_GET['code']) && $_GET['code'] == -1){
			?><p class="code"> Die zu Überweisende Betrag darf nicht größer sein als dein Kapital</p> <?php
		}
		?>

		<form action="senden.php" method="post">
			<p> Konto ID </p>
			<input type="text" id="id" name="id"> <br/>
			<p> Inhaber Name </p>
			<input type="text" id="name" name="name"> <br/>
			<p> Summe </p>
			<input type="number" id="summe" name="summe"><br/>
			<p> Kommentar </p>
			<input type="text" id="comment" name="comment"> <br/>
			
			<input type="submit" value="Senden">
			<input type="reset" value="Zurücksetzen">
		</form>

		<h3> Kredit Board </h3>

		<h4> Meine Kredit </h4>

		<h4> Kreditausschreiben </h4>

		<h4> Ausgeschrieben </h4>

</body>

</html>

<?php
	} else{
		$host = htmlspecialchars($_SERVER['HTTP_HOST']);
		$url = rtrim(dirname(htmlspecialchars($_SERVER["PHP_SELF"])), "/\\");
		$extra = "start.php";
		header("Location:http://$host$url/$extra");
	}
?>

