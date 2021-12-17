package com.pmtspringboot;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.pmtspringboot.controller.UserController;
import com.pmtspringboot.dto.AccountDto;
import com.pmtspringboot.model.Account;
import com.pmtspringboot.model.Group;
import com.pmtspringboot.service.AccountServices;
import com.pmtspringboot.service.GroupServices;

@WebMvcTest(UserController.class)
@ContextConfiguration(classes = { UserController.class })
@ExtendWith(MockitoExtension.class)

class ControllerTest {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	AccountServices accountServices;
	@MockBean
	GroupServices groupServices;

	@Test
	void shouldReturnAccountWhenValidAcountName() throws Exception {

		when(accountServices.getAccount("shubham")).thenReturn(new Account());
		mockMvc.perform(get("/displayRecordByUserName?user=shubham")).andExpect(status().isOk())
				.andExpect(view().name(("viewDataByAccount.jsp")));

	}

	@Test
	void shouldReturnSucessPageWhenDataIsInsterted() throws Exception {
		AccountDto acc = new AccountDto();
		acc.setAccountName("shubham");
		acc.setAccountPassword("hello");
		acc.setAccountUrl("hi.com");
		acc.setGroupName("social");
		doNothing().when(groupServices).addAccount(acc);
		groupServices.addAccount(acc);
		verify(groupServices, times(1)).addAccount(acc);
	}

	@Test
	void shouldReturnGroupListWhenGroupIsPresent() throws Exception {
		when(groupServices.allRecord()).thenReturn(new ArrayList<Group>());
		mockMvc.perform(get("/displayAllRecord")).andExpect(status().isOk())
				.andExpect(view().name(("displayAllRecord.jsp")));

	}

	@Test
	void shouldReturnTrueWhenAccountDeletedByAccountName() throws Exception {
		when(accountServices.deleteAccountByAccountName("fb")).thenReturn(true);
		mockMvc.perform(get("/deleteRecordByUserName?user=fb")).andExpect(status().isOk())
				.andExpect(view().name(("deleteRecordSucess.jsp")));
	}

	@Test
	void shouldReturnTrueWhenPasswordIsUpdatedByAccountName() throws Exception {
		when(accountServices.updatePasswordByAccountName("fb", "shubham")).thenReturn(true);
		mockMvc.perform(get("/UpdatePasswordByUserName?user=fb&password=shubham")).andExpect(status().isOk())
				.andExpect(view().name(("updateRecordSucess.jsp")));
	}
	/*
	 * @Test void masterAuthenticationTest()throws Exception {
	 * when(MasterUserAuthentication.isMasterUserAuthentication("shubham",
	 * "yadavji81")).thenReturn(true);
	 * mockMvc.perform(get("/masterLogin?user=shubham&password=yadavji81")).
	 * andExpect(status().isOk()) .andExpect(view().name(("sucess.jsp"))); }
	 */

	@Test
	void shouldReturnTrueWhenAccountDeletedByGroupName() throws Exception {
		when(groupServices.deleteAccountByGroupName("fb")).thenReturn(true);
		mockMvc.perform(get("/deleteRecordByGroupName?user=fb")).andExpect(status().isOk())
				.andExpect(view().name(("deleteRecordfail.jsp")));
	}

	@Test
	void shouldReturnTrueWhenGroupNameIsUpdated() throws Exception {
		when(groupServices.updateGroupNameByGroupName("fb", "shubham")).thenReturn(true);
		mockMvc.perform(get("/updateGroup?user=fb&password=shubham")).andExpect(status().isOk())
				.andExpect(view().name(("updateRecordFail.jsp")));
	}

}
