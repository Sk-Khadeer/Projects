package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.User;

public interface UserRepo extends CrudRepository<User,Integer>{

}
