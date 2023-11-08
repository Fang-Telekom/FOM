<?php
	if(isset($_POST['name']) && isset($_POST['pass']) &&
		isset($_POST['kapital']) && isset($_POST['mail'])){
		//Verbindung zum MySQLDatenbankserver aufnehmen
		$con = mysqli_connect("", "fom", "unifom"); //auch möflich: Host, Benutzer, Kennwort, DB
		echo $con;
		//Datenbank auswählen
		mysqli_select_db($con, "uni");
		//SQL-Abfrage ausführen
		if(mysqli_query($con, "insert into user
			(name, pass, kapital, mail) values(
			'" . $_POST['name'] . "',
			'" . md5($_POST['pass']) . "', 
			'" . $_POST['kapital'] . "', 
			'" . $_POST['mail'] . "'")){
				mysqli_close($con);
				echo "HI";
				header("Location: login.php");
				exit;
		} else{
			echo "HIll";
			mysqli_close($con);
			header("Location: register.php?error=1");
			exit;
		}
		
	}
?>