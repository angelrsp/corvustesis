package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ViewScoped
@ManagedBean(name="registroOpcionDataManager")
public class RegistroOpcionDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int opcion;
	
	public RegistroOpcionDataManager() {
	
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	
}
