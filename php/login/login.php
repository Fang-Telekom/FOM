<?php
	session_start();

	if(isset($_POST['name']) && isset($_POST['pass'])){
		//Verbindung zum MySQLDatenbankserver aufnehmen
		$con = mysqli_connect("", "fom", "unifom"); //auch möflich: Host, Benutzer, Kennwort, DB
		
		//Datenbank auswählen
		mysqli_select_db($con, "uni");
		//SQL-Abfrage ausführen
		$req=mysqli_query($con, "select * from user where name='" . $_POST['name'] .
		"' and pass='" . md5($_POST['pass']) . "'");
		//Anzahl Datensätze ermitelln und ausgeben
		$num = mysqli_num_rows($req);
		$dsatz = mysqli_fetch_assoc($req);
		mysqli_close($con);
		if($num == 1){
			$_SESSION['name'] = $_POST['name'];
			$_SESSION['login'] = "1";
			$_SESSION['admin'] = $dsatz['admin'];
			if($dsatz['request'] == 1)
				header("Location: willkommen.php");
			else
				header("Location: willkommen.php");
			exit;
		} 
	}
	header("Location: start.php?error=1");
	exit;
?>