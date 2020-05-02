package com.original.teste.service;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.original.teste.entity.Produto;
import com.original.teste.repository.ProdutoRepository;

@Service
public class ProdutoService extends BaseServiceConfig {

	@Autowired
	ProdutoRepository produtoRepository;

	@Value("${produto.order.columns}")
	private String[] properties;

	@Value("#{'${produto.order.direction}'.split(',')}")
	private Sort.Direction direction;

	public Page<Produto> findAll(final int page) {

		PageRequest pageRequest = createPageRequest(page, direction, properties);

		Page<Produto> produtos = produtoRepository.listarTodos(properties, direction, pageRequest);

		return produtos;
	}

}
