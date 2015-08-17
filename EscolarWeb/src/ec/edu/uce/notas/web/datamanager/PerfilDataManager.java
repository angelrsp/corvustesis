package ec.edu.uce.notas.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.notas.ejb.persistence.entity.PerfilDTO;

@ViewScoped
@ManagedBean(name = "perfilDataManager")
public class PerfilDataManager implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PerfilDTO perfil;
	
	private List<PerfilDTO> perfilList;
	
	public PerfilDataManager() {
		perfil=new PerfilDTO();
		perfilList=new ArrayList<PerfilDTO>();
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
