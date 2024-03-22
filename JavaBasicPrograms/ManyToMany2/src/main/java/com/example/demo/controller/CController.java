package com.example.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CC;
import com.example.demo.entity.College;
import com.example.demo.service.CCService;


@RestController
public class CController {
	@Autowired
	private CCService ccs;

	@PostMapping("/college")
	public ResponseEntity<Set<College>> create(@RequestBody CC dto){
		return new ResponseEntity<Set<College>>(ccs.create(dto),HttpStatus.CREATED);
	}
}
