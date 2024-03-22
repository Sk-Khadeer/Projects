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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int cid;
private String name;
private String loca;

@ManyToMany(targetEntity=Bank.class, cascade= {CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
//@ManyToMany(targetEntity = Bank.class,cascade = CascadeType.ALL)
@JoinColumn(name="cid",referencedColumnName = "cid")
private Set<Bank> b;
}
