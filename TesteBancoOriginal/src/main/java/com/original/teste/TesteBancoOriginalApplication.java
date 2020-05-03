package com.original.teste;

import javax.persistence.Cacheable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Cacheable
public class TesteBancoOriginalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteBancoOriginalApplication.class, args);
	}

}
