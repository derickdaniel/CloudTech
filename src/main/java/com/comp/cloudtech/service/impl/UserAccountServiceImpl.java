package com.comp.cloudtech.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp.cloudtech.UserAccount;
import com.comp.cloudtech.db.repository.UserAccountRepository;
import com.comp.cloudtech.service.UserAccountService;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService{
	
	@Autowired
	UserAccountRepository repo;

	@Override
	public List<UserAccount> listUsers() {
		return repo.findAll();
	}

	@Override
	public void saveUser(UserAccount userAccount) {
		repo.save(userAccount);
	}

}
