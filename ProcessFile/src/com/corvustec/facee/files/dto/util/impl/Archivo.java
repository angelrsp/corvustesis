/**
 * 
 */
package com.corvustec.facee.files.dto.util.impl;

import java.io.File;
import java.util.Map;

import com.corvustec.facee.files.dto.util.IArchivo;

/**
 * @author wilmerPC
 *
 */
public abstract class Archivo implements IArchivo {
	
	private String nombreCliente;
	
	private Map<String, String> estructuraArchivos;
	
	public Archivo (Map<String, String> estructuraArchivos) {
		this.estructuraArchivos = estructuraArchivos;
	}

	/* (non-Javadoc)
	 * @see com.corvustec.facee.files.dto.IArchivo#procesarArchivo(java.io.File)
	 */
	@Override
	public abstract void procesarArchivo(File file);

	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * @return the estructuraArchivos
	 */
	public Map<String, String> getEstructuraArchivos() {
		return estructuraArchivos;
	}

	/**
	 * @param estructuraArchivos the estructuraArchivos to set
	 */
	public void setEstructuraArchivos(Map<String, String> estructuraArchivos) {
		this.estructuraArchivos = estructuraArchivos;
	}

}
