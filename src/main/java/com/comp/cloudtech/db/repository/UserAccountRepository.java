package com.comp.cloudtech.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comp.cloudtech.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}
