@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz 
				.antMatchers(HttpMethod.GET).permitAll() 
				.antMatchers(HttpMethod.POST, "/").permitAll() 
				.antMatchers(HttpMethod.PUT, "/").hasRole("USER") 
				.antMatchers(HttpMethod.PATCH, "/").hasRole("USER") 
				.antMatchers(HttpMethod.DELETE, "/").hasRole("ADMIN") ) 
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
		.and() 
		.csrf().disable() .httpBasic(Customizer.withDefaults());
				
	}
