package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.ejb.entity.EmpresaDTO;
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

	public EmpresaDataManager() {
		empresaInsertar=new EmpresaDTO();
		empresaBuscar=new EmpresaDTO();
		empresaDTOs=new ArrayList<EmpresaDTO>();
		usuarioDTO=new UsuarioDTO();
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

	
}
