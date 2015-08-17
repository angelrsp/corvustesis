package ec.edu.uce.notas.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.notas.ejb.persistence.entity.ComponenteDTO;

@ViewScoped
@ManagedBean(name = "componenteDataManager")
public class ComponenteDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ComponenteDTO componente; 
	
	private List<ComponenteDTO> componenteList;
	
	public ComponenteDataManager() {
		componente=new ComponenteDTO();
		componenteList=new ArrayList<ComponenteDTO>();
	}

	public ComponenteDTO getComponente() {
		return componente;
	}

	public List<ComponenteDTO> getComponenteList() {
		return componenteList;
	}

	public void setComponente(ComponenteDTO componente) {
		this.componente = componente;
	}

	public void setComponenteList(List<ComponenteDTO> componenteList) {
		this.componenteList = componenteList;
	}
	
	
	
}
