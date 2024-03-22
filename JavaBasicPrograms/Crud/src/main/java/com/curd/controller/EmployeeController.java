package com.curd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curd.entity.Employee;
import com.curd.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/save")
	public ResponseEntity<Employee> newEmployee(@RequestBody Employee employee) {
		Employee newEmployee = employeeRepository
				.save(Employee.builder().name(employee.getName()).location(employee.getLocation()).build());
		return new ResponseEntity<>(newEmployee, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getEmployees() {
		try {
			return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<String> getEmployeeById(@PathVariable("id") long id) {
		try {
			Employee e = getEmpRec(id);
			if (e != null) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(id + " id is  not present ", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		Employee emp = getEmpRec(id);
		if (emp != null) {
			emp.setName(employee.getName());
			emp.setLocation(employee.getLocation());
			employeeRepository.save(emp);
			return new ResponseEntity<>("Sucessfully Updated data for this id --- " + id, HttpStatus.OK);
		}
		return new ResponseEntity<>(id + " id is not present ", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long id) {
		try {
			Employee emp = getEmpRec(id);
			if (emp != null) {
				employeeRepository.deleteById(id);
				return new ResponseEntity<>("Sucessfully deleted this record id --- " + id, HttpStatus.OK);
			}
			return new ResponseEntity<>("That " + id + " is  not found ", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllEmployees() {
		try {
			employeeRepository.deleteAll();
			return new ResponseEntity<>("Deleted All Employees", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	private Employee getEmpRec(long id) {
		Optional<Employee> empObj = employeeRepository.findById(id);

		if (empObj.isPresent()) {
			return empObj.get();
		}
		return null;
	}

}