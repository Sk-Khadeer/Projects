package com.sbi;

import java.time.LocalDate;

public class Atm {
	private int id,pin_number;
private String debit_card_number,customer_name,balance;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getPin_number() {
	return pin_number;
}
public void setPin_number(int pin_number) {
	this.pin_number = pin_number;
}
public String getDebit_card_number() {
	return debit_card_number;
}
public void setDebit_card_number(String debit_card_number) {
	this.debit_card_number = debit_card_number;
}
public String getCustomer_name() {
	return customer_name;
}
public void setCustomer_name(String customer_name) {
	this.customer_name = customer_name;
}
public String getBalance() {
	return balance;
}
public void setBalance(String balance) {
	this.balance = balance;
}




}
