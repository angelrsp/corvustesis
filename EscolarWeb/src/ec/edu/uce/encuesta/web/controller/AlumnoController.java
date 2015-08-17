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

@ViewScoped
@ManagedBean(name = "alumnoController")
public class AlumnoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AcademicoService academicoService;
	
	@ManagedProperty(value="#{alumnoDataManager}")
	private AlumnoDataManager alumnoDataManager;

	public AlumnoController() {
	
	}
	
	public AlumnoDataManager getAlumnoDataManager() {
		return alumnoDataManager;
	}
	public void setAlumnoDataManager(AlumnoDataManager alumnoDataManager) {
		this.alumnoDataManager = alumnoDataManager;
	}

	@PostConstruct
	private void init()
	{
		readAlumno();
	}
	
	private void readAlumno()
	{
		try {
			alumnoDataManager.setAlumnoViewList(academicoService.readAlumnoView(new AlumnoViewDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void clear()
	{
		alumnoDataManager.setUsuarioDTO(new UsuarioDTO());
	}
	
	public void onClickSave()
	{
		AlumnoVO alumnoVO;
		try {
			alumnoVO=new AlumnoVO();
			alumnoVO.setUsuarioDTO(alumnoDataManager.getUsuarioDTO());
			academicoService.createOrUpdateAlumno(alumnoVO);
			clear();
			readAlumno();
			JsfUtil.addInfoMessage("Guardado");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void onClickCancel()
	{
		clear();
	}
	
	public void onClickEdit(DocenteViewDTO docenteViewDTO)
	{
		
	}

	
}
