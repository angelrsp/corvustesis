package ec.edu.uce.silsae.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.AdministracionService;
import ec.edu.uce.silsae.ejb.persistence.entities.CatalogoDTO;



public abstract class SelectItemController {

	
	private List<SelectItem> catalogoTipoDocumento;

	@EJB
	private AdministracionService administracionService; 

	public SelectItemController() {
	}
	
	@PostConstruct
	private void init()
	{
		catalogoTipoDocumento=new ArrayList<SelectItem>();
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoTipoDocumento() throws SilsaeException {
		if(CollectionUtils.isEmpty(catalogoTipoDocumento))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(1);
			catalogoTipoDocumento=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}
		return catalogoTipoDocumento;
	}

}
