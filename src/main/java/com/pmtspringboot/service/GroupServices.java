package com.pmtspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmtspringboot.dao.GroupRepository;
import com.pmtspringboot.dto.AccountDto;
import com.pmtspringboot.model.Account;
import com.pmtspringboot.model.Group;

@Service
public class GroupServices {
	@Autowired
	GroupRepository groupRepository;

	public void addAccount(AccountDto grp) {
		Account account = new Account();
		account.setAccountName(grp.getAccountName());
		account.setAccountUrl(grp.getAccountUrl());
		account.setAccountPassword(grp.getAccountPassword());

		if (groupRepository.existsByGroupName(grp.getGroupName())) {

			Optional<Group> optionalGroup = groupRepository.findByGroupName(grp.getGroupName());
			if (optionalGroup.isPresent()) {
				Group group = optionalGroup.get();
				account.setGroup(group);
				group.getAccount().add(account);
				groupRepository.save(group);
			}
		} else {
			Group newGroup = new Group();
			List<Account> accountList = new ArrayList();
			accountList.add(account);
			newGroup.setGroupName(grp.getGroupName());
			newGroup.setAccount(accountList);
			account.setGroup(newGroup);
			groupRepository.save(newGroup);
		}

	}

	public List<Group> allRecord() {
		return (List<Group>) groupRepository.findAll();
	}

	public boolean deleteAccountByGroupName(String groupName) {
		boolean result = false;

		Optional<Group> optionalGroup = groupRepository.findByGroupName(groupName);
		if (optionalGroup.isPresent()) {
			Group grp = optionalGroup.get();
			groupRepository.delete(grp);
			result = true;
		}
		return result;
	}

	public boolean updateGroupNameByGroupName(String oldGroupName, String newGroupName) {
		boolean result = false;

		Optional<Group> optionalGroup = groupRepository.findByGroupName(oldGroupName);
		if (optionalGroup.isPresent()) {
			groupRepository.updateGroupName(oldGroupName, newGroupName);
			result = true;
		}
		return result;
	}
}
