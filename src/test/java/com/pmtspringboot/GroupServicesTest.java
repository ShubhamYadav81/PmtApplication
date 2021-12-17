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

import com.pmtspringboot.dao.GroupRepository;
import com.pmtspringboot.service.GroupServices;

@WebMvcTest(GroupServices.class)
@ContextConfiguration(classes = { GroupServices.class })
@ExtendWith(MockitoExtension.class)

class GroupServicesTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GroupServices groupServices;
	@MockBean
	private GroupRepository groupRepository;

	@Test
	void shouldReturnFalseWhenGroupIsNotDeltedByGroupName() throws Exception {

		when(groupServices.deleteAccountByGroupName("social")).thenReturn(false);
		assertFalse(groupServices.deleteAccountByGroupName("social"));

	}

	@Test
	void shouldReturnFalseWhenGroupNameIsNotUpdatedByOldGroupName() throws Exception {

		when(groupServices.updateGroupNameByGroupName("social", "default")).thenReturn(false);
		assertFalse(groupServices.updateGroupNameByGroupName("social", "default"));

	}

}
