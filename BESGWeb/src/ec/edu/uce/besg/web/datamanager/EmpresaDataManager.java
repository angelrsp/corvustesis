package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;

@ViewScoped
@ManagedBean(name = "empresaDataManager")
public class EmpresaDataManager implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private EmpresaDTO empresaDTO;
	private UsuarioDTO usuarioDTO;
		
	private List<CatalogoDTO> sectorList;
	
	private List<CatalogoDTO> paisList;
	
	private List<CatalogoDTO> provinciaList;
	
	private List<CatalogoDTO> ciudadList;
	

	public EmpresaDataManager() {
		empresaDTO=new EmpresaDTO();
		usuarioDTO=new UsuarioDTO();
		
		sectorList=new ArrayList<CatalogoDTO>();
		paisList=new ArrayList<CatalogoDTO>();
		provinciaList=new ArrayList<CatalogoDTO>();
		ciudadList=new ArrayList<CatalogoDTO>();
	}


	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public EmpresaDTO getEmpresaDTO() {
		return empresaDTO;
	}

	public void setEmpresaDTO(EmpresaDTO empresaDTO) {
		this.empresaDTO = empresaDTO;
	}


	public List<CatalogoDTO> getSectorList() {
		return sectorList;
	}


	public void setSectorList(List<CatalogoDTO> sectorList) {
		this.sectorList = sectorList;
	}


	public List<CatalogoDTO> getPaisList() {
		return paisList;
	}


	public void setPaisList(List<CatalogoDTO> paisList) {
		this.paisList = paisList;
	}

	public List<CatalogoDTO> getProvinciaList() {
		return provinciaList;
	}


	public void setProvinciaList(List<CatalogoDTO> provinciaList) {
		this.provinciaList = provinciaList;
	}

	public List<CatalogoDTO> getCiudadList() {
		return ciudadList;
	}


	public void setCiudadList(List<CatalogoDTO> ciudadList) {
		this.ciudadList = ciudadList;
	}

}
