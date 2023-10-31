<?php

	echo "Ihre Eingaben <br /> \n";
	echo "Vorname: " . htmlspecialchars($_GET['vorname']) . "<br/>\n";
	echo "Name: " . htmlspecialchars($_GET['name']) . "<br />\n";
	echo "E-Mail: " . htmlspecialchars($_GET['mail']) ."<br />\n";
	echo "Telefonnummer: " . htmlspecialchars($_GET['nummer']) . "<br />\n";

?>
	
