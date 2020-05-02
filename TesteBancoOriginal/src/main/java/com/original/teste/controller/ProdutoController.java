package com.original.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.original.teste.entity.Produto;
import com.original.teste.service.ProdutoService;

@RestController
@CrossOrigin
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	
	
	@RequestMapping(path = "/produtos", method = RequestMethod.GET)
	public ResponseEntity<?> listarProdutos(
			@RequestParam(defaultValue = "0") Integer pageNo){
		
		Page<Produto> produtos = produtoService.findAll(pageNo);
		
		return ResponseEntity.status(HttpStatus.OK).body(produtos);
	}
	
}
