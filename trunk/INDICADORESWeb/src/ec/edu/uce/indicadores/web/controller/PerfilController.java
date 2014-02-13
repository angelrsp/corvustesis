package ec.edu.uce.indicadores.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;

@ViewScoped
@ManagedBean(name = "perfilController")
public class PerfilController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PerfilDTO perfil;
	private List<PerfilDTO> perfilList;
	
	public PerfilController() {
	}

	@PostConstruct
	private void init()
	{
		
	}
	
	public PerfilDTO getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}
	public List<PerfilDTO> getPerfilList() {
		return perfilList;
	}
	public void setPerfilList(List<PerfilDTO> perfilList) {
		this.perfilList = perfilList;
	}

		
	
}
