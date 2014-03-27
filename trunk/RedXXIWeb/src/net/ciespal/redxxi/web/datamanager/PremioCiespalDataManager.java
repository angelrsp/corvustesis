package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioCiespalDTO;

@ViewScoped
@ManagedBean(name="premioCiespalDataManager")
public class PremioCiespalDataManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PremioCiespalDTO premioCiespalDTO;
	private List<PremioCiespalDTO> premioCiespalList;
	
	
	public PremioCiespalDataManager() {
		premioCiespalDTO=new PremioCiespalDTO();
		premioCiespalList=new ArrayList<PremioCiespalDTO>();
	}


	public PremioCiespalDTO getPremioCiespalDTO() {
		return premioCiespalDTO;
	}


	public void setPremioCiespalDTO(PremioCiespalDTO premioCiespalDTO) {
		this.premioCiespalDTO = premioCiespalDTO;
	}


	public List<PremioCiespalDTO> getPremioCiespalList() {
		return premioCiespalList;
	}


	public void setPremioCiespalList(List<PremioCiespalDTO> premioCiespalList) {
		this.premioCiespalList = premioCiespalList;
	}


}
