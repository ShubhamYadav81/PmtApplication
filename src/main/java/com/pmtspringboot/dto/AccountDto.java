package com.pmtspringboot.dto;

public class AccountDto {
	private int accountId;
	private String accountName;
	private String accountUrl;
	private String accountPassword;
	private int groupId;
	private String groupName;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountUrl() {
		return accountUrl;
	}

	@Override
	public String toString() {
		return "AccountDto [accountId=" + accountId + ", accountName=" + accountName + ", accountUrl=" + accountUrl
				+ ", accountPassword=" + accountPassword + "]";
	}

	public void setAccountUrl(String accountUrl) {
		this.accountUrl = accountUrl;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

}
