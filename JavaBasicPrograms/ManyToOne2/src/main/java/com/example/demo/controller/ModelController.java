package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ModelRequest;
import com.example.demo.entity.Models;
import com.example.demo.repository.Model;
import com.example.demo.service.ModelService;

@RestController
public class ModelController {

	@Autowired
	private ModelService ms;
	@Autowired
	private Model modelRepo;
	
	@PostMapping("/MODEL")
	public Models m(@RequestBody Models m) {
		return  modelRepo.save(m);
	}
	
	@PostMapping("/SAVEMODEL")
	public Models m(@RequestBody ModelRequest req) {
		return ms.m(req);
	}
	
	
	
	
}
