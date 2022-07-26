1,"Tinto","2013",4.9,58,90,200,995,3,0,0,0

https://memorynotfound.com/unit-test-spring-mvc-rest-service-junit-mockito/#unit-test-http-get-path-variable


https://java2blog.com/spring-boot-spring-security-example/


@Test
public void invalidCredentials() throws Exception {

    this.mockMvc
            .perform(get("/test").header(HttpHeaders.AUTHORIZATION,
                    "Basic " + Base64Utils.encodeToString("testuser:WRONGpassword".getBytes())))
            .andExpect(status().isOk());
}


https://stackoverflow.com/questions/60001748/testing-spring-security-protected-controllers-with-mockmvc-possible


https://docs.gitcode.net/spring/guide/en/spring-security/servlet-test-mockmvc-setup.html
