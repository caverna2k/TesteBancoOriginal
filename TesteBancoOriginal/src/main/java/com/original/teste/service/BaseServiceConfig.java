package com.original.teste.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class BaseServiceConfig {

	@Value("${page.size}")
	private int pageSize;
	
	

	protected PageRequest createPageRequest(int pageNumber, Sort.Direction direction, String... properties) {
	    return PageRequest.of(pageNumber,getPageSize(),direction,properties);
	}

	public int getPageSize() {
		return pageSize;
	}
}
