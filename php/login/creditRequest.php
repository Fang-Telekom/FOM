<?php
    session_start();	
    //Verbindung zum MySQLDatenbankserver aufnehmen
    $con = mysqli_connect("", "fom", "unifom"); //auch möflich: Host, Benutzer, Kennwort, DB
    
    //Datenbank auswählen
    mysqli_select_db($con, "uni");
    //SQL-Abfrage ausführen
    
    $req = (mysqli_query($con, "select kredit.id, user.name, kredit.credit, user.kapital, user.id as requester from request inner join kredit on request.kredit=kredit.id inner join user on request.requester=user.id where kredit.giver='" . $_SESSION['id'] . "' and request.granted='pending'"));


    /* Datensätze aus Ergebnis ermitteln,
        * in Array speicher und ausgeben */
	?> 
    <style> table, th, td{ padding: 5px; } </style>
    <form action="acceptCredit.php" method="post">
    <table border="1">
        <tr>
            <th> Kredit ID</th>
            <th> Anfrager </th>
            <th> Kapital </th>
            <th> Annehmen </th>
        </tr><?php
    while ($dsatz = mysqli_fetch_assoc($req)){
        echo "<tr> <td> {$dsatz['id']} <input type='hidden' name='kredit' value='{$dsatz['id']}'></td>";
        echo "<td> {$dsatz['name']} </td>";
        echo "<td> {$dsatz['credit']} <input type='hidden' name='credit' value='{$dsatz['credit']}'> </td> ";
        echo "<td> <input type=radio name=accept value={$dsatz['requester']}> </td> </tr>";
    }
    ?> <table>
    <input type="submit" value="Annehmen">
	<input type="reset" value="Reset">
    </form> <?php

    // Verbindung schließen
	mysqli_close($con);
?>
