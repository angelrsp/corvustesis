package ec.edu.uce.indicadores.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.IndicadorService;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ModeloDTO;

public abstract class SelectItemController {

	private List<SelectItem> iesList;
	private List<SelectItem> modeloList;
	
	@EJB
	private IndicadorService indicadorService;
	
	public SelectItemController()
	{
		
	}
	
	@PostConstruct
	private void init()
	{
		iesList=new ArrayList<SelectItem>();
		modeloList=new ArrayList<SelectItem>();
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
					return new SelectItem(modelo.getModCodigo(), modelo.getModDescripcion());
				}
			});
		}
		return modeloList;
	}
	
}
