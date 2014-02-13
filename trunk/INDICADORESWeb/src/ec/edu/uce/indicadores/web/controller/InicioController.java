package ec.edu.uce.indicadores.web.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.IndicadorService;
import ec.edu.uce.indicadores.web.datamanager.IndicadorDataManager;

@ViewScoped
@ManagedBean(name="inicioController")
public class InicioController extends SelectItemController {

	
	@ManagedProperty(value="#{indicadorDataManager}")
	private IndicadorDataManager indicadorDataManager;
	
	@EJB
	private IndicadorService indicadorService;
	
	public void aceptar()
	{
		try {
			indicadorDataManager.setIesDTO(indicadorService.obtenerIes(Integer.valueOf(indicadorDataManager.getIes().toString())));
			indicadorDataManager.setModeloDTO(indicadorService.obtenerModelo(Integer.valueOf(indicadorDataManager.getModelo().toString())));
		} catch (IndicadoresException e) {
			e.printStackTrace();
		}
	}

	public void setIndicadorDataManager(IndicadorDataManager indicadorDataManager) {
		this.indicadorDataManager = indicadorDataManager;
	}
}
