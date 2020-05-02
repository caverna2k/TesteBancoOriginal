package com.original.teste.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class Produto {

	
	@Entity(name = "produto")
	@NoArgsConstructor
	@RequiredArgsConstructor
	@EqualsAndHashCode(exclude={"codigoProduto", "descricao", "valor", "ativo", "dataCriacao"})
	public class SystemUser {

		@Id @Column(name = "codigo_produto") @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Getter @Setter private Long codigoProduto;
		
		@Column (length = 255) @NonNull
		@Getter @Setter private String descricao;
		
		@NonNull @Column(precision=10, scale=2)
		@Getter @Setter private BigDecimal valor;
		
		@Column @NonNull
		@Getter @Setter private boolean ativo;
		
		@Column(name = "data_Criacao") @NonNull @Temporal(TemporalType.TIMESTAMP)
		@Getter @Setter private Date dataCriacao;
		
	}

	
}
