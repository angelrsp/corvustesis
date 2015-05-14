package ec.edu.uce.besg.web.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.EncuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.ResultadoViewDTO;
import ec.edu.uce.besg.ejb.service.CuestionarioService;
import ec.edu.uce.besg.web.datamanager.ReporteRespuestaDataManager;
import ec.edu.uce.besg.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "reporteRespuestaController")
public class ReporteRespuestaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CuestionarioService cuestionarioService;
	
	@ManagedProperty(value="#{reporteRespuestaDataManager}")
	private ReporteRespuestaDataManager reporteRespuestaDataManager;
	
	public ReporteRespuestaController() {
		readEncuesta();	
	}	
	
	public ReporteRespuestaDataManager getReporteRespuestaDataManager() {
		return reporteRespuestaDataManager;
	}
	public void setReporteRespuestaDataManager(
			ReporteRespuestaDataManager reporteRespuestaDataManager) {
		this.reporteRespuestaDataManager = reporteRespuestaDataManager;
	}


	private void readEncuesta()
	{
		try {
			reporteRespuestaDataManager.setEncuestaList(cuestionarioService.readEncuesta(new EncuestaDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	

	public void readResultado()
	{
		ResultadoViewDTO resultadoViewDTO;
		try {
			resultadoViewDTO=new ResultadoViewDTO();
			resultadoViewDTO.setCatEncuesta(reporteRespuestaDataManager.getEncuestaCode());
			reporteRespuestaDataManager.setResultadoViewList(cuestionarioService.readResultadoView(resultadoViewDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	
}
