package ec.edu.uce.notas.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.corvustec.notas.common.util.dto.ObjetoDTO;

import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.AlumnoViewDTO;

@ViewScoped
@ManagedBean(name = "notasDocenteDataManager")
public class NotasDocenteDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UsuarioDTO usuarioDTO;
	
	private List<AlumnoViewDTO> alumnoViewList;
	
	private List<ObjetoDTO> quimestre;
	
	
	
	public NotasDocenteDataManager() {
		usuarioDTO=new UsuarioDTO();
		alumnoViewList=new ArrayList<AlumnoViewDTO>();
		quimestre=new ArrayList<ObjetoDTO>();
		ObjetoDTO pq=new ObjetoDTO();
		pq.setCodigo(1);
		pq.setDescripcion("Mostrar Parciles");
		quimestre.add(pq);
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

	public List<ObjetoDTO> getQuimestre() {
		return quimestre;
	}

	public void setQuimestre(List<ObjetoDTO> quimestre) {
		this.quimestre = quimestre;
	}

	

	
	
	
	
}
