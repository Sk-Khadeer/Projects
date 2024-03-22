package com.example.demo.controller;

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

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;


@RestController
public class EmployeeController
{
	@Autowired
    private EmployeeRepo employeeRepository;


@PostMapping("/employee")
public ResponseEntity<Employee> newEmployee(@RequestBody Employee employee) 
{
    Employee newEmployee = employeeRepository
            .save(Employee.builder()
                    .name(employee.getName()).role(employee.getRole()).gender(employee.getGender()).salary(employee.getSalary()).date(employee.getDate()).build());                 
    return new ResponseEntity<>(newEmployee, HttpStatus.OK);
}

@GetMapping("/employees")
public ResponseEntity<List<Employee>> getEmployees() 
{
    try
    {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    } 
    catch (Exception e) 
    {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


@GetMapping("/employee/{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id)
{
    try 
    {
       Employee e=getEmpRec(id);
       	if(e!=null)
       	{
            return new ResponseEntity<>(e, HttpStatus.OK);
        }
       	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } 
    catch (Exception e) 
    {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

@PutMapping("/employee/{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) 
{
    Employee emp = getEmpRec(id);
    if(emp!=null) 
    {
        emp.setName(employee.getName());
        emp.setRole(employee.getRole());
        emp.setGender(employee.getGender());
        emp.setSalary(employee.getSalary());
        emp.setDate(employee.getDate());
        return new ResponseEntity<>(employeeRepository.save(emp), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}


@DeleteMapping("/employee/{id}")
public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable("id") long id) 
{
    try 
    {
        Employee emp = getEmpRec(id);
        if (emp!=null)
        {
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    catch (Exception e) 
    {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@DeleteMapping("/employees")
public ResponseEntity<HttpStatus> deleteAllEmployees()
{
    try 
    {
        employeeRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    catch (Exception e)
    {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

private Employee getEmpRec(long id) 
{
    Optional<Employee> empObj = employeeRepository.findById(id);

    if(empObj.isPresent()) 
    {
        return empObj.get();
    }
    return null;
  }







}