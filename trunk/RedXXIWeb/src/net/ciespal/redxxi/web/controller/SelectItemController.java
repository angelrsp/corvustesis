package net.ciespal.redxxi.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import com.corvustec.commons.util.CorvustecException;


public abstract class SelectItemController {

	@EJB
	private AdministracionService administracionService; 

	private List<SelectItem> catalogoTipoEstablecimiento;
	
	public SelectItemController() {
	}
	
	@PostConstruct
	private void init()
	{
		catalogoTipoEstablecimiento=new ArrayList<SelectItem>();
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoTipoEstablecimiento() throws CorvustecException {
		if(CollectionUtils.isEmpty(catalogoTipoEstablecimiento))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(1);
			catalogoTipoEstablecimiento=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}
		return catalogoTipoEstablecimiento;
	}

	
}
