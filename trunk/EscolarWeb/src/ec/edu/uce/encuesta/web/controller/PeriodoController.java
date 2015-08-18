package ec.edu.uce.encuesta.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.web.util.JsfUtil;


import ec.edu.uce.notas.ejb.persistence.entity.PeriodoDTO;
import ec.edu.uce.notas.ejb.service.AcademicoService;
import ec.edu.uce.notas.web.datamanager.PeriodoDataManager;

@ViewScoped
@ManagedBean(name = "periodoController")
public class PeriodoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AcademicoService academicoService;
	
	@ManagedProperty(value="#{periodoDataManager}")
	private PeriodoDataManager periodoDataManager;


	public PeriodoController() {
	
	}
	


	@PostConstruct
	private void init()
	{
		read();	
	}



	public PeriodoDataManager getPeriodoDataManager() {
		return periodoDataManager;
	}



	public void setPeriodoDataManager(PeriodoDataManager periodoDataManager) {
		this.periodoDataManager = periodoDataManager;
	}



	public void clear()
	{
		periodoDataManager.setPeriodoDTO(new PeriodoDTO());
	}
	
	public void onClickSave()
	{
		try {
			academicoService.createOrUpdatePeriodo(periodoDataManager.getPeriodoDTO());
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
			periodoDataManager.setPeriodoList(academicoService.readPeriodo(new PeriodoDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}

	public void onClickEdit(PeriodoDTO periodoDTO)
	{
		periodoDataManager.setPeriodoDTO(periodoDTO);
	}
	
	public void onClickCancel()
	{
		clear();
	}
}
