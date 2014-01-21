package ec.edu.uce.silsag.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.AdministracionService;
import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.persistence.entities.AdicionalDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoEstudioDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CursoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EstudioListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ExperienciaListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ReferenciaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "verHojasDeVidaController")
public class VerHojasDeVidaController extends SelectItemController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private AdministracionService administracionService;
	@EJB
	private CandidatosService candidatosService;
	

	public List<CandidatoEstudioDTO> candidatoList;
	
	private List<EstudioListDTO> estudioList;
	private List<ExperienciaListDTO> experienciaList;
	private List<ReferenciaDTO> referenciaList;
	private List<CursoDTO> cursoList;
	private List<AdicionalDTO> adicionalList;

	
	public CandidatoDTO candidato;
	public UsuarioDTO user;
	
	private Object estadoCivil;
	private Object tipoDocumento;
	private Object genero;
	
	public VerHojasDeVidaController()
	{
		
	}
	
	@PostConstruct
	private void init()
	{
		candidato=new CandidatoDTO();
		candidatoList=new ArrayList<CandidatoEstudioDTO>();
		estudioList=new ArrayList<EstudioListDTO>();
		experienciaList=new ArrayList<ExperienciaListDTO>();
		referenciaList=new ArrayList<ReferenciaDTO>();
		cursoList=new ArrayList<CursoDTO>();
		adicionalList=new ArrayList<AdicionalDTO>();
	}

	public List<CandidatoEstudioDTO> getCandidatoList() throws SilsagException {
		this.candidatoList=administracionService.obtenerCandidatos();
		return candidatoList;
	}
	
	public CandidatoDTO getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoDTO candidato) {
		this.candidato = candidato;
	}

	public UsuarioDTO getUser() {
		return user;
	}

	public void setUser(UsuarioDTO user) {
		this.user = user;
	}

	public Object getTipoDocumento() {
		return tipoDocumento;
	}

	public Object getEstadoCivil() {
		return estadoCivil;
	}

	public Object getGenero() {
		return genero;
	}

	public List<EstudioListDTO> getEstudioList() {
		return estudioList;
	}

	public List<ExperienciaListDTO> getExperienciaList() {
		return experienciaList;
	}

	public List<ReferenciaDTO> getReferenciaList() {
		return referenciaList;
	}

	public List<CursoDTO> getCursoList() {
		return cursoList;
	}

	public List<AdicionalDTO> getAdicionalList() {
		return adicionalList;
	}

	
	public void buscarCandidato(CandidatoEstudioDTO can) {
		try {
			setCandidato(candidatosService.obtenerCandidato(can.getCanCodigo()));
			this.estadoCivil=can.getCanEstadoCivil();
			this.tipoDocumento=can.getCanTipoIdentificacion();
			this.genero=getCandidato().getCanSexo();
			setUser(getCandidato().getBemUsuario());
			this.estudioList=candidatosService.obtenerEstudio(getCandidato());
			this.experienciaList=candidatosService.obtenerExperiencia(getCandidato());
			this.referenciaList=candidatosService.obtenerReferencia(getCandidato());
			this.cursoList=candidatosService.obtenerCurso(getCandidato());
			this.adicionalList=candidatosService.obtenerAdicional(getCandidato());
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}

	}

}
