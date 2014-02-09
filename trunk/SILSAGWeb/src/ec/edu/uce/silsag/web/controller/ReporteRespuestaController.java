package ec.edu.uce.silsag.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.silsag.commons.util.SilsagException;
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
	
	private List<PreguntaDTO> preguntaList;

	@PostConstruct
	private void init()
	{
		preguntaList=new ArrayList<PreguntaDTO>();		
		try {
			this.preguntaList=candidatosService.obtenerPregunta();
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

}
