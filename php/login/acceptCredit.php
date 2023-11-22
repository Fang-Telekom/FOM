<?php
	session_start();
	$code="8";
	
	if(isset($_POST['accept']) && isset($_POST['accept'])){
		
		//Verbindung zum MySQLDatenbankserver aufnehmen
		$con = mysqli_connect("", "fom", "unifom"); //auch möflich: Host, Benutzer, Kennwort, DB
	
		//Datenbank auswählen
		mysqli_select_db($con, "uni");
		//SQL-Abfrage ausführen
		if(mysqli_query($con, "update request set granted='rejected' where kredit={$_POST['kredit']}"))
			$code="9";
		if(mysqli_query($con, "update request set granted='granted' where requester={$_POST['accept']} and kredit={$_POST['kredit']}"))
			$code="10";
		if(mysqli_query($con, "update kredit set requester={$_POST['accept']}, granted='" . date("Y-m-d") . "' where id={$_POST['kredit']}"))
			$code="11";
		// Verbindung schließen
		mysqli_close($con);
	}
	header("Location: willkommen.php?code=$code");
	exit;
	
?>
