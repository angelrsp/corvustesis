package ec.edu.uce.notas.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ec.edu.uce.notas.ejb.persistence.entity.view.AlumnoViewDTO;

@ManagedBean(name="alumnoService", eager = true)
@ApplicationScoped
public class AlumnoService {

	private List<AlumnoViewDTO> alumnoList;

	@PostConstruct
	private void init()
	{
		alumnoList=new ArrayList<AlumnoViewDTO>();
	}

	public List<AlumnoViewDTO> getAlumnoList() {
		return alumnoList;
	}

	public void setAlumnoList(List<AlumnoViewDTO> alumnoList) {
		this.alumnoList = alumnoList;
	}
	
	
}
