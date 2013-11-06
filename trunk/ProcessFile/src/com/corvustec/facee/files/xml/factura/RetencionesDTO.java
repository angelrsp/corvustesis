package com.corvustec.facee.files.xml.factura;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"retencion"})
public class RetencionesDTO {
	
	@XmlElement(required = true)
	private List<RetencionDTO> retencion;
	
	public RetencionesDTO () {}

	/**
	 * @return the retencion
	 */
	public List<RetencionDTO> getRetencion() {
		
		if (retencion == null) {
			retencion = new ArrayList<RetencionDTO>();
		}
		return retencion;
	}

	/**
	 * @param retencion the retencion to set
	 */
	public void setRetencion(List<RetencionDTO> retencion) {
		this.retencion = retencion;
	}
	
}
