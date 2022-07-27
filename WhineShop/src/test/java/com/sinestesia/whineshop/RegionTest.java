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
import com.sinestesia.whineshop.model.Region;

import com.sinestesia.whineshop.service.WineryService;


@WebMvcTest
class RegionTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private WineryService wineService;
	
	@Test
	@WithMockUser(username = "admin",password = "admin",roles = {"user"})
	void testWineById() throws Exception {
		Region region = new Region(1,"test","test");
		Mockito.when(wineService.getRegionById(1)).thenReturn(region);
		
		mockMvc.perform(get("/api/region/{id}",1)).andExpect(status().isOk()).andExpect(jsonPath("$.id",is(1)));
				
		
	}
	
	
	
	

}

