package com.example.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.modal.ProductModel;
@Repository
public interface ProductRepository  extends CrudRepository<ProductModel,Integer> {

}
