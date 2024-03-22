package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
public class ModelRequest {
public Integer id;
public String ModelName;
public double amount;
@Temporal(TemporalType.TIMESTAMP)
private Date relasedDate=new Date(System.currentTimeMillis());

public int brand_id;
}
