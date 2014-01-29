package net.ciespal.redxxi.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "facultadController")
public class FacultadController extends SelectItemController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Object tipoEstablecimiento;
	
	public FacultadController() {
	}

	@PostConstruct
	private void init()
	{
		
	}

	public Object getTipoEstablecimiento() {
		return tipoEstablecimiento;
	}

	public void setTipoEstablecimiento(Object tipoEstablecimiento) {
		this.tipoEstablecimiento = tipoEstablecimiento;
	}
	
	public void agregarUniversidad()
	{
		
	}
}
