package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ViewScoped
@ManagedBean(name = "reportPublicDataManager")
public class ReportPublicDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int universidadNumber;
	private int provinciaNumber;
	private int ciudadNumber;
	
	public ReportPublicDataManager() {
	
	}

	public int getUniversidadNumber() {
		return universidadNumber;
	}

	public void setUniversidadNumber(int universidadNumber) {
		this.universidadNumber = universidadNumber;
	}

	public int getProvinciaNumber() {
		return provinciaNumber;
	}

	public void setProvinciaNumber(int provinciaNumber) {
		this.provinciaNumber = provinciaNumber;
	}

	public int getCiudadNumber() {
		return ciudadNumber;
	}

	public void setCiudadNumber(int ciudadNumber) {
		this.ciudadNumber = ciudadNumber;
	}
}
