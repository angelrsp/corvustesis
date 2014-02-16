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
	private List<SelectItem> catalogoTipoContacto;
	private List<SelectItem> catalogoPais;
	private List<SelectItem> catalogoProvincia;
	private List<SelectItem> catalogoCiudad;
	private List<SelectItem> catalogoModalidad;
	private List<SelectItem> catalogoTipoPosgrado;
	private List<SelectItem> catalogoSexo;
	private List<SelectItem> catalogoTipoPublicacion;
	private List<SelectItem> catalogoCampoConocimiento;
	private List<SelectItem> catalogoSubCampoConocimiento;
	
	private Object pais;
	private Object provincia;
	private Object ciudad;
	
	private Object campoConocimiento;
	private Object subCampoConocimiento;
	
	
	public SelectItemController() {
	}
	
	@PostConstruct
	private void init()
	{
		catalogoTipoEstablecimiento=new ArrayList<SelectItem>();
		catalogoTipoContacto=new ArrayList<SelectItem>();
		catalogoPais=new ArrayList<SelectItem>();
		catalogoProvincia=new ArrayList<SelectItem>();
		catalogoCiudad=new ArrayList<SelectItem>();
		catalogoCampoConocimiento=new ArrayList<SelectItem>();
		catalogoSubCampoConocimiento=new ArrayList<SelectItem>();				
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

	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoTipoContacto() throws CorvustecException {
		if(CollectionUtils.isEmpty(catalogoTipoContacto))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(8);
			catalogoTipoContacto=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}
		return catalogoTipoContacto;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoPais() throws CorvustecException {
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
	public List<SelectItem> getCatalogoProvincia() throws CorvustecException {
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(pais!=null?Integer.valueOf(pais.toString()):-3);
			if(administracionService.getCatalogo(catalogo)==null)
				return new ArrayList<SelectItem>();
			catalogoProvincia=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		return catalogoProvincia;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoCiudad() throws CorvustecException {
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(provincia!=null?Integer.valueOf(provincia.toString()):-3);
			if(administracionService.getCatalogo(catalogo)==null)
				return new ArrayList<SelectItem>();
			catalogoCiudad=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		return catalogoCiudad;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoModalidad() throws CorvustecException {
		if(CollectionUtils.isEmpty(catalogoModalidad))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(23);
			catalogoModalidad=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}
		return catalogoModalidad;
	}	
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoTipoPosgrado() throws CorvustecException {
		if(CollectionUtils.isEmpty(catalogoTipoPosgrado))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(26);
			catalogoTipoPosgrado=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}
		return catalogoTipoPosgrado;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoSexo() throws CorvustecException {
		if(CollectionUtils.isEmpty(catalogoSexo))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(30);
			catalogoSexo=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}
		return catalogoSexo;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoTipoPublicacion() throws CorvustecException {
		if(CollectionUtils.isEmpty(catalogoTipoPublicacion))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(33);
			catalogoTipoPublicacion=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}
		return catalogoTipoPublicacion;
	}

	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoCampoConocimiento() throws CorvustecException {
		if(CollectionUtils.isEmpty(catalogoCampoConocimiento))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(38);
			catalogoCampoConocimiento=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}		
		
		return catalogoCampoConocimiento;
	}


	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoSubCampoConocimiento() throws CorvustecException {
		if(CollectionUtils.isEmpty(catalogoSubCampoConocimiento))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(campoConocimiento!=null?Integer.valueOf(campoConocimiento.toString()):-3);
			if(administracionService.getCatalogo(catalogo)==null)
				return new ArrayList<SelectItem>();
			catalogoSubCampoConocimiento=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}		
		
		return catalogoSubCampoConocimiento;
	}


	
	
	public Object getPais() {
		return pais;
	}

	public void setPais(Object pais) {
		this.pais = pais;
	}

	public Object getProvincia() {
		return provincia;
	}

	public void setProvincia(Object provincia) {
		this.provincia = provincia;
	}

	public Object getCiudad() {
		return ciudad;
	}

	public void setCiudad(Object ciudad) {
		this.ciudad = ciudad;
	}

	public Object getCampoConocimiento() {
		return campoConocimiento;
	}

	public void setCampoConocimiento(Object campoConocimiento) {
		this.campoConocimiento = campoConocimiento;
	}

	public Object getSubCampoConocimiento() {
		return subCampoConocimiento;
	}

	public void setSubCampoConocimiento(Object subCampoConocimiento) {
		this.subCampoConocimiento = subCampoConocimiento;
	}
}
