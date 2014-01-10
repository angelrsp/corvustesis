package com.corvustec.signature.xml.commons.util;

import java.util.ResourceBundle;

public class MessagesApplication {

private static final String BUNDLE_NAME = "com.corvustec.signature.xml.commons.resorces.ApplicationResources";
	
	private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	private static final MessagesApplication INSTANCIA = new MessagesApplication();
	
	/**
	 * Constructor privado
	 */
	private MessagesApplication(){};
	
	/**
	 * Devolvemos la instancia de la clase
	 * @return INSTANCIA
	 */
	public static MessagesApplication getInstancia() {
		return INSTANCIA;
	}
	
	public String getString(String key) {
		return RESOURCE_BUNDLE.getString(key);
	}
	
	public Integer getInteger(String key){
		return Integer.valueOf(MessagesApplication.getInstancia().getString(key));
	}
}
