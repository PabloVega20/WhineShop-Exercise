package com.sinestesia.whineshop.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN").and().withUser("user")
				.password("user").roles("USER");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers(HttpMethod.GET).permitAll()
				.antMatchers("/manage").permitAll()
				.antMatchers(HttpMethod.POST, "/**").permitAll()//.hasRole("USER").antMatchers(HttpMethod.PUT, "/**").hasRole("USER")
				.antMatchers(HttpMethod.PATCH, "/**").hasRole("USER").antMatchers(HttpMethod.DELETE, "/**")
				.hasRole("ADMIN").anyRequest().authenticated().and().formLogin();
				
	}

}