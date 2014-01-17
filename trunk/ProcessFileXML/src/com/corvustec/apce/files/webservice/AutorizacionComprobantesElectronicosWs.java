package com.corvustec.apce.files.webservice;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.apce.files.commons.exception.ProcessFileException;
import com.corvustec.apce.files.commons.util.MessagesApplication;
import com.corvustec.apce.files.commons.util.UtilWebService;

import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
import ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobantes;
import ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobantesService;
import ec.gob.sri.comprobantes.ws.aut.Mensaje;
import ec.gob.sri.comprobantes.ws.aut.RespuestaComprobante;

public class AutorizacionComprobantesElectronicosWs {

	private final static Logger logger = LoggerFactory.getLogger(AutorizacionComprobantesElectronicosWs.class);
	
	
	public static final String SERVICIO_AUTORIZACION = 
			MessagesApplication.getInstancia().getString("com.corvustec.apce.files.sri.webService.servicio.autorizacion");
	
	public static final String ESTADO_AUTORIZADO = 
			MessagesApplication.getInstancia().getString("com.corvustec.apce.files.cliente.webService.respuesta.autorizado");

	public static final String ESTADO_NO_AUTORIZADO = 
			MessagesApplication.getInstancia().getString("com.corvustec.apce.files.cliente.webService.respuesta.no.autorizado");

	
	public static AutorizacionComprobantesService service;
	
	
	private static Object webService(String wsUrl) throws ProcessFileException {
		
		try {
			
			QName qName = new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesService");
			URL url = new URL(wsUrl);
			return service = new AutorizacionComprobantesService(url, qName);
			
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
	
	public static RespuestaComprobante autorizacionComprobante(String claveDeAcceso)
	  {
	    RespuestaComprobante response = null;
	    try
	    {
	      AutorizacionComprobantes port = service.getAutorizacionComprobantesPort();
	      response = port.autorizacionComprobante(claveDeAcceso);
	    }
	    catch (Exception e) {
	    	logger.info("ProcessFileException {}", e.toString());
	      return response;
	    }

	    return response;
	  }
	
	public static String getMensajeRespuestaEnvio(RespuestaComprobante response) {
		
		final String saltoLinea = "\n";
		
		StringBuilder mensaje=new StringBuilder();
		 if (response != null) {
			 
	        for (Autorizacion item : response.getAutorizaciones().getAutorizacion()) {
	        	
	        	logger.info("estado {} ",item.getEstado());
	        	
	        	if(item.getEstado().equals(AutorizacionComprobantesElectronicosWs.ESTADO_NO_AUTORIZADO))
	        	{
	        		for(Mensaje m:item.getMensajes().getMensaje())
	        		{
	        			mensaje.append(item.getEstado()).append(" ");
	        			mensaje.append(m.getMensaje()).append(" , ");
	        			mensaje.append(m.getInformacionAdicional() == null ? "" : m.getInformacionAdicional());
	        			mensaje.append(saltoLinea);
	        			
//	        			logger.info("identificador {}",m.getIdentificador());
//	        			logger.info("mensaje {}",m.getMensaje());
//	        			logger.info("informacion adicional {}",m.getInformacionAdicional());
//	        			logger.info("tipo {}",m.getTipo());
	        		}
	        	}
	        	else
	        	{
	        		mensaje.append(item.getEstado());
	        	}
	        }
		 }
	        	
		
		return mensaje.toString();
	}
	
	
}
	
