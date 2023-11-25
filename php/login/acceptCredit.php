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
		
		//Transfer Money
		if($_POST['id'] != $_SESSION['id']){
			$_SESSION['kapital'] = $_SESSION['kapital'] - $_POST['credit'];
			mysqli_query($con, "update user set kapital=" . $_SESSION['kapital'] . " where id='" . $_SESSION['id'] . "'");
		
			$kapital=mysqli_fetch_assoc(mysqli_query($con, "select * from user where id='" . $_POST['accept'] . "'"))['kapital'] + $_POST['credit'];
			
			mysqli_query($con, "update user set kapital='" . $kapital . "' where id='" . $_POST['accept'] . "'");
		}
		mysqli_query($con, "insert into transaction(receiver, sender, sum, comment) value('"
		. $_POST['accept'] . ", " . $_SESSION['id'] . ", '". $_POST['credit'] . "', 'Your Credit-Request has been approved')");


		// Verbindung schließen
		mysqli_close($con);
	}
	header("Location: willkommen.php?code=$code");
	exit;
	
?>
