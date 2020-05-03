package com.original.teste.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import com.original.teste.entity.Produto;
import com.original.teste.service.ProdutoService;

/**
 * @author drube
 *
 */
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@Configuration(value = "test")
public class ProdutoServiceTest {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ProdutoService produtoService;

	private Produto produto = null;
	
	@Test
	@Order(1)
	public void listProdutosTest() {
		Page<Produto> produtos = produtoService.findAll(0, 20);
		assertEquals(20, produtos.getNumberOfElements());
	}
	
	@Test
	@Order(2)
	public void listProdutosByStatusAtivoTest() {
		Page<Produto> produtos = produtoService.findAllActive(0, 20, true);
		assertTrue(produtos.get().allMatch(t -> t.isAtivo() == true));
	}
	
	@Test
	@Order(3)
	public void findProdutobyCodigoProdutoTest() {
		produto = produtoRepository.findAll().iterator().next();
		Produto produto = produtoService.findByid(this.produto.getCodigoProduto());
		assertTrue(produto != null);
	}
	
	
	@Test
	@Order(4)
	public void atualizarProdutobyTest() {
		produto = produtoRepository.findAll().iterator().next();
		Produto produto = produtoService.findByid(this.produto.getCodigoProduto());
		
		boolean priorStatusAtivo = produto.isAtivo();
		
		produto.setAtivo(!produto.isAtivo());
		
		produto = produtoService.atualizarProduto(produto);
		
		assertTrue(produto.isAtivo() != priorStatusAtivo);
	}
	
}
