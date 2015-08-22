package ec.edu.uce.encuesta.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.web.util.JsfUtil;

import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.AlumnoViewDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.DocenteViewDTO;
import ec.edu.uce.notas.ejb.persistence.vo.AlumnoVO;
import ec.edu.uce.notas.ejb.service.AcademicoService;
import ec.edu.uce.notas.web.datamanager.AlumnoDataManager;
import ec.edu.uce.notas.web.datamanager.NotasDocenteDataManager;

@ViewScoped
@ManagedBean(name = "notasDocenteController")
public class NotasDocenteController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AcademicoService academicoService;
	
	@ManagedProperty(value="#{notasDocenteDataManager}")
	private NotasDocenteDataManager notasDocenteDataManager;

	public NotasDocenteController() {
	
	}
	
	

	public NotasDocenteDataManager getNotasDocenteDataManager() {
		return notasDocenteDataManager;
	}



	public void setNotasDocenteDataManager(
			NotasDocenteDataManager notasDocenteDataManager) {
		this.notasDocenteDataManager = notasDocenteDataManager;
	}



	@PostConstruct
	private void init()
	{
		readAlumno();
	}
	
	private void readAlumno()
	{
		try {
			notasDocenteDataManager.setAlumnoViewList(academicoService.readAlumnoView(new AlumnoViewDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	

	
}
