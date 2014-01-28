package com.corvustec.apce.files.dto;

import java.io.Serializable;
import java.util.List;

public class TotalConImpuestosDTO implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<TotalImpuestoDTO> totalImpuesto;

	
	
	public List<TotalImpuestoDTO> getTotalImpuesto() {
		return totalImpuesto;
	}

	public void setTotalImpuesto(List<TotalImpuestoDTO> totalImpuesto) {
		this.totalImpuesto = totalImpuesto;
	}
	
	
}
