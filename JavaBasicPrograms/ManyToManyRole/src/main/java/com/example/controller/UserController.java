package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
public class UserController {
	@Autowired
    private UserService userService;
	@PostMapping("/user/create")
    public User save(@RequestBody User c)
    {
    	return userService.saveUser(c);
    }
	
    @GetMapping("/{id}")
    	public User ger(@PathVariable Long id)
	{
		return userService.getUser(id);
	}
    @GetMapping("/getAllUsers")
    public List<User> getAll(User c)
    {
    	return userService.getAllUsers(c);
    }
    @PutMapping("/user/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(user, id);
    }
    @DeleteMapping("user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
