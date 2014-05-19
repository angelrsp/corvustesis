package com.corvustec.facturacionelectronica.webservice;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceException;



import com.corvustec.facturacionelectronica.util.UtilWebService;

import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
import ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobantes;
import ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobantesService;
import ec.gob.sri.comprobantes.ws.aut.Mensaje;
import ec.gob.sri.comprobantes.ws.aut.RespuestaComprobante;

public class AutorizacionComprobantesElectronicosWs {


	
	
	public static final String SERVICIO_AUTORIZACION = "AutorizacionComprobantes";
	
	public static final String ESTADO_AUTORIZADO = "AUTORIZADO";

	public static final String ESTADO_NO_AUTORIZADO = "NO AUTORIZADO";

	
	public static AutorizacionComprobantesService service;
	
	
	private static Object webService(String wsUrl) {
		
		try {
			
			QName qName = new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesService");
			URL url = new URL(wsUrl);
			service = new AutorizacionComprobantesService(url, qName);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (WebServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
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
	
	public static RespuestaComprobante autorizacionComprobante(String claveDeAcceso)
	  {
	    RespuestaComprobante response = null;
	    try
	    {
	      AutorizacionComprobantes port = service.getAutorizacionComprobantesPort();
	      response = port.autorizacionComprobante(claveDeAcceso);
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	      return response;
	    }

	    return response;
	  }
	
	public static String getMensajeRespuestaEnvio(RespuestaComprobante response) {
		
		final String saltoLinea = "\n";
		
		StringBuilder mensaje=new StringBuilder();
		 if (response != null) {
			 
	        for (Autorizacion item : response.getAutorizaciones().getAutorizacion()) {
	        	
	        	System.out.println("estado "+item.getEstado());
	        	
	        	
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
	
	
	public static String getMensajeRespuestaEnvio(Autorizacion item)
	{
		final String saltoLinea = "\n";
		
		StringBuilder mensaje=new StringBuilder();

		for(Mensaje m:item.getMensajes().getMensaje())
		{
			mensaje.append(item.getEstado()).append(" ");
			mensaje.append(m.getMensaje()).append(" ; ");
			mensaje.append(m.getInformacionAdicional() == null ? "" : m.getInformacionAdicional());
			mensaje.append(saltoLinea);			
		}
		return mensaje.toString();
				
	}
	
}