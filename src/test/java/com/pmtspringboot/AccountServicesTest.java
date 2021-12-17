package com.pmtspringboot;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.pmtspringboot.dao.AccountRepository;
import com.pmtspringboot.service.AccountServices;

@WebMvcTest(AccountServices.class)
@ContextConfiguration(classes = { AccountServices.class })
@ExtendWith(MockitoExtension.class)

class AccountServicesTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountServices accountServices;
	@MockBean
	private AccountRepository accountRepository;

	@Test
	void shouldRetrunFalseWhenAccountIsNotDeletedByAccountName() throws Exception {

		when(accountServices.deleteAccountByAccountName("shubham")).thenReturn(false);
		assertFalse(accountServices.deleteAccountByAccountName("false"));

	}

	@Test
	void shouldRetrunFalseWhenPasswordIsNotUpdatedByAccountName() throws Exception {

		when(accountServices.updatePasswordByAccountName("instagram", "hi")).thenReturn(false);
		assertFalse(accountServices.updatePasswordByAccountName("instagram", "hihelo"));

	}

}
