package net.ciespal.redxxi.web.datamanager.home;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "espejoVisorDataManager")
public class EspejoVisorDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String item;


	public EspejoVisorDataManager() {
	
	}
	
	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}
	
	
}
