/**
 * 
 */
package com.corvustec.facee.files.xml.factura;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.corvustec.facee.files.xml.commons.ImpuestoDTO;

/**
 * @author wilmerPC
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"impuesto"})
public class ImpuestosDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(required = true)
	private List<ImpuestoDTO> impuesto;
	
	public ImpuestosDTO () {}

	/**
	 * @return the impuesto
	 */
	public List<ImpuestoDTO> getImpuesto() {
		return impuesto;
	}

	/**
	 * @param impuesto the impuesto to set
	 */
	public void setImpuesto(List<ImpuestoDTO> impuesto) {
		this.impuesto = impuesto;
	}
	
}
