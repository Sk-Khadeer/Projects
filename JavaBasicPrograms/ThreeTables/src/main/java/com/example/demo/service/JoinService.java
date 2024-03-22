package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Sale;
import com.example.demo.repository.JoinRepo;
@Service
public class JoinService {
@Autowired
private JoinRepo jr;
public Sale save(Sale c) {
	return jr.save(c);
}


}