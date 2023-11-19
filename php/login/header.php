<!DOCTYPE html>

<html>

<head>

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
			<?php $host ='http://' + htmlspecialchars($_SERVER['HTTP_HOST']);
				$url = rtrim(dirname(htmlspecialchars($_SERVER["PHP_SELF"])));
				?>
            <a href="<?php echo $host . $url;?>/willkommen.php" aria-label="Home"> Home </a>
            

			<?php
				if(isset($_SESSION['admin']) &&
					$_SESSION['admin'] == 1)
					echo "<a href='$host$url/admin.php' aria-label='Termine'> Admin </a>";
			?>
            <a href="<?php echo $host . $url;?>/logout.php" aria-label="Logout"> LOG OUT </a>
        </nav>
        </header>
    </div>

</body>

</html>
