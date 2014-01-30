package com.corvustec.apce.files.dto.factura;

import java.util.ArrayList;
import java.util.List;

public class RetencionesDTO {
	
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
