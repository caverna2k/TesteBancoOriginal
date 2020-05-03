package com.original.teste.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;

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

import com.original.teste.entity.Produto;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
@Configuration(value = "test")
public class ProdutoControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	@Order(1)
	public void listagemTest() throws Exception {
		
		Object response2 = this.restTemplate.getForObject("http://localhost:" + port + "/v1/produtos/listar/0/20", Object.class);
	
		LinkedHashMap res = (LinkedHashMap) response2;
		
		assertThat(res.entrySet()).isNotNull().isNotEmpty();
		
	}
	
	@Test
	@Order(2)
	public void listagemAtivosTest() throws Exception {
		
		Object response2 = this.restTemplate.getForObject("http://localhost:" + port + "/v1/produtos/listar/0/20/true", Object.class);
	
		LinkedHashMap res = (LinkedHashMap) response2;
		
		assertThat(res.entrySet()).isNotNull().isNotEmpty();	
		
	}
	
	@Test
	@Order(2)
	public void loadProduto() throws Exception {
		
		Produto response2 = this.restTemplate.getForObject("http://localhost:" + port + "v1/produtos/load/45", Produto.class);
		
		assertThat(response2.getCodigoProduto()).isEqualTo(45L);	
		
	}
	
	
	
	
}
