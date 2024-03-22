// callback function --- we can pass function in to a another function
// setTimeout(() => {
//   console.log("anonymous");
// }, 2000);
// function a(b) {
//   console.log("a");
//   b();
// }
// a(function b() {
//   console.log("b")

// });

// event listenrers
function attachEventListeners() {
  //   debugger;
  let count = 0;
  document.getElementById("clickme").addEventListener("click", function abc() {
    console.log("button clicked", ++count);
  });
}

attachEventListeners();
