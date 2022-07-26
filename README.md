1,"Tinto","2013",4.9,58,90,200,995,3,0,0,0

https://memorynotfound.com/unit-test-spring-mvc-rest-service-junit-mockito/#unit-test-http-get-path-variable


https://java2blog.com/spring-boot-spring-security-example/


 @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void when_userIsValid_should_return200() throws Exception {
        String res = testRestTemplate
                .withBasicAuth("testuser", "testpassword")
                .getForEntity("/test", String.class)
                .getBody();
        Assert.assertEquals("hello", res);
    }
