package com.location.entity;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Account {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    Integer id;
	    String accountNumber;
	    String fullName;
	    BigDecimal balance;

	    @ManyToOne(cascade = CascadeType.ALL)
	    Branch branch;
}
