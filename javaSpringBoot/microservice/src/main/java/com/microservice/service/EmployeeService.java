package com.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.entity.Employee;
import com.microservice.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee getEmployeee(Long id) {
		System.out.println(id);
		Employee employee = employeeRepo.findById(id).get();
		System.out.println(employee);
		return employee;
	}

	public void save(Employee e) {
		employeeRepo.save(e);
	}
}
