package com.sinestesia.whineshop;



import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.*;



import com.sinestesia.whineshop.model.Winery;

import com.sinestesia.whineshop.service.WineryService;


@WebMvcTest
class WineryTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private WineryService wineService;
	
	@Test
	@WithMockUser(username = "admin",password = "admin",roles = {"user"})
	void testWineById() throws Exception {
		Winery winery = new Winery(1,"test");
		Mockito.when(wineService.getWineryById(1)).thenReturn(winery);
		
		mockMvc.perform(get("/api/winery/{id}",1)).andExpect(status().isOk()).andExpect(jsonPath("$.id",is(1)));
				
		
	}
	
	
	
	

}
