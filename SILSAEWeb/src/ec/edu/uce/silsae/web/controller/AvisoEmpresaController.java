package ec.edu.uce.silsae.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.silsae.ejb.persistence.entities.AvisoDTO;

@ViewScoped
@ManagedBean (name = "avisoEmpresaController")
public class AvisoEmpresaController extends SelectItemController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AvisoDTO aviso;

	@PostConstruct
	private void init()
	{
		aviso=new AvisoDTO();
	}
	
	public AvisoDTO getAviso() {
		return aviso;
	}

	public void setAviso(AvisoDTO aviso) {
		this.aviso = aviso;
	}
	
}
