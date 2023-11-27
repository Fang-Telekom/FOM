<?php
	if(isset($_POST['name']) && $_POST['name'] != "" &&
		isset($_POST['kapital']) && $_POST['kapital'] != "" && isset($_POST['mail']) && $_POST['mail'] != ""){
		//Verbindung zum MySQLDatenbankserver aufnehmen
		$con = mysqli_connect("", "fom", "unifom"); //auch möflich: Host, Benutzer, Kennwort, DB
		
		//Datenbank auswählen
		mysqli_select_db($con, "uni");
		//SQL-Abfrage ausführen
		if(isset($_POST['pass']) && $_POST['pass'] != ""){
			mysqli_query($con, "update user set pass='" . md5($_POST['pass']) . "' where id='". $_POST['id'] . "'");
		}
		mysqli_query($con, "update user set name='" . $_POST['name'] .
				 "', kapital='" . $_POST['kapital'] . "', mail='" . $_POST['mail']
				 . "', request='" . (isset($_POST['request']) && $_POST['request']) . "', admin='" . (isset($_POST['admin']) && $_POST['admin']) . "' where id='". $_POST['id'] . "'");
		mysqli_close($con);
		header("Location: admin.php?code=1");
		exit;
		
	}
	header("Location: admin.php?code=2");
	
?>
