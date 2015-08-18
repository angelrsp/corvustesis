package ec.edu.uce.encuesta.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.web.util.JsfUtil;


import ec.edu.uce.notas.ejb.persistence.entity.ParaleloDTO;
import ec.edu.uce.notas.ejb.service.AcademicoService;
import ec.edu.uce.notas.web.datamanager.ParaleloDataManager;

@ViewScoped
@ManagedBean(name = "paraleloController")
public class ParaleloController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AcademicoService academicoService;
	
	@ManagedProperty(value="#{paraleloDataManager}")
	private ParaleloDataManager paraleloDataManager;


	public ParaleloController() {
	
	}
	


	@PostConstruct
	private void init()
	{
		read();	
	}



	public ParaleloDataManager getParaleloDataManager() {
		return paraleloDataManager;
	}



	public void setParaleloDataManager(ParaleloDataManager paraleloDataManager) {
		this.paraleloDataManager = paraleloDataManager;
	}



	public void clear()
	{
		paraleloDataManager.setParaleloDTO(new ParaleloDTO());
	}
	
	public void onClickSave()
	{
		try {
			academicoService.createOrUpdateParalelo(paraleloDataManager.getParaleloDTO());
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
			paraleloDataManager.setParaleloList(academicoService.readParalelo(new ParaleloDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}

	public void onClickEdit(ParaleloDTO paraleloDTO)
	{
		paraleloDataManager.setParaleloDTO(paraleloDTO);
	}
	
	public void onClickCancel()
	{
		clear();
	}
}
