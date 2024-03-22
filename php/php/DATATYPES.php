<!DOCTYPE html>
<html>

<body>

    <?php
    $x = "Hello world!";
    $y = 'Hello world!';

    echo $x;
    echo "<br>";
    echo $y;
    print "<br>";
    //===========================================================================================================
    // In the following example $x is an integer. The PHP var_dump() function returns the data type and value:
    $x = 5985;
    var_dump($x);
    echo "<br>";
    //Array
    $cars = array("Volvo", "BMW", "Toyota");
    var_dump($cars);
    echo "<br>";
    echo $cars[0];
    echo "<br>";

    //==========================================================================================================
    //class object
    class Car
    {
        public $color;
        public $model;
        public function __construct($color, $model)
        {
            $this->color = $color;
            $this->model = $model;
        }
        public function message()
        {
            return "My car is a " . $this->color . " " . $this->model . "!";
        }
    }

    $myCar = new Car("black", "Volvo");
    echo $myCar->message();
    echo "<br>";
    $myCar = new Car("red", "Toyota");
    echo $myCar->message();
    ?>

</body>

</html>