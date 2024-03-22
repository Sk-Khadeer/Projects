package com.example.dao;


import org.springframework.data.repository.CrudRepository;

import com.example.modal.User;

public interface UserRepo extends CrudRepository<User,Long>{

}
