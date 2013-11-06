/**
 * 
 */
package com.corvustec.facee.files.xml.notaDebito;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author wilmerPC
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"motivo"})
public class MotivosDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(required = true)
	private List<MotivoDTO> motivo;
	
	public MotivosDTO () {}

	public List<MotivoDTO> getMotivo() {
		return motivo;
	}

	public void setMotivo(List<MotivoDTO> motivo) {
		this.motivo = motivo;
	}
	
	

}
