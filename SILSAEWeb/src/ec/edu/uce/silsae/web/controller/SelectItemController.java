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
	private List<SelectItem> catalogoNivelEstudio;
	private List<SelectItem> catalogoTipoExperiencia;
	private List<SelectItem> catalogoPais;
	private List<SelectItem> catalogoPrograma;
	private List<SelectItem> catalogoNivelPrograma;
	private List<SelectItem> catalogoIdioma;
	private List<SelectItem> catalogoNivelIdioma;
	private List<SelectItem> catalogoAnio;
	private List<SelectItem> catalogoMes;
	private List<SelectItem> catalogoUbicacion;
	private List<SelectItem> catalogoTipoEmpresa;
	private List<SelectItem> catalogoPuesto;
	
	@EJB
	private AdministracionService administracionService; 

	public SelectItemController() {
	}
	
	@PostConstruct
	private void init()
	{
		catalogoTipoDocumento=new ArrayList<SelectItem>();
		catalogoNivelEstudio=new ArrayList<SelectItem>();
		catalogoTipoExperiencia=new ArrayList<SelectItem>();
		catalogoPais=new ArrayList<SelectItem>();
		catalogoPrograma=new ArrayList<SelectItem>();
		catalogoNivelPrograma=new ArrayList<SelectItem>();
		catalogoIdioma=new ArrayList<SelectItem>();
		catalogoNivelIdioma=new ArrayList<SelectItem>();
		catalogoAnio=new ArrayList<SelectItem>();
		catalogoMes=new ArrayList<SelectItem>();
		catalogoPuesto=new ArrayList<SelectItem>();
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

	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoNivelEstudio() throws SilsaeException {
		if(CollectionUtils.isEmpty(catalogoNivelEstudio))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(4);
			catalogoNivelEstudio=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}
		return catalogoNivelEstudio;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoTipoExperiencia() throws SilsaeException {
		if(CollectionUtils.isEmpty(catalogoTipoExperiencia))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(10);
			catalogoTipoExperiencia=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}
		return catalogoTipoExperiencia;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoPais() throws SilsaeException{
		if(CollectionUtils.isEmpty(catalogoPais))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(13);
			catalogoPais=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}
		return catalogoPais;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoPrograma() throws SilsaeException {
		if(CollectionUtils.isEmpty(catalogoPrograma))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(15);
			catalogoPrograma=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}
		return catalogoPrograma;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoNivelPrograma() throws SilsaeException
	{
		if(CollectionUtils.isEmpty(catalogoNivelPrograma))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(19);
			catalogoNivelPrograma=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}
		return catalogoNivelPrograma;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoIdioma() throws SilsaeException {
		if(CollectionUtils.isEmpty(catalogoIdioma))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(23);
			catalogoIdioma=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}
		return catalogoIdioma;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoNivelIdioma() throws SilsaeException {
		if(CollectionUtils.isEmpty(catalogoNivelIdioma))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(28);
			catalogoNivelIdioma=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
		}
		return catalogoNivelIdioma;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoAnio() throws SilsaeException {
		if(CollectionUtils.isEmpty(catalogoAnio))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(0);
			catalogoAnio=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
		}

		return catalogoAnio;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoMes() throws SilsaeException {
		if(CollectionUtils.isEmpty(catalogoMes))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(-1);
			catalogoMes=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
		}
		return catalogoMes;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoUbicacion() throws SilsaeException {
		if(CollectionUtils.isEmpty(catalogoUbicacion))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(35);
			catalogoUbicacion=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
		}
		return catalogoUbicacion;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoTipoEmpresa() throws SilsaeException {
		if(CollectionUtils.isEmpty(catalogoTipoEmpresa))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(32);
			catalogoTipoEmpresa=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
		}
		return catalogoTipoEmpresa;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoPuesto() throws SilsaeException {
		if(CollectionUtils.isEmpty(catalogoPuesto))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(37);
			catalogoPuesto=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
		}
		return catalogoPuesto;
	}
	
	
}
