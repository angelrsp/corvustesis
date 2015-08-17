package ec.edu.uce.notas.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.notas.ejb.persistence.entity.CursoDTO;

@ViewScoped
@ManagedBean(name = "cursoDataManager")
public class CursoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CursoDTO cursoDTO; 
	
	private List<CursoDTO> cursoList;

	public CursoDataManager() {
		cursoDTO=new CursoDTO();
		cursoList=new ArrayList<CursoDTO>();
	}

	public CursoDTO getCursoDTO() {
		return cursoDTO;
	}

	public void setCursoDTO(CursoDTO cursoDTO) {
		this.cursoDTO = cursoDTO;
	}

	public List<CursoDTO> getCursoList() {
		return cursoList;
	}

	public void setCursoList(List<CursoDTO> cursoList) {
		this.cursoList = cursoList;
	}
}
