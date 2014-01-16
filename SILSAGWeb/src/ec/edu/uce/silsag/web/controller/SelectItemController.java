package ec.edu.uce.silsag.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.AdministracionService;
import ec.edu.uce.silsag.ejb.persistence.entities.CatalogoDTO;


public abstract class SelectItemController{

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
	private List<SelectItem> catalogoEstadoCivil;
	
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
		catalogoEstadoCivil=new ArrayList<SelectItem>();
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoTipoDocumento() throws SilsagException {
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
	public List<SelectItem> getCatalogoNivelEstudio() throws SilsagException {
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
	public List<SelectItem> getCatalogoTipoExperiencia() throws SilsagException {
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
	public List<SelectItem> getCatalogoPais() throws SilsagException{
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
	public List<SelectItem> getCatalogoPrograma() throws SilsagException {
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
	public List<SelectItem> getCatalogoNivelPrograma() throws SilsagException
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
	public List<SelectItem> getCatalogoIdioma() throws SilsagException {
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
	public List<SelectItem> getCatalogoNivelIdioma() throws SilsagException {
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
	public List<SelectItem> getCatalogoAnio() throws SilsagException {
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
	public List<SelectItem> getCatalogoMes() throws SilsagException {
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
	public List<SelectItem> getCatalogoUbicacion() throws SilsagException {
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
	public List<SelectItem> getCatalogoTipoEmpresa() throws SilsagException {
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
	public List<SelectItem> getCatalogoPuesto() throws SilsagException {
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

	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoEstadoCivil() throws SilsagException {
		if(CollectionUtils.isEmpty(catalogoEstadoCivil))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(39);//Codigo Catalogo
			catalogoEstadoCivil=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
		}
		return catalogoEstadoCivil;
	}

	
}
