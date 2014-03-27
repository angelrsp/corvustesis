package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaDTO;

@ViewScoped
@ManagedBean(name = "eticaDataManager")
public class EticaDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private EticaDTO eticaDTO;
	private List<EticaDTO> eticaList;
	
	public EticaDataManager() {
		eticaDTO=new EticaDTO();
		eticaList=new ArrayList<EticaDTO>();
	}

	
	public EticaDTO getEticaDTO() {
		return eticaDTO;
	}

	public void setEticaDTO(EticaDTO eticaDTO) {
		this.eticaDTO = eticaDTO;
	}

	public List<EticaDTO> getEticaList() {
		return eticaList;
	}

	public void setEticaList(List<EticaDTO> eticaList) {
		this.eticaList = eticaList;
	}
	
	
}
