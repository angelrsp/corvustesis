package com.corvustec.apce.files.main;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.corvustec.apce.files.ArchivoXML;
import com.corvustec.apce.files.commons.util.UtilApplication;

public class Process {

	
	private final static Logger logger = LoggerFactory.getLogger(Process.class);
	
	/**
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		
//		String filepath = "D:\\FacturacionElectronica\\clientes\\Prueba\\firmado\\fac-2004000000023.xml";
//		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//		Document doc = docBuilder.parse(filepath);
//		
//		String docStr= UtilApplication.convertDocumentToString(doc);
	
			logger.info("Argumentos ");

			
			String xmlStr=args[0];
			String claveAcceso=args[1];
			String pathSignature=args[2];
			String claveFirma=args[3];
			String codFactura=args[4];
			String conHost=args[5];
			String conDataBase=args[6];
			String conUser=args[7];
			String conPass=args[8];

			logger.info("xmlStr {}",xmlStr);
			logger.info("claveAcceso {}",claveAcceso);
			logger.info("claveFirma {}",claveFirma);
			logger.info("codFactura {}",codFactura);
			logger.info("conHost {}",conHost);
			logger.info("conDataBase {}",conDataBase);
			logger.info("conUser {}",conUser);
			logger.info("conPass {}",conPass);
			
			Document document=UtilApplication.convertStringToDocument(xmlStr);
			
			String pathXml=UtilApplication.getTempPath()+"\\"+claveAcceso+".xml";
			
			UtilApplication.saveDocumenteDisk(document, pathXml);
		
//		
//		
//		NodeList infoTributaria = document.getElementsByTagName("infoTributaria");
//		
//		for (int temp = 0; temp < infoTributaria.getLength(); temp++) {
//			Node infoTributariaNode = infoTributaria.item(temp);
//			System.out.println("\nCurrent Element : " + infoTributariaNode.getNodeName());
//			
//			
//			if (infoTributariaNode.getNodeType() == Node.ELEMENT_NODE) {
//				 
//				Element eElement = (Element) infoTributariaNode;
//	 
//				System.out.println("Staff id : " + eElement.getAttribute("id"));
//				System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
//				System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
//				System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
//				System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
//	 
//			}
//			
//		}
		
		
			logger.info("Procesar Archivo ");
			logger.info("pathXml {}",pathXml);
			logger.info("pathSignature {}",pathSignature);
			logger.info("claveFirma {}",claveFirma);
			logger.info("claveAcceso {}",claveAcceso);
			logger.info("codFactura {}",codFactura);
			
			
//			String fileXml,fileXmlSignature,pathSignature;
//			fileXml="D:\\FacturacionElectronica\\clientes\\Prueba\\xml\\fac-2004000000023.xml";
//			fileXmlSignature="D:\\FacturacionElectronica\\clientes\\Prueba\\firmado\\fac-2004000000023.xml";
//			pathSignature="D:\\FacturacionElectronica\\clientes\\Prueba\\firma\\francisco_arturo_velez_rojas.p12";
			
			ArchivoXML.procesarComprobante(pathXml,pathXml,pathSignature,claveFirma,claveAcceso,codFactura,
			conHost,
			conDataBase,
			conUser,
			conPass,xmlStr);
		} catch (Exception e) {
			logger.info("Error "+e.toString());
		}
		
	}

}
