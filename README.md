package com.sinestesia.whineshop.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.withUser("admin").password("admin").roles("ADMIN")
			.and()
			.withUser("user").password("user").roles("USER");
	}
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception { 
        http
        .cors().and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET).permitAll()
        .antMatchers(HttpMethod.POST).hasRole("USER")
        .antMatchers(HttpMethod.PUT).hasRole("USER")
        .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin();
    }
    
   
}
