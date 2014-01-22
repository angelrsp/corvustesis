package ec.edu.uce.silsag.commons.dto.util;

import java.io.Serializable;

public class EstudioReportDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String estNumero; 
	
	private String estCodigo;
	
	private String estMes;
	
	public EstudioReportDTO() {
	}

	public String getEstNumero() {
		return estNumero;
	}

	public void setEstNumero(String estNumero) {
		this.estNumero = estNumero;
	}

	public String getEstCodigo() {
		return estCodigo;
	}

	public void setEstCodigo(String estCodigo) {
		this.estCodigo = estCodigo;
	}

	public String getEstMes() {
		return estMes;
	}

	public void setEstMes(String estMes) {
		this.estMes = estMes;
	}
	
	
	
	
}
