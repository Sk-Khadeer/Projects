package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Sale;
@Repository
public interface JoinRepo extends JpaRepository<Sale, Integer> {

	@Query(value="select * from company inner join food on company.id=food.company_id inner join sale on food.id=sale.food_id",nativeQuery=true)
	public List<Sale> get();
}
