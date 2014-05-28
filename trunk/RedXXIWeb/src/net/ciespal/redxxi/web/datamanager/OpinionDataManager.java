package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.argos.OpinionDTO;

@ViewScoped
@ManagedBean(name = "opinionDataManager")
public class OpinionDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OpinionDTO opinionDTO;
	
	private String fecha;
	
	public OpinionDataManager() {
		opinionDTO=new OpinionDTO();
	}

	public OpinionDTO getOpinionDTO() {
		return opinionDTO;
	}

	public void setOpinionDTO(OpinionDTO opinionDTO) {
		this.opinionDTO = opinionDTO;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
