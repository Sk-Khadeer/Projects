package com.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.location.entity.Account;
import com.location.service.AccountService;

@RestController
public class AccountController {
@Autowired
    private AccountService accountService;


    @PostMapping("/save")
    public String save(@RequestBody Account account) {
    	System.out.println(account);
    	System.out.println(account.getBranch());
    	return accountService.save(account);
    }
}
