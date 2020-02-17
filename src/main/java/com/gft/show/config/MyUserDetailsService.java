 package com.gft.show.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gft.show.model.User;
import com.gft.show.model.UserPrincipal;
import com.gft.show.repository.UserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;
	
	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		
		
		User user = repo.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("Usuario nao encontrado");
		
		
		
		
		return new UserPrincipal(user);
	}
	
		

}
