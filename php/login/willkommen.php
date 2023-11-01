<?php
	session_start();
	if(isset($_SESSION['login']) &&
		$_SESSION['login'] == 1){
?>

<!DOCTYPE html>

<html>

<head>

	<meta charset="UTF-8" />
	<title> Willkommen im geschützten Bereich </title>
</head>

<body>

<?php
		echo "<h1>Hallo {$_SESSION['name']} </h1>";
?>
	<p> <a href="logout.php" > LOG OUT </a> </p>
</body>

</html>

