package ec.edu.uce.besg.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LegendPlacement;
import org.primefaces.model.chart.PieChartModel;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.persistence.entity.CategoriaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.EncuestaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.PreguntaDTO;
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
	
	private BarChartModel barChartModel;
	private PieChartModel pieChartModel;
	
	
	public ReporteRespuestaController() {
		
	}	
	
	public ReporteRespuestaDataManager getReporteRespuestaDataManager() {
		return reporteRespuestaDataManager;
	}
	public void setReporteRespuestaDataManager(
			ReporteRespuestaDataManager reporteRespuestaDataManager) {
		this.reporteRespuestaDataManager = reporteRespuestaDataManager;
	}
	
	public BarChartModel getBarChartModel() {
		return barChartModel;
	}

	public void setBarChartModel(BarChartModel barChartModel) {
		this.barChartModel = barChartModel;
	}
	
	public PieChartModel getPieChartModel() {
		return pieChartModel;
	}

	public void setPieChartModel(PieChartModel pieChartModel) {
		this.pieChartModel = pieChartModel;
	}

	@PostConstruct
	private void init()
	{
		readEncuesta();
		createBarChartModel();
		createPieChartModel();
		reporteRespuestaDataManager.setVisibleCharts(false);
		reporteRespuestaDataManager.setVisibleDataTable(false);
	}

	private void createBarChartModel()
	{
		barChartModel=new BarChartModel();
		ChartSeries chartSeries=new ChartSeries();
		chartSeries.set("0", 0);
		barChartModel.addSeries(chartSeries);
	}

	private void createPieChartModel()
	{
		pieChartModel=new PieChartModel();
		pieChartModel.set("0", 0);
	}

	
	private void readEncuesta()
	{
		try {
			reporteRespuestaDataManager.setEncuestaList(cuestionarioService.readEncuesta(new EncuestaDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void readCategoria()
	{
		CategoriaDTO categoriaDTO;
		try {
			categoriaDTO=new CategoriaDTO();
			categoriaDTO.setCueEncuesta(reporteRespuestaDataManager.getEncuestaDTO());
			reporteRespuestaDataManager.setCategoriaList(cuestionarioService.readCategoria(categoriaDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void readPregunta()
	{
		PreguntaDTO preguntaDTO;
		try {
			preguntaDTO=new PreguntaDTO();
			preguntaDTO.setCueCategoria(reporteRespuestaDataManager.getCategoriaDTO());
			reporteRespuestaDataManager.setPreguntaList(cuestionarioService.readPregunta(preguntaDTO));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	
	public void readResultado()
	{
		ResultadoViewDTO resultadoViewDTO;
		try {
			resultadoViewDTO=new ResultadoViewDTO();
			resultadoViewDTO.setCatEncuesta(reporteRespuestaDataManager.getEncuestaDTO().getEncCodigo());
			resultadoViewDTO.setPreCodigo(reporteRespuestaDataManager.getPreguntaDTO().getPreCodigo());
			
			reporteRespuestaDataManager.setPreguntaDTO(cuestionarioService.readPregunta(reporteRespuestaDataManager.getPreguntaDTO().getPreCodigo()));
			
			reporteRespuestaDataManager.setResultadoViewList(cuestionarioService.readResultadoView(resultadoViewDTO));
			
			if(reporteRespuestaDataManager.getPreguntaDTO().getCueControl().getConCodigo().equals(4)||reporteRespuestaDataManager.getPreguntaDTO().getCueControl().getConCodigo().equals(7))
			{
				createBarChartModel(cuestionarioService.readResultadoCountView(resultadoViewDTO));
				createPieChartModel(cuestionarioService.readResultadoCountView(resultadoViewDTO));
				reporteRespuestaDataManager.setVisibleCharts(true);
				reporteRespuestaDataManager.setVisibleDataTable(false);
			}
			else
			{
				reporteRespuestaDataManager.setVisibleCharts(false);
				reporteRespuestaDataManager.setVisibleDataTable(true);				
			}
				
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}		
	}
	
	private void createBarChartModel(List<ResultadoViewDTO> resultadoList) {  
		
		if(!resultadoList.isEmpty())
		{
			barChartModel = new BarChartModel();  
			
			ChartSeries chartSeries;
				
			for(ResultadoViewDTO resultadoViewDTO:resultadoList)
			{
				chartSeries = new ChartSeries();
				
				chartSeries.setLabel(resultadoViewDTO.getResDescripcion());
				chartSeries.set("", resultadoViewDTO.getCount());
				barChartModel.addSeries(chartSeries);
			}
			
			barChartModel.setLegendPosition("ne");
			barChartModel.setShowPointLabels(true);
			barChartModel.setAnimate(true);
			barChartModel.setLegendPlacement(LegendPlacement.OUTSIDEGRID);			
		}
		else
			createBarChartModel();
	}

	private void createPieChartModel(List<ResultadoViewDTO> resultadoList) {  
		
		if(!resultadoList.isEmpty())
		{
			pieChartModel=new PieChartModel();
			
			for(ResultadoViewDTO resultadoViewDTO:resultadoList)
				pieChartModel.set(resultadoViewDTO.getResDescripcion(), resultadoViewDTO.getCount());
			
			pieChartModel.setLegendPosition("w");
			pieChartModel.setShowDataLabels(true);
			
		}
		else
			createPieChartModel();
	}

	
	
}
