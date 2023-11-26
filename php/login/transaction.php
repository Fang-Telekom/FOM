<?php

    //Verbindung zum MySQLDatenbankserver aufnehmen
    $con = mysqli_connect("", "fom", "unifom"); //auch möflich: Host, Benutzer, Kennwort, DB
    
    //Datenbank auswählen
    mysqli_select_db($con, "uni");
    //SQL-Abfrage ausführen
    
    $req = (mysqli_query($con, "select sender.name as sender, receiver.name as receiver, transaction.sum, transaction.comment from transaction inner join user receiver on transaction.receiver=receiver.id inner join user sender on transaction.sender=sender.id where receiver.id='" . $_SESSION['id'] ."'"));

    /* Datensätze aus Ergebnis ermitteln,
        * in Array speicher und ausgeben */
    ?> <style> table, th, td{ padding: 5px; } </style>
    
    <table border="1">
        <tr>
            <th> Sender</th>
            <th> Empfänger </th>
            <th> Summe </th> 
            <th> Kommentar </th>
        </tr><?php
    while ($dsatz = mysqli_fetch_assoc($req)){
        echo "<tr> <td> {$dsatz['sender']} </td>";
        echo "<td> {$dsatz['receiver']} </td>";
        echo "<td> {$dsatz['sum']} </td>";
        echo "<td> {$dsatz['comment']} </td> </tr>";
    }
    ?> <table>
    </form> <?php
    // Verbindung schließen
	mysqli_close($con);
?>
