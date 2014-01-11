package com.corvustec.apce.files.commons.enums;

import com.corvustec.apce.files.commons.util.MessagesApplication;

public enum EnumAmbiente {
	
	PRODUCCION (MessagesApplication.getInstancia().getString("com.corvustec.apce.files.ambiente.produccion")),
	DESARROLLO (MessagesApplication.getInstancia().getString("com.corvustec.apce.files.ambiente.desarrollo"));
	
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
