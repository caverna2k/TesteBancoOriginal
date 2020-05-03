package com.original.teste.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONObject;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
@Configuration(value = "test")
public class JwtAuthenticationControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	@Order(1)
	public void userCannotAccess() throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		JSONObject jsonLogin = new JSONObject();
		
		//Set your request body params
		jsonLogin.put("username", "clochead0");
		jsonLogin.put("password", "fFBWnnb4LKe2345");
		
		HttpEntity<String> request = 
			      new HttpEntity<String>(jsonLogin.toString(), headers);
		try {
			this.restTemplate.postForObject("http://localhost:" + port + "/v1/authenticate", request, String.class);
		} catch (Exception e) {
			assertThat(e.getMessage()).contains("error");
			return;
		}
		
		assertTrue(false);//error
	}

	

	@Test
	@Order(2)
	public void userCanAccess() throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		JSONObject jsonLogin = new JSONObject();
		
		//Set your request body params
		jsonLogin.put("username", "clochead0");
		jsonLogin.put("password", "fFBWnnb4LKe");
		
		HttpEntity<String> request = 
			      new HttpEntity<String>(jsonLogin.toString(), headers);
		
		String response = this.restTemplate.postForObject("http://localhost:" + port + "/v1/authenticate", request, String.class);
		
		assertThat(response).doesNotContain("404").contains("token");
	}

	
}
