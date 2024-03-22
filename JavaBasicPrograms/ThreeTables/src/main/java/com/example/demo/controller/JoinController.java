package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Sale;
import com.example.demo.repository.JoinRepo;
import com.example.demo.service.JoinService;

@RestController
public class JoinController {
@Autowired
private JoinService js;
@Autowired
private JoinRepo jr;
@PostMapping("/company")
public Sale save(@RequestBody Sale c) {
	return js.save(c);
}

@GetMapping("/three")
public List<Sale> get() {
	return jr.get();
}
}
