package com.corvustec.apce.files.main;



import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.corvustec.apce.files.dto.InfoFacturaDTO;
import com.corvustec.apce.files.dto.InfoTributariaDTO;


public class TestPdf {

	
	public static void main(String[] args) {
	
		String filepath = "D:\\FacturaElectronica\\2301201401171679011600110010010000123580001235818.xml";
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		Document document;
		try {
			docBuilder = docFactory.newDocumentBuilder();
			document = docBuilder.parse(filepath);
			
			
			NodeList infoTributaria = document.getElementsByTagName("infoTributaria");
			NodeList infoFactura = document.getElementsByTagName("infoFactura");
			
			InfoTributariaDTO infoTributariaDTO=new InfoTributariaDTO();
			InfoFacturaDTO infoFacturaDTO=new InfoFacturaDTO();
			
			for (int temp = 0; temp < infoTributaria.getLength(); temp++) {
				Node infoTributariaNode = infoTributaria.item(temp);
				
				if (infoTributariaNode.getNodeType() == Node.ELEMENT_NODE) {
					 
					Element eElement = (Element) infoTributariaNode;
		 
					infoTributariaDTO.setAmbiente(eElement.getElementsByTagName("ambiente").item(0).getTextContent());
					infoTributariaDTO.setTipoEmision(eElement.getElementsByTagName("tipoEmision").item(0).getTextContent());
					infoTributariaDTO.setRazonSocial(eElement.getElementsByTagName("razonSocial").item(0).getTextContent());
					infoTributariaDTO.setNombreComercial(eElement.getElementsByTagName("nombreComercial").item(0).getTextContent());
		 
				}
				
			}
			
			for (int temp = 0; temp < infoFactura.getLength(); temp++) {
				Node infoFacturaNode = infoFactura.item(temp);
				
				if (infoFacturaNode.getNodeType() == Node.ELEMENT_NODE) {
					 
					Element eElement = (Element) infoFacturaNode;
		 
					infoTributariaDTO.setAmbiente(eElement.getElementsByTagName("ambiente").item(0).getTextContent());
					infoTributariaDTO.setTipoEmision(eElement.getElementsByTagName("tipoEmision").item(0).getTextContent());
					infoTributariaDTO.setRazonSocial(eElement.getElementsByTagName("razonSocial").item(0).getTextContent());
					infoTributariaDTO.setNombreComercial(eElement.getElementsByTagName("nombreComercial").item(0).getTextContent());
		 
				}
				
			}
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
