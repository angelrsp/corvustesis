package ec.edu.uce.notas.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.AlumnoViewDTO;

@ViewScoped
@ManagedBean(name = "alumnoDataManager")
public class AlumnoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UsuarioDTO usuarioDTO;
	
	private List<AlumnoViewDTO> alumnoViewList;
	
	public AlumnoDataManager() {
		usuarioDTO=new UsuarioDTO();
		alumnoViewList=new ArrayList<AlumnoViewDTO>();
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public List<AlumnoViewDTO> getAlumnoViewList() {
		return alumnoViewList;
	}

	public void setAlumnoViewList(List<AlumnoViewDTO> alumnoViewList) {
		this.alumnoViewList = alumnoViewList;
	}

	
	
	
}
