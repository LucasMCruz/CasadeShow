/*package com.gft.show.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class MemorySecurity{
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		builder
			.inMemoryAuthentication()
			.withUser("carlos").password("{noop}123").roles("PG_REL_EQUIPE")
			.and()
			.withUser("flavio").password("{noop}123").roles("PG_REL_EQUIPE");
	}
}*/