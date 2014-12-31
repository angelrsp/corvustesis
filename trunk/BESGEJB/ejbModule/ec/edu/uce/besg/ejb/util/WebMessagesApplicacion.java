package ec.edu.uce.besg.ejb.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Clase para leer los recursos desde un archivo de propiedades
 * @author 
 *
 */
public final class WebMessagesApplicacion {
	
	private static final String BUNDLE_NAME = "ec.edu.uce.silsae.web.util.WebResources";
	private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	private WebMessagesApplicacion () {}
	
	public static String getString(String key) throws MissingResourceException{
		return RESOURCE_BUNDLE.getString(key);
	}
	
	public static Integer getInteger(String key) throws MissingResourceException{
		return Integer.valueOf(getString(key));
	}

}
