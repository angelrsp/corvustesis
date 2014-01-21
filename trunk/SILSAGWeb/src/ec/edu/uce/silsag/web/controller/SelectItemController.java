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
	private List<SelectItem> catalogoUbicacion;
	private List<SelectItem> catalogoTipoEmpresa;
	private List<SelectItem> catalogoPuesto;
	private List<SelectItem> catalogoEstadoCivil;
	private List<SelectItem> catalogoGenero;
	private List<SelectItem> catalogoEspeciliadadTercerNivel;
	private List<SelectItem> catalogoEspeciliadadCuartoNivel;
	
	
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
		catalogoPuesto=new ArrayList<SelectItem>();
		catalogoEstadoCivil=new ArrayList<SelectItem>();
		catalogoEspeciliadadCuartoNivel=new ArrayList<SelectItem>();
		catalogoEspeciliadadTercerNivel=new ArrayList<SelectItem>();
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
			catalogo.setCatCodigo(8);
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
			catalogo.setCatCodigo(11);
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
	public List<SelectItem> getCatalogoUbicacion() throws SilsagException {
		if(CollectionUtils.isEmpty(catalogoUbicacion))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(11);
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
			catalogo.setCatCodigo(16);
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
			catalogo.setCatCodigo(25);
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
			catalogo.setCatCodigo(19);//Codigo Catalogo
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

	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoGenero() throws SilsagException {
		if(CollectionUtils.isEmpty(catalogoGenero))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(32);//Codigo Catalogo
			catalogoGenero=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
		}
		return catalogoGenero;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoEspeciliadadTercerNivel() throws SilsagException {
		if(CollectionUtils.isEmpty(catalogoEspeciliadadTercerNivel))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(35);//Codigo Catalogo
			catalogoEspeciliadadTercerNivel=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
		}
		return catalogoEspeciliadadTercerNivel;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoEspeciliadadCuartoNivel() throws SilsagException {
		if(CollectionUtils.isEmpty(catalogoEspeciliadadTercerNivel))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(38);//Codigo Catalogo
			catalogoEspeciliadadCuartoNivel=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
		}
		return catalogoEspeciliadadCuartoNivel;
	}
}
