/**
 * 
 */
package com.corvustec.apce.files.commons.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Clase para el manejo de mensajes en la aplicaci&oacute;n</br>
 * Usamos el patr&oacute;n de dise&ntilde;o SINGLETON
 * @author wilmerPC
 *
 */
public class MessagesApplication {
	
private static final String BUNDLE_NAME = "com.corvustec.apce.files.commons.resources.ApplicationResources";
	
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
	
	public String getString(String key) throws MissingResourceException{
		return RESOURCE_BUNDLE.getString(key);
	}
	
	public Integer getInteger(String key) throws MissingResourceException{
		return Integer.valueOf(MessagesApplication.getInstancia().getString(key));
	}

}
