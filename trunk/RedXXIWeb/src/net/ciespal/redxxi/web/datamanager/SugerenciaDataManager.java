package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.security.ComentarioDTO;

@ViewScoped
@ManagedBean(name = "sugerenciaDataManager")
public class SugerenciaDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ComentarioDTO comentario;
	
	
	public SugerenciaDataManager() {
		comentario=new ComentarioDTO();
	}


	public ComentarioDTO getComentario() {
		return comentario;
	}


	public void setComentario(ComentarioDTO comentario) {
		this.comentario = comentario;
	}
	
}
