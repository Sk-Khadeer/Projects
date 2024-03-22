package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Brand;
import com.example.demo.entity.ModelRequest;
import com.example.demo.entity.Models;
import com.example.demo.repository.BrandRepo;
import com.example.demo.repository.Model;
@Service
public class ModelService {
	
	@Autowired
    private BrandRepo br;
	
	@Autowired
    private Model mr;
	
	
	public Models m(ModelRequest req) {
		Brand brand=br.findById(req.brand_id);
		Models m=new Models();
		m.setModelName(req.ModelName);
		m.setAmount(req.amount);
		
		m.setBrand(brand);
		return mr.save(m);
	}
}
