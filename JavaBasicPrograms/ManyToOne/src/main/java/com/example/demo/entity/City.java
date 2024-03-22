package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;
@Entity
@Data
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String cityName;
    private String cityCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="country_id")
	 private Country country;
}
