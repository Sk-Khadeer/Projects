package com.example.demo.entity;


import lombok.Data;

@Data
public class CityRequest {

	public long id;
	public String cityname;
	public String citycode;
	public int country_id;
	
}
