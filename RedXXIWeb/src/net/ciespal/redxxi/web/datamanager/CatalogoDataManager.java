package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;

@SessionScoped
@ManagedBean(name="catalogoDataManager")
public class CatalogoDataManager implements Serializable{

	private static final long serialVersionUID = 1L;

	private CatalogoDTO catalogo;

	private List<CatalogoDTO> catalogoList;
	
	public CatalogoDataManager() {
		
	}
	
	@PostConstruct
	private void init()
	{
		catalogo=new CatalogoDTO();
		catalogoList=new ArrayList<CatalogoDTO>();
	}

	public CatalogoDTO getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(CatalogoDTO catalogo) {
		this.catalogo = catalogo;
	}

	public List<CatalogoDTO> getCatalogoList() {
		return catalogoList;
	}

	public void setCatalogoList(List<CatalogoDTO> catalogoList) {
		this.catalogoList = catalogoList;
	}
}
