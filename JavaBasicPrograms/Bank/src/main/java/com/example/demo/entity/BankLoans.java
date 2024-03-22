package com.example.demo.entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class BankLoans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loan_id;
	private String loan_name;
	private double loan_percentage;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bank_id")
	private Bank b;
}
