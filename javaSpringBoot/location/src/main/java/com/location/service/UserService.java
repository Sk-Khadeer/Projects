package com.location.service;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.entity.User;
import com.location.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	
	public User saveUser(User ur) {
		ur.setId(UUID.randomUUID().toString());
		ur.setCreatedDate(new Date());
		return repo.save(ur);
	}
}
