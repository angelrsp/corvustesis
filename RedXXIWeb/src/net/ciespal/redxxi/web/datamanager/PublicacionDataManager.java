package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.PublicacionDTO;

@SessionScoped
@ManagedBean(name="publicacionDataManager")
public class PublicacionDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PublicacionDTO publicacion;
	private List<PublicacionDTO> publicacionList;
	private List<PublicacionDTO> publicacionListPublic;

	private Object tipoPublicacion;
	
	public PublicacionDataManager() {
	}
	
	@PostConstruct
	private void init()
	{
		publicacion=new PublicacionDTO();
		publicacionList=new ArrayList<PublicacionDTO>();
		publicacionListPublic=new ArrayList<PublicacionDTO>();
	}
	
	public PublicacionDTO getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(PublicacionDTO publicacion) {
		this.publicacion = publicacion;
	}

	public List<PublicacionDTO> getPublicacionList() {
		return publicacionList;
	}

	public void setPublicacionList(List<PublicacionDTO> publicacionList) {
		this.publicacionList = publicacionList;
	}

	public List<PublicacionDTO> getPublicacionListPublic() {
		return publicacionListPublic;
	}

	public void setPublicacionListPublic(List<PublicacionDTO> publicacionListPublic) {
		this.publicacionListPublic = publicacionListPublic;
	}

	public Object getTipoPublicacion() {
		return tipoPublicacion;
	}

	public void setTipoPublicacion(Object tipoPublicacion) {
		this.tipoPublicacion = tipoPublicacion;
	}
}
