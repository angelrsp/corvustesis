/**
 * 
 */
package com.corvustec.facee.files.webService;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.facee.files.commons.exception.ProcessFileException;
import com.corvustec.facee.files.commons.util.MessagesApplication;
import com.corvustec.facee.files.commons.util.UtilApplication;
import com.corvustec.facee.files.commons.util.UtilWebService;

import ec.gob.sri.comprobantes.ws.Comprobante;
import ec.gob.sri.comprobantes.ws.Mensaje;
import ec.gob.sri.comprobantes.ws.RecepcionComprobantes;
import ec.gob.sri.comprobantes.ws.RecepcionComprobantesService;
import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;

/**
 * @author wilmerPC
 *
 */
public final class ComprobantesElectronicosWs {
	
	private final static Logger logger = LoggerFactory.getLogger(ComprobantesElectronicosWs.class);
	
	/**
	 * Nombre del servicio de recepci&oacute;n de comprobantes del SRI
	 */
	public static final String SERVICIO_RECEPCION = 
			MessagesApplication.getInstancia().getString("com.corvustec.facce.files.sri.webService.servicio.recepcion");
	
	/**
	 * respuesta recibida webService de recepci&oacute;n del SRI
	 */
	public static final String RESPUESTA_RECIBIDA = 
			MessagesApplication.getInstancia().getString("com.corvustec.facce.files.cliente.webService.respuesta.recibida");
	
	/**
	 * respuesta devuelta webService de recepci&oacute;n del SRI
	 */
	public static final String RESPUESTA_DEVUELTA = 
			MessagesApplication.getInstancia().getString("com.corvustec.facce.files.cliente.webService.respuesta.devuelta");
	
	public static RecepcionComprobantesService service;
	
	private static Object webService(String wsUrl) throws ProcessFileException {
		
		try {
			
			QName qName = new QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesService");
			URL url = new URL(wsUrl);
			return service = new RecepcionComprobantesService(url, qName);
			
		} catch (MalformedURLException e) {
			logger.info("error MalformedURLException {}", e.toString());
			throw new ProcessFileException("error MalformedURLException" + e);
		} catch (WebServiceException e) {
			logger.info("error WebServiceException {}", e.toString());
			throw new ProcessFileException("error WebServiceException" + e);
		} catch (Exception e) {
			logger.info("error Exception {}", e.toString());
			throw new ProcessFileException("error Exception" + e);
		}
		
	}
	
	public static Object verificarConectividad(String ambiente, String nombreServicio) {
		
		try {
			
			String wsUrl = UtilWebService.getUrlWebService(ambiente, nombreServicio);
			return webService(wsUrl);
			
		} catch (ProcessFileException e) {
			logger.info("ProcessFileException {}", e.toString());
		}
		
		return null;
		
	}
	
	public static RespuestaSolicitud enviarComprobante(File xmlFile) {
		RespuestaSolicitud response = null;
		try {
			RecepcionComprobantes port = service.getRecepcionComprobantesPort();
			response = port.validarComprobante(UtilApplication.fileToByte(xmlFile));
		} catch (Exception e) {
			logger.info("Error al enviar el comprobante {}", e.toString());
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
					mensajeRespuesta.append(sms.getMensaje()).append(", ");
					mensajeRespuesta.append(sms.getInformacionAdicional() == null ? "" : sms.getInformacionAdicional());
					mensajeRespuesta.append(saltoLinea);
				}
			}
			return mensajeRespuesta.toString();
		}
		return null;
	}

}
