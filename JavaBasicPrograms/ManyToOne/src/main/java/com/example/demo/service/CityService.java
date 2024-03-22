package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.example.demo.entity.City;
import com.example.demo.entity.CityRequest;
import com.example.demo.entity.Country;

import com.example.demo.repository.CityRepo;
import com.example.demo.repository.CountryRepo;
@Service
public class CityService {
	
	@Autowired
	private CityRepo cr;
	
	@Autowired
	private CountryRepo c;
	
	
	public City save(City city) {
		return cr.save(city);
	}

	public City add(CityRequest cityreq) {
		Country country=c.findById(cityreq.country_id);
		City city=new City();
		city.setCityCode(cityreq.citycode);
		city.setCityName(cityreq.cityname);
		city.setCountry(country);
		return cr.save(city);
	}

	public List<City> getcities() {
		return cr.findAll();
	}
	
	public Country saveC(Country c1) {
		return c.save(c1);
	}

	//CountryRepo
	public List<Country> inner(){
		return c.inner();
	}
	
	public List<Country> left(){
		return c.left();
	}
	public List<Country> right(){
		return c.right();
	}
	//CityRepo
	public List<City> inner1(){
		return cr.inner();
	}
	
	public List<City> left1(){
		return cr.left();
	}
	public List<City> right1(){
		return cr.right();
	}
	public List<City> join1(){
		return cr.join();
	}
	
	
	

}
