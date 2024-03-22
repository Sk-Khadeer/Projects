var div=document.getElementById("main");
let a=0;
function show(){
	if(a==1){
		div.style.display="block";
		a=0;
	}else{
		div.style.display="none";
		a=1;
	}
}