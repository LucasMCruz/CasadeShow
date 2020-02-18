package com.gft.show.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class CasaSecurity extends WebSecurityConfigurerAdapter {
	
	
	//private MyUserDetailsService userDetailsService;
	@Autowired
	private UserDetailsService userDetailsService;
	

	
	
	
	/*protected UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("navin").password("1234").roles("USER").build());
	
	return new InMemoryUserDetailsManager(users);
	}
	
}*/
	
	
	
	/*@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider autoProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			
				.antMatchers("/").permitAll()
				.antMatchers("/registrar").permitAll()
				.antMatchers("/historico").permitAll()//.hasAnyRole("USER")
				.antMatchers("/casas").permitAll()//.hasAnyRole("ADMIN")
				//.antMatchers("/{codigo}").hasAnyRole("USER2")
				.antMatchers("/evento").permitAll()//.hasAnyRole("ADMIN")
				.antMatchers("/entrar").permitAll()
				.anyRequest()
				.authenticated()
			
			.and()
				.formLogin()
				.loginPage("/entrar")
				.permitAll()
			.and()
				.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true);
				//.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				//.logoutSuccessUrl("/logout-success").permitAll();
			
		}
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	
	@Override
	public void configure(WebSecurity config) throws Exception{
		config.ignoring().antMatchers("/css/**").antMatchers("/js/**").antMatchers("/images/**").antMatchers("/fontawesome-free-5.12.0-web/**");
	}
	
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		builder.userDetailsService(userDetailsService);
		
	}*/

	/*salvar em memoria
	 * @Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		builder
			.inMemoryAuthentication()
			.withUser("carlos").password("{noop}123").roles("ADM1", "ADM2", "USER1", "USER2")
			.and()
			.withUser("flavio").password("{noop}123").roles("PG_HISTORICO","PG_VENDA");
	}*/
	
	
}
	
	
	

