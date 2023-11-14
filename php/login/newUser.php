<?php
	if(isset($_POST['name']) && $_POST['name'] != "" && isset($_POST['pass']) && $_POST['pass'] != "" &&
		isset($_POST['kapital']) && $_POST['kapital'] != "" && isset($_POST['mail']) && $_POST['mail'] != ""){
		//Verbindung zum MySQLDatenbankserver aufnehmen
		$con = mysqli_connect("", "fom", "unifom"); //auch möflich: Host, Benutzer, Kennwort, DB
		
		//Datenbank auswählen
		mysqli_select_db($con, "uni");
		//SQL-Abfrage ausführen
		
		mysqli_query($con, "insert into user (name, pass, kapital, mail, admin) values('" . $_POST['name'] .
			"', '" . md5($_POST['pass']) . "', '" . $_POST['kapital'] . "','" . $_POST['mail'] . "', false)");
		mysqli_close($con);
		header("Location: start.php?code=1");
		exit;
	}
	header("Location: register.php?error=1");
	
?>
