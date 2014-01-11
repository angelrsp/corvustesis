package com.corvustec.apce.files.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.apce.files.ArchivoXML;

public class Process {

	
	private final static Logger logger = LoggerFactory.getLogger(Process.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("Procesar Archivo ");
		ArchivoXML.procesarComprobante("/home/fernando/FacturacionElectronica/archivosCadena/fac-2004000000021.xml");
		//ArchivoXML.procesarComprobante("/home/fernando/FacturacionElectronica/clientes/Prueba/xml/0710201301179125123700110010650000000107791051216.xml");
		
		

	}

}
