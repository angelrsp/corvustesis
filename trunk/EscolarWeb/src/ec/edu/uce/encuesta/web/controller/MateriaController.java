package ec.edu.uce.encuesta.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.web.util.JsfUtil;


import ec.edu.uce.notas.ejb.persistence.entity.MateriaDTO;
import ec.edu.uce.notas.ejb.service.AcademicoService;
import ec.edu.uce.notas.web.datamanager.MateriaDataManager;

@ViewScoped
@ManagedBean(name = "materiaController")
public class MateriaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AcademicoService academicoService;
	
	@ManagedProperty(value="#{materiaDataManager}")
	private MateriaDataManager materiaDataManager;


	public MateriaController() {
	
	}
	


	@PostConstruct
	private void init()
	{
		read();	
	}
	
	
	
	
	public AcademicoService getAcademicoService() {
		return academicoService;
	}



	public void setAcademicoService(AcademicoService academicoService) {
		this.academicoService = academicoService;
	}



	public MateriaDataManager getMateriaDataManager() {
		return materiaDataManager;
	}



	public void setMateriaDataManager(MateriaDataManager materiaDataManager) {
		this.materiaDataManager = materiaDataManager;
	}



	public void clear()
	{
		materiaDataManager.setMateriaDTO(new MateriaDTO());
	}
	
	public void onClickSave()
	{
		try {
			academicoService.createOrUpdateMateria(materiaDataManager.getMateriaDTO());
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
			materiaDataManager.setMateriaList(academicoService.readMateria(new MateriaDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}

	public void onClickEdit(MateriaDTO materiaDTO)
	{
		materiaDataManager.setMateriaDTO(materiaDTO);
	}
	
	public void onClickCancel()
	{
		clear();
	}
}
