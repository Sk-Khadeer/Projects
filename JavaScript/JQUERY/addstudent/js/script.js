$(function () {
  $("#button-1").on("click", function (e) {
    e.preventDefault();
    const id = $("#id").val();
    const name = $("#name").val();
    const bal = $("#bal").val();

    if (id === "" || name === "" || bal === "") {
      alert("Please fill all the fields");
    } else {
      var appendText =
        "<p>Id - <b>&nbsp;" +
        id +
        "&nbsp;</b> , <b>&nbsp;" +
        name +
        "&nbsp;</b> ur balance in account is : <b>&nbsp;" +
        bal +
        "&nbsp;</b> .rs</p>";
      $("#output-details").append(appendText);

      $("#id").val("");
      $("#name").val("");
      $("#bal").val("");
    }
  });
});
