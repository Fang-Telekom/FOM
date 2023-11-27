<?php

    //Verbindung zum MySQLDatenbankserver aufnehmen
    $con = mysqli_connect("", "fom", "unifom"); //auch möflich: Host, Benutzer, Kennwort, DB
    
    //Datenbank auswählen
    mysqli_select_db($con, "uni");
    //SQL-Abfrage ausführen
    
    $req = (mysqli_query($con, "select * from user"));

    /* Datensätze aus Ergebnis ermitteln,
        * in Array speicher und ausgeben */
    ?> <style> table, th, td{ padding: 5px; } </style>
    
    
    <table border="1">
        <tr>
            <th> User ID</th>
            <th> Name </th>
            <th> Neue Passwort </th> 
            <th> Kapital </th>
            <th> Mail </th>
            <th> Kreditnehmer </th>
            <th> Admin </th>
            <th> Update </th>
        </tr><?php
    while ($dsatz = mysqli_fetch_assoc($req)){
        ?><form action="updateUser.php" method="post">
        <tr> <td> <?php echo $dsatz['id']; ?> <input type='hidden' name='id' value='<?php echo $dsatz['id']; ?>'></td>
        <td> <input type='text' name='name' value='<?php echo $dsatz['name']; ?>'> </td>
        <td> <input type='text' name='pass'> </td>
        <td> <input type='number' name='kapital' value='<?php echo $dsatz['kapital']; ?>'> </td>
        <td> <input type='text' name='mail' value='<?php echo $dsatz['mail']; ?>'> </td>
        <td> <input type='checkbox' name='request' <?php if($dsatz['request']) echo "checked value='1'"; else echo "value='0'"; ?>> </td>
        <td> <input type='checkbox' name='admin' <?php if($dsatz['admin']) echo "checked value='1'"; else echo "value='0'"; ?>> </td> 
        <td><input type="submit" value="Update"></td></tr>
        </form><?php
    }
    ?> <table>
     <?php
    // Verbindung schließen
	mysqli_close($con);
?>
