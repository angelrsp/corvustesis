package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.security.AccesoDTO;

import org.primefaces.model.DualListModel;

@ViewScoped
@ManagedBean(name="perfilMenuDataManager")
public class PerfilMenuDataManager implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DualListModel<AccesoDTO> dualListModel;
	
	public PerfilMenuDataManager() {
		dualListModel=new DualListModel<AccesoDTO>();
	}

	public DualListModel<AccesoDTO> getDualListModel() {
		return dualListModel;
	}

	public void setDualListModel(DualListModel<AccesoDTO> dualListModel) {
		this.dualListModel = dualListModel;
	}
	
	
}
