<?php
	session_start();
	$code="0";
	
	if(isset($_POST['name']) && $_POST['name'] != "" && isset($_POST['id']) && $_POST['id'] != "" &&
	isset($_POST['summe']) && $_POST['summe'] != ""){
		if($_POST['name'] != $_SESSION['name'] && $_POST['id'] != $_SESSION['id']){
			$code="1";
			//Verbindung zum MySQLDatenbankserver aufnehmen
			$con = mysqli_connect("", "fom", "unifom"); //auch möflich: Host, Benutzer, Kennwort, DB
		
			//Datenbank auswählen
			mysqli_select_db($con, "uni");
			//SQL-Abfrage ausführen
			$_SESSION['kapital'] = $_SESSION['kapital'] - $_POST['summe'];
			if(mysqli_query($con, "update user set kapital=" . $_SESSION['kapital'] . " where id='" . $_SESSION['id'] . "'"))
				$code="2";
		
			$kapital=mysqli_fetch_assoc(mysqli_query($con, "select * from user where id='" . $_POST['id'] . "' and name='" . $_POST['name'] . "'"))['kapital'] + $_POST['summe'];
			
			if(mysqli_query($con, "update user set kapital='" . $kapital . "' where id='" . $_POST['id'] . "' and name='" . $_POST['name'] . "'"))
				$code="3";

			mysqli_query($con, "insert into transaction(receiver, sender, sum, comment) value('"
			. $_POST['id'] . "', '" . $_SESSION['id'] . "', '". $_POST['summe'] . "', '". $_POST['comment'] . "')");

			// Verbindung schließen
			mysqli_close($con);
		} else
			$code="-1";
	}
	header("Location: willkommen.php?code=$code");
	exit;
	
?>
