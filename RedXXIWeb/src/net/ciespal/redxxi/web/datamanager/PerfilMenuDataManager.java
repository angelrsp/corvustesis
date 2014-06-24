package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.persistence.entities.security.AccesoVieDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.MenuDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.PerfilDTO;
import net.ciespal.redxxi.ejb.persistence.entities.util.dto.ObjetoDTO;

import org.primefaces.model.DualListModel;

@ViewScoped
@ManagedBean(name="perfilMenuDataManager")
public class PerfilMenuDataManager implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DualListModel<ObjetoDTO> dualListModel;
	
	private List<PerfilDTO> perfilList;
	
	private List<MenuDTO> menuList;
	
	private List<AccesoVieDTO> accesoList;
	private List<AccesoVieDTO> autorizadoList;
	
	
	private int perfilCode;
	private int menuCode;
	
	public PerfilMenuDataManager() {
		dualListModel=new DualListModel<ObjetoDTO>();
		perfilList=new ArrayList<PerfilDTO>();
		menuList=new ArrayList<MenuDTO>();
		accesoList=new ArrayList<AccesoVieDTO>();
		autorizadoList=new ArrayList<AccesoVieDTO>();
	}


	public List<PerfilDTO> getPerfilList() {
		return perfilList;
	}

	public void setPerfilList(List<PerfilDTO> perfilList) {
		this.perfilList = perfilList;
	}

	public List<MenuDTO> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuDTO> menuList) {
		this.menuList = menuList;
	}

	public int getPerfilCode() {
		return perfilCode;
	}

	public void setPerfilCode(int perfilCode) {
		this.perfilCode = perfilCode;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}


	public DualListModel<ObjetoDTO> getDualListModel() {
		return dualListModel;
	}


	public void setDualListModel(DualListModel<ObjetoDTO> dualListModel) {
		this.dualListModel = dualListModel;
	}


	public List<AccesoVieDTO> getAccesoList() {
		return accesoList;
	}


	public void setAccesoList(List<AccesoVieDTO> accesoList) {
		this.accesoList = accesoList;
	}


	public List<AccesoVieDTO> getAutorizadoList() {
		return autorizadoList;
	}


	public void setAutorizadoList(List<AccesoVieDTO> autorizadoList) {
		this.autorizadoList = autorizadoList;
	}
	
	
}
