<?php
	session_start();
	if(isset($_SESSION['login']) &&
		$_SESSION['login'] == 1){
?>
<!DOCTYPE html>

<html>

<head>

	<meta charset="UTF-8" />
	<title> <?php if($_SESSION['request'])
			echo "Willkommen Kreditnehmer";
		else
			echo "Willkommen Kreditgeber"; ?></title>
	<?php include "header.php"; ?>
	
	<style>
		.code{
			color:green;
		}
		.body{       
        width:80%;
        margin: auto;
        background-color: white;

    }
    .row{
        display: flex;
        align-items: center;
        text-align: left;
        margin: auto;
        padding: 1.5rem;
    }
    .w50{
        width: 50%;
    }
	</style>
</head>



<body>
	<div class="body">
<?php
		echo "<h1>Willkommen {$_SESSION['name']} </h1>";
		echo "<p> Kapital: " . $_SESSION['kapital'] . "</p>";
		echo "<p> ID: " . $_SESSION['id'] . "</p>";
?>
		
		<div class="row">
			<div class="w50">
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
					?><p class="code"> Es kann nicht an sich überwiesen werden.</p> <?php
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
			</div>
			<div class="w50">
				<h3> Transaktionen </h3>
				<?php include "transaction.php"; ?>
			</div>
		</div>
		<div class="row">
			<div class="w50">
			<h3> Kredit Board </h3>		
				<h4> Meine Kredit </h4>
				<?php include "myCredit.php";
				?>
			</div>
		</div>
		<div class="row">
			<div class="w50"> <?php
				if(!($_SESSION['request'])){
					echo "<h4> Kreditausschreiben </h4>";

					if(isset($_GET['code']) && $_GET['code'] == 4){
						?><p class="code"> Bitte füllen Sie alles aus </p> <?php
					} else if(isset($_GET['code']) && $_GET['code'] == 5){
						?><p class="code"> Erfolgreich Ausgeschrieben</p> <?php
					}
					?>

					<form action="postCredit.php" method="post">
						Kredithöhe <br/>
						<input type="number" name="credit" size="20">
						<br/>
						Zins (%) <br/>
						<input type="number" name="interest" size="20">
						<br/>
						<input type="submit" value="Auschreiben">
						<input type="reset" value="Reset">
					</form>
			</div>
			<div class="w50">
				<?php
				echo "<h4> Kreditannehmen </h4>";
				if(isset($_GET['code']) && $_GET['code'] == 8){
					?><p class="code"> Bitte wählen Sie mindestens einen Kredit </p> <?php
				} else if(isset($_GET['code']) && $_GET['code'] == 11){
					?><p class="code"> Erfolgreich Angenommen</p> <?php
				}
				include "creditRequest.php";
				}?>
			</div>
		</div>
		<div class="row">
				<?php
			echo "<h4> Ausgeschrieben </h4>";
			if(isset($_GET['code']) && $_GET['code'] == 6){
				?><p class="code"> Bitte wählen Sie mindestens einen Kredit </p> <?php
			} else if(isset($_GET['code']) && $_GET['code'] == 7){
				?><p class="code"> Erfolgreich Ausgeschrieben</p> <?php
			}
			include "credits.php";
			?>
		</div>
	</div>
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

