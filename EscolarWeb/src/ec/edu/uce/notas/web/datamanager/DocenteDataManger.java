package ec.edu.uce.notas.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.DocenteViewDTO;

@ViewScoped
@ManagedBean(name = "docenteDataManger")
public class DocenteDataManger implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UsuarioDTO usuarioDTO;
	
	private List<DocenteViewDTO> docenteViewList;
	
	public DocenteDataManger() {
		usuarioDTO=new UsuarioDTO();
		docenteViewList=new ArrayList<DocenteViewDTO>();
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public List<DocenteViewDTO> getDocenteViewList() {
		return docenteViewList;
	}

	public void setDocenteViewList(List<DocenteViewDTO> docenteViewList) {
		this.docenteViewList = docenteViewList;
	}
	
}
