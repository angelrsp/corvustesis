package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.argos.RedDTO;

@ViewScoped
@ManagedBean(name="redDataManager")
public class RedDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RedDTO red;
	private List<RedDTO> redList;
	
	
	public RedDataManager() {
		red=new RedDTO();
		redList=new ArrayList<RedDTO>();
	}

	public RedDTO getRed() {
		return red;
	}

	public void setRed(RedDTO red) {
		this.red = red;
	}

	public List<RedDTO> getRedList() {
		return redList;
	}

	public void setRedList(List<RedDTO> redList) {
		this.redList = redList;
	}
	
	
}
