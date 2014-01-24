package com.corvustec.apce.files;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.apce.files.commons.jdbc.SqlServerJDBC;
import com.corvustec.apce.files.commons.util.Constantes;
import com.corvustec.apce.files.commons.util.UtilApplication;
import com.corvustec.apce.files.commons.util.UtilMail;
import com.corvustec.apce.files.webservice.AutorizacionComprobantesElectronicosWs;
import com.corvustec.apce.files.webservice.ComprobantesElectronicosWs;
import com.corvustec.signature.xml.Signature;

import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;
import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
import ec.gob.sri.comprobantes.ws.aut.RespuestaComprobante;

public class ArchivoXML {

	
	private final static Logger logger = LoggerFactory.getLogger(ArchivoXML.class);
	
	public static void procesarComprobante(String fileXml,String fileXmlSignature,String pathSignature,String passSignature,String claveAcceso,String codFactura,
	String conHost,
	String conDataBase,
	String conUser,
	String conPass,String xmlBody,String mailDestino)
	{
		File xmlFile=new File(fileXml);
		String comprobante = null;
		String autorizacion=null;
		String fechaHora=null;
		String respuestaAut=null;
		try {	
			
		if (Signature.executeNoEncrypted(xmlFile, fileXmlSignature, pathSignature, passSignature)){
			
			Object a = ComprobantesElectronicosWs.verificarConectividad(Constantes.AMBIENTE, ComprobantesElectronicosWs.SERVICIO_RECEPCION);
			
			SqlServerJDBC sqlServer=SqlServerJDBC.getInstance(conHost,conDataBase,conUser,conPass);
			
			if (a == null) {
				logger.info("No se puede conectar al servicio del SRI implementar envio contingencia");
			} else {
				File xmlFileSignature=new File(fileXmlSignature);
				RespuestaSolicitud response = ComprobantesElectronicosWs.enviarComprobante(xmlFileSignature);
				logger.info("Respuesta WS Envio: {}", response.getEstado());
				
				if (response.getEstado().equals(ComprobantesElectronicosWs.RESPUESTA_RECIBIDA)) {
					
					
					Object aut= AutorizacionComprobantesElectronicosWs.verificarConectividad(Constantes.AMBIENTE, AutorizacionComprobantesElectronicosWs.SERVICIO_AUTORIZACION);
					if(aut == null) {
						logger.info("No se puede conectar al servicio Autorizacion del SRI implementar envio contingencia");
					}
					else
					{
						RespuestaComprobante responseAut=AutorizacionComprobantesElectronicosWs.autorizacionComprobante(claveAcceso);
							
							for (Autorizacion item : responseAut.getAutorizaciones().getAutorizacion()) {

								respuestaAut=item.getEstado();
								
								logger.info("Respuesta WS Autorizacion {}",respuestaAut);
								logger.info("claveAcceso {}",claveAcceso);

								
								if(respuestaAut.equals(AutorizacionComprobantesElectronicosWs.ESTADO_AUTORIZADO))
								{
								
									autorizacion= item.getNumeroAutorizacion();
									comprobante=item.getComprobante();
									fechaHora=item.getFechaAutorizacion().toString();
								
									escribirCorrecto(sqlServer, codFactura, fechaHora, claveAcceso, autorizacion, comprobante);
									
									UtilApplication.convertStringToDocument(comprobante);
									logger.info("Enviar mail");
									UtilMail.enviar(mailDestino,"Facturacion Electronica","Estimado(a) cliente reciba un cordial saludo. Su factura electrónica esta adjunto",xmlFileSignature);
									break;
								}
								else
								{
									String mensaje=AutorizacionComprobantesElectronicosWs.getMensajeRespuestaEnvio(item);
									escribirError(sqlServer, codFactura, fechaHora, claveAcceso, autorizacion, comprobante, mensaje);
								}
							
  					        //item.setComprobante("<![CDATA[" + item.getComprobante() + "]]>");
  					        
							
							
  					        //logger.info("Compronate {}",item.getComprobante());

//  					        XStream xstream = XStreamUtil.getRespuestaXStream();
//  					        Writer writer = null;
//  					        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//  					        writer = new OutputStreamWriter(outputStream, "UTF-8");
//  					        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
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
								
								
						}
					}
					
					
					//UtilApplication.moverArchivoProcesado(file, getEstructuraArchivos().get(Constantes.carpetaProcesados));
					//Agregado por FPU
					
				} else {
					String mensaje = ComprobantesElectronicosWs.getMensajeRespuestaEnvio(response);
					logger.info("mensaje: {}", mensaje);
					
					escribirError(sqlServer, codFactura, fechaHora, claveAcceso, autorizacion, comprobante, mensaje);
					
				}
			}
			
		} else {
			logger.info("No se pudo firmar el archivo {} ", fileXml);
		}
		} catch (Exception e) {
			logger.info("Problemas al procesar comprobante {}, {} ", fileXmlSignature, e.toString());
		}
	}
	
	
	private static void escribirError(SqlServerJDBC sqlServer,String codFactura,String fechaHora,String claveAcceso,String autorizacion,String comprobante,String mensaje)
	{
		String sqlQuery=null;
		mensaje=mensaje.replace('\'', '"');
		if(!sqlServer.exists("select * from facelec where clavefe='"+claveAcceso+"'"))
		{
			sqlQuery="insert into facelec (codfac,fechahorafe,clavefe,noautfe,xmlfirfe,estadofe,errorfe) values('"+codFactura+"','"+
					fechaHora+"','"+claveAcceso+"','"+autorizacion+"','"+comprobante+"',"+0+",'"+mensaje+"')";
			
			sqlServer.execute(sqlQuery);
		}
		else
		{
			sqlQuery="update facelec set "
					+ "codfac='"+codFactura+"',"
					+ "fechahorafe='"+fechaHora+"',"
					+ "clavefe='"+claveAcceso+"',"
					+ "noautfe='"+autorizacion+"',"
					+ "xmlfirfe='"+comprobante+"',"
					+ "estadofe="+0+","
					+ "errorfe='"+mensaje+"' "
					+ "where clavefe='"+claveAcceso+"'";
			
			sqlServer.execute(sqlQuery);						
		}
	}
	
	private static void escribirCorrecto(SqlServerJDBC sqlServer,String codFactura,String fechaHora,String claveAcceso,String autorizacion, String comprobante)
	{
		String sqlQuery=null;
		if(!sqlServer.exists("select * from facelec where clavefe='"+claveAcceso+"'"))
		{
			sqlQuery="insert into facelec (codfac,fechahorafe,clavefe,noautfe,xmlfirfe,estadofe) values('"+codFactura+"','"+
					fechaHora+"','"+claveAcceso+"','"+autorizacion+"','"+comprobante+"',"+1+")";
			
			sqlServer.execute(sqlQuery);
		}
		else
		{
			sqlQuery="update facelec set "
					+ "codfac='"+codFactura+"',"
					+ "fechahorafe='"+fechaHora+"',"
					+ "clavefe='"+claveAcceso+"',"
					+ "noautfe='"+autorizacion+"',"
					+ "xmlfirfe='"+comprobante+"',"
					+ "estadofe="+1+","
					+ "errorfe=' '"
			+ "where clavefe='"+claveAcceso+"'";
					
			sqlServer.execute(sqlQuery);
		}
		

	}
	
}
