package ec.edu.uce.indicadores.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.AdministracionService;
import ec.edu.uce.indicadores.ejb.negocio.IndicadorService;
import ec.edu.uce.indicadores.ejb.persistence.entities.CatalogoDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ModeloDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalListDTO;

public abstract class SelectItemController {

	private List<SelectItem> iesList;
	private List<SelectItem> modeloList;
	private List<SelectItem> representanteLegalList;
	private List<SelectItem> catalogoTipoContacto;
	private List<SelectItem> catalogoTipoDocumento;
	private List<SelectItem> catalogoTipoIndicador;
	
	@EJB
	private IndicadorService indicadorService;
	
	@EJB
	private AdministracionService administracionService;
	
	
	public SelectItemController()
	{
		
	}
	
	@PostConstruct
	private void init()
	{
		iesList=new ArrayList<SelectItem>();
		modeloList=new ArrayList<SelectItem>();
		representanteLegalList=new ArrayList<SelectItem>();
		catalogoTipoContacto=new ArrayList<SelectItem>();
		catalogoTipoDocumento=new ArrayList<SelectItem>();
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> getIesList() throws IndicadoresException {
		if(CollectionUtils.isEmpty(iesList))
		{
			iesList=(List<SelectItem>) CollectionUtils.collect(indicadorService.obtenerIes(),new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					IesDTO ies=(IesDTO) arg0;
					return new SelectItem(ies.getIesCodigo(), ies.getIesNombreCorto());
				}
			});
		}
		return iesList;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> getModeloList() throws IndicadoresException {
		if(CollectionUtils.isEmpty(modeloList))
		{
			modeloList=(List<SelectItem>) CollectionUtils.collect(indicadorService.obtenerModelo(),new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					ModeloDTO modelo=(ModeloDTO) arg0;
					return new SelectItem(modelo.getModCodigo(), modelo.getModDescripcion()+" - "+modelo.getModVersion());
				}
			});
		}
		return modeloList;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getRepresentanteLegalList() throws IndicadoresException {
		if(CollectionUtils.isEmpty(representanteLegalList))
		{
			representanteLegalList=(List<SelectItem>) CollectionUtils.collect(indicadorService.obtenerRepresentantes(),new Transformer() {
				
				@Override
				public Object transform(Object arg0) {
					RepresentanteLegalListDTO rep=(RepresentanteLegalListDTO) arg0;
					return new SelectItem(rep.getRleCodigo(), rep.getRleNombres()+" "+rep.getRleApellidos());
				}
			});
		}
		return representanteLegalList;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> getCatalogoTipoContacto() throws IndicadoresException {
		if(CollectionUtils.isEmpty(catalogoTipoContacto))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(1);
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
	public List<SelectItem> getCatalogoTipoDocumento() throws IndicadoresException {
		if(CollectionUtils.isEmpty(catalogoTipoDocumento))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(5);
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
	public List<SelectItem> getCatalogoTipoIndicador() throws IndicadoresException {
		if(CollectionUtils.isEmpty(catalogoTipoIndicador))
		{
			CatalogoDTO catalogo=new CatalogoDTO();
			catalogo.setCatCodigo(8);
			catalogoTipoIndicador=(List<SelectItem>)CollectionUtils.collect(administracionService.getCatalogo(catalogo), new Transformer() {
				
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
