<!DOCTYPE html>

<?php 
	if(isset($_POST['vorname'])){
		$vorname = htmlspecialchars($_POST['vorname']);
		$name = htmlspecialchars($_POST['name']);
		$mail = htmlspecialchars($_POST['mail']);
		$nummer = htmlspecialchars($_POST['nummer']);
	}else{
		$vorname ="";
		$name ="";
		$mail ="";
		$nummer ="";
	}
?>

<html>

	<body>
		<form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="post">
			<input type="radio" name="anrede" value="Dame" checked="checked" /> Dame
			<input type="radio" name="anrede" value="Herr" /> Herr
			<input type="radio" name="anrede" value="nb" /> Non-Binary <br />
			Ihr Vorname: <br />
			<input type="text" name="vorname" size="20" maxlength="30" value="<?php echo $vorname; ?>"/>
			<br />
			Ihr Nachname: <br />
			<input type="text" name="name" size="20" maxlength="30"  value="<?php echo $name; ?>"/>
			<br />
			Ihr E-Mail-Adresse <br />
			<input type="text" name="mail" size="20" maxlength="30" value="<?php echo $mail; ?>">
			<br />
			Ihr Telefonnummer <br/>
			<input type="text" name="nummer" size="20" maxlength="30" value="<?php echo $nummer; ?>">
			<br />
			Nachrichten Thema: <br />
			<select name="thema">
				<option value="beschwerde"> Beschwerde </option>
				<option value="info"> Information </option>
				<option value="danke"> Dankaussage </option>
			</select> <br />

			An: <br />
			<input type="checkbox" name="an[]" value="admin" /> Administrator
			<input type="checkbox" name="an[]" value="creator" /> Creator
			<input type="checkbox" name="an[]" value="proof" /> Proofreader
			<input type="checkbox" name="an[]" value="special" /> Speziell
			<br />

			Nachricht: <br />
			<textarea name="nachricht" rows="3" cols="20"> </textarea>
			
			<br />
			<input type="submit" value="Abschicken" />
		
		</form>

		<?php
			if(!empty($_POST['anrede']))
				echo htmlspecialchars($_POST['anrede']) . " ";
			if (isset($_POST['vorname'])){
				echo "Ihre Eingaben <br />\n";
				echo "Vorname: " . htmlspecialchars($_POST['vorname']) . "<br />\n";
			}
			if(isset($_POST['an']) && is_array($_POST['an'])){
				echo "Ausgewählte Personen: <br /> \n";
				?> <ul> <?php
				foreach($_POST['an'] as $a){
					?> 		
						<li> <?php echo htmlspecialchars($a); ?> </li> <?php
				}
			}

		?>
	</body>
</html>

