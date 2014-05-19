package com.corvustec.facturacionelectronica.webservice;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceException;




import com.corvustec.facturacionelectronica.util.UtilApplication;
import com.corvustec.facturacionelectronica.util.UtilWebService;

import ec.gob.sri.comprobantes.ws.Comprobante;
import ec.gob.sri.comprobantes.ws.Mensaje;
import ec.gob.sri.comprobantes.ws.RecepcionComprobantes;
import ec.gob.sri.comprobantes.ws.RecepcionComprobantesService;
import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;

public final class ComprobantesElectronicosWs {
	

	
	/**
	 * Nombre del servicio de recepci&oacute;n de comprobantes del SRI
	 */
	public static final String SERVICIO_RECEPCION = "RecepcionComprobantes";
	
	/**
	 * respuesta recibida webService de recepci&oacute;n del SRI
	 */
	public static final String RESPUESTA_RECIBIDA = "RECIBIDA";
	
	/**
	 * respuesta devuelta webService de recepci&oacute;n del SRI
	 */
	public static final String RESPUESTA_DEVUELTA = "DEVUELTA";
	
	
	public static RecepcionComprobantesService service;
	
	private static Object webService(String wsUrl) {
		QName qName = null;
		URL url = null;
		try {
			
			qName = new QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesService");
			url = new URL(wsUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (WebServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service = new RecepcionComprobantesService(url, qName);
	}
	
	public static Object verificarConectividad(String ambiente, String nombreServicio) {
		
		try {
			
			String wsUrl = UtilWebService.getUrlWebService(ambiente, nombreServicio);
			return webService(wsUrl);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static RespuestaSolicitud enviarComprobante(File xmlFile) {
		RespuestaSolicitud response = null;
		try {
			RecepcionComprobantes port = service.getRecepcionComprobantesPort();
			response = port.validarComprobante(UtilApplication.fileToByte(xmlFile));
			
		} catch (Exception e) {
			
			response = new RespuestaSolicitud();
			response.setEstado(e.getMessage());
			return response;
		}
		
		return response;
	}
	
	public static RespuestaSolicitud validarComprobante(File xmlFile) {
		RespuestaSolicitud response = null;
		try {
			RecepcionComprobantes port = service.getRecepcionComprobantesPort();
			response = port.validarComprobante(UtilApplication.fileToByte(xmlFile));
			
		} catch (Exception e) {
			
			response = new RespuestaSolicitud();
			response.setEstado(e.getMessage());
			return response;
		}
		
		return response;
	}
	
	
	/**
	 * 
	 * @param response
	 * @return
	 */
	public static String getMensajeRespuestaEnvio(RespuestaSolicitud response) {
		
		final String saltoLinea = "\n";
		
		if (response.getComprobantes()!=null) {
			
			StringBuilder mensajeRespuesta = new StringBuilder();
			
			for (Comprobante comprobante : response.getComprobantes().getComprobante()) {
				
				mensajeRespuesta.append(comprobante.getClaveAcceso()).append(saltoLinea);
				
				for (Mensaje sms : comprobante.getMensajes().getMensaje()) {
					mensajeRespuesta.append(sms.getMensaje()).append("; ");
					mensajeRespuesta.append(sms.getInformacionAdicional() == null ? "" : sms.getInformacionAdicional());
					mensajeRespuesta.append(saltoLinea);
				}
			}
			return mensajeRespuesta.toString();
		}
		return null;
	}
	
	
	
	

}
