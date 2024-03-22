//defalut function
export default function(){
    console.log("default function");
}
 

//normal code from here
 let name="sridhar bhai akkaraju";

 function user(){
    console.log("function called");
}

 function userArguments(name){
    return `Hello ${name}`;
}

 class test{
    constructor(){
        console.log("Constructor called");
    }
}

//bridge
function bridge(){
    console.log("bridge function called");
}


//till now we are using export for every thing variable,function and class...
//no need to use those many times we have a shortcut way. 
//  remove all exports in above code and use this line.  i.e.,   export{ name,user,userArguments,test};
export{ name,user,bridge,userArguments,test};