<?php
	session_start();
	if(isset($_SESSION['login']) &&
		$_SESSION['login'] == 1){
?>
<?php include "header.php"; ?>
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
</body>

</html>

<?php
	} else{
		$host = htmlspecialchars($_SERVER['HTTP_HOST']);
		$url = rtrim(dirname(htmlspecialchars($_SERVER["PHP_SELF"])), "/\\");
		$extra = "start.php";
		header("Location:http://$host$url/$extra");
	}
?>

