/**
 * 
 */
package ec.edu.uce.silsae.commons.dto.util;

import java.io.Serializable;

/**
 * @author 
 *
 */
public class CredencialesDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	public CredencialesDTO () {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
