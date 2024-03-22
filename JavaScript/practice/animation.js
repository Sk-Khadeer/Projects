//setinterval

// var a = 0;
// var clear = setInterval(Animation, 500); //for clearing interval we have to into variable
// function Animation() {
//   a = a + 20;
//   if (a == 200) {
//     clearInterval(clear);
//   } else {
//     var target = document.getElementById("test");
//     target.style.marginLeft = a + "px";
//   }
// }

//setTimeout

var time = setTimeout(Animation, 1000); //after 3 seconds the width automatically increase
function Animation() {
  var target = document.getElementById("test");
  target.style.width = "750px";
  target.style.alignItems = "centre";
}
function stopAnimation() {
  clearTimeout(time);
}
