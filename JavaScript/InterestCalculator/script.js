var principal = 0;
var interestRate = 0;
var termOfLoan = 0;
var interest = 0;
var amount = 0;

let buttonClick = document.getElementById("button");

buttonClick.addEventListener("click", function () {
  principal = parseFloat(document.getElementById("principal").value);
  interestRate = parseFloat(document.getElementById("interest").value);
  termOfLoan = parseFloat(document.getElementById("year").value);
  months = termOfLoan * 12;
  interestRate = interestRate / 100;
  interest = principal * interestRate * months;
  amount = (principal + interest).toFixed(2);

  document.getElementById("resultInterest").innerHTML =
    "Total interest : $" + interest.toFixed(2);
  document.getElementById("finalAmount").innerHTML =
    "Total plus interest : $" + principal + " + " + interest + " = " + amount;
});
