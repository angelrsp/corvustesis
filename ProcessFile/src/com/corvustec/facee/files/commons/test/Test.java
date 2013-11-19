/**
 * 
 */
package com.corvustec.facee.files.commons.test;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.facee.files.commons.exception.ProcessFileException;
import com.corvustec.facee.files.commons.util.Constantes;
import com.corvustec.facee.files.commons.util.UtilApplication;
import com.corvustec.facee.files.commons.util.UtilFileMonitor;
import com.corvustec.facee.files.commons.util.UtilXML;
import com.corvustec.facee.files.webService.ComprobantesElectronicosWs;
import com.corvustec.facee.files.xml.commons.InfoTributariaDTO;

import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;

/**
 * @author wilmerPC
 */
public class Test {

	final static Logger logger = LoggerFactory.getLogger(Test.class);
	
	/**
	 * @param args
	 */
	public static void main(String... args) {

		switch (1) {
		case 1:
			testListener();
			break;
		case 2:
			testXml();
			break;
		case 3:
			testFecha();
			break;
		case 4:
			testWebService();
			break;
		}
	}
	
	public static void testListener () {
		try {
			UtilFileMonitor.iniciarListenerClientes();
		} catch (ProcessFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testXml() {
		try {
			UtilXML.getInstancia()
					.construirObject(
							"C://plantillas//plantillaFactura.xml",
							"//factura/infoTributaria/atributos/*",
							new StringBuilder("empresa prueba razonSocial; empresa prueba nombreComercial; empresa prueba descripcion; empresa prueba ruc; empresa prueba tipoComprobante; empresa prueba codigoEstablecimiento"),
							new InfoTributariaDTO());
		} catch (ProcessFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testFecha() {
		logger.info("UtilApplication.formatDate {}", UtilApplication.formatStringToDate("02/10/2013", Constantes.FORMATO_FECHA_SRI));
		logger.info("UtilApplication.formatDate {}", 
				UtilApplication.formatDateToString(UtilApplication.formatStringToDate("02/10/2013", Constantes.FORMATO_FECHA_SRI), Constantes.FORMATO_FECHA_SRI));
	}
	
	public static void testWebService() {
		
		Object a = ComprobantesElectronicosWs.verificarConectividad("1", "RecepcionComprobantes");
		
		if (a!=null) {
			logger.info("true"); 
			
//			File file = new File("D:\\1801201301179125123700120010650000477711810081311.xml");
			
			File file = new File("D:\\0710201301179125123700110010650000000107586788613.xml");
			
			if (file.exists()){
				RespuestaSolicitud response = ComprobantesElectronicosWs.enviarComprobante(file);
				logger.info("response.getEstado: {}", response.getEstado());
				
				String mensaje = ComprobantesElectronicosWs.getMensajeRespuestaEnvio(response);
				logger.info("mensaje: {}", mensaje);
				
			} else {
				logger.info("no existe el archivo en el path indicado");
			}
			
		} else {
			logger.info("false");
		}
		
	}
	
//	private static RespuestaSolicitud validarComprobante(byte[] xml) {
//        recepcion.ws.sri.gob.ec.RecepcionComprobantesService service = new recepcion.ws.sri.gob.ec.RecepcionComprobantesService();
//        recepcion.ws.sri.gob.ec.RecepcionComprobantes port = service.getRecepcionComprobantesPort();
//        return port.validarComprobante(xml);
//    }
// 
//    public static void testWebService2() {
//        //System.setProperty("javax.net.ssl.keyStore", "C:\Program Files (x86)\Java\jdk1.6.0_23\jre\lib\security\cacerts");
//        System.setProperty("javax.net.ssl.keyStore", "C:\\Program Files\\Java\\jre6\\lib\\security\\cacerts");
//        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
//        //System.setProperty("javax.net.ssl.trustStore", "C:\Program Files (x86)\Java\jdk1.6.0_23\jre\lib\security\cacerts");
//        System.setProperty("javax.net.ssl.trustStore", "C:\\Program Files\\Java\\jre6\\lib\\security\\cacerts");
//        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
//        File file = new File("D:\\2103201301000000000000110015010000000101234567811.xml");
//        RespuestaSolicitud respuesta = validarComprobante(UtilApplication.fileToByte(file));
//        System.out.println(respuesta.getEstado());
//    }

}
