/**
 * 
 */
package com.corvustec.facee.files.dto.util.impl;

import java.io.File;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wilmerPC
 *
 */
public class ArchivoComprobanteRetencion extends Archivo{
	
	private final static Logger logger = LoggerFactory.getLogger(ArchivoComprobanteRetencion.class);
	
//	public ArchivoComprobanteRetencion(String urlCarpetaProcesados){
//		super(urlCarpetaProcesados);
//	}
	
	public ArchivoComprobanteRetencion (Map<String, String> estructuraArchivos) {
		super(estructuraArchivos);
	}

	@Override
	public void procesarArchivo(File file) {
		// TODO Auto-generated method stub
		logger.info("se va ha procesar el archivo {} ArchivoComprobanteRetencion", file.getName());
		
	}

}
