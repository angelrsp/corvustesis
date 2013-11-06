/**
 * 
 */
package com.corvustec.facee.files.dto.util.impl;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wilmerPC
 *
 */
public class ArchivoListener extends Archivo {
	
	private final static Logger logger = LoggerFactory.getLogger(ArchivoListener.class);
	
	public ArchivoListener (Map<String, String> estructuraArchivos) {
		super(estructuraArchivos);
	}

	@Override
	public void procesarArchivo(File file) {}
	
	@SuppressWarnings("rawtypes")
	public void verificarEstructuraArchivos () {
		
		logger.info("verificarEstructuraArchivos");
		
		Iterator<Entry<String, String>> iterator = getEstructuraArchivos().entrySet().iterator();
		
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry)iterator.next();
			
			logger.info("[{} = {} ]" , entry.getKey(), entry.getValue());
			
			File file = new File(entry.getValue().toString());
			
			if (!file.exists()) {
				file.mkdir();
			}
			
		}
		
	}

}
