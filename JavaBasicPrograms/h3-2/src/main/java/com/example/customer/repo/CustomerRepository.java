package com.example.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.modal1.CustomerModel;
@Repository
public interface CustomerRepository extends CrudRepository <CustomerModel, Integer > {

}
