{{-- variables using in blade in js--}}

@php
    $user="sridhar";
    $car=["benz","audi","bmw","fortuner","verna"];
@endphp
<script>
console.log(@json($user));
var data =@json($car);
console.log("------ using json with arrow function ------");   
    data.forEach(element => {
        console.log(element);
    });
    console.log("------ using json along with annoymous function ------");
    data.forEach(function(a) {
        console.log(a);
    });
    console.log("------- using blade in Javascript -----");
    var data1={{Js::from($car)}};
    data1.forEach(function(a) {
        console.log(a);
    });
</script>