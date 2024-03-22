<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>Constants</h1>

    <?php

    // To create a constant, use the define() function.define(name, value, case-insensitive)
    

    //Create a constant with a case-sensitive name:
    define("GREETING", "Welcome to W3Schools.com!");
    echo GREETING . "<br>";
    // Create a constant with a case-insensitive name:
    // define("GREETINGS", "Welcome to W3Schools.com!", true);
    // echo greetings;
    



    // =====================================================================================================================
    
    // PHP Constant Arrays
    define("cars", [
        "Alfa Romeo",
        "BMW",
        "Toyota"
    ]);
    echo cars[1] . "<br>";




    // =====================================================================================================================
// Constants are Global
// Constants are automatically global and can be used across the entire script.
    
    define("GREETING1", "Welcome2 to W3Schools.com!");

    function myTest()
    {
        echo GREETING1 . "<br>";
    }

    myTest();
    ?>
</body>

</html>