package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.persistence.entity.AvisoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.view.AvisoViewDTO;

@ViewScoped
@ManagedBean(name = "avisoDataManager")
public class AvisoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmpresaDTO empresaDTO; 
	
	private AvisoDTO avisoDTO;
	
	private List<CatalogoDTO> cargoList;
	
	private List<AvisoViewDTO> avisoViewList;
	
	public AvisoDataManager() {
		avisoDTO=new AvisoDTO();
		empresaDTO=new EmpresaDTO();
		cargoList=new ArrayList<CatalogoDTO>();
		avisoViewList=new ArrayList<AvisoViewDTO>();
	}

	public AvisoDTO getAvisoDTO() {
		return avisoDTO;
	}

	public void setAvisoDTO(AvisoDTO avisoDTO) {
		this.avisoDTO = avisoDTO;
	}

	public List<CatalogoDTO> getCargoList() {
		return cargoList;
	}

	public void setCargoList(List<CatalogoDTO> cargoList) {
		this.cargoList = cargoList;
	}

	public EmpresaDTO getEmpresaDTO() {
		return empresaDTO;
	}

	public void setEmpresaDTO(EmpresaDTO empresaDTO) {
		this.empresaDTO = empresaDTO;
	}

	public List<AvisoViewDTO> getAvisoViewList() {
		return avisoViewList;
	}

	public void setAvisoViewList(List<AvisoViewDTO> avisoViewList) {
		this.avisoViewList = avisoViewList;
	}
	
	
	
}
