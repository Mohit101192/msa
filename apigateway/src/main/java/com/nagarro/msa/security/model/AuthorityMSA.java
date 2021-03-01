package com.nagarro.msa.security.model;

import org.springframework.security.core.GrantedAuthority;

public class AuthorityMSA  implements GrantedAuthority
{

	private static final long serialVersionUID = 1654L;
	
	private String authority;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
	
}
