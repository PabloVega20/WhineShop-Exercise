management.endpoints.web.base.path=/manage
management.endpoints.web.exposure.include=*
management.endpoint.health.group.custom.show-components=always
management.endpoint.health.group.custom.show-details=always
management.health.defaults.enabled=true
management.endpoint.health.show.detail=always


public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> authz
                        .antMatchers(HttpMethod.GET).permitAll()
                        .antMatchers(HttpMethod.POST, "/**").hasRole("USER")
                        .antMatchers(HttpMethod.PUT, "/**").hasRole("USER")
                        .antMatchers(HttpMethod.PATCH, "/**").hasRole("USER")
                        .antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
                )
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
