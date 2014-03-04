package net.ciespal.redxxi.web.controller.home;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;
import net.ciespal.redxxi.web.commons.util.JsfUtil;
import net.ciespal.redxxi.web.controller.SelectItemController;
import net.ciespal.redxxi.web.datamanager.CatalogoDataManager;

import com.corvustec.commons.util.CorvustecException;

@ViewScoped
@ManagedBean(name = "indexController")
public class IndexController extends SelectItemController {

	@EJB
	private AdministracionService administracionService;
	
	
	@ManagedProperty(value="#{catalogoDataManager}")
	private CatalogoDataManager catalogoDataManager;

	
	@PostConstruct
	private void init()
	{
		paises();
	}
	
	public CatalogoDataManager getCatalogoDataManager() {
		return catalogoDataManager;
	}

	public void setCatalogoDataManager(CatalogoDataManager catalogoDataManager) {
		this.catalogoDataManager = catalogoDataManager;
	}

	public void paises()
	{
		CatalogoDTO catalogo;
		try {
			catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(13);
			getCatalogoDataManager().setCatalogoList(administracionService.getCatalogo(catalogo));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
