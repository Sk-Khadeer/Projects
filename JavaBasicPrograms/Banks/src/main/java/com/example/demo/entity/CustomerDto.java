package com.example.demo.entity;

import java.util.Set;

import lombok.Data;

@Data
public class CustomerDto {
private Set<Customer> c;
private Set<Bank> b;
private Set<Loan> l;
}
