package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer>{
		Country findById(int id);
		
		@Query(value="select * from country inner join city on country.id=city.country_id",nativeQuery = true)
		List<Country> inner();
		
		
		@Query(value="select * from country right outer join city on country.id=city.country_id",nativeQuery = true)
		List<Country> right();

		@Query(value="select * from country left outer join city on country.id=city.country_id",nativeQuery = true)
		List<Country> left();

}	
