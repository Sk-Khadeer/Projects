package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;
	public User saveUser(User c) {
		return userRepository.save(c);
	}
	public User onlyUser(User c)
	{
		return userRepository.save(c);
	}
	public User getUser(Long id)
    {
    	return userRepository.findById(id).get();
    }
	public List<User> getAllUsers(User c1)
  	{
  		return userRepository.findAll();
  	}
	public User updateUser(User user, Long id) {
            User newUser = userRepository.findById(id).get();
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setMobile(user.getMobile());
            newUser.setEmail(user.getEmail());
            newUser.setRoles(user.getRoles());
            User savedUser = userRepository.save(newUser);
        return userRepository.save(savedUser);
    }
    public ResponseEntity<String> deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
             return ResponseEntity.ok().body("Successfully deleted the specified user");
        } else return ResponseEntity.badRequest().body("Cannot find the user specified");
    }
}
