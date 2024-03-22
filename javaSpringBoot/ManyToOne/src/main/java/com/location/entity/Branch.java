package com.location.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Branch {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    Integer id;
	    String branchCode;
	    String branchName;
}
