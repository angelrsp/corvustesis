package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioDTO;

@ViewScoped
@ManagedBean(name="premioPeriodisticoDataManager")
public class PremioPeriodisticoDataManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PremioDTO premioDTO;
	private List<PremioDTO> premioList;
	
	
	public PremioPeriodisticoDataManager() {
		premioDTO=new PremioDTO();
		premioList=new ArrayList<PremioDTO>();
	}


	public PremioDTO getPremioDTO() {
		return premioDTO;
	}


	public void setPremioDTO(PremioDTO premioDTO) {
		this.premioDTO = premioDTO;
	}


	public List<PremioDTO> getPremioList() {
		return premioList;
	}


	public void setPremioList(List<PremioDTO> premioList) {
		this.premioList = premioList;
	}

}
