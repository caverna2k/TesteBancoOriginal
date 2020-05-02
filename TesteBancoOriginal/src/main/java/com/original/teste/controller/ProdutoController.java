package com.original.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.original.teste.repository.ProdutoRepository;

@RestController
@CrossOrigin
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@RequestMapping(path = "/produtos", method = RequestMethod.GET)
	public ResponseEntity<?> listarProdutos(){
		
		
		return null;
	}
	
}
