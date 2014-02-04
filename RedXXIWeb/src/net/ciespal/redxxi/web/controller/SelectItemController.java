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
	
	private Object pais;
	private Object provincia;
	private Object ciudad;
	
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
}
