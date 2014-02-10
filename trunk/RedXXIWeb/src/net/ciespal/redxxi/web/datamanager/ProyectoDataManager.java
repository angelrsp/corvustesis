package net.ciespal.redxxi.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.ciespal.redxxi.ejb.persistence.entities.ProyectoInvestigacionDTO;

@SessionScoped
@ManagedBean(name="proyectoDataManager")
public class ProyectoDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProyectoInvestigacionDTO proyecto;
	private List<ProyectoInvestigacionDTO> proyectoList;
	
	public ProyectoDataManager() {
		
	}
	
	@PostConstruct
	private void init()
	{
		proyecto=new ProyectoInvestigacionDTO();
		proyectoList=new ArrayList<ProyectoInvestigacionDTO>();
	}

	public ProyectoInvestigacionDTO getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoInvestigacionDTO proyecto) {
		this.proyecto = proyecto;
	}

	public List<ProyectoInvestigacionDTO> getProyectoList() {
		return proyectoList;
	}

	public void setProyectoList(List<ProyectoInvestigacionDTO> proyectoList) {
		this.proyectoList = proyectoList;
	}
}
