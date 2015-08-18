package ec.edu.uce.notas.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.notas.ejb.persistence.entity.PeriodoDTO;

@ViewScoped
@ManagedBean(name = "periodoDataManager")
public class PeriodoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PeriodoDTO periodoDTO; 
	
	private List<PeriodoDTO> periodoList;

	public PeriodoDataManager() {
		periodoDTO=new PeriodoDTO();
		periodoList=new ArrayList<PeriodoDTO>();
	}

	public PeriodoDTO getPeriodoDTO() {
		return periodoDTO;
	}

	public void setPeriodoDTO(PeriodoDTO periodoDTO) {
		this.periodoDTO = periodoDTO;
	}

	public List<PeriodoDTO> getPeriodoList() {
		return periodoList;
	}

	public void setPeriodoList(List<PeriodoDTO> periodoList) {
		this.periodoList = periodoList;
	}

	
}
