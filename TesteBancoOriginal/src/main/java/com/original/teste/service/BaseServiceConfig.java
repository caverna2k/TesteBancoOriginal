package com.original.teste.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class BaseServiceConfig {


	/** Creates a @PageRequest
	 * @param pageLen - page items length
	 * @param pageNumber - number of the page, starts with zero.
	 * @param direction - defined in application-xyz.properties
	 * @param properties - defined in application-xyz.properties
	 * @return
	 */
	protected PageRequest createPageRequest(int pageLen, int pageNumber, Sort.Direction direction, String... properties) {
	    return PageRequest.of(pageNumber,pageLen,direction,properties);
	}

}
