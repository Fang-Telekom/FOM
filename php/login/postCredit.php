<?php
	session_start();
	$code="4";
	
	if(isset($_POST['credit']) && $_POST['credit'] != "" && isset($_POST['interest']) && $_POST['interest'] != ""){
		//Verbindung zum MySQLDatenbankserver aufnehmen
		$con = mysqli_connect("", "fom", "unifom"); //auch möflich: Host, Benutzer, Kennwort, DB
	
		//Datenbank auswählen
		mysqli_select_db($con, "uni");
		//SQL-Abfrage ausführen
		if(mysqli_query($con, "insert into kredit(giver, publish, credit, interest) value('"
		. $_SESSION['id'] . "', '" . date("Y-m-d") . "', " . $_POST['credit'] . ", "
		. $_POST['interest'] . ")"))
			$code="5";

		// Verbindung schließen
		mysqli_close($con);
	}
	header("Location: willkommen.php?code=$code");
	exit;
	
?>
