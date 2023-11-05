<?php
	session_start();
	
	if(isset($_POST['name']) && isset($_POST['pass'])){
		$con = mysqli_connect("", "linux", "Hacken03");
		mysqli_select_db($con, "uni");
	
		$sql = "select * from user where"
			. " name='" . $_POST['name'] . "' and"
			. " pass='" . md5($_POST['pass']) . "'";

		$req = mysqli_query($con, $sql);
		$num = mysqli_num_rows($res);
		
		mysqli_close($con);

		if($num >= 1){
			$_SESSION['name']=$_POST['name'];
			$_SESSION['login']="1";
			header("Location: willkommen.php"); //Header für die Umleitung
			exit;
		}
	}
	header("Location:start.php?error=1"); //Setzung des Errors
	exit;

?>

	
