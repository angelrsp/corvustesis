package ec.edu.uce.silsae.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.AdministracionService;
import ec.edu.uce.silsae.ejb.negocio.CandidatosService;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoEstudioDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EstudioListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ExperienciaListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.IdiomaListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ReferenciaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.SoftwareListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsae.web.util.JsfUtil;

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
	private List<SoftwareListDTO> herramientasList;
	private List<IdiomaListDTO> idiomaList;
	private List<ReferenciaDTO> referenciaList;

	
	public CandidatoDTO candidato;
	public UsuarioDTO user;
	
	private Object estadoCivil;
	private Object tipoDocumento; 
	
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
		herramientasList=new ArrayList<SoftwareListDTO>();
		idiomaList=new ArrayList<IdiomaListDTO>();
		referenciaList=new ArrayList<ReferenciaDTO>();
	}

	public List<CandidatoEstudioDTO> getCandidatoList() throws SilsaeException {
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

	public List<EstudioListDTO> getEstudioList() {
		return estudioList;
	}

	public List<ExperienciaListDTO> getExperienciaList() {
		return experienciaList;
	}

	public List<SoftwareListDTO> getHerramientasList() {
		return herramientasList;
	}

	public List<IdiomaListDTO> getIdiomaList() {
		return idiomaList;
	}

	public List<ReferenciaDTO> getReferenciaList() {
		return referenciaList;
	}

	public void buscarCandidato(CandidatoEstudioDTO can) {
		try {
			setCandidato(candidatosService.obtenerCandidato(can.getCanCodigo()));
			this.estadoCivil=can.getCanEstadoCivil();
			this.tipoDocumento=can.getCanTipoIdentificacion();
			setUser(getCandidato().getBemUsuario());
			this.estudioList=candidatosService.obtenerEstudio(getCandidato());
			this.experienciaList=candidatosService.obtenerExperiencia(getCandidato());
			this.herramientasList=candidatosService.obtenerHerramientas(getCandidato());
			this.idiomaList=candidatosService.obtenerIdioma(getCandidato());
			this.referenciaList=candidatosService.obtenerReferencia(getCandidato());
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}

	}

}
