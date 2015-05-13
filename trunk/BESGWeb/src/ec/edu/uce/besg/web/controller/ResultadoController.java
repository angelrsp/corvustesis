package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.EncuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.ResultadoViewDTO;
import ec.edu.uce.besg.ejb.service.CuestionarioService;
import ec.edu.uce.besg.web.datamanager.ResultadoDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "resultadoController")
public class ResultadoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CuestionarioService cuestionarioService;
	
	@ManagedProperty(value="#{resultadoDataManager}")
	private ResultadoDataManager resultadoDataManager;

	public ResultadoController() {
	
	}
	
	public ResultadoDataManager getResultadoDataManager() {
		return resultadoDataManager;
	}

	public void setResultadoDataManager(ResultadoDataManager resultadoDataManager) {
		this.resultadoDataManager = resultadoDataManager;
	}

	
	@PostConstruct
	private void init()
	{
		readEncuesta();
	}
	
	private void readEncuesta()
	{
		try {
			resultadoDataManager.setEncuestaList(cuestionarioService.readEncuesta(new EncuestaDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	

	public void readResultado()
	{
		ResultadoViewDTO resultadoViewDTO;
		try {
			resultadoViewDTO=new ResultadoViewDTO();
			resultadoViewDTO.setCatEncuesta(resultadoDataManager.getEncuestaCode());
			resultadoDataManager.setResultadoViewList(cuestionarioService.readResultadoView(resultadoViewDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

}
