/**
 * 
 */
package com.corvustec.facee.files.xml.commons;

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
@XmlType(name="", propOrder={"totalImpuesto"})
public class TotalConImpuestosDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(required = true)
	private List<ImpuestoDTO> totalImpuesto;

	public TotalConImpuestosDTO() {}

	/**
	 * @return the totalImpuesto
	 */
	public List<ImpuestoDTO> getTotalImpuesto() {
		return totalImpuesto;
	}

	/**
	 * @param totalImpuesto the totalImpuesto to set
	 */
	public void setTotalImpuesto(List<ImpuestoDTO> totalImpuesto) {
		this.totalImpuesto = totalImpuesto;
	}
	
}
