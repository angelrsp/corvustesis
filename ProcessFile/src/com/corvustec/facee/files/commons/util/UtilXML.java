/**
 * 
 */
package com.corvustec.facee.files.commons.util;

import java.io.File;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.facee.files.commons.exception.ProcessFileException;

/**
 * @author wilmerPC
 * 
 */
public class UtilXML {
	
	final static Logger logger = LoggerFactory.getLogger(UtilXML.class);

	private static final UtilXML INSTANCIA = new UtilXML();
	
	//atributo del nodo de la plantilla a procesar
	public final static String ATRIBUTO_NOMBRE = "nombre";
	//tipo de dato del nodo a procesar
	public final static String ELEMENT_TIPO= "tipo";

	/**
	 * Constructor privado
	 */
	private UtilXML() {}
	
	/**
	 * Devolvemos la instancia de la clase
	 * @return INSTANCIA
	 */
	public static UtilXML getInstancia() {
		return INSTANCIA;
	}

	@SuppressWarnings("unchecked")
	private <x> void procesarString(String urlPlantillaXML, String pathExpresion, StringBuilder cadenaProcesar, x object) throws ProcessFileException {
		
		try {
			
			Document document = getDocument(urlPlantillaXML);
			List<Node> listNode = selectNodes(document, pathExpresion);
			
//			StringBuilder stringProcess = new StringBuilder(cadenaProcesar.trim());
			
			for (Node node : listNode) {
				Element element = (Element) node;
				//atributos del nodo a procesar
				List<DefaultAttribute> atr = element.attributes();
				String nameField = getValueAtribute(atr, ATRIBUTO_NOMBRE);
				
//				//obtener elementos dentro del nodo actual
//				List<Element> elementTipo = element.elements(ELEMENT_TIPO);
//				String tipoDato = elementTipo.get(0).getData().toString();
//				logger.info("cadenaProcesar: {}", cadenaProcesar.toString());
				String valorField = obtenerValorCadena(cadenaProcesar);
				if (!StringUtils.isEmpty(valorField==null? valorField:valorField.trim())) {
					setValueObject(object, nameField, valorField);
				}
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Exception {}", e.toString());
			e.printStackTrace();
			throw new ProcessFileException();
		}

	}

	private Document getDocument(String urlPlantillaXML) throws DocumentException, MalformedURLException {
		return new SAXReader().read(new File(urlPlantillaXML));
	}
	
	@SuppressWarnings("unchecked")
	private List<Node> selectNodes (Document document, String pathExpresion) throws ProcessFileException {
		return document.selectNodes(pathExpresion);
	}
	
	private String getValueAtribute (List<DefaultAttribute> atributo , String nameAtribute) {
		
		for (DefaultAttribute ob : atributo) {
			if (ob.getName().equalsIgnoreCase(nameAtribute)) {
				return ob.getValue();
			}
		}
		return null;
	}
	
	private String obtenerValorCadena (StringBuilder cadenaProcesar) throws ProcessFileException{
//		logger.info("cadenaProcesar {}" , cadenaProcesar);
		String valorCadena = null;
		try {
			if (!StringUtils.isEmpty(cadenaProcesar)) {
				int posicion = cadenaProcesar.indexOf(Constantes.SPLIT_ARCHIVOS);
				if (posicion>0) {
					valorCadena = cadenaProcesar.substring(0, posicion);
					cadenaProcesar.delete(0, posicion+1);
				} else if (posicion==0){
					valorCadena = null;
					cadenaProcesar.delete(0, posicion+1);
				} else {
					valorCadena = cadenaProcesar.toString();
				}
			}
		} catch (Exception e) {
			logger.info("Error al leer la cadena de texto a procesar {}", e.toString());
			throw new ProcessFileException("Error al leer la cadena de texto a procesar");
		}
		return valorCadena;
	}
	
	@SuppressWarnings("rawtypes")
	private Object transformarTipoDato (Class fileType, String valor) {
		
		Object objectSetField = null;
		
		if (fileType.equals(String.class)) {
			objectSetField = valor.toUpperCase();
		} else if (fileType.equals(Double.class)) {
			objectSetField = Double.valueOf(valor);
		} else if (fileType.equals(Integer.class)) {
			objectSetField = Integer.valueOf(valor);
		} else if (fileType.equals(Date.class)) {
			objectSetField = UtilApplication.formatStringToDate(valor, Constantes.FORMATO_FECHA_SRI);
		} else if (fileType.equals(BigDecimal.class)) {
			objectSetField = new BigDecimal(valor);
		}
		
		return objectSetField;
	}
	
	@SuppressWarnings("rawtypes")
	private <x> void  setValueObject (x object, String nameField, String valorField) throws ProcessFileException {
		
		Object objectSetField = null;
		
		Class classProcess = object.getClass();
		Field fieldProcess = buscarAtributo(classProcess.getDeclaredFields(), nameField);
		
		//validar q el campo exista en el objecto
		if (fieldProcess != null) {
			Class fileType = fieldProcess.getType();
			
			objectSetField = transformarTipoDato(fileType, valorField);
			
			try {
				fieldProcess.setAccessible(true);
				fieldProcess.set(object, objectSetField);
				
			} catch (IllegalArgumentException e) {
				throw new ProcessFileException("Ilegal argumento: " + e.getMessage());
			} catch (Exception e) {
				throw new ProcessFileException("Ilegal access: " + e.getMessage());
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	private Field buscarAtributo (Field [] fields, final String nombreCampo) throws ProcessFileException {
		
		Collection colField =  CollectionUtils.select(Arrays.asList(fields), new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				Field field = (Field)arg0;
				String nombreField = field.getName();
				
				return nombreField.equalsIgnoreCase(nombreCampo);
			}
		});
		
		if (null == colField || colField.isEmpty()) {
			return null;
		}
		return (Field) colField.toArray()[0];
	}
	
	public <x> x construirObject (String urlPlantillaXML, String pathExpresion, StringBuilder cadenaProcesar, x object) throws ProcessFileException {
		procesarString(urlPlantillaXML, pathExpresion, cadenaProcesar, object);
		return object;
	}

}
