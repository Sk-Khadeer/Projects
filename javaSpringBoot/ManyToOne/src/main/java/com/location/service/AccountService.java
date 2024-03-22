package com.location.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.entity.Account;
import com.location.repo.AccountRepository;

@Service
public class AccountService {
@Autowired
    private  AccountRepository accountRepository;

//    public AccountService(AccountRepository accountRepository){
//
//        this.accountRepository = accountRepository;
//    }
//    public Account getAccount(String accountNumber){
//        return  accountRepository.findAccount(accountNumber);
//    }
	public String save(Account account) {
		System.out.println(account.getFullName());
		
		accountRepository.save(account);
		return "inserted";
	}
	
//	public String save(Branch branch) {
//		if(branch!=null) {
//			branchRepository.save(branch);
//		return "inserted";
//		}else {
//			return "failed";
//		}
//	}
}