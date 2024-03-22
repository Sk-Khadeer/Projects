import { name, user, userArguments, test } from "./file1.js";
import { bridge } from "./bridgeBetweenFile1&File2.js";



//we can use alias name for lengthy names in import statement .for example "userArguments as ua"
//if we access all properties from another class then use as import statement.. import * as abc from "./file1.js";

//variable
console.log(name);//abc.name
document.body.innerHTML=name;

//method
user();//abc.user
//method with argument

let a=userArguments("sridhar");// ua("sridhar")
console.log(a);
document.body.innerHTML=a;

//class
let obj=new test();//new abc.test();


//bridge function calling present in bridgeBetweenFile1&File2.js
console.log(bridge());
