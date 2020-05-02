package com.original.teste.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.original.teste.entity.SystemUser;

@Repository
public interface UserRepository extends CrudRepository<SystemUser, Long> {

	SystemUser findByLogin(String login);
	
}
