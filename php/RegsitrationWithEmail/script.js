const togglePassword = document.querySelector("#togglePassword");
const password = document.querySelector("#id_password");

togglePassword.addEventListener("click", function (e) {
  // toggle the type attribute
  this.classList.toggle("fa-eye-slash");
  const type =
    password.getAttribute("type") === "password" ? "text" : "password";
  password.setAttribute("type", type);
  // toggle the eye slash icon
});
