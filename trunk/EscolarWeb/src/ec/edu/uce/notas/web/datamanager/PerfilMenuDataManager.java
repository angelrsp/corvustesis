package ec.edu.uce.notas.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import com.corvustec.notas.common.util.dto.ObjetoDTO;

import ec.edu.uce.notas.ejb.persistence.entity.MenuDTO;
import ec.edu.uce.notas.ejb.persistence.entity.PerfilDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.AccesoViewDTO;

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
	
	private List<AccesoViewDTO> accesoList;
	private List<AccesoViewDTO> autorizadoList;
	
	
	private int perfilCode;
	private int menuCode;
	
	public PerfilMenuDataManager() {
		dualListModel=new DualListModel<ObjetoDTO>();
		perfilList=new ArrayList<PerfilDTO>();
		menuList=new ArrayList<MenuDTO>();
		accesoList=new ArrayList<AccesoViewDTO>();
		autorizadoList=new ArrayList<AccesoViewDTO>();
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


	public List<AccesoViewDTO> getAccesoList() {
		return accesoList;
	}


	public void setAccesoList(List<AccesoViewDTO> accesoList) {
		this.accesoList = accesoList;
	}


	public List<AccesoViewDTO> getAutorizadoList() {
		return autorizadoList;
	}


	public void setAutorizadoList(List<AccesoViewDTO> autorizadoList) {
		this.autorizadoList = autorizadoList;
	}
	
	
}
