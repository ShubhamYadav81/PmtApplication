package com.pmtspringboot.dao;

public class MasterUserAuthentication {
	public static boolean isMasterUserAuthentication(String userName, String password) {
		boolean result = false;
		final String masterUserName = "shubham";
		final String masterUserPassword = "yadavji81";

		if (masterUserName.equals(userName) && masterUserPassword.equals(password)) {
			result = true;
		}

		return result;

	}
}
