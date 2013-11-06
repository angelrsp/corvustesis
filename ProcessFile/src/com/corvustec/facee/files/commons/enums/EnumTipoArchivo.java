/**
 * 
 */
package com.corvustec.facee.files.commons.enums;

import com.corvustec.facee.files.commons.util.MessagesApplication;

/**
 * Enum para los diferentes tipos de archivos que se van a procesar
 * @author wilmerPC
 *
 */
public enum EnumTipoArchivo {
	
	FACTURA(MessagesApplication.getInstancia().getString("com.corvustec.facee.codigo.tipoArchivo.factura")),
	NOTACREDITO(MessagesApplication.getInstancia().getString("com.corvustec.facee.codigo.tipoArchivo.notaCredito")),
	NOTADEBITO(MessagesApplication.getInstancia().getString("com.corvustec.facee.codigo.tipoArchivo.notaDebito")),
	GUIAREMISION(MessagesApplication.getInstancia().getString("com.corvustec.facee.codigo.tipoArchivo.guiaRemision")),
	COMPROBANTERETENCION(MessagesApplication.getInstancia().getString("com.corvustec.facee.codigo.tipoArchivo.comprobanteRetencion"));
	
	private String id;
	
	EnumTipoArchivo(String id){
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
}
