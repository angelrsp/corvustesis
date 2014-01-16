package ec.edu.uce.silsag.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.negocio.EmpresaService;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;
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
	
//	private PostulacionListDTO postulacion;
//	private List<PostulacionListDTO> postulacionList;	
	
	private CandidatoDTO candidato;
	
//	private List<EstudioListDTO> estudioList;
//	private List<ExperienciaListDTO> experienciaList;
	private List<ReferenciaDTO> referenciaList;
	
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
//		postulacionList= new ArrayList<PostulacionListDTO>();
//		postulacion=new PostulacionListDTO();
		candidato=new CandidatoDTO();
//		estudioList=new ArrayList<EstudioListDTO>();
//		experienciaList=new ArrayList<ExperienciaListDTO>();
		referenciaList=new ArrayList<ReferenciaDTO>();
	}

//	public List<PostulacionListDTO> getPostulacionList() throws SilsagException {
//		this.postulacionList=empresaService.obtenerPostulacion(empresa);
//		return postulacionList;
//	}

	public Object getTipoDocumento() {
		return tipoDocumento;
	}
	
	public Object getEstadoCivil() {
		return estadoCivil;
	}
	
//	public PostulacionListDTO getPostulacion() {
//		return postulacion;
//	}

	public CandidatoDTO getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoDTO candidato) {
		this.candidato = candidato;
	}


//	public List<EstudioListDTO> getEstudioList() {
//		return estudioList;
//	}
//
//	public List<ExperienciaListDTO> getExperienciaList() {
//		return experienciaList;
//	}

	public List<ReferenciaDTO> getReferenciaList() {
		return referenciaList;
	}
	
	public UsuarioDTO getUser() {
		return user;
	}

//	public void buscarCandidato(PostulacionListDTO pos)
//	{
//		try {
//			setCandidato(candidatosService.obtenerCandidato(pos.getCanCodigo()));
//			this.estadoCivil=getCandidato().getCanEstadoCivil();
//			this.tipoDocumento=getCandidato().getCanTipoIdentificacion();
////			this.estudioList=candidatosService.obtenerEstudio(getCandidato());
////			this.experienciaList=candidatosService.obtenerExperiencia(getCandidato());
//			this.referenciaList=candidatosService.obtenerReferencia(getCandidato());
//			user=getCandidato().getBemUsuario();
//		} catch (Exception e) {
//			JsfUtil.addErrorMessage(e.getMessage());
//		}
//	}
	
}
