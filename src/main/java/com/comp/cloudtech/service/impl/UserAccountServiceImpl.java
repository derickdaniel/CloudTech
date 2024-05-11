package com.comp.cloudtech.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp.cloudtech.UserAccount;
import com.comp.cloudtech.db.repository.UserAccountRepository;
import com.comp.cloudtech.service.UserAccountService;
import static java.util.Objects.nonNull;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

	Logger log = LoggerFactory.getLogger(UserAccountServiceImpl.class);

	@Autowired
	UserAccountRepository repo;

	@Override
	public List<UserAccount> listUsers() {
		return repo.findAll();
	}

	@Override
	public void saveUser(UserAccount userAccount) {

		userAccount.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		userAccount = repo.save(userAccount);

		log.info("New user created with id: " + userAccount.getId() + " at: "
				+ new Timestamp(System.currentTimeMillis()));
	}

	@Override
	public UserAccount updateUser(UserAccount userAccount, Long id) {

		Optional<UserAccount> entity = repo.findById(id);

		if (entity.isPresent()) {

			UserAccount existUser = entity.get();
			setFieldsToUpdate(userAccount, existUser);

			repo.save(existUser);

			log.info(
					"User updated with id: " + existUser.getId() + " at: " + new Timestamp(System.currentTimeMillis()));

			return existUser;
		}

		log.info("User not found with id: " + userAccount.getId());

		return new UserAccount();
	}

	private void setFieldsToUpdate(UserAccount userAccount, UserAccount existUser) {

		if (nonNull(userAccount.getFirstName())) {
			existUser.setFirstName(userAccount.getFirstName());
		}

		if (nonNull(userAccount.getLastName())) {
			existUser.setLastName(userAccount.getLastName());
		}

		if (nonNull(userAccount.getEmail())) {
			existUser.setEmail(userAccount.getEmail());
		}

		if (nonNull(userAccount.getMobile())) {
			existUser.setMobile(userAccount.getMobile());
		}
	}
}
