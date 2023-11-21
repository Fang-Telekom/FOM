<?php

    //Verbindung zum MySQLDatenbankserver aufnehmen
    $con = mysqli_connect("", "fom", "unifom"); //auch möflich: Host, Benutzer, Kennwort, DB
    
    //Datenbank auswählen
    mysqli_select_db($con, "uni");
    //SQL-Abfrage ausführen
    
    $req = (mysqli_query($con, "select * from request inner join kredit on request.kredit=kredit.id where request.requester='" . $_SESSION['id'] . "' or request.giver='" . $_SESSION['id'] . "'"));

    /* Datensätze aus Ergebnis ermitteln,
        * in Array speicher und ausgeben */
    ?> <table>
        <tr>
            <th> Kreditnummer </th>
            <th> Kredit </th> 
            <th> Status </th>
        </tr><?php
    while ($dsatz = mysqli_fetch_assoc($req)){
        echo "<tr> <td> {$dsatz['id']} </td>";
        echo "<td> {$dsatz['id']} </td>";
        echo "<td> {$dsatz['credit']} </td>";
        echo "<td> {$dsatz['request.granted']} </td> </tr>";
    }
    ?> <table> <?php

    // Verbindung schließen
	mysqli_close($con);
?>