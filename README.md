1,"Tinto","2013",4.9,58,90,200,995,3,0,0,0


@Testpublic void test_get_by_id_success() throws Exception {    User user = new User(1, "Daenerys Targaryen");    when(userService.findById(1)).thenReturn(user);    mockMvc.perform(get("/users/{id}", 1))            .andExpect(status().isOk())            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))            .andExpect(jsonPath("$.id", is(1)))            .andExpect(jsonPath("$.username", is("Daenerys Targaryen")));    verify(userService, times(1)).findById(1);    verifyNoMoreInteractions(userService); }
