package ec.edu.uce.silsag.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import ec.edu.uce.silsag.commons.dto.util.ResultadoReportDTO;
import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.AdministracionService;
import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.persistence.entities.PreguntaDTO;

@ViewScoped
@ManagedBean(name = "reporteRespuestaController")
public class ReporteRespuestaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CandidatosService candidatosService;

	@EJB
	private AdministracionService administracionService;

	private int preguntaCode;
	private List<PreguntaDTO> preguntaList;

	
	private PieChartModel pieModel;  
	
	private List<ResultadoReportDTO> resultadoList;
  	
	@PostConstruct
	private void init()
	{
		preguntaList=new ArrayList<PreguntaDTO>();
		resultadoList=new ArrayList<ResultadoReportDTO>();
		try {
			this.preguntaList=candidatosService.obtenerPregunta();
			createPieModel();
		} catch (SilsagException e) {
			e.printStackTrace();
		}		
	}

	public List<PreguntaDTO> getPreguntaList() {
		return preguntaList;
	}

	public void setPreguntaList(List<PreguntaDTO> preguntaList) {
		this.preguntaList = preguntaList;
	}

	public int getPreguntaCode() {
		return preguntaCode;
	}

	public void setPreguntaCode(int preguntaCode) {
		this.preguntaCode = preguntaCode;
	}

    public PieChartModel getPieModel() {  
        return pieModel;  
    }  

	
	public void buscar()
	{
		PreguntaDTO pregunta; 
		try {
			pregunta=new PreguntaDTO();
			pregunta.setPreCodigo(getPreguntaCode());
			resultadoList=administracionService.obtenerResultadoPorPregunta(pregunta);
			createPieModel(resultadoList);
		} catch (SilsagException e) {
			e.printStackTrace();
		}
	}
	
    private void createPieModel() {  
        pieModel = new PieChartModel();  
        pieModel.set("Sin Dato", 0);  
    }  

    private void createPieModel(List<ResultadoReportDTO> list)
    {
        pieModel = new PieChartModel();
        if(list!=null)
        {
	        for(ResultadoReportDTO rep:list)
	        {
	        	pieModel.set(rep.getResDescripcion(), rep.getCantidad());	
	        }
        }else{
        	pieModel.set("Sin Dato", 0);
        }     	
    }
}
