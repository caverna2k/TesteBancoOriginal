package com.original.teste.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.original.teste.entity.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	Produto findByCodigoProduto(Long codigo);
	
	@Query("from Produto p")
	Page<Produto> listarTodos(@Param("properties") String[] properties, 
			@Param("direction") Sort.Direction direction,
			Pageable pageable);
	
}
