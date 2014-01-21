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
import ec.edu.uce.silsag.ejb.negocio.EmpresaService;
import ec.edu.uce.silsag.ejb.persistence.entities.AdicionalDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CursoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EstudioListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ExperienciaListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PostulacionDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ReferenciaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "verPostulacionController")
public class VerPostulacionController extends SelectItemController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private EmpresaService empresaService;
	@EJB
	private CandidatosService candidatosService;

	private EmpresaDTO empresa;
	private UsuarioDTO usuario;
	
	private UsuarioDTO user;
	
	private Object estadoCivil;
	private Object tipoDocumento; 
	private Object genero;
	
	private List<PostulacionDTO> postulacionList;	
	
	private CandidatoDTO candidato;
	
	private List<EstudioListDTO> estudioList;
	private List<ExperienciaListDTO> experienciaList;
	private List<ReferenciaDTO> referenciaList;
	private List<CursoDTO> cursoList;
	private List<AdicionalDTO> adicionalList;
	
	public VerPostulacionController() {
		
	}
	
	@PostConstruct
	private void init()
	{
		user=new UsuarioDTO();
		usuario=new UsuarioDTO();
		empresa=new EmpresaDTO();
		usuario=(UsuarioDTO)JsfUtil.getObject("UsuarioDTO");
		empresa=usuario.getBemEmpresas().get(0);
		postulacionList= new ArrayList<PostulacionDTO>();
		candidato=new CandidatoDTO();
		estudioList=new ArrayList<EstudioListDTO>();
		experienciaList=new ArrayList<ExperienciaListDTO>();
		referenciaList=new ArrayList<ReferenciaDTO>();
		cursoList=new ArrayList<CursoDTO>();
		adicionalList=new ArrayList<AdicionalDTO>();
	}

	public List<PostulacionDTO> getPostulacionList() throws SilsagException {
		this.postulacionList=empresaService.obtenerPostulacion(empresa);
		return postulacionList;
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
	
	public CandidatoDTO getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoDTO candidato) {
		this.candidato = candidato;
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

	
	public UsuarioDTO getUser() {
		return user;
	}

	public void buscarCandidato(PostulacionDTO pos)
	{
		try {
			setCandidato(pos.getBemCandidato());
			this.estadoCivil=getCandidato().getCanEstadoCivil();
			this.tipoDocumento=getCandidato().getCanTipoIdentificacion();
			this.genero=getCandidato().getCanSexo();
			this.estudioList=candidatosService.obtenerEstudio(getCandidato());
			this.experienciaList=candidatosService.obtenerExperiencia(getCandidato());
			this.referenciaList=candidatosService.obtenerReferencia(getCandidato());
			this.cursoList=candidatosService.obtenerCurso(getCandidato());
			this.adicionalList=candidatosService.obtenerAdicional(getCandidato());
			user=getCandidato().getBemUsuario();
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void aceptarCandidato(PostulacionDTO pos)
	{
		try {
			empresaService.aceptarPostulacion(pos);
			JsfUtil.addInfoMessage("Las postulacion ha sido aceptada.");
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
}
