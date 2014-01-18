package ec.edu.uce.silsag.web.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PreguntaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.RespuestaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

@ViewScoped
@ManagedBean (name = "encuestaController")
public class EncuestaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@EJB
	private CandidatosService candidatosService;
	
	private List<PreguntaDTO> preguntaList;
	private List<RespuestaDTO> respuestaList;
	
	private UsuarioDTO user;
	private CandidatoDTO candidato;

	
	
	private Object[] respuesta;
	private Object[] respuestaTexto;
	
	public EncuestaController() {
	}
	
	@PostConstruct
	private void init()
	{
		user=new UsuarioDTO();
		candidato=new CandidatoDTO();
		user=(UsuarioDTO)JsfUtil.getObject("UsuarioDTO");
		candidato=user.getBemCandidatos().get(0);
		respuesta=new Object[29];
		respuestaTexto=new Object[16];
		preguntaList=new ArrayList<PreguntaDTO>();
		respuestaList=new ArrayList<RespuestaDTO>();
		
		try {
			this.preguntaList=candidatosService.obtenerPregunta();
			this.respuestaList=candidatosService.obtenerRespuesta();
		} catch (SilsagException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<PreguntaDTO> getPreguntaList() {
		return preguntaList;
	}

	public void setPreguntaList(List<PreguntaDTO> preguntaList) {
		this.preguntaList = preguntaList;
	}

	public Object[] getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Object[] respuesta) {
		this.respuesta = respuesta;
	}

	public Object[] getRespuestaTexto() {
		return respuestaTexto;
	}

	public void setRespuestatexto(Object[] respuestaTexto) {
		this.respuestaTexto = respuestaTexto;
	}

	public List<RespuestaDTO> getRespuestaList() {
		return respuestaList;
	}

	public void setRespuestaList(List<RespuestaDTO> respuestaList) {
		this.respuestaList = respuestaList;
	}

	public void guardar()
	{
		try {
			List<RespuestaDTO> resList= candidatosService.obtenerRespuestaPorTipo(2);
			Map<Integer, String> respuestaText=new HashMap<Integer, String>();
			for(int i=0;i<resList.size();i++)
				respuestaText.put(resList.get(i).getResCodigo(), respuestaTexto[i]!=null?respuestaTexto[i].toString():null);
			candidatosService.guardarResultados(respuesta, respuestaText, candidato);
			JsfUtil.redirect("/SILSAGWeb/pages/candidato/dato.jsf");
		} catch (SilsagException e) {
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
