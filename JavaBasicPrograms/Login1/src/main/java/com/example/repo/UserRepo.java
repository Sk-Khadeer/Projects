package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Employee;

public interface UserRepo extends JpaRepository<Employee, Integer> {

}
