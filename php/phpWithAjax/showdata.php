<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <table id="main" border="0" cellspacing="0">
        <tr>
            <td id="header">
                <h1>PHP WITH AJAX</h1>
            </td>
        </tr>
        <tr>
            <td id="table-load">
                <input type="button" id="loadButton" value="Load Data">
            </td>
        </tr>
        <tr>
            <td id="table-data">
                <table id="main" border="1" width="100%" cellpadding="10px" cellspacing="0">
                </table>
            </td>
        </tr>
    </table>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#loadButton').on("click", function (e) {
                $.ajax({
                    url: "ajaxload.php",
                    type: "post",
                    success: function (data) {
                        $('#table-data').html(data);
                    }
                })
            });
        });

    </script>
</body>

</html>