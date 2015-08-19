package ec.edu.uce.encuesta.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.web.util.JsfUtil;

import ec.edu.uce.notas.ejb.persistence.entity.CursoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.CursoParaleloDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ParaleloDTO;
import ec.edu.uce.notas.ejb.persistence.vo.CursoVO;
import ec.edu.uce.notas.ejb.service.AcademicoService;
import ec.edu.uce.notas.web.datamanager.CursoParaleloDataManager;

@ViewScoped
@ManagedBean(name = "cursoParaleloController")
public class CursoParaleloController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AcademicoService academicoService;
	
	@ManagedProperty(value="#{cursoParaleloDataManager}")
	private CursoParaleloDataManager cursoParaleloDataManager;

	public CursoParaleloController() {
	
	}
	

	public CursoParaleloDataManager getCursoParaleloDataManager() {
		return cursoParaleloDataManager;
	}




	public void setCursoParaleloDataManager(
			CursoParaleloDataManager cursoParaleloDataManager) {
		this.cursoParaleloDataManager = cursoParaleloDataManager;
	}




	@PostConstruct
	private void init()
	{
		readCurso();
		readParalelo();
		read();	
	}
	private void readCurso()
	{
		 List<CursoDTO> cursoList;
		try {
			
			cursoList=academicoService.readCurso(new CursoDTO());
			if(!cursoList.isEmpty())
			cursoParaleloDataManager.setCursoList(cursoList);
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}finally{
			cursoList=null;
		}
	}
	
	private void readParalelo()
	{
		 List<ParaleloDTO> paraleloList;
		try {
			
			paraleloList=academicoService.readParalelo(new ParaleloDTO());
			if(!paraleloList.isEmpty())
			cursoParaleloDataManager.setParaleloList(paraleloList);
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}finally{
			paraleloList=null;
		}
	}
	private void clear()
	{
		cursoParaleloDataManager.setCursoParalelo(new CursoVO());
	}
	
	public void onClickSave()
	{
		try {
			CursoParaleloDTO curPar= new CursoParaleloDTO();
			curPar.setCpaCurso(cursoParaleloDataManager.getCursoParalelo().getCursoDTO().getCurCodigo());
			curPar.setCpaParalelo(cursoParaleloDataManager.getCursoParalelo().getParaleloDTO().getParCodigo());
			 if (existCursoParalelo(curPar.getCpaCurso(), curPar.getCpaParalelo())) {
				 JsfUtil.addWarningMessage("Registro existente.");
		    	 return;
			}else{
			academicoService.createOrUpdateCursoParalelo(curPar);
			read();
			clear();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
			} 
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void read()
	{
		List<CursoVO> cursoParaleloList;
		try {
			cursoParaleloList=new ArrayList<CursoVO>();
			for (CursoDTO cursoDTO : cursoParaleloDataManager.getCursoList()) {
				CursoParaleloDTO curPar = new CursoParaleloDTO();
				curPar.setCpaCurso(cursoDTO.getCurCodigo());
				for (CursoParaleloDTO cursoParaleloDTO : academicoService.readCursoParalelo(curPar)) {
					CursoVO cursoVO= new CursoVO();
					cursoVO.setCursoDTO(cursoDTO);
					ParaleloDTO paralelo= new ParaleloDTO();
					paralelo.setParCodigo(cursoParaleloDTO.getCpaParalelo());
					cursoVO.setParaleloDTO(academicoService.readParalelo(paralelo).get(0));
					cursoParaleloList.add(cursoVO);
				}
			}
			cursoParaleloDataManager.setCursoParaleloList(cursoParaleloList);
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}

	public void onCellEdit(CellEditEvent event) {
		 CursoParaleloDTO curPar;
		 try {
			 Object oldValue = event.getOldValue();
		     Object newValue = event.getNewValue();
		     FacesContext context = FacesContext.getCurrentInstance();
			 CursoVO cursoPara = context.getApplication().evaluateExpressionGet(context, "#{cPa}", CursoVO.class);
		     if (existCursoParalelo(cursoPara.getCursoDTO().getCurCodigo(), Integer.parseInt(newValue.toString()))) {
				 JsfUtil.addWarningMessage("Ning\u00FAn cambio realizado registro existente.");
		    	 return;
			}else{
		 
		 curPar=new CursoParaleloDTO();
		 curPar.setCpaCurso(cursoPara.getCursoDTO().getCurCodigo());
		 curPar.setCpaParalelo(Integer.parseInt(oldValue.toString()));
		 curPar=academicoService.readCursoParalelo(curPar).get(0);
		 curPar.setCpaParalelo(Integer.parseInt(newValue.toString()));
			 academicoService.createOrUpdateCursoParalelo(curPar);
		 read();
	   }
	 } catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}  finally {
			curPar=null;
		  }
		
	    }
	public boolean existCursoParalelo(Integer codCurso, Integer codParalelo)
	{
		boolean isExistCursoParalelo=false;
		List<CursoParaleloDTO> cursoParaleloList;
		try {
			cursoParaleloList=new ArrayList<CursoParaleloDTO>();
			    CursoParaleloDTO curPar = new CursoParaleloDTO();
				curPar.setCpaCurso(codCurso);
				curPar.setCpaParalelo(codParalelo);
				cursoParaleloList= academicoService.readCursoParalelo(curPar);
				if (!cursoParaleloList.isEmpty()) 
					isExistCursoParalelo=true;
			
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		return isExistCursoParalelo;
	}
	
	public void onClickCancel()
	{
		clear();
	}
}
