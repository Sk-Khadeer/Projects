package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.City;


@Repository
public interface CityRepo extends JpaRepository<City, Integer> {
	
	@Query(value="select * from country inner join city on country.id=city.country_id",nativeQuery = true)
		public List<City> inner();
	
	
	@Query(value="select * from country right outer join city on country.id=city.country_id",nativeQuery = true)
		public List<City> right();

	@Query(value="select * from country left outer join city on country.id=city.country_id",nativeQuery = true)
		public List<City> left();
	
	

	@Query(value="select * from country cross join city ",nativeQuery = true)
	public List<City> join();

}
