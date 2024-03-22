package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.Role;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class RoleService {
	@Autowired
    private RoleRepository rs;
	@Autowired
    private UserRepository ur;

	public ResponseEntity<Object> addRole(Role role)
	{
		Role newRole = new Role();
		newRole.setName(role.getName());
		newRole.setDescription(role.getDescription());
		List<Role> roleList =  new ArrayList<>();
		roleList.add(newRole);
	
		for(int i=0;i<role.getUsers().size();i++)
		{
			com.example.entity.User newUser =role.getUsers().get(i);
			newUser.setRoles(roleList);
			com.example.entity.User savedUser = ur.save(newUser);
		}
		return ResponseEntity.ok("success");
		
	}
	public Role saveOnlyRole(Role c) {
		return rs.save(c);
	}
	public Role getRole(Long id)
    {
    	return rs.findById(id).get();
    }
	
	public List<Role> getAllRoles(Role c1)
  	{
		
  		return rs.findAll();
  	}
	public Role updateRole(Role user, Long id) {
			Role newUser = rs.findById(id).get();
            newUser.setName(user.getName());
            newUser.setDescription(user.getDescription());
            newUser.setUsers(user.getUsers());
            Role savedUser = rs.save(newUser);
        return rs.save(savedUser);
    }
    public ResponseEntity<String> deleteRole(Long id) {
        if (rs.findById(id).isPresent()) {
            rs.deleteById(id);
             return ResponseEntity.ok().body("Successfully deleted the specified user");
        } else return ResponseEntity.badRequest().body("Cannot find the user specified");
    }}