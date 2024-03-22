document.getElementById("btnajax").addEventListener("click", makerequest);

// function
// function makerequest() {
//   console.log("Button clicked");
//   document.write("Clicked");
//   const xhr = new XMLHttpRequest();
//   xhr.open("GET", "data.txt", true);
//   xhr.onreadystatechange = showdata;
//   function showdata() {
//     if (xhr.readyState === XMLHttpRequest.DONE) {
//       if (xhr.status === 200) {
//         console.log(xhr);
//         console.log(xhr.responseText);
//       } else {
//         console.log("Problem occured");
//       }
//     }
//   }
//   xhr.send();
// }

//anonymous function
// function makerequest() {
//   console.log("Button clicked");
//   document.write("Clicked");
//   const xhr = new XMLHttpRequest();
//   xhr.open("GET", "data.txt", true);
//   xhr.onreadystatechange = function () {
//     if (xhr.readyState === XMLHttpRequest.DONE) {
//       if (xhr.status === 200) {
//         console.log(xhr);
//         console.log(xhr.responseText);
//       } else {
//         console.log("Problem occured");
//       }
//     }
//   };
//   xhr.send();
// }

//arrow function
function makerequest() {
  console.log("Button clicked");
  document.write("Clicked");
  const xhr = new XMLHttpRequest();
  xhr.open("GET", "data.txt", true);
  xhr.onreadystatechange = () => {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      if (xhr.status === 200) {
        console.log(xhr);
        console.log(xhr.responseText);
      } else {
        console.log("Problem occured");
      }
    }
  };
  xhr.send();
}
