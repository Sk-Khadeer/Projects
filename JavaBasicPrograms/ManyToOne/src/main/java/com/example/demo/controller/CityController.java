package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.City;
import com.example.demo.entity.CityRequest;
import com.example.demo.entity.Country;

import com.example.demo.service.CityService;

@RestController
public class CityController {
@Autowired
private CityService cs;

@PostMapping("/savecountry")
public Country save(@RequestBody Country c1) {	
return cs.saveC(c1);
}

@PostMapping("/save")
public City save(@RequestBody City city) {	
return cs.save(city);
}
@PostMapping("/savecity")
public City add(@RequestBody CityRequest cityreq) {
	return cs.add(cityreq);
	}

@GetMapping("/GET")
public List<City> get(){
	return 	cs.getcities();
}
//CountryRepo
@GetMapping("/inner")
public List<Country> inner(){
	return 	cs.inner();
}

@GetMapping("/left")
public List<Country> left(){
	return 	cs.left();
}

@GetMapping("/right")
public List<Country> right(){
	return 	cs.right();
}

//CityRepo
@GetMapping("/inner1")
public List<City> inner1(){
	return 	cs.inner1();
}

@GetMapping("/left1")
public List<City> left1(){
	return 	cs.left1();
}

@GetMapping("/right1")
public List<City> right1(){
	return 	cs.right1();
}

@GetMapping("/join1")
public List<City> join1(){
	return 	cs.join1();
}



	
}
