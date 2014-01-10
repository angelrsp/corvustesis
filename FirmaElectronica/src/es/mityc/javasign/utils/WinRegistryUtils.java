/**
 * Copyright 2013 Ministerio de Industria, Energía y Turismo
 *
 * Este fichero es parte de "Componentes de Firma XAdES 1.1.7".
 *
 * Licencia con arreglo a la EUPL, Versión 1.1 o –en cuanto sean aprobadas por la Comisión Europea– versiones posteriores de la EUPL (la Licencia);
 * Solo podrá usarse esta obra si se respeta la Licencia.
 *
 * Puede obtenerse una copia de la Licencia en:
 *
 * http://joinup.ec.europa.eu/software/page/eupl/licence-eupl
 *
 * Salvo cuando lo exija la legislación aplicable o se acuerde por escrito, el programa distribuido con arreglo a la Licencia se distribuye «TAL CUAL»,
 * SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ni expresas ni implícitas.
 * Véase la Licencia en el idioma concreto que rige los permisos y limitaciones que establece la Licencia.
 */
package es.mityc.javasign.utils;

import java.lang.reflect.InvocationTargetException; 
import java.lang.reflect.Method; 
import java.util.HashMap; 
import java.util.Map; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.prefs.Preferences; 

/**
 * <p>Permite leer claves del registro de windows.</p>
 *
 * @version 1.0
 */
public class WinRegistryUtils { 
	  // inspired by
	  // http://javabyexample.wisdomplug.com/java-concepts/34-core-java/62-java-registry-wrapper.html
	  // http://www.snipcode.org/java/1-java/23-java-class-for-accessing-reading-and-writing-from-windows-registry.html
	  // http://snipplr.com/view/6620/accessing-windows-registry-in-java/

	public static final int HKEY_CLASSES_ROOT = 0x80000000;
	public static final int HKEY_CURRENT_USER = 0x80000001; 
	public static final int HKEY_LOCAL_MACHINE = 0x80000002;
	public static final int REG_SUCCESS = 0; 
	public static final int REG_NOTFOUND = 2; 
	public static final int REG_ACCESSDENIED = 5; 

	private static final int KEY_ALL_ACCESS = 0xf003f; 
	private static final int KEY_READ = 0x20019; 
	private static Preferences userRoot = Preferences.userRoot(); 
	private static Preferences systemRoot = Preferences.systemRoot(); 
	private static Class<? extends Preferences> userClass = userRoot.getClass(); 
	private static Method regOpenKey = null; 
	private static Method regCloseKey = null; 
	private static Method regQueryValueEx = null; 
	private static Method regEnumValue = null; 
	private static Method regQueryInfoKey = null; 
	private static Method regEnumKeyEx = null; 
	private static Method regCreateKeyEx = null; 
	private static Method regSetValueEx = null; 
	private static Method regDeleteKey = null; 
	private static Method regDeleteValue = null;
	
	static { // Se buscan los métodos a emplear por reflexión
		try { 
			regOpenKey = userClass.getDeclaredMethod(
					"WindowsRegOpenKey", new Class[] { int.class, byte[].class, int.class }); 
			regOpenKey.setAccessible(true); 
			regCloseKey = userClass.getDeclaredMethod(
					"WindowsRegCloseKey", new Class[] { int.class }); 
			regCloseKey.setAccessible(true); 
			regQueryValueEx = userClass.getDeclaredMethod(
					"WindowsRegQueryValueEx", new Class[] { int.class, byte[].class }); 
			regQueryValueEx.setAccessible(true); 
			regEnumValue = userClass.getDeclaredMethod(
					"WindowsRegEnumValue", new Class[] { int.class, int.class, int.class }); 
			regEnumValue.setAccessible(true); 
			regQueryInfoKey = userClass.getDeclaredMethod(
					"WindowsRegQueryInfoKey1", new Class[] { int.class }); 
			regQueryInfoKey.setAccessible(true); 
			regEnumKeyEx = userClass.getDeclaredMethod(   
					"WindowsRegEnumKeyEx", new Class[] { int.class, int.class, int.class });   
			regEnumKeyEx.setAccessible(true); 
			regCreateKeyEx = userClass.getDeclaredMethod(   
					"WindowsRegCreateKeyEx", new Class[] { int.class, byte[].class });   
			regCreateKeyEx.setAccessible(true);   
			regSetValueEx = userClass.getDeclaredMethod(   
					"WindowsRegSetValueEx", new Class[] { int.class, byte[].class, byte[].class });   
			regSetValueEx.setAccessible(true);  
			regDeleteValue = userClass.getDeclaredMethod(   
					"WindowsRegDeleteValue", new Class[] { int.class, byte[].class });   
			regDeleteValue.setAccessible(true);  
			regDeleteKey = userClass.getDeclaredMethod(   
					"WindowsRegDeleteKey", new Class[] { int.class, byte[].class });   
			regDeleteKey.setAccessible(true);  
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 

	/**
	 * <p>Constructor.</p>
	 */
	private WinRegistryUtils() {  } 

	/** 
	 * <p>Lee el valor de la clave y valor indicados.</p>
	 * @param hkey .- HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE 
	 * @param key .- Nombre de la clave a buscar.
	 * @param valueName .- Nombre del valor a leer.
	 * @return El contenido leído.
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 */ 
	public static String readString(int hkey, String key, String valueName)  
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		if (OSTool.getSO().isWindows()) {
			if (hkey == HKEY_LOCAL_MACHINE) { 
				return readString(systemRoot, hkey, key, valueName); 
			} else if (hkey == HKEY_CURRENT_USER) { 
				return readString(userRoot, hkey, key, valueName); 
			} else { 
				throw new IllegalArgumentException("hkey=" + hkey); 
			}
		} else {
			return null;
		}
	} 

	/** 
	 * <p>Lee los valores y nombres contenidos en la clave indicada.</p>
	 * @param hkey .- HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE 
	 * @param key .- Nombre de la clave.
	 * @return Los nombres y los valores leídos 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 */ 
	public static Map<String, String> readStringValues(int hkey, String key)  
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException { 
		if (hkey == HKEY_LOCAL_MACHINE) { 
			return readStringValues(systemRoot, hkey, key); 
		} else if (hkey == HKEY_CURRENT_USER) { 
			return readStringValues(userRoot, hkey, key); 
		} else { 
			throw new IllegalArgumentException("hkey=" + hkey); 
		} 
	} 

	/** 
	 * <p>Devuelve el valor leído de la clave indicada.</p>
	 * @param hkey .- HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE 
	 * @param key .- Nombre de la clave a leer
	 * @return El valor leído.
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 */ 
	public static List<String> readStringSubKeys(int hkey, String key)  
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException { 
		if (hkey == HKEY_LOCAL_MACHINE) { 
			return readStringSubKeys(systemRoot, hkey, key); 
		} else if (hkey == HKEY_CURRENT_USER) { 
			return readStringSubKeys(userRoot, hkey, key); 
		} else { 
			throw new IllegalArgumentException("hkey=" + hkey); 
		} 
	} 

	/** 
	 * <p>Crea una clave nueva.</p> 
	 * @param hkey .- HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE 
	 * @param key .- Nombre de la clave a crear
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 */ 
	public static void createKey(int hkey, String key)  
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException { 
		int [] ret = null; 
		if (hkey == HKEY_LOCAL_MACHINE) { 
			ret = createKey(systemRoot, hkey, key); 
			regCloseKey.invoke(systemRoot, new Object[] { new Integer(ret[0]) }); 
		} else if (hkey == HKEY_CURRENT_USER) { 
			ret = createKey(userRoot, hkey, key); 
			regCloseKey.invoke(userRoot, new Object[] { new Integer(ret[0]) }); 
		}  else if (hkey == HKEY_CLASSES_ROOT) { 
			ret = createKey(systemRoot, hkey, key); 
			regCloseKey.invoke(systemRoot, new Object[] { new Integer(ret[0]) }); 
		} else { 
			throw new IllegalArgumentException("hkey=" + hkey); 
		} 
		if (ret[1] != REG_SUCCESS) { 
			throw new IllegalArgumentException("rc=" + ret[1] + "  key=" + key); 
		} 
	} 

	/** 
	 * <p>Escribe el valor indicado en la clave indicada.</p> 
	 * @param hkey .- HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE
	 * @param key .- Clave en la cual se va a escribir
	 * @param valueName .- Nombre del valor a escribir
	 * @param value .- Valor a escribir
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 */ 
	public static void writeStringValue(int hkey, String key, String valueName, String value)  
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException { 
		if (hkey == HKEY_LOCAL_MACHINE) { 
			writeStringValue(systemRoot, hkey, key, valueName, value); 
		} else if (hkey == HKEY_CURRENT_USER) { 
			writeStringValue(userRoot, hkey, key, valueName, value); 
		} else if (hkey == HKEY_CLASSES_ROOT) { 
			writeStringValue(systemRoot, hkey, key, valueName, value); 
		} else { 
			throw new IllegalArgumentException("hkey=" + hkey); 
		} 
	} 

	/** 
	 * <p>Borra la clave pasada por parámetro.</p>
	 * @param hkey .- HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE
	 * @param key .- Clave a borrar
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 */ 
	public static void deleteKey(int hkey, String key)  
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException { 
		int rc = -1; 
		if (hkey == HKEY_LOCAL_MACHINE) { 
			rc = deleteKey(systemRoot, hkey, key); 
		} else if (hkey == HKEY_CURRENT_USER) { 
			rc = deleteKey(userRoot, hkey, key); 
		} 
		if (rc != REG_SUCCESS) { 
			throw new IllegalArgumentException("rc=" + rc + "  key=" + key); 
		} 
	} 

	/** 
	 * <p>Borra el contenido de la clave y valor indicados.</p> 
	 * @param hkey .- HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE
	 * @param key .- Clave a buscar
	 * @param value .- Nombre del valor a borrar
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 */ 
	public static void deleteValue(int hkey, String key, String value) 
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		int rc = -1; 
		if (hkey == HKEY_LOCAL_MACHINE) { 
			rc = deleteValue(systemRoot, hkey, key, value); 
		} else if (hkey == HKEY_CURRENT_USER) { 
			rc = deleteValue(userRoot, hkey, key, value); 
		} 
		if (rc != REG_SUCCESS) { 
			throw new IllegalArgumentException("rc=" + rc + "  key=" + key + "  value=" + value); 
		} 
	}
	
	/** 
	 * <p>Comprueba si existe la clave.</p> 
	 * @param hkey .- HKEY_CURRENT_USER/HKEY_LOCAL_MACHINE/HKEY_CLASSES_ROOT
	 * @param key .- Clave a buscar
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 */ 
	public static boolean keyExists(int hkey, String key) 
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		boolean rc = false; 
		if (hkey == HKEY_LOCAL_MACHINE) { 
			rc = keyExists(systemRoot, hkey, key); 
		} else if (hkey == HKEY_CURRENT_USER) { 
			rc = keyExists(userRoot, hkey, key); 
		} 
		return rc;
	} 

	private static int deleteValue(Preferences root, int hkey, String key, String value)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException { 
		int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { 
				new Integer(hkey), toCstr(key), new Integer(KEY_ALL_ACCESS) }); 
		if (handles[1] != REG_SUCCESS) { 
			return handles[1];  // can be REG_NOTFOUND, REG_ACCESSDENIED 
		} 
		int rc =((Integer) regDeleteValue.invoke(root,   
				new Object[] {  
				new Integer(handles[0]), toCstr(value)  
		})).intValue(); 
		regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) }); 
		return rc; 
	} 

	private static int deleteKey(Preferences root, int hkey, String key)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException { 
		int rc =((Integer) regDeleteKey.invoke(root,   
				new Object[] { new Integer(hkey), toCstr(key) })).intValue(); 
		return rc;  // can be REG_NOTFOUND, REG_ACCESSDENIED, REG_SUCCESS 
	} 

	private static String readString(Preferences root, int hkey, String key, String value) 
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException { 
		int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { 
				new Integer(hkey), toCstr(key), new Integer(KEY_READ) }); 
		if (handles[1] != REG_SUCCESS) { 
			return null;  
		} 
		byte[] valb = (byte[]) regQueryValueEx.invoke(root, new Object[] { 
				new Integer(handles[0]), toCstr(value) }); 
		regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) }); 
		return (valb != null ? new String(valb).trim() : null); 
	} 

	private static Map<String,String> readStringValues(Preferences root, int hkey, String key) 
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException { 
		HashMap<String, String> results = new HashMap<String,String>(); 
		int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { 
				new Integer(hkey), toCstr(key), new Integer(KEY_READ) }); 
		if (handles[1] != REG_SUCCESS) { 
			return null; 
		} 
		int[] info = (int[]) regQueryInfoKey.invoke(root, new Object[] { new Integer(handles[0]) }); 

		int count = info[2]; // count   
		int maxlen = info[3]; // value length max 
		for(int index=0; index<count; index++)  { 
			byte[] name = (byte[]) regEnumValue.invoke(root, new Object[] { 
					new Integer 
					(handles[0]), new Integer(index), new Integer(maxlen + 1)}); 
			String value = readString(hkey, key, new String(name)); 
			results.put(new String(name).trim(), value); 
		} 
		regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) }); 
		return results; 
	} 

	private static List<String> readStringSubKeys(Preferences root, int hkey, String key) 
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException { 
		List<String> results = new ArrayList<String>(); 
		int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { 
				new Integer(hkey), toCstr(key), new Integer(KEY_READ)  
		}); 
		if (handles[1] != REG_SUCCESS) { 
			return null; 
		} 
		int[] info = (int[]) regQueryInfoKey.invoke(root, new Object[] { new Integer(handles[0]) }); 

		int count = info[2]; // count   
		int maxlen = info[3]; // value length max 
		for(int index=0; index<count; index++)  { 
			byte[] name = (byte[]) regEnumKeyEx.invoke(root, new Object[] { 
					new Integer 
					(handles[0]), new Integer(index), new Integer(maxlen + 1) 
			}); 
			results.add(new String(name).trim()); 
		} 
		regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) }); 
		return results; 
	} 

	private static int [] createKey(Preferences root, int hkey, String key) 
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException { 
		return  (int[]) regCreateKeyEx.invoke(root, new Object[] { new Integer(hkey), toCstr(key) }); 
	} 

	private static void writeStringValue(Preferences root, int hkey, String key, String valueName, String value)  
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException { 
		int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { 
				new Integer(hkey), toCstr(key), new Integer(KEY_ALL_ACCESS) 
			}); 

		regSetValueEx.invoke(root, new Object[] {  
				new Integer(handles[0]), toCstr(valueName), toCstr(value)  
		});  
		regCloseKey.invoke(root, new Object[] { new Integer(handles[0]) }); 
	} 
	
	private static boolean keyExists(Preferences root, int hkey, String key)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException { 
		int[] handles = (int[]) regOpenKey.invoke(root, new Object[] { 
				new Integer(hkey), toCstr(key), new Integer(KEY_ALL_ACCESS) }); 
		return (handles[1] != REG_SUCCESS); // can be REG_NOTFOUND, REG_ACCESSDENIED 
	}
 
	private static byte[] toCstr(String str) { 
		byte[] result = new byte[str.length() + 1]; 

		for (int i = 0; i < str.length(); i++) { 
			result[i] = (byte) str.charAt(i); 
		} 
		result[str.length()] = 0; 
		return result; 
	} 
} 
