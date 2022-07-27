package com.sinestesia.whineshop.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.MalformedURLException;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
//import org.springframework.security.access.SecurityConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Base64Utils;
import org.springframework.web.context.WebApplicationContext;

import com.sinestesia.whineshop.model.Wine;
import com.sinestesia.whineshop.model.Winery;
import com.sinestesia.whineshop.repository.WineRepository;
import com.sinestesia.whineshop.repository.WineryRepository;
import com.sinestesia.whineshop.service.WineService;
import com.sinestesia.whineshop.service.WineryService;


@WebMvcTest
public class WineryControllerTest {

	@Autowired
	private WebApplicationContext context;

//
//	@Before
//	public void setup() {
//		mockMvc = MockMvcBuil1ders
//				.webAppContextSetup(context)
//				.apply(springSecurity()) (1)
//				.build();
//	}
//	
	
	@MockBean
	private WineryService wineryService;
	@MockBean
	private WineService wineService;

	@Autowired
	private MockMvc mockMvc;
	
	
	
	@Test
	void getWineByIdTest() throws Exception {
		Wine vino = new Wine(1, "testName", 2013, 4.9f, 58, 90.0f, 200, 995, 3, 0, 0);

		when(wineService.getWineById(1)).thenReturn(vino);

		mockMvc.perform(get("/api/wine/{id}", 1)).andExpect(status().isOk())
				.andExpect(jsonPath("name", is("testName")));
	}

	@Test
	void getWineryByIdTest() throws Exception {
		Winery bodega = new Winery(1,"testName");

		Mockito.when(wineryService.getWineryById(1)).thenReturn(bodega);

		mockMvc.perform(get("/api/winery/1")).andExpect(status().isOk())
				.andExpect(jsonPath("name", is("testName")));
		
	}

/*	@Test
	void test_get_by_id_success() throws Exception {
		User user = new User(1, "Daenerys Targaryen");
		when(userService.findById(1)).thenReturn(user);
		mockMvc.perform(get("/users/{id}", 1)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath(".username", is("Daenerys Targaryen")));
		verify(userService, times(1)).findById(1);
		verifyNoMoreInteractions(userService);
	}*/
}
