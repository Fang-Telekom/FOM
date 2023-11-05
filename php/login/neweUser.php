<!DOCTYPE html>

<html>

<head>
	<title> Register </title>
</head>

<body>

<?php
	if(isset($_POST['name']) && isset($_POST['pass']) && isset($_POST['kapital']) && isset($_POST['mail'])){
		$con = mysqli_connect("", "linux", "Hacken03");
		mysqli_select_db($con, "uni");
		$sql ="insert into user";
		$sql .="(name, pass, kapital, mail) values("
			. "'" . $_POST['name'] . "', "
			. "'" . md5($_POST['pass']) . "', "
			. $_POST['kapital'] . ", "
			. "'" . $_POST['mail'] . "')";

		mysqli_query($con, $sql);
		mysqli_close($con);
		sleep(4);
		?> <h1> Sie haben einen neuen Nutzer erschaffen!" <h1>
		<p> Bitte melden Sie sich an. Sie werden zurück geleitet </p>

		<?php
		header("Location: start.php");
	}else{
		header("Location: register.php?error=1");
		exit;

?>

