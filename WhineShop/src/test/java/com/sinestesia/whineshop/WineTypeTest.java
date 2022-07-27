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



import com.sinestesia.whineshop.model.WineType;

import com.sinestesia.whineshop.service.WineryService;


@WebMvcTest
class WineTypeTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private WineryService wineService;
	
	@Test
	@WithMockUser(username = "admin",password = "admin",roles = {"user"})
	void testWineById() throws Exception {
		WineType wineType = new WineType(1,"test");
		Mockito.when(wineService.getWineTypeById(1)).thenReturn(wineType);
		
		mockMvc.perform(get("/api/region/{id}",1)).andExpect(status().isOk()).andExpect(jsonPath("$.id",is(1)));
				
		
	}
	
	
	
	

}


