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
		if(isset($_POST['request']))
			$request=1;
		else
			$request=0;
		if(isset($_POST['admin']))
			$admin=1;
		else
			$admin=0;
		mysqli_query($con, "update user set name='" . $_POST['name'] .
				 "', kapital='" . $_POST['kapital'] . "', mail='" . $_POST['mail']
				 . "', request='" . $request . "', admin='" . $admin . "' where id='". $_POST['id'] . "'");
		mysqli_close($con);
		header("Location: admin.php?code=1");
		exit;
		
	}
	header("Location: admin.php?code=2");
	
?>
