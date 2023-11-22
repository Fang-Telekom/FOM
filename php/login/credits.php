<?php

    //Verbindung zum MySQLDatenbankserver aufnehmen
    $con = mysqli_connect("", "fom", "unifom"); //auch möflich: Host, Benutzer, Kennwort, DB
    
    //Datenbank auswählen
    mysqli_select_db($con, "uni");
    //SQL-Abfrage ausführen
    
    $req = (mysqli_query($con, "select * from kredit inner join user on kredit.giver=user.id"));

    /* Datensätze aus Ergebnis ermitteln,
        * in Array speicher und ausgeben */
    ?> <style> table, th, td{ padding: 5px; } </style>
    
    <form action="request.php" method="post">
    <table border="1">
        <tr>
            <th> Kredit ID</th>
            <th> Leiher </th>
            <th> Kredit </th> 
            <th> Zins </th>
            <th> Veröffentlicht </th>
            <th> Anfragen </th>
        </tr><?php
    while ($dsatz = mysqli_fetch_assoc($req)){
        echo "<tr> <td> {$dsatz['kredit.id']} </td>";
        echo "<td> {$dsatz['user.name']} </td>";
        echo "<td> {$dsatz['credit']} </td>";
        echo "<td> {$dsatz['interest']} </td>";
        echo "<td> {$dsatz['publish']} </td>";
        echo "<td> <input type=checkbox name=credit[] value={$dsatz['kredit.id']}> </td> </tr>";
    }
    ?> <table> 
    </form> <?php
    // Verbindung schließen
	mysqli_close($con);
?>