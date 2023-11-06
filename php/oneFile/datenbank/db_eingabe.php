<!DOCTYPE HTML>

<html>

<body>

	<p> Anzeige der Personen mit einem Gehalt zwischen: </p>

	<form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="post">
		<p> <input type="number" name="ug" min="1"/> Untergrenze </p>
		<p> und </p>
		<p> <input type="number" name="og" /> Obergrenze </p>
		
		<p> <input type="submit" /> <input type="reset" /> </p>
	</ form>
</body>

<?php
	$con = mysqli_connect("", "linux", "Hacken03);
	mysqli_select_db($con, "uni");
	$sql = "select name, gehalt from personen";
	$sql .= " where gehalt >= " . $_POST['ug'];
	$sql .= " and gehalt <= " . $_POST['og'];
	$sql .= " order by gehalt";

	$req = mysqli_query($con, $sql);

	$num = mysqli_num_rows($req);
	if($num==0)
		echo "Kein passenden Datensatz gefunden";

	while($dsatz = mysqli_fetch_assoc($req))
		echo $dsatz['name'] . ", " . $dsatz['gehalt'] . "<br />\n";
	mysqli_close($con);

?>

</html>
