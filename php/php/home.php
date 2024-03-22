<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>XAMPP</h1>

    <?php

    //Text Printing
    $txt = "PHP";
    echo "I love $txt!" . "<br>";
    echo "I love " . $txt . " langauge" . "<br>";



    //date
    echo "date " . date('j-m-y h-i-s') . "<br>";
    echo "Today is " . date("Y/m/d") . "<br>";
    echo "Today is " . date("Y.m.d") . "<br>";
    echo "Today is " . date("Y-m-d") . "<br>";
    echo "Today is " . date("H a") . "<br>";
    echo "Today is " . date("h a") . "<br>";
    echo "Today is " . date("l");
    ?>
</body>

</html>