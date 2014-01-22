package ec.edu.uce.silsag.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import ec.edu.uce.silsag.commons.dto.util.EstudioReportDTO;
import ec.edu.uce.silsag.commons.util.CalendarUtil;
import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.persistence.entities.AnioEstudioDTO;

@ViewScoped
@ManagedBean (name = "reporteCandidatoEstudioController")
public class ReporteCandidatoEstudioController extends SelectItemController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CandidatosService candidatosService;
	
	private List<AnioEstudioDTO> listAnio;
	
	private String anio;
	
	private CartesianChartModel categoryModel;  
	
	public ReporteCandidatoEstudioController() {
          
		createCategoryModel();


	}
	
	@PostConstruct
	private void init()
	{
		listAnio=new ArrayList<AnioEstudioDTO>();
	}

	
    public CartesianChartModel getCategoryModel() {  
        return categoryModel;  
    }  
	
	public List<AnioEstudioDTO> getListAnio() throws SilsagException {
		this.listAnio=candidatosService.obtenerAnios();
		return listAnio;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public void verReporte() throws NumberFormatException, SilsagException
	{
		List<EstudioReportDTO> list=new ArrayList<EstudioReportDTO>();
        categoryModel = new CartesianChartModel();  
  
        ChartSeries egresados = new ChartSeries();
        egresados.setLabel("Egresados");
        
        ChartSeries tercerNivel = new ChartSeries();  
        tercerNivel.setLabel("Tercer Nivel");

        ChartSeries cuartoNivel = new ChartSeries();  
        cuartoNivel.setLabel("Cuarto Nivel");

        if(Integer.valueOf(getAnio())>0)
        {
        	list=candidatosService.obtenerNivelReporte(Integer.valueOf(getAnio()));
        	for(EstudioReportDTO est:list)
        	{
        		//Egresado
        		if(Integer.valueOf(est.getEstCodigo())==5)
        		{
        			egresados.set(CalendarUtil.getMonthName(Integer.valueOf(est.getEstMes())), Integer.valueOf(est.getEstNumero()));
        		}
        		//Tercer nivel
        		if(Integer.valueOf(est.getEstCodigo())==6)
        		{
        			tercerNivel.set(CalendarUtil.getMonthName(Integer.valueOf(est.getEstMes())), Integer.valueOf(est.getEstNumero()));
        		}
        		//Cuarto nivel
        		if(Integer.valueOf(est.getEstCodigo())==7)
        		{
        			cuartoNivel.set(CalendarUtil.getMonthName(Integer.valueOf(est.getEstMes())), Integer.valueOf(est.getEstNumero()));
        		}
        	}
        }
        else
        {
        	list=candidatosService.obtenerNivelReporte();
        	for(EstudioReportDTO est:list)
        	{
        		//Egresado
        		if(Integer.valueOf(est.getEstCodigo())==5)
        		{
        			egresados.set(est.getEstMes(), Integer.valueOf(est.getEstNumero()));
        		}
        		//Tercer nivel
        		if(Integer.valueOf(est.getEstCodigo())==6)
        		{
        			tercerNivel.set(est.getEstMes(), Integer.valueOf(est.getEstNumero()));
        		}
        		//Cuarto nivel
        		if(Integer.valueOf(est.getEstCodigo())==7)
        		{
        			cuartoNivel.set(est.getEstMes(), Integer.valueOf(est.getEstNumero()));
        		}
        	}        	
        }
        if(!egresados.getData().isEmpty())
        	categoryModel.addSeries(egresados);
        if(!tercerNivel.getData().isEmpty())
        	categoryModel.addSeries(tercerNivel);
        if(!cuartoNivel.getData().isEmpty())
        	categoryModel.addSeries(cuartoNivel);
        
	}
	
	
	 private void createCategoryModel() {  
	        categoryModel = new CartesianChartModel();  
	  
	        ChartSeries egresados = new ChartSeries();  
	        egresados.setLabel("Egresados");  
	        egresados.set("0", 0);
	  
	        ChartSeries tercerNivel = new ChartSeries();  
	        tercerNivel.setLabel("Tercer Nivel");  
	        tercerNivel.set("0", 0);  
	
	        ChartSeries cuartoNivel = new ChartSeries();  
	        cuartoNivel.setLabel("Tercer Nivel");  
	        cuartoNivel.set("0", 0);  
	
	        categoryModel.addSeries(egresados);  
	        categoryModel.addSeries(tercerNivel); 
	        categoryModel.addSeries(cuartoNivel); 
	    }  
	
}
