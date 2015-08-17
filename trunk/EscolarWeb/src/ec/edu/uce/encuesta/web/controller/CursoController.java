package ec.edu.uce.encuesta.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.web.util.JsfUtil;

import ec.edu.uce.notas.ejb.persistence.entity.CursoDTO;
import ec.edu.uce.notas.ejb.service.AcademicoService;
import ec.edu.uce.notas.web.datamanager.CursoDataManager;

@ViewScoped
@ManagedBean(name = "cursoController")
public class CursoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AcademicoService academicoService;
	
	@ManagedProperty(value="#{cursoDataManager}")
	private CursoDataManager cursoDataManager;


	public CursoController() {
	
	}
	
	public CursoDataManager getCursoDataManager() {
		return cursoDataManager;
	}
	public void setCursoDataManager(CursoDataManager cursoDataManager) {
		this.cursoDataManager = cursoDataManager;
	}


	@PostConstruct
	private void init()
	{
		read();	
	}
	
	private void clear()
	{
		cursoDataManager.setCursoDTO(new CursoDTO());
	}
	
	public void onClickSave()
	{
		try {
			academicoService.createOrUpdateCurso(cursoDataManager.getCursoDTO());
			read();
			clear();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void read()
	{
		try {
			cursoDataManager.setCursoList(academicoService.readCurso(new CursoDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}

	public void onClicEdit(CursoDTO cursoDTO)
	{
		cursoDataManager.setCursoDTO(cursoDTO);
	}
	
	public void onClickCancel()
	{
		clear();
	}
}
