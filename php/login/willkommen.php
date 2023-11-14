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


	<div class="sticky-header">
        <header app-name="FOM Köln">
        <h1> FOM Köln </h1>
        <nav>
            <a href="/" aria-label="Home"> Home </a>
            

			<?php
				if(isset($_SESSION['admin']) &&
					$_SESSION['admin'] == 1)
					echo "<a href='/termine' aria-label='Termine'> Admin </a>";
			?>
            <a href="logout.php" aria-label="Logout"> LOG OUT </a>
        </nav>
        </header>
    </div>
	
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

