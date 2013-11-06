/**
 * 
 */
package com.corvustec.facee.files.xml;

import java.io.Serializable;

/**
 * @author wilmerPC
 *
 */
public class InfoAdicionalDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String campoAdicional;
	
	public InfoAdicionalDTO () {}

	/**
	 * @return the campoAdicional
	 */
	public String getCampoAdicional() {
		return campoAdicional;
	}

	/**
	 * @param campoAdicional the campoAdicional to set
	 */
	public void setCampoAdicional(String campoAdicional) {
		this.campoAdicional = campoAdicional;
	}
	
}
