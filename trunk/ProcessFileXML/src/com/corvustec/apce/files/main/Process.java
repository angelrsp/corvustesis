package com.corvustec.apce.files.main;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		
//		String filepath = "D:\\FacturacionElectronica\\clientes\\Prueba\\firmado\\fac-2004000000023.xml";
//		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//		Document doc = docBuilder.parse(filepath);
//		
//		String docStr= UtilApplication.convertDocumentToString(doc);
//		
//		Document document=UtilApplication.convertStringToDocument(docStr);
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
		String fileXml,fileXmlSignature,pathSignature;
		fileXml="D:\\FacturacionElectronica\\clientes\\Prueba\\xml\\fac-2004000000023.xml";
		fileXmlSignature="D:\\FacturacionElectronica\\clientes\\Prueba\\firmado\\fac-2004000000023.xml";
		pathSignature="D:\\FacturacionElectronica\\clientes\\Prueba\\firma\\francisco_arturo_velez_rojas.p12";
		
		ArchivoXML.procesarComprobante(fileXml,fileXmlSignature,pathSignature,"ulygGd+Hh/4di7WinfA1NA=","1101201401171679011600110010012004000321234560115");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,2014);
		cal.set(Calendar.MONTH,0);
		cal.set(Calendar.DAY_OF_MONTH,11);

		Date date = cal.getTime();
		
		String a= UtilApplication.getClaveAcceso(date, "01", "1716790116001", "1", "200400032", "12345601", "1", "001", "001");
		System.out.print(a);
	}

}
