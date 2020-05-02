package com.original.teste.repository;

import org.springframework.data.repository.CrudRepository;

import com.original.teste.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	Produto findByCodigoProdutoi(Long codigo);
	
}
