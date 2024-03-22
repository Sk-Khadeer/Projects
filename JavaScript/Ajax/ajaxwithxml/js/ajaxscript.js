document.getElementById("btnajax").addEventListener("click", makerequest);
let nam = document.getElementById("name-id");
let ag = document.getElementById("age-id");
function makerequest() {
  const xhr = new XMLHttpRequest();
  xhr.open("GET", "data.xml", true);
  xhr.responseType = "document";
  xhr.onload = () => {
    if (xhr.status === 200) {
      console.log(xhr.response);
      console.log(xhr.response.getElementsByTagName("student"));
      // nam.innerText=xhr.response.name;
      // ag.innerText=xhr.response.age;
    } else {
      console.log("Problem occured");
    }
  };
  xhr.send();
}

//multiple data hadnling by for loop and printing on web
// function makerequest() {
//   const xhr = new XMLHttpRequest();
//   xhr.open("GET", "data.xml", true);
//   xhr.responseType = "document";
//   xhr.onload = () => {
//     if (xhr.status === 200) {
//       x = xhr.response.getElementsByTagName("student");
//       for (i = 0; i < x.length; i++) {
//         data.innerHTML +=
//           "<p>" +
//           x[i].getElementsByTagName("name")[0].childNodes[0].nodeValue +
//           "</p>" +
//           "<p>" +
//           x[i].getElementsByTagName("age")[0].childNodes[0].nodeValue +
//           "</p></br>";
//       }
//     } else {
//       console.log("Problem occured");
//     }
//   };
//   xhr.send();
// }
