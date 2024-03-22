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

import com.example.entity.Role;
import com.example.service.RoleService;

import lombok.Data;


@RestController
public class RoleController {
	@Autowired
    private RoleService rs;
	@PostMapping("/role/create")
	public ResponseEntity<Object> save(@RequestBody Role c)
    {
    	return rs.addRole(c);
    }
	@PostMapping("/onlyrole/create")
	public Role onlyRole(@RequestBody Role c) {
		return rs.saveOnlyRole(c);
	}
    @GetMapping("/role/{id}")
    public Role ger(@PathVariable Long id)
	{
		return rs.getRole(id);
	}
    @GetMapping("/getAllRoles")
    
    public List<Role> getAll(Role c)
    {
    	return rs.getAllRoles(c);
    }
    @PutMapping("/role/update/{id}")
    public Role updateUser(@PathVariable Long id, @RequestBody Role user) {
        return rs.updateRole(user, id);
    }
    @DeleteMapping("role/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return rs.deleteRole(id);
    }

}




