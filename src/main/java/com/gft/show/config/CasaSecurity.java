package com.gft.show.config;

import java.util.ArrayList;
import java.util.List;

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

	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider autoProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/home").hasAnyRole("PG_HOME")
			.antMatchers("/casas").hasAnyRole("PG_CASAS")
			.antMatchers("/evento").hasAnyRole("PG_EVENTOS")
			.antMatchers("/historico").hasAnyRole("PG_HISTORICO")
			.antMatchers("/entrar").permitAll()
			.antMatchers("/registrar").permitAll()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/entrar").permitAll()
				.and()
				.logout().invalidateHttpSession(true)
				.clearAuthentication(true);
				//.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				//.logoutSuccessUrl("/logout-success").permitAll();
			
		}
	
	@Override
	public void configure(WebSecurity config) throws Exception{
		config.ignoring().antMatchers("/css/**").antMatchers("/js/**").antMatchers("/images/**").antMatchers("/fontawesome-free-5.12.0-web/**");
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		builder
			.inMemoryAuthentication()
			.withUser("carlos").password("{noop}123").roles("PG_EVENTO", "PG_HISTORICO", "PG_CASAS", "PG_HOME")
			.and()
			.withUser("flavio").password("{noop}123").roles("PG_HOME");
	}
	/*@Bean
	@Override
	 protected UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("navin").password("1234").roles("USER").build());
		
		
		return new InMemoryUserDetailsManager(users);
		
		
	}*/
}
