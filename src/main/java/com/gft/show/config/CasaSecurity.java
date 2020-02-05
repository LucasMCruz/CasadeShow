package com.gft.show.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class CasaSecurity extends WebSecurityConfigurerAdapter {

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			authorizeRequests()
				.anyRequest()
				.authenticated()
			.and()
			.formLogin()
				.loginPage("/entrar")
				.permitAll();
			
		}*/
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider autoProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	/*@Bean
	@Override
	 protected UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("navin").password("1234").roles("USER").build());
		
		
		return new InMemoryUserDetailsManager(users);
		
		
	}*/
}
