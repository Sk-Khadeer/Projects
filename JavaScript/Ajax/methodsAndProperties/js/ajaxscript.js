document.getElementById("btnajax").addEventListener("click", makerequest);

function makerequest() {
  console.log("Button clicked");
  document.write("Clicked");
  const xhr = new XMLHttpRequest();
  xhr.open("GET", "data.txt", true);
  xhr.onload = function () {
    if (xhr.status === 200) {
      console.log("xhr object", xhr);
      console.log("responsetext", xhr.responseText);
      console.log("status", xhr.status);
      console.log("statustext", xhr.statusText);
      console.log("response", xhr.response);
      console.log("responseUrl", xhr.responseURL);
      console.log("withCredentials", xhr.withCredentials);
      console.log(xhr.getResponseHeader("LAST-Modified"));
      console.log(xhr.getAllResponseHeaders());
    } else {
      console.log("Problem occured");
    }
  };

  xhr.send();
}
