document.getElementById("btnajax").addEventListener("click", makerequest);

//getting single data
// let t = document.getElementById("title");
// let b = document.getElementById("body");
// function makerequest() {
//   const xhr = new XMLHttpRequest();
//   xhr.open("GET", "https://dummyjson.com/products/1", true);
//   xhr.responseType = "json";
//   xhr.onload = () => {
//     if (xhr.status === 200) {
//       console.log(xhr.response);
//       t.innerText = xhr.response.title;
//       b.innerText = xhr.response.description;
//     } else {
//       console.log("Problem occured");
//     }
//   };
//   xhr.send();
// }

//multiple data
// function makerequest() {
//   const xhr = new XMLHttpRequest();
//   xhr.open("GET", "https://dummyjson.com/products", true);
//   xhr.responseType = "json";
//   xhr.onload = () => {
//     if (xhr.status === 200) {
//       x = xhr.response.products;
//       console.log(x);
//       for (i = 0; i < x.length; i++) {
//         console.log(x[i].id);
//         console.log(x[i].title);
//         console.log(x[i].description);
//       }
//     } else {
//       console.log("Problem occured");
//     }
//   };

//   xhr.send();
// }

const a = {
  type: "geojson",

  data: {
    type: "Feature",

    geometry: {
      type: "Polygon",

      coordinate: [
        [
          [-70.66002, 45.46022],

          [-67.79141, 45.70258],

          [-67.13734, 45.13745],
        ],
      ],
    },
  },
};
