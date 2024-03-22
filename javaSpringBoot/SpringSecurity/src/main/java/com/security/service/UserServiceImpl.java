package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.entity.User;
import com.security.entity.UserModal;
import com.security.entity.VerificationToken;
import com.security.repo.UserRepo;
import com.security.repo.VerificationTokenRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Override
	public User registerUser(UserModal userModal) {
		User user = new User();
		user.setEmail(userModal.getEmail());
		user.setFirstName(userModal.getFirstName());
		user.setLastName(userModal.getLastName());
		user.setRole("USER");
		user.setPassword(passwordEncoder.encode(userModal.getPassword()));

		userRepo.save(user);
		return user;
	}

	@Override
	public void saveVerificationTokenForUser(String token, User user) {
		VerificationToken verificationToken = new VerificationToken(user, token);

		verificationTokenRepository.save(verificationToken);

	}

}
