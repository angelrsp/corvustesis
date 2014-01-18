package ec.edu.uce.silsag.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PostulacionDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "misPostulacionesController")
public class MisPostulacionesController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CandidatosService candidatosService;

	private UsuarioDTO user;
	private CandidatoDTO candidato;
	
	private List<PostulacionDTO> postulacionList;
	
	public MisPostulacionesController() {
	}
	
	@PostConstruct
	private void init()
	{
		user=(UsuarioDTO)JsfUtil.getObject("UsuarioDTO");
		candidato=user.getBemCandidatos().get(0);
		
	}

	public List<PostulacionDTO> getPostulacionList() {
		try {
			postulacionList=candidatosService.obtenerPostulacion(candidato);
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		return postulacionList;
	}
	
	
	
	
}
