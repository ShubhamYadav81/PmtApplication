package com.pmtspringboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmtspringboot.dao.AccountRepository;
import com.pmtspringboot.model.Account;

@Service
public class AccountServices {
	@Autowired
	AccountRepository accountRepository;

	public Account getAccount(String accountName) {

		Account account = null;
		Optional<Account> optional = accountRepository.getAccountByName(accountName);
		if (optional.isPresent()) {
			account = optional.get();
		}
		return account;
	}

	public boolean deleteAccountByAccountName(String accountName) {
		int flag = 0;

		boolean result = false;
		flag = accountRepository.deleteAccountByName(accountName);
		if (flag > 0) {
			result = true;
		}
		return result;
	}

	public boolean updatePasswordByAccountName(String accountName, String password) {

		boolean result = false;
		Optional<Account> optional = accountRepository.getAccountByName(accountName);
		if (optional.isPresent()) {
			accountRepository.updatePasswordByUserName(accountName, password);
			result = true;
		}

		return result;
	}

}
