console.log(x);
directly(); // console log prints
console.log(directly); //function prints
var x = 10;

console.log(x);
// getname();

//DECLARING FUNCTION IN THREEE WAYS.
// 1. Directly
function directly() {
  console.log("hello");
}

// 2.varaible
var varaible = function () {
  console.log("undefined");
};

//   3. arrow function
var arrow = () => {
  console.log("arrow function undefined");
};
