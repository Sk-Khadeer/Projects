document.getElementById("btnajax").addEventListener("click", makerequest);

// function
function makerequest() {
  console.log("Button clicked");
  document.write("Clicked");
  const xhr = new XMLHttpRequest();
  xhr.open("GET", "data.txt", true);
  xhr.onload = function () {
    if (xhr.status === 200) {
      console.log(xhr);
      console.log(xhr.responseText);
    } else {
      console.log("Problem occured");
    }
  };
  xhr.send();
}
