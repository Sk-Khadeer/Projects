package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.User;
import com.security.entity.UserModal;
import com.security.event.RegistrationCompleteEvent;
import com.security.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController

public class RegistrationContoller {
	@Autowired
	private UserService userService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping("/register")
	public String registerUser(@RequestBody UserModal userModal, final HttpServletRequest request) {
		User user = userService.registerUser(userModal);
		publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
		return "Success";
	}

	private String applicationUrl(HttpServletRequest request) {
		return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	}
}
