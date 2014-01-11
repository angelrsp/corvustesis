package com.corvustec.apce.files;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.apce.files.commons.util.Constantes;
import com.corvustec.apce.files.commons.util.UtilMail;
import com.corvustec.apce.files.webservice.AutorizacionComprobantesElectronicosWs;
import com.corvustec.apce.files.webservice.ComprobantesElectronicosWs;
import com.corvustec.signature.xml.Signature;

import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;
import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
import ec.gob.sri.comprobantes.ws.aut.Mensaje;
import ec.gob.sri.comprobantes.ws.aut.RespuestaComprobante;

public class ArchivoXML {

	
	private final static Logger logger = LoggerFactory.getLogger(ArchivoXML.class);
	
	public static void procesarComprobante(String file)
	{
		File xmlFile=new File(file);
		
		try {	
			
		//if (Signature.Xml(xmlFile, "/home/fernando/FacturacionElectronica/clientes/Prueba/Firma/francisco_arturo_velez_rojas.p12","ulygGd+Hh/4di7WinfA1NA==")){
			
			Object a = ComprobantesElectronicosWs.verificarConectividad(Constantes.AMBIENTE, ComprobantesElectronicosWs.SERVICIO_RECEPCION);
			
			if (a == null) {
				logger.info("No se puede conectar al servicio del SRI implementar envio contingencia");
			} else {
				
				RespuestaSolicitud response = ComprobantesElectronicosWs.enviarComprobante(xmlFile);
				logger.info("Respuesta WS: {}", response.getEstado());
				
				if (response.getEstado().equals(ComprobantesElectronicosWs.RESPUESTA_RECIBIDA)) {
					
					Object aut= AutorizacionComprobantesElectronicosWs.verificarConectividad(Constantes.AMBIENTE, AutorizacionComprobantesElectronicosWs.SERVICIO_AUTORIZACION);
					if(aut == null) {
						logger.info("No se puede conectar al servicio Autorizacion del SRI implementar envio contingencia");
					}
					else
					{
//						RespuestaComprobante responseAut=AutorizacionComprobantesElectronicosWs.autorizacionComprobante("0710201301179125123700110010650000000107791051216");
//
//						String respuestaAut= AutorizacionComprobantesElectronicosWs.getMensajeRespuestaEnvio(responseAut);
//
//						logger.info("Respuesta WS Autorizacion {}",respuestaAut);
						
//  					        item.setComprobante("<![CDATA[" + item.getComprobante() + "]]>");
//
//						          XStream xstream = XStreamUtil.getRespuestaXStream();
//						          Writer writer = null;
//						          ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//						          writer = new OutputStreamWriter(outputStream, "UTF-8");
//						          writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//
//						          xstream.toXML(item, writer);
//						          String xmlAutorizacion = outputStream.toString("UTF-8");
//
//						          if (item.getEstado().equals("AUTORIZADO")) {
//						            ArchivoUtils.stringToArchivo(dirAutorizados + File.separator + nombreArchivo, xmlAutorizacion);
//						            VisualizacionRideUtil.decodeArchivoBase64(dirAutorizados + File.separator + nombreArchivo, item.getNumeroAutorizacion(), item.getFechaAutorizacion().toString());
//						            break;
//						          }
//						          if (item.getEstado().equals("NO AUTORIZADO")) {
//						            ArchivoUtils.stringToArchivo(dirNoAutorizados + File.separator + nombreArchivo, xmlAutorizacion);
//						            mensaje.append("|" + obtieneMensajesAutorizacion(item));
//
//						            verificarOCSP(item);
//
//						            break;
//						          }
					          
					        //}
						 //}
					}
					
					UtilMail.enviar(xmlFile);
					//UtilApplication.moverArchivoProcesado(file, getEstructuraArchivos().get(Constantes.carpetaProcesados));
					//Agregado por FPU
					
				} else {
					String mensaje = ComprobantesElectronicosWs.getMensajeRespuestaEnvio(response);
					logger.info("mensaje: {}", mensaje);
				}
			}
			
		//} else {
		//	logger.info("No se pudo firmar el archivo {} ", file);
		//}
		} catch (Exception e) {
			logger.info("Problemas al procesar comprobante {}, {} ", file, e.toString());
		}
	}
	
}
