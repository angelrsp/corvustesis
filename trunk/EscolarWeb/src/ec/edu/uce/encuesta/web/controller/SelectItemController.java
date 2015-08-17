package ec.edu.uce.encuesta.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.persistence.entity.CatalogoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ModeloDTO;
import ec.edu.uce.notas.ejb.service.AdministracionService;
import ec.edu.uce.notas.ejb.service.CatalogoService;
import ec.edu.uce.notas.ejb.service.IndicadorService;

public abstract class SelectItemController {

	private List<SelectItem> modeloList;
	private List<SelectItem> catalogoTipoContacto;
	private List<SelectItem> catalogoTipoDocumento;
	private List<SelectItem> catalogoTipoIndicador;
	
	@EJB
	private IndicadorService indicadorService;
	
	@EJB
	private AdministracionService administracionService;

	@EJB
	private CatalogoService catalogoService;

	
	public SelectItemController()
	{
		
	}
	
	@PostConstruct
	private void init()
	{
		modeloList=new ArrayList<SelectItem>();
		catalogoTipoContacto=new ArrayList<SelectItem>();
		catalogoTipoDocumento=new ArrayList<SelectItem>();
	}


	@SuppressWarnings("unchecked")
	public List<SelectItem> getModeloList() throws CorvustecException {
		if(CollectionUtils.isEmpty(modeloList))
		{
			modeloList=(List<SelectItem>) CollectionUtils.collect(indicadorService.obtenerModelo(),new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					ModeloDTO modelo=(ModeloDTO) arg0;
					return new SelectItem(modelo.getModCodigo(), modelo.getModDescripcion());
				}
			});
		}
		return modeloList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoTipoContacto() throws CorvustecException {
		if(CollectionUtils.isEmpty(catalogoTipoContacto))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(1);
			catalogoTipoContacto=(List<SelectItem>)CollectionUtils.collect(catalogoService.readCatalogo(1), new Transformer() {
				
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
	public List<SelectItem> getCatalogoTipoDocumento() throws CorvustecException {
		if(CollectionUtils.isEmpty(catalogoTipoDocumento))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(5);
			catalogoTipoDocumento=(List<SelectItem>)CollectionUtils.collect(catalogoService.readCatalogo(5), new Transformer() {
				
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
	public List<SelectItem> getCatalogoTipoIndicador() throws CorvustecException {
		if(CollectionUtils.isEmpty(catalogoTipoIndicador))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(8);
			catalogoTipoIndicador=(List<SelectItem>)CollectionUtils.collect(catalogoService.readCatalogo(8), new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					CatalogoDTO cat=(CatalogoDTO)arg0;
					return new SelectItem(cat.getCatCodigo(), cat.getCatDescripcion());
				}
			});
			
		}
		return catalogoTipoIndicador;
	}

}
