<?php
	$text = array("Hello World!", "Hello PHP!", "Hello Web!");
	$random = rand(0, count($text) - 1);
	
	echo "Der zufällig ausgewählte text ist:<br/>" . $text[$random] . "\n";

?>
