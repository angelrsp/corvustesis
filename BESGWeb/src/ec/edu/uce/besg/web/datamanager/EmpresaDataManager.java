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
	
	private int codigoSector;
	private int codigoPais;
	private int codigoProvincia;
	private int codigoCiudad;
	
	private List<CatalogoDTO> sectorCatalogoList;
	private List<CatalogoDTO> provinciaCatalogoList;
	private List<CatalogoDTO> ciudadCatalogoList;
	private List<CatalogoDTO> paisCatalogoList;

	public EmpresaDataManager() {
		empresaDTO=new EmpresaDTO();
		usuarioDTO=new UsuarioDTO();
		sectorCatalogoList=new ArrayList<CatalogoDTO>();
		provinciaCatalogoList=new ArrayList<CatalogoDTO>();
		ciudadCatalogoList=new ArrayList<CatalogoDTO>();
		paisCatalogoList=new ArrayList<CatalogoDTO>();
	}


	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public int getCodigoSector() {
		return codigoSector;
	}

	public void setCodigoSector(int codigoSector) {
		this.codigoSector = codigoSector;
	}

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}

	public int getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(int codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public int getCodigoCiudad() {
		return codigoCiudad;
	}

	public void setCodigoCiudad(int codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}

	public List<CatalogoDTO> getSectorCatalogoList() {
		return sectorCatalogoList;
	}

	public void setSectorCatalogoList(List<CatalogoDTO> sectorCatalogoList) {
		this.sectorCatalogoList = sectorCatalogoList;
	}

	public List<CatalogoDTO> getProvinciaCatalogoList() {
		return provinciaCatalogoList;
	}

	public void setProvinciaCatalogoList(List<CatalogoDTO> provinciaCatalogoList) {
		this.provinciaCatalogoList = provinciaCatalogoList;
	}

	public List<CatalogoDTO> getCiudadCatalogoList() {
		return ciudadCatalogoList;
	}

	public void setCiudadCatalogoList(List<CatalogoDTO> ciudadCatalogoList) {
		this.ciudadCatalogoList = ciudadCatalogoList;
	}

	public List<CatalogoDTO> getPaisCatalogoList() {
		return paisCatalogoList;
	}

	public void setPaisCatalogoList(List<CatalogoDTO> paisCatalogoList) {
		this.paisCatalogoList = paisCatalogoList;
	}


	public EmpresaDTO getEmpresaDTO() {
		return empresaDTO;
	}


	public void setEmpresaDTO(EmpresaDTO empresaDTO) {
		this.empresaDTO = empresaDTO;
	}


	
}
