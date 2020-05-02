package com.original.teste.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.original.teste.entity.SystemUser;
import com.original.teste.repository.UserRepository;

@Component
public class CustomAuthManager implements AuthenticationManager {

	@Autowired
	UserRepository userRepo;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getPrincipal() + "";
	    String password = authentication.getCredentials() + "";

	    SystemUser user = userRepo.findByLogin(username);
	    if (user == null) {
	        throw new BadCredentialsException("1000");
	    }
	    if (!password.equals(user.getSenha())) {
	        throw new BadCredentialsException("1000");
	    }
	    
	    //List<Right> userRights = rightRepo.getUserRights(username);
	    return new UsernamePasswordAuthenticationToken(username, null, null/*userRights.stream().map(x -> new SimpleGrantedAuthority(x.getName())).collect(Collectors.toList())*/);
	}
}


