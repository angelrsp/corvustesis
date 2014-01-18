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
import ec.edu.uce.silsag.ejb.persistence.entities.AvisoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PostulacionDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "verOfertasCandidatoController")
public class VerOfertasCandidatoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CandidatosService candidatosService;

	private PostulacionDTO postulacion;
	private UsuarioDTO user;
	private CandidatoDTO candidato;
	private List<AvisoDTO> ofertasList;
	
	@PostConstruct
	private void init() {
		ofertasList=new ArrayList<AvisoDTO>();
		user=(UsuarioDTO)JsfUtil.getObject("UsuarioDTO");
		candidato=user.getBemCandidatos().get(0);
		postulacion=new PostulacionDTO();
	}

	public List<AvisoDTO> getOfertasList() {
		try {
			this.ofertasList=candidatosService.verOfertas(candidato);
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.toString());;
		}
		return ofertasList;
	}
	
	public PostulacionDTO getPostulacion() {
		return postulacion;
	}

	public void setPostulacion(PostulacionDTO postulacion) {
		this.postulacion = postulacion;
	}

	public void postularse(AvisoDTO aviso)
	{
		try {
			setPostulacion(new PostulacionDTO());
			getPostulacion().setBemAviso(aviso);
			getPostulacion().setBemCandidato(candidato);
			candidatosService.postular(postulacion);
			JsfUtil.addInfoMessage("Su hoja de vida fue enviada Exitosamente");
			getOfertasList();
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
