package com.example.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Models {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
private String modelName;
private double amount;
@Temporal(TemporalType.TIMESTAMP)
private Date relasedDate=new Date(System.currentTimeMillis());

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="brand_id")

private Brand brand;

}
