package com.security.event.listener;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.security.entity.User;
import com.security.event.RegistrationCompleteEvent;
import com.security.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

	@Autowired
	private UserService userService;

	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {
		// Create the Verification Token for the User with Link
		User user = event.getUser();
		String token = UUID.randomUUID().toString();
		userService.saveVerificationTokenForUser(token, user);
		// Send Mail to user
		String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;

		// sendVerificationEmail()
		log.info("Click the link to verify your account: {}", url);
	}

}