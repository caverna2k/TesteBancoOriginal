package com.original.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
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

	/**lista todos os produtos para uma pagina e tamanho
	 * @param pageNo
	 * @param pageLen
	 * @return
	 */
	public Page<Produto> findAll(final int pageNo, final int pageLen) {

		PageRequest pageRequest = createPageRequest(pageLen, pageNo, direction, properties);

		Page<Produto> produtos = produtoRepository.listarTodos(pageRequest);
		
		return produtos;
	}
	

	/**lista todos os produtos para uma pagina e tamanho se estiver ativo ou não
	 * @param pageNo
	 * @param pageLen
	 * @param ativo true/false -> true = ativo, false=inativo
	 * @return
	 */
	public Page<Produto> findAllActive(final int pageNo, final int pageLen, boolean ativo) {

		PageRequest pageRequest = createPageRequest(pageLen, pageNo, direction, properties);

		Page<Produto> produtos = produtoRepository.listarTodosByActive(pageRequest, ativo);
		
		return produtos;
	}
	
	/** Carrega um produto por codigo do produto, similar a getById. Usado para edição do produto.
	 * @param pageNo
	 * @param pageLen
	 * @param id - id do produto
	 * @return
	 */
	public Produto findByid(Long codigoProduto){
		
		Produto produto = produtoRepository.getProdutoByCodigoProduto(codigoProduto);
		
		return produto;
		
	}
	
	/**
	 * @param produto
	 * @return produto atualizado
	 */
	public Produto atualizarProduto(Produto produto) {
		return this.produtoRepository.save(produto);
	}

}
