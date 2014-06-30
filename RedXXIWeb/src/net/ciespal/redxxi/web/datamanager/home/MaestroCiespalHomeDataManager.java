package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalVieDTO;

@SessionScoped
@ManagedBean(name = "maestroCiespalHomeDataManager")
public class MaestroCiespalHomeDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private MaestroCiespalVieDTO maestroCiespalVieDTO;

	private String item;
	
	public MaestroCiespalHomeDataManager() {
		maestroCiespalVieDTO=new MaestroCiespalVieDTO();	
	}


	public MaestroCiespalVieDTO getMaestroCiespalVieDTO() {
		return maestroCiespalVieDTO;
	}


	public void setMaestroCiespalVieDTO(MaestroCiespalVieDTO maestroCiespalVieDTO) {
		this.maestroCiespalVieDTO = maestroCiespalVieDTO;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}
	
}
