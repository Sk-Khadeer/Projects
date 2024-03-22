package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long>{

}
