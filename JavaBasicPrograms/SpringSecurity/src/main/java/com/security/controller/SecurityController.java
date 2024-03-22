package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.User;
import com.security.entity.UserModal;
import com.security.repository.UserRepository;

@RestController

public class SecurityController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository repository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/register")
	public User reg(@RequestBody UserModal user) {
		User u = new User();
		u.setEmail(user.getEmail());
		u.setPassword(passwordEncoder.encode(user.getPassword()));
		return repository.save(u);
	}

	@PostMapping("/login")
	public ResponseEntity<HttpStatus> login(@RequestBody UserModal user) throws Exception {
		Authentication authentication;
		try {
			authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);

		} catch (BadCredentialsException e) {
			throw new Exception("Invalid Credientals");
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping("/home")
	public String home() {
		return "this is home ";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "this is dashboard ";
	}

	@GetMapping("/profile")
	public String profile() {
		return "this is profile ";
	}
}
