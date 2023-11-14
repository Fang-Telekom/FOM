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

	<style>
		.sticky-header {
        top: 0;
        left: 0;
        width: 100%;
        min-height: 6rem;
        height: auto;
        
        z-index: 100; /*Es über andere Inhalte liegen*/
        margin: 0 auto;
        padding: 0;
        text-align: center;
        position: sticky;

        background-color: black;
        color: white;
        text-align: center;
        line-height: 1;
    	}
		nav{
        position: absolute;
        right: 0;
        bottom: 0;
        width: 100%;
        height: 40px;
        background-color: black;
		}
		a{
			display: inline-block;
			padding: 10px 15px;
			line-height: 1;
			color: white;
			text-decoration: none;
			transition: 0.5s ease-in;
		}
		a:hover{
			border-bottom: 1px solid white;
		}
	</style>
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

