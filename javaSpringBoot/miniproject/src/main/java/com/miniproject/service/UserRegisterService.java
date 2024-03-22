package com.miniproject.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.entity.UserRegister;
import com.miniproject.repo.UserRegisterRepo;

@Service
public class UserRegisterService {
	@Autowired
	private UserRegisterRepo registerRepo;

	public UserRegister saveUser(UserRegister ur) {
		ur.setId(UUID.randomUUID().toString());
		ur.setCreatedDate(new Date());
		return registerRepo.save(ur);
	}

	public String valid(UserRegister user) {
		UserRegister ur = registerRepo.findByEmail(user.getEmail());

		if (ur != null) {
			if (ur.getEmail().equals(user.getEmail())) {
				if (ur.getPassword().equals(user.getPassword())) {
					return " login success";
				} else
					return "Wrong Password";
			} else
				return "Email is wrong";
		} else {
			return "User is not registered with this email";
		}

	}

	public String changePassword(UserRegister user) {
		UserRegister ur = registerRepo.findByEmail(user.getEmail());
		String s = null;
		if (ur != null) {
			if (ur.getEmail().equals(user.getEmail())) {
				s = user.getEmail();
			} else
				s = "wrong email";
		}
		return s;
	}

	public String gettingNames(UserRegister user) {
		UserRegister ur = registerRepo.findByEmail(user.getEmail());

		if (ur != null) {
				return ur.getFname()+" "+ur.getLname();
		} else {
			return "User is not registered with this email";
		}
		
	}

	public void updatePassword(UserRegister user) {
		
	}
}
