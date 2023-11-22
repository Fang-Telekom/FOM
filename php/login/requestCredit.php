<?php
	session_start();
	$code="6";
	
	if(isset($_POST['credit']) && is_array($_POST['credit'])){
		$code="7";
		//Verbindung zum MySQLDatenbankserver aufnehmen
		$con = mysqli_connect("", "fom", "unifom"); //auch möflich: Host, Benutzer, Kennwort, DB
	
		//Datenbank auswählen
		mysqli_select_db($con, "uni");
		//SQL-Abfrage ausführen

		foreach($_POST['credit'] as $c){
			mysqli_query($con, "insert into request(kredit, requester, granted) value('"
			. $c . "', " . $_SESSION['id'] . ", 'pending')");
		}
		// Verbindung schließen
		mysqli_close($con);
	}
	header("Location: willkommen.php?code=$code");
	exit;
	
?>
