package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bank_id;
	private String bank_name;
	private String loc;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private BankHolders bh;
	@JsonIgnore
	@OneToMany(targetEntity = BankLoans.class,cascade = CascadeType.ALL)
   private Set<BankLoans> b;
}
