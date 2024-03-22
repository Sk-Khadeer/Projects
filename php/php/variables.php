<!DOCTYPE html>
<html>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <?php
    // A variable declared within a function has a LOCAL SCOPE and can only be accessed within that function:
    function myTest()
    {
        $x = 5; // local scope
        echo "<p>Variable x inside function is: $x</p><br>";
    }
    myTest();

    // using x outside the function will generate an error
    echo "<p>Variable x outside function is: $x</p><br>";

    //==============================================================================================
//The global keyword is used to access a global variable from within a function.
    $x1 = 5;
    $y1 = 10;

    function myTest1()
    {
        global $x1, $y1;
        $y1 = $x1 + $y1;
    }

    myTest1();
    echo $y1 . "<br>"; // outputs 15
    
    //===============================================================================================
    
    //PHP also stores all global variables in an array called $GLOBALS[index].
//  The index holds the name of the variable. 
    $x2 = 5;
    $y2 = 10;

    function myTest2()
    {
        $GLOBALS['y2'] = $GLOBALS['x2'] + $GLOBALS['y2'];
    }

    myTest2();
    echo $y2 . "<br>";
    ?>

</body>

</html>