package com.corvustec.rtoqad.process.dto;

import java.sql.Time;

public class IntervaloTiempoDTO {

	private Time timeDesde;
	private Time timeHasta;
	
	public IntervaloTiempoDTO() {
	
	}

	public Time getTimeDesde() {
		return timeDesde;
	}

	public void setTimeDesde(Time timeDesde) {
		this.timeDesde = timeDesde;
	}

	public Time getTimeHasta() {
		return timeHasta;
	}

	public void setTimeHasta(Time timeHasta) {
		this.timeHasta = timeHasta;
	}

	
}
