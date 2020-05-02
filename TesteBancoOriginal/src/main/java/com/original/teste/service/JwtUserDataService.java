package com.original.teste.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.original.teste.entity.SystemUser;
import com.original.teste.repository.UserRepository;

@Service
public class JwtUserDataService implements UserDetailsService {

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		SystemUser user = userRepository.findByLogin(username);
		//TODO load autorities
		if (user != null) {
			return new User(user.getLogin(), user.getSenha(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
