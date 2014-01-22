package ec.edu.uce.silsag.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoEstudioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

@ViewScoped
@ManagedBean (name = "reporteCandidatoGeneroController")
public class ReporteCandidatoGeneroController extends SelectItemController implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PieChartModel pieModel; 

	@EJB
	private CandidatosService candidatosService;
	
	private Object nivelEstudio;
	
	public ReporteCandidatoGeneroController() {  
        createPieModel();  
    }  
  
    public Object getNivelEstudio() {
		return nivelEstudio;
	}

	public void setNivelEstudio(Object nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}

	public PieChartModel getPieModel() {  
        return pieModel;  
    }  
  
    private void createPieModel() {
        pieModel = new PieChartModel();
        pieModel.set("Femenino", 0);
        pieModel.set("Masculino", 0);
    }
    
    public void verReporte()
    {
    	List<CandidatoEstudioDTO> listCan=new ArrayList<CandidatoEstudioDTO>();
    	try {
			listCan= candidatosService.obtenerCandidatos(Integer.valueOf(nivelEstudio.toString()) ,33);
			if(listCan!=null)
				pieModel.set("Femenino", listCan.size());
			else
				pieModel.set("Femenino", 0);
	    	listCan= candidatosService.obtenerCandidatos(Integer.valueOf(nivelEstudio.toString()),34);
	    	if(listCan!=null)
	    		pieModel.set("Masculino", listCan.size());
	    	else
	    		pieModel.set("Masculino", 0);
		} catch (SilsagException e) {
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
		}
    }
}
