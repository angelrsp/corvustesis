package net.ciespal.redxxi.ejb.persistence.entities.util.dto;

import java.io.Serializable;

public class CredencialesDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String password;
	
	public CredencialesDTO() {
	
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
