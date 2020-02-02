package com.web.dndapp;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.junit.runners.ParentRunner;
//import org.junit.runners.model.FrameworkMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;

import com.web.dndapp.dto.User;
import com.web.dndapp.security.LoginController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogInControllerTest {

	private MockMvc mockMvc;

	@Autowired
	public LoginController controller;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testLoginPost() throws Exception {

		MvcResult result = mockMvc.perform(post("/login").param("username", "crsmith").param("password", "wownita5"))
				.andExpect(status().isFound()).andReturn();
		ModelMap map = result.getModelAndView().getModelMap();
		
		assertEquals("crsmith", ((User) map.get("user")).getUsername());
		assertEquals("Chris", ((User) map.get("user")).getName());
	}
}
