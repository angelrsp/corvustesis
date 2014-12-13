package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;

@ViewScoped
@ManagedBean(name = "actualizarClaveDataManager")
public class ActualizarClaveDataManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UsuarioDTO usuarioDTOInsertar;
	
	public ActualizarClaveDataManager() {
		usuarioDTOInsertar=new UsuarioDTO();
	}

}
