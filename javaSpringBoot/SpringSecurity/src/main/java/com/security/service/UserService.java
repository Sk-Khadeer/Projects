package com.security.service;

import com.security.entity.User;
import com.security.entity.UserModal;

public interface UserService {

	User registerUser(UserModal userModal);

	void saveVerificationTokenForUser(String token, User user);
}
