package com.original.teste;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import com.original.teste.controller.JwtAuthenticationController;
import com.original.teste.controller.ProdutoController;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@Configuration(value = "test")
class TesteBancoOriginalApplicationTests {

	@Autowired
	ProdutoController produtoController;
	
	@Autowired
	JwtAuthenticationController jwtAuthenticationController;
	
	
	@Test
	@Order(1)
	void contextLoads() {
		assertThat(produtoController).isNotNull();
		assertThat(jwtAuthenticationController).isNotNull();
	}

}
