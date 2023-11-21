<?php
	//Verbindung zum MySQLDatenbankserver aufnehmen
	$con = mysqli_connect("", "fom", "unifom"); //auch möflich: Host, Benutzer, Kennwort, DB
	
	//Datenbank auswählen
	mysqli_select_db($con, "uni");
	//SQL-Abfrage ausführen
	$req=mysqli_query($con, "update user set kapital='" . $_SESSION['kapital'] - $_POST['summe']. "' where id='" . $_SESSION['id'] . "'");
	//Anzahl Datensätze ermitelln und ausgeben
	$num = mysqli_num_rows($req);

	echo "$num Datensätze wurde gefunden";

	/* Datensätze aus Ergebnis ermitteln,
	 * in Array speicher und ausgeben */
	while ($dsatz = mysqli_fetch_assoc($req)){
		echo $dsatz['name'] . ", "
		. $dsatz['vorname'] . ", "
		. $dsatz['personalnummer'] . ", "
		. $dsatz['gehalt'] . ", "
		. $dsatz['geburtstag'] . "<br />";
	}
	// Verbindung schließen
	mysqli_close($con);
?>


