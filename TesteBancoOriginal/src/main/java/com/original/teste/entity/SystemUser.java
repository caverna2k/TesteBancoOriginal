package com.original.teste.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "system_user")
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class SystemUser {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	
	@Column (length = 255) @NonNull
	@Getter @Setter private String login;
	
	@Column(length = 255) @NonNull
	@Getter @Setter private String senha;
	
}
