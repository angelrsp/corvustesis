package com.corvustec.facturacionelectronica.util;


/**
 * @author wilmerPC
 *
 */
public class UtilWebService {
	
	
	
	public static String getUrlWebService (String ambiente, String nombreServicio) {
		
		StringBuilder urlAmbiente = new StringBuilder();
		//pruebas
		if (ambiente.equals("2")) {
//			urlAmbiente ="https://cel.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantes?wsdl";
			urlAmbiente.append("https://cel.sri.gob.ec/");
			urlAmbiente.append("comprobantes-electronicos-ws/");
			urlAmbiente.append(nombreServicio);
			urlAmbiente.append("?wsdl");
		} else {//Produccion
//			urlAmbiente ="https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantes?wsdl";
			urlAmbiente.append("https://celcer.sri.gob.ec/");
			urlAmbiente.append("comprobantes-electronicos-ws/");
			urlAmbiente.append(nombreServicio);
			urlAmbiente.append("?wsdl");
		}
		
		if (urlAmbiente.equals("")) {
			return null;
		} else {
//			logger.info("url: {}", urlAmbiente.toString());
			return urlAmbiente.toString();
		}
		
	}
}