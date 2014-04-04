package ec.edu.uce.indicadores.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.AdministracionService;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;
import ec.edu.uce.indicadores.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "perfilController")
public class PerfilController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AdministracionService administracionService;
	
	private PerfilDTO perfil;
	private List<PerfilDTO> perfilList;
	
	public PerfilController() {
	}

	@PostConstruct
	private void init()
	{
		perfil=new PerfilDTO();
		perfilList=new ArrayList<PerfilDTO>();
	}
	
	public PerfilDTO getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}
	public List<PerfilDTO> getPerfilList() throws IndicadoresException {
		this.perfilList=administracionService.readPerfil();
		return perfilList;
	}
	public void setPerfilList(List<PerfilDTO> perfilList) {
		this.perfilList = perfilList;
	}


	public void save()
	{
		try {
			administracionService.createOrUpdatePerfil(getPerfil());
			getPerfilList();
			cancel();
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void cancel()
	{
		setPerfil(new PerfilDTO());
	}
	
	public void edit(PerfilDTO perfil)
	{
		setPerfil(perfil);
	}
	
	public void delete(PerfilDTO perfil)
	{
		try {
			administracionService.deletePerfil(perfil);
			JsfUtil.addInfoMessage("Eliminado Exitosamente");
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
