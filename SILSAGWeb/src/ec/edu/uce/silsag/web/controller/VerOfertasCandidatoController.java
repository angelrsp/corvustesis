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

//	private List<AvisoListDTO> ofertasList;
	
	@EJB
	private CandidatosService candidatosService;

	private PostulacionDTO postulacion;
	private UsuarioDTO user;
	private CandidatoDTO candidato;
	
	@PostConstruct
	private void init() {
//		ofertasList=new ArrayList<AvisoListDTO>();
		user=(UsuarioDTO)JsfUtil.getObject("UsuarioDTO");
		candidato=user.getBemCandidatos().get(0);
		postulacion=new PostulacionDTO();
	}

//	public List<AvisoListDTO> getOfertasList() {
//		try {
//			this.ofertasList=candidatosService.verOfertas();
//		} catch (SilsagException e) {
//			// TODO Auto-generated catch block
//			JsfUtil.addErrorMessage(e.toString());;
//		}
//		return ofertasList;
//	}

//	public void setOfertasList(List<AvisoListDTO> ofertasList) {
//		this.ofertasList = ofertasList;
//	}
//	
	
//	public void postularse(AvisoListDTO aviso)
//	{
//		try {
//			postulacion=new PostulacionDTO();
//			postulacion.setBemAviso(new AvisoDTO(aviso.getAviNombre()));
//			postulacion.setBemCandidato(candidato);
//			candidatosService.postular(postulacion);
//			JsfUtil.addInfoMessage("Su hoja de vida fue enviada Exitosamente");
//		} catch (SilsagException e) {
//			// TODO Auto-generated catch block
//			JsfUtil.addErrorMessage(e.toString());
//		}
//	}
	
}
