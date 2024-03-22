<!DOCTYPE html>
<html>

<body>

    <?php

    //function basic
    function writeMsg()
    {
        echo "Hello world!";
    }

    writeMsg();
    // ==========================================================================================
    
    //with arguments
    function familyName($fname)
    {
        echo "$fname .<br>";
    }

    familyName("Jani");
    familyName("Hege");

    //=============================================================================================
    //  two arguments
    function familyNameWithyear($fname, $year)
    {
        print "$fname Refsnes. Saved.Born in $year <br>";
    }

    familyNameWithyear("Hege", "1975");
    familyNameWithyear("Stale", "1978");
    familyNameWithyear("Kai Jim", "1983");

    //=============================================================================================
    

    //  without using strict:
    function addNumbersNotUsingStrict(int $a, int $b)
    {
        return $a + $b;
    }
    echo addNumbersNotUsingStrict(5, "5");
    //=============================================================================================
    


    //  with using strict:
// To specify strict we need to set declare(strict_types=1);.
    function addNumbersUsingStrict(int $a, int $b)
    {
        return $a + $b;
    }
    echo addNumbersUsingStrict(5, 10);

    //=============================================================================================
    
    //default argument
    
    function setHeight(int $minheight = 50)
    {
        echo "The height is : $minheight <br>";
    }

    setHeight(350);
    setHeight(); // will use the default value of 50
    setHeight(135);
    setHeight(80);
    //=============================================================================================
// To let a function return a value, use the return statement:
    function sum(int $x, int $y)
    {
        $z = $x + $y;
        return $z;
    }

    echo "5 + 10 = " . sum(5, 10) . "<br>";
    //=============================================================================================
// PHP Return Type Declarations
    
    ?>

</body>

</html>