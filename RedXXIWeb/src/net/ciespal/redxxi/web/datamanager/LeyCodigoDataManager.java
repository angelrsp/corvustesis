package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.espejo.LeyDTO;

@ViewScoped
@ManagedBean(name="leyCodigoDataManager")
public class LeyCodigoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LeyDTO leyDTO;
	private List<LeyDTO> leyList;
	
	
	public LeyCodigoDataManager() {
		leyDTO=new LeyDTO();
		leyList=new ArrayList<LeyDTO>();
	}


	public LeyDTO getLeyDTO() {
		return leyDTO;
	}


	public void setLeyDTO(LeyDTO leyDTO) {
		this.leyDTO = leyDTO;
	}


	public List<LeyDTO> getLeyList() {
		return leyList;
	}


	public void setLeyList(List<LeyDTO> leyList) {
		this.leyList = leyList;
	}


}
