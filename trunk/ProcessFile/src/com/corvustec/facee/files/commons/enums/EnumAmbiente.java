package com.corvustec.facee.files.commons.enums;

import com.corvustec.facee.files.commons.util.MessagesApplication;

public enum EnumAmbiente {
	
	PRODUCCION (MessagesApplication.getInstancia().getString("com.corvustec.facee.files.ambiente.produccion")),
	DESARROLLO (MessagesApplication.getInstancia().getString("com.corvustec.facee.files.ambiente.desarrollo"));
	
	private String id;
	
	EnumAmbiente(String id){
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

}
