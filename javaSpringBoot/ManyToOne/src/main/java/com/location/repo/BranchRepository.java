package com.location.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.location.entity.Account;
import com.location.entity.Branch;


@Repository
public interface BranchRepository extends JpaRepository<Account, Integer> {

	void save(Branch branch);

}