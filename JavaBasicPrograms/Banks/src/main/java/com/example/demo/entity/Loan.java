package com.example.demo.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Loan {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int loanId;
private String type;
@ManyToMany(targetEntity = Customer.class,cascade = CascadeType.ALL)
@JoinColumn(name="loanId",referencedColumnName = "loanId")
//@JsonIgnore
private Set<Customer> c;
//@ManyToMany(cascade= CascadeType.REFRESH,fetch = FetchType.LAZY)
//@JoinTable(name="B_L",joinColumns = @JoinColumn(name="loanId"), inverseJoinColumns = @JoinColumn(name="bank_id"))
//@JsonIgnore
//private Set<Customer> c;
}
