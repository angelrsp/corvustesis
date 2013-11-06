/**
 * 
 */
package com.corvustec.facee.files.commons.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.facee.files.commons.enums.EnumAmbiente;

/**
 * @author wilmerPC
 *
 */
public class UtilWebService {
	
	final static Logger logger = LoggerFactory.getLogger(UtilWebService.class);
	
	public static String getUrlWebService (String ambiente, String nombreServicio) {
		
		StringBuilder urlAmbiente = new StringBuilder();
		
		if (ambiente.equals(EnumAmbiente.PRODUCCION.getId())) {
//			urlAmbiente ="https://cel.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantes?wsdl";
			urlAmbiente.append("https://cel.sri.gob.ec/");
			urlAmbiente.append("comprobantes-electronicos-ws/");
			urlAmbiente.append(nombreServicio);
			urlAmbiente.append("?wsdl");
		} else {
//			urlAmbiente ="https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantes?wsdl";
			urlAmbiente.append("https://celcer.sri.gob.ec/");
			urlAmbiente.append("comprobantes-electronicos-ws/");
			urlAmbiente.append(nombreServicio);
			urlAmbiente.append("?wsdl");
		}
		
		if (StringUtils.isEmpty(urlAmbiente)) {
			return null;
		} else {
//			logger.info("url: {}", urlAmbiente.toString());
			return urlAmbiente.toString();
		}
		
	}
	
}
