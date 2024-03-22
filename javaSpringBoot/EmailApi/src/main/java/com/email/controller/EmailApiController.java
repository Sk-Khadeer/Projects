package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.entity.EmailRequest;
import com.email.service.EmailService;

@RestController
public class EmailApiController {
	@Autowired
	private EmailService emailService;

	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest req) {
		System.out.println(req);
		boolean b = emailService.sendEmail(req.getSubject(), req.getMessage(), req.getTo());
		if (b)
			return ResponseEntity.ok("Email sent successfully....!!!!");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent");

	}
}
