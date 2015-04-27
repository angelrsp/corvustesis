package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.common.util.Const;
import ec.edu.uce.besg.ejb.persistence.entity.CandidatoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;


@ViewScoped
@ManagedBean(name = "registroCandidatoDataManager")
public class RegistroCandidatoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private UsuarioDTO usuarioDTO;
	private CandidatoDTO candidatoDTO;
	
	private Integer identificationTypeCode;
	private List<CatalogoDTO> identificationTypeList;
	
	private List<CatalogoDTO> facultadesList;
	private Integer facultadCode;

	
	public RegistroCandidatoDataManager() {
		usuarioDTO=new UsuarioDTO();
		candidatoDTO=new CandidatoDTO();
		identificationTypeList=new ArrayList<CatalogoDTO>();
		facultadesList=new ArrayList<CatalogoDTO>();
		
		facultadCode=Const.INGENIERIA;
	}
	
	@PostConstruct
	private void init()
	{
		identificationTypeCode=Const.CEDULA;
	}


	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public CandidatoDTO getCandidatoDTO() {
		return candidatoDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public void setCandidatoDTO(CandidatoDTO candidatoDTO) {
		this.candidatoDTO = candidatoDTO;
	}

	public List<CatalogoDTO> getIdentificationTypeList() {
		return identificationTypeList;
	}

	public void setIdentificationTypeList(List<CatalogoDTO> identificationTypeList) {
		this.identificationTypeList = identificationTypeList;
	}

	public Integer getIdentificationTypeCode() {
		return identificationTypeCode;
	}

	public void setIdentificationTypeCode(Integer identificationTypeCode) {
		this.identificationTypeCode = identificationTypeCode;
	}
	
	public List<CatalogoDTO> getFacultadesList() {
		return facultadesList;
	}

	public void setFacultadesList(List<CatalogoDTO> facultadesList) {
		this.facultadesList = facultadesList;
	}

	public Integer getFacultadCode() {
		return facultadCode;
	}

	public void setFacultadCode(Integer facultadCode) {
		this.facultadCode = facultadCode;
	}
	
}
