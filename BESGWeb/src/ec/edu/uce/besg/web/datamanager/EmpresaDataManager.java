package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;

@ViewScoped
@ManagedBean(name = "empresaDataManager")
public class EmpresaDataManager implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EmpresaDTO empresaInsertar;
	private EmpresaDTO empresaBuscar;
	private List<EmpresaDTO> empresaDTOs;
	private UsuarioDTO usuarioDTO;
	private int codigoSector;
	private int codigoPais;
	private int codigoProvincia;
	private int codigoCiudad;
	private List<CatalogoDTO> secCatalogoDTOs;
	private List<CatalogoDTO> proCatalogoDTOs;
	private List<CatalogoDTO> ciuCatalogoDTOs;
	private List<CatalogoDTO> paiCatalogoDTOs;

	public EmpresaDataManager() {
		empresaInsertar=new EmpresaDTO();
		empresaBuscar=new EmpresaDTO();
		empresaDTOs=new ArrayList<EmpresaDTO>();
		usuarioDTO=new UsuarioDTO();
		secCatalogoDTOs=new ArrayList<CatalogoDTO>();
		proCatalogoDTOs=new ArrayList<CatalogoDTO>();
		ciuCatalogoDTOs=new ArrayList<CatalogoDTO>();
		paiCatalogoDTOs=new ArrayList<CatalogoDTO>();
	}

	public EmpresaDTO getEmpresaInsertar() {
		return empresaInsertar;
	}

	public void setEmpresaInsertar(EmpresaDTO empresaInsertar) {
		this.empresaInsertar = empresaInsertar;
	}

	public EmpresaDTO getEmpresaBuscar() {
		return empresaBuscar;
	}

	public void setEmpresaBuscar(EmpresaDTO empresaBuscar) {
		this.empresaBuscar = empresaBuscar;
	}

	public List<EmpresaDTO> getEmpresaDTOs() {
		return empresaDTOs;
	}

	public void setEmpresaDTOs(List<EmpresaDTO> empresaDTOs) {
		this.empresaDTOs = empresaDTOs;
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

	public List<CatalogoDTO> getSecCatalogoDTOs() {
		return secCatalogoDTOs;
	}

	public void setSecCatalogoDTOs(List<CatalogoDTO> secCatalogoDTOs) {
		this.secCatalogoDTOs = secCatalogoDTOs;
	}

	public List<CatalogoDTO> getProCatalogoDTOs() {
		return proCatalogoDTOs;
	}

	public void setProCatalogoDTOs(List<CatalogoDTO> proCatalogoDTOs) {
		this.proCatalogoDTOs = proCatalogoDTOs;
	}

	public List<CatalogoDTO> getCiuCatalogoDTOs() {
		return ciuCatalogoDTOs;
	}

	public void setCiuCatalogoDTOs(List<CatalogoDTO> ciuCatalogoDTOs) {
		this.ciuCatalogoDTOs = ciuCatalogoDTOs;
	}

	public List<CatalogoDTO> getPaiCatalogoDTOs() {
		return paiCatalogoDTOs;
	}

	public void setPaiCatalogoDTOs(List<CatalogoDTO> paiCatalogoDTOs) {
		this.paiCatalogoDTOs = paiCatalogoDTOs;
	}

	
}
