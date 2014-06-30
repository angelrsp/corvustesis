package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroVieDTO;

@SessionScoped
@ManagedBean(name = "grandesMaestrosHomeDataManager")
public class GrandesMaestrosHomeDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GranMaestroVieDTO granMaestroVieDTO;
	
	private String item;
	
	public GrandesMaestrosHomeDataManager() {
		granMaestroVieDTO=new GranMaestroVieDTO();
	}

	public GranMaestroVieDTO getGranMaestroVieDTO() {
		return granMaestroVieDTO;
	}

	public void setGranMaestroVieDTO(GranMaestroVieDTO granMaestroVieDTO) {
		this.granMaestroVieDTO = granMaestroVieDTO;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
}
