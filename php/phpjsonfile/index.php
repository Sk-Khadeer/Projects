<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <div id="main">
        <div id="header">
            <h1>Save From data in JSON FILE</h1>
        </div>
        <div id="table-data">
            <form id="submit_form" method="post" action="saveform.php">
                <table width="100%" cellpadding="10px">
                    <tr>
                        <td width="10%"><label>Name</label> </td>
                        <td> <input type="text" name="fullname" autocomplete="off"> </td>
                    </tr>
                    <tr>
                        <td width="10%"><label>Age</label> </td>
                        <td> <input type="text" name="age" autocomplete="off"></td>
                    </tr>
                    <tr>
                        <td width="10%"><label>City</label> </td>
                        <td> <input type="text" name="city" autocomplete="off"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="submit" id="submit">
                    </tr>
                </table>

            </form>
        </div>
    </div>

</body>

</html>