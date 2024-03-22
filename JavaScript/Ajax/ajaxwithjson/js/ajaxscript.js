document.getElementById("btnajax").addEventListener("click", makerequest);
var nam = document.getElementById("name-id");
var ag = document.getElementById("age-id");
// function makerequest() {
//   const xhr = new XMLHttpRequest();
//   xhr.open("GET", "data.json", true);
//   // we will get o/p in json format.if we want o/p in javascript object use below line.automatically it will parse json to object
//   xhr.responseType = "json";
//   xhr.onload = () => {
//     if (xhr.status === 200) {
//       console.log(xhr.response);
//       nam.innerText = xhr.response.name;
//       ag.innerText = xhr.response.age;
//     } else {
//       console.log("Problem occured");
//     }
//   };
//   xhr.send();
// }

//by using json.parse() function
function makerequest() {
  const xhr = new XMLHttpRequest();
  xhr.open("GET", "data.json", true);
  xhr.onload = () => {
    if (xhr.status === 200) {
      console.log(xhr.response); //json data .....for this data we are parsing now in below line
      let obj = JSON.parse(xhr.response); //javascript object
      console.log(obj); //object
      nam.innerText = obj.name;
      ag.innerText = obj.age;
    } else {
      console.log("Problem occured");
    }
  };
  xhr.send();
}
