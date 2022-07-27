package com.sinestesia.whineshop;



import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sinestesia.whineshop.model.Wine;
import com.sinestesia.whineshop.model.Winery;
import com.sinestesia.whineshop.repository.WineRepository;
import com.sinestesia.whineshop.repository.WineryRepository;
import com.sinestesia.whineshop.service.WineryService;


@WebMvcTest
class WhineShopApplicationTests {

//	@MockBean
//	private WineRepository wineRepository;
//	
//	@MockBean
//	private WineryRepository wineryRepository;
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private WineryService wineService;
	
//	@Autowired
//	private WebApplicantionContext context;
//	
//	@Begore
//	public void setup() {
//		mvc=MockMvcBuilders.webAppContextSetup(null)
//	}
	
	@Test
	@WithMockUser(username = "admin",password = "admin",roles = {"user"})
	void testWine() throws Exception {
		Wine wine = new Wine(1,"test",2013,4.9f,58,90.0f,200,995,3,0,0);
		Mockito.when(wineService.getWineById(1)).thenReturn(wine);
		
		mockMvc.perform(get("/api/wine/{id}",1)).andExpect(status().isOk()).andExpect(jsonPath("$.id",is(1)));
				
		
	}

}
