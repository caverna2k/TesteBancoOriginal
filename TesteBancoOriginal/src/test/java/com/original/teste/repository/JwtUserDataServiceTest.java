package com.original.teste.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;

import com.original.teste.entity.SystemUser;
import com.original.teste.service.JwtUserDataService;

/**
 * @author drube
 *
 */
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@Configuration(value = "test")
public class JwtUserDataServiceTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtUserDataService jwtUserDataService;
	
	@Test
	@Order(1)
	public void loadUserByUsernameTest() {
		
		SystemUser user = userRepository.findAll().iterator().next();
		
		UserDetails loadedUser = jwtUserDataService.loadUserByUsername(user.getLogin());
		
		assertEquals(user.getLogin(), loadedUser.getUsername());
		
	}

}
