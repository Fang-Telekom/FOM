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

<div class="sticky-header">
	<header app-name="FOM Köln">
	<h1> FOM Köln </h1>
	<nav>
		<a href=<?php 
			if($_SESSION['request'])
				echo "kreditnehmer.php";
			else {
				echo "kreditgeber.php";
			}?> aria-label="Home"> Home </a>
		

		<?php
			if($_SESSION['admin'] == 1)
				echo "<a href='admin.php' aria-label='Admin'> Admin </a>";
		?>
		<a href="logout.php" aria-label="Logout"> LOG OUT </a>
	</nav>
	</header>
</div>
