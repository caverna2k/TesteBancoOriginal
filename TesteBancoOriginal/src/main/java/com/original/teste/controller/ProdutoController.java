package com.original.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.original.teste.entity.Produto;
import com.original.teste.service.ProdutoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
		
	@RequestMapping(path = "v1/produtos/listar/{pageNo}/{pageLen}", method = RequestMethod.GET)
	public ResponseEntity<?> listarProdutos(
	@PathVariable(required = true, name = "pageLen") Integer pageNo,
	@PathVariable(required = true, name = "pageNo") Integer pageLen){
		
		Page<Produto> produtos = produtoService.findAll(pageLen,pageNo);
		
		return ResponseEntity.status(HttpStatus.OK).body(produtos);
	}
	
	
	@RequestMapping(path = "v1/produtos/load/{codigoProduto}", method = RequestMethod.GET)
	public ResponseEntity<?> carregarProduto(	
	@PathVariable(required = true, name = "codigoProduto") Long codigoProduto){
		
		Produto produto = produtoService.findByid(codigoProduto);
		
		return ResponseEntity.status(HttpStatus.OK).body(produto);
	}
	
	@RequestMapping(path = "v1/produtos/listar/ativo/{pageNo}/{pageLen}/{ativo}", method = RequestMethod.GET)
	public ResponseEntity<?> listarProdutosAtivacao(
	@PathVariable(required = true, name = "pageNo") Integer pageNo,
	@PathVariable(required = true, name = "pageLen") Integer pageLen,
	@PathVariable(required = true, name = "ativo") Boolean ativo){
		
		Page<Produto> produtos = produtoService.findAllActive(pageNo, pageLen, ativo);
		
		return ResponseEntity.status(HttpStatus.OK).body(produtos);
	}
	
	@RequestMapping(path = "v1/produtos/atualizar", method = RequestMethod.GET,  consumes={MediaType.APPLICATION_JSON_VALUE, 
            MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> atualizarProduto(@RequestBody Produto produto){
		
		Produto produtoAtualizado = produtoService.atualizarProduto(produto);
		
		return ResponseEntity.status(HttpStatus.OK).body(produtoAtualizado);
	}
	
}
