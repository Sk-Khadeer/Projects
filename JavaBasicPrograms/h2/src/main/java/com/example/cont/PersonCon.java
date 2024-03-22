package com.example.cont;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Person;
import com.example.repo.PersonRepo;

@RestController
@RequestMapping("save")
public class PersonCon {
	@Autowired
	private PersonRepo sr;
	@PostMapping("/per")
	public Person a(@RequestBody Person s)
	{
	return sr.save(s);
	}
	@GetMapping("/all")
	public List<Person> getAll(){
		return sr.findAll();
	}
}
