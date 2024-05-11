package com.comp.cloudtech.service;

import java.util.List;

import com.comp.cloudtech.UserAccount;

public interface UserAccountService {
	
	List<UserAccount> listUsers();
	
	void saveUser(UserAccount userAccount);
	
	UserAccount updateUser(UserAccount userAccount, Long id);

}
