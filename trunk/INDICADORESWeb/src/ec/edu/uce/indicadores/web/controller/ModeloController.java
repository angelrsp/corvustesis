package ec.edu.uce.indicadores.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.IndicadorService;
import ec.edu.uce.indicadores.ejb.persistence.entities.ModeloDTO;
import ec.edu.uce.indicadores.web.util.JsfUtil;

@SessionScoped
@ManagedBean(name = "modeloController")
public class ModeloController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IndicadorService indicadorService;
	
	private ModeloDTO modeloDTO;
	
	private List<ModeloDTO> modeloList;
	
	public ModeloController() {
		
	}
	
	@PostConstruct
	private void init()
	{
		modeloDTO=new ModeloDTO();
		modeloList=new ArrayList<ModeloDTO>();
	}
	
	public ModeloDTO getModeloDTO() {
		return modeloDTO;
	}

	public void setModeloDTO(ModeloDTO modeloDTO) {
		this.modeloDTO = modeloDTO;
	}

	public List<ModeloDTO> getModeloList() {
		try {
			this.modeloList=indicadorService.obtenerModelo();
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());		}
		return modeloList;
	}

	public void setModeloList(List<ModeloDTO> modeloList) {
		this.modeloList = modeloList;
	}

	public void agregarModelo()
	{
		try {
			indicadorService.createOrUpdateModelo(getModeloDTO());
			getModeloList();
			setModeloDTO(new ModeloDTO());
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void edit(ModeloDTO mode) 
	{
		setModeloDTO(mode);
	}
	
	public void delete(ModeloDTO mode) 
	{
		try {
			indicadorService.deleteModelo(mode);
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void cancel()
	{
		setModeloDTO(new ModeloDTO());
	}

}
