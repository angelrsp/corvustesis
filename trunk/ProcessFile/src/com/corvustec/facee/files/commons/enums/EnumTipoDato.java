/**
 * 
 */
package com.corvustec.facee.files.commons.enums;

import com.corvustec.facee.files.commons.util.MessagesApplication;

/**
 * @author wilmerPC
 *
 */
public enum EnumTipoDato {
	
	STRING(MessagesApplication.getInstancia().getString("com.corvustec.facee.files.tipo.dato.string")),
	DOUBLE(MessagesApplication.getInstancia().getString("com.corvustec.facee.files.tipo.dato.double")),
	INTEGER(MessagesApplication.getInstancia().getString("com.corvustec.facee.files.tipo.dato.integer")),
	FECHA(MessagesApplication.getInstancia().getString("com.corvustec.facee.files.tipo.dato.fecha"));
	
	private String id;
	
	private EnumTipoDato(String id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
}
