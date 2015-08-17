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
import ec.edu.uce.notas.ejb.persistence.entity.view.DocenteViewDTO;
import ec.edu.uce.notas.ejb.persistence.vo.DocenteVO;
import ec.edu.uce.notas.ejb.service.AcademicoService;
import ec.edu.uce.notas.web.datamanager.DocenteDataManger;

@ViewScoped
@ManagedBean(name = "docenteController")
public class DocenteController implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AcademicoService academicoService;
	
	@ManagedProperty(value="#{docenteDataManger}")
	private DocenteDataManger docenteDataManger;

	
	public DocenteController() {
	
	}

	public DocenteDataManger getDocenteDataManger() {
		return docenteDataManger;
	}
	public void setDocenteDataManger(DocenteDataManger docenteDataManger) {
		this.docenteDataManger = docenteDataManger;
	}
	
	@PostConstruct
	private void init()
	{
		readDocente();
	}
	
	private void readDocente()
	{
		try {
			docenteDataManger.setDocenteViewList(academicoService.readDocenteView(new DocenteViewDTO()));
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void clear()
	{
		docenteDataManger.setUsuarioDTO(new UsuarioDTO());
	}
	
	public void onClickSave()
	{
		DocenteVO docenteVO;
		try {
			docenteVO=new DocenteVO();
			docenteVO.setUsuarioDTO(docenteDataManger.getUsuarioDTO());
			academicoService.createOrUpdateDocente(docenteVO);
			clear();
			readDocente();
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
