package com.original.teste.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.original.teste.entity.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	Produto findByCodigoProduto(Long codigo);
	
	@Cacheable("produtos")
	@Query("from Produto p")
	Page<Produto> listarTodos(Pageable pageable);
	
	@Query("from Produto p where p.ativo = :ativo")
	Page<Produto> listarTodosByActive(Pageable pageable, @Param("ativo") boolean ativo);
	
	
	@Query("from Produto p where p.codigoProduto = :codigoProduto")
	Produto getProdutoByCodigoProduto(@Param("codigoProduto") Long id);
	
	
}
