package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	private String bank_name;
	
	


//@ManyToMany(mappedBy="c",cascade= {CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
//@JoinTable(name="C_B",joinColumns = @JoinColumn(name="bid"),
//inverseJoinColumns = @JoinColumn(name="cid"))
//@JsonIgnore
	
	@ManyToMany(targetEntity = Loan.class,cascade = CascadeType.ALL)
	@JoinColumn(name="bid",referencedColumnName = "bid")
	private Set<Loan> l;
}
