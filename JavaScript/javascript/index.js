// console.log("abc");//bac
// console.log(1+"abc");//1abc
// console.log(9-"abc");//nan
// console.log(9-"4");//5
// console.log("java"+"abc");//javaabc
// console.log("java"-"abc");//nan
// console.log(" "+" ");//  
// console.log(0+" ");//0 
// console.log("true"+"true");//truetrue
// console.log(true+true);//true 2
// console.log(false+false);//false 0
// console.log(true+false);//true 1
// console.log(true-false);//error 1
// console.log(false+true);//true 1
// console.log(false-true);//error -1

function a(){
  console.log("a");
}
 var b=function(){
   return "10";
 }
 var c=b;
 var d=b();
 a();
 console.log(b());
 console.log(b);
 console.log(c);
 console.log(d);
