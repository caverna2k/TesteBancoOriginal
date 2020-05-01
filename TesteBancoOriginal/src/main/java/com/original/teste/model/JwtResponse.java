package com.original.teste.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {


/**
	 * 
	 */
	private static final long serialVersionUID = -2908995319221995832L;
	
private final String jwttoken;

public JwtResponse(String jwttoken) {

this.jwttoken = jwttoken;

}

public String getToken() {

return this.jwttoken;

}

}