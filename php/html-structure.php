<!--Possible Structure and elements of HTML
Überall können php-Segmente eingefügt werden-->
<?php date_default_timezone_set("Europe/Berlin"); ?>

<!--Dokumenttyp-->
<!DOCTYPE html>

<?php /** Beginn vom Code*/ ?>
<html>

<!--Kopf / Header
//Grund- / Meta- Daten-->
<head>
	<meta charset="UTF-8" />
	<title> Structure </title>
</head>

<style>
	body { background_color: <?php echo "blue"; ?> }
</style>

<body>
	<!--Überschriften (h1 bis h6)-->
	<h1> Hauptüberschrift</h1>
	<h2> Top-Level Unterüberschrift </h2>
	<h3> Unterüberschrift </h3>
	
	<!--Absatz-->
	<p> Ein Absatz </p>	
	<!--//Datum Abfrage mit PHP-->
	<?php
		echo date("j.n.Y");
		//Zeilensprung mit \n--
		print "<br />";
		echo "Ich springe <br /> gerne Zeilen!<br/>";
		//Tabulator mit \t
		print "Ich springe \t gerne in der selbe Zeile!";
	?>
	

	<!--Kursiv-->
	<p><em> Kursives Schreiben</em></p>
	<!--Fettgedruckt-->
	<p><strong> Fettgedruckt </strong></p>
	<!--Verlinkungen (a = anker href = hyper referrence)-->
	<p><a href="www.google.com"> Google Verlinkung </a></p>
	

	geordnete Listen
	<ol>
		<li> 1. Element </li>
		<li> 2. Element </li>
	</ol>
	
	unsortierte Listen
	<ul>
		<li> 1. Element </li>
		<li> 2. Element </li>
	</ul>

	Bilder einbinden
	<img src=/oneFile/pic/flower.jpg" width="400" height="300" alt="Flowers" />
	<br/>
	Tabellen
	<table border="1">
		<tr>
			<th> 1. Reihe, 1. Spalte, Header </th>
			<th> 1. Reihe, 2. Spalte, Header </th>
		</tr>
		<tr>
			<td> 2. Reihe, 1 Spalte, Data </td>
			<td> 2. Reihe, 2 Spalte, Data </td>
		</tr>

</body>

</html>


