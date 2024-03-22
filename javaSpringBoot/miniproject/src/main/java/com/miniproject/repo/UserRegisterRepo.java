package com.miniproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.entity.UserRegister;

@Repository
public interface UserRegisterRepo extends JpaRepository<UserRegister, String> {

	UserRegister findByEmail(String email);

}
