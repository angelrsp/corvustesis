package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.argos.VeeduriaDTO;

@ViewScoped
@ManagedBean(name="veeduriaDataManager")
public class VeeduriaDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VeeduriaDTO veeduria;
	private List<VeeduriaDTO> veeduriaList;
	
	public VeeduriaDataManager() {
		veeduria=new VeeduriaDTO();
		veeduriaList=new ArrayList<VeeduriaDTO>();
	}

	public VeeduriaDTO getVeeduria() {
		return veeduria;
	}

	public void setVeeduria(VeeduriaDTO veeduria) {
		this.veeduria = veeduria;
	}

	public List<VeeduriaDTO> getVeeduriaList() {
		return veeduriaList;
	}

	public void setVeeduriaList(List<VeeduriaDTO> veeduriaList) {
		this.veeduriaList = veeduriaList;
	}
}
