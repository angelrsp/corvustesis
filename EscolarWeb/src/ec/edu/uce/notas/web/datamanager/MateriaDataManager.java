package ec.edu.uce.notas.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.notas.ejb.persistence.entity.MateriaDTO;

@ViewScoped
@ManagedBean(name = "materiaDataManager")
public class MateriaDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MateriaDTO materiaDTO; 
	
	private List<MateriaDTO> materiaList;

	public MateriaDataManager() {
		materiaDTO=new MateriaDTO();
		materiaList=new ArrayList<MateriaDTO>();
	}

	public MateriaDTO getMateriaDTO() {
		return materiaDTO;
	}

	public void setMateriaDTO(MateriaDTO materiaDTO) {
		this.materiaDTO = materiaDTO;
	}

	public List<MateriaDTO> getMateriaList() {
		return materiaList;
	}

	public void setMateriaList(List<MateriaDTO> materiaList) {
		this.materiaList = materiaList;
	}

	
}
