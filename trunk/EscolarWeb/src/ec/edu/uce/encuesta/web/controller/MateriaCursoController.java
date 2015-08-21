package ec.edu.uce.encuesta.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.web.util.JsfUtil;

import ec.edu.uce.notas.ejb.persistence.entity.CursoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.CursoParaleloDTO;
import ec.edu.uce.notas.ejb.persistence.entity.DocenteDTO;
import ec.edu.uce.notas.ejb.persistence.entity.MateriaDTO;
import ec.edu.uce.notas.ejb.persistence.entity.MateriaDocenteDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ParaleloDTO;
import ec.edu.uce.notas.ejb.persistence.entity.PeriodoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.DocenteViewDTO;
import ec.edu.uce.notas.ejb.persistence.vo.DocenteVO;
import ec.edu.uce.notas.ejb.service.AcademicoService;
import ec.edu.uce.notas.web.datamanager.MateriaCursoDataManager;

@ViewScoped
@ManagedBean(name = "materiaCursoController")
public class MateriaCursoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AcademicoService academicoService;
	
	@ManagedProperty(value="#{materiaCursoDataManager}")
	private MateriaCursoDataManager materiaCursoDataManager;

	public MateriaCursoController() {
	
	}
	



	public MateriaCursoDataManager getMateriaCursoDataManager() {
		return materiaCursoDataManager;
	}




	public void setMateriaCursoDataManager(
			MateriaCursoDataManager materiaCursoDataManager) {
		this.materiaCursoDataManager = materiaCursoDataManager;
	}




	@PostConstruct
	private void init()
	{
		readPeriodo();
		readCurso();
		readDocente();
		readMateria();
		read();
	}
	
	private void read()
	{
		List<DocenteVO> matDocList;
		try {
			matDocList=new ArrayList<DocenteVO>();
			for (MateriaDocenteDTO matDo : academicoService.readMateriaDocente(new MateriaDocenteDTO())) {
				   DocenteVO matDocen= new DocenteVO();
				   matDocen.setPeriodoDTO(matDo.getNotPeriodo());
				   CursoDTO cur=new CursoDTO();
				   cur.setCurCodigo(matDo.getNotCursoParalelo().getCpaCurso());
				   matDocen.setCursoDTO(academicoService.readCurso(cur).get(0));
				   ParaleloDTO par=new ParaleloDTO();
				   par.setParCodigo(matDo.getNotCursoParalelo().getCpaParalelo());
				   matDocen.setParaleloDTO(academicoService.readParalelo(par).get(0));
				   DocenteViewDTO doc= new DocenteViewDTO();
				   doc.setDocCodigo(matDo.getNotDocente().getDocCodigo());
				   matDocen.setDocenteViewDTO(academicoService.readDocenteView(doc).get(0));
				   matDocen.setMateriaDTO(matDo.getNotMateria());
				   matDocen.setMateriaDocenteDTO(matDo);
				   matDocList.add(matDocen);
			}
			materiaCursoDataManager.setMateriaCursoList(matDocList);
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readPeriodo()
	{
		try {
			materiaCursoDataManager.setPeriodoList(academicoService.readPeriodo(new PeriodoDTO()));
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	private void readCurso()
	{
		try {
			materiaCursoDataManager.setCursoList(academicoService.readCurso(new CursoDTO()));
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	public void readParalelo()
	{
		List<ParaleloDTO> paraleloList;
		try {
			paraleloList=new ArrayList<ParaleloDTO>();
			CursoParaleloDTO curPar=new CursoParaleloDTO();
			curPar.setCpaCurso(materiaCursoDataManager.getMateriaCurso().getCursoDTO().getCurCodigo());
			for (CursoParaleloDTO curPa : academicoService.readCursoParalelo(curPar)) {
				ParaleloDTO par=new ParaleloDTO();
				par.setParCodigo(curPa.getCpaParalelo());
				paraleloList.add(academicoService.readParalelo(par).get(0));
				
			}
			materiaCursoDataManager.setParaleloList(paraleloList);
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	private void readDocente()
	{
		try {
			materiaCursoDataManager.setDocenteList(academicoService.readDocenteView(new DocenteViewDTO()));
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readMateria()
	{
		try {
			materiaCursoDataManager.setMateriaList(academicoService.readMateria(new MateriaDTO()));
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void save()
	{
		try {
			validarRegistro(materiaCursoDataManager.getMateriaCurso());
			if(materiaCursoDataManager.getIsSave()){
			MateriaDocenteDTO maD= new MateriaDocenteDTO();
			if(materiaCursoDataManager.getMateriaCurso().getMateriaDocenteDTO().getMadCodigo()!=null)
				maD.setMadCodigo(materiaCursoDataManager.getMateriaCurso().getMateriaDocenteDTO().getMadCodigo());
			maD.setNotPeriodo(materiaCursoDataManager.getMateriaCurso().getPeriodoDTO());
			CursoParaleloDTO curPar= new CursoParaleloDTO();
			curPar.setCpaCurso(materiaCursoDataManager.getMateriaCurso().getCursoDTO().getCurCodigo());
			curPar.setCpaParalelo(materiaCursoDataManager.getMateriaCurso().getParaleloDTO().getParCodigo());
			maD.setNotCursoParalelo(academicoService.readCursoParalelo(curPar).get(0));
			maD.setNotMateria(materiaCursoDataManager.getMateriaCurso().getMateriaDTO());
			DocenteDTO doc= new DocenteDTO();
			doc.setDocCodigo(materiaCursoDataManager.getMateriaCurso().getDocenteViewDTO().getDocCodigo());
			maD.setNotDocente(doc);
			academicoService.createOrUpdateMateriaDocente(maD);
			JsfUtil.addInfoMessage("Registrado Correctamete.");
			}
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}
	
	private void validarRegistro(DocenteVO matCur)
	{
		try {
			MateriaDocenteDTO maD= new MateriaDocenteDTO();
			maD.setNotPeriodo(matCur.getPeriodoDTO());
			maD.setNotMateria(matCur.getMateriaDTO());
			if(!academicoService.readMateriaDocente(maD).isEmpty()) {
				 JsfUtil.addWarningMessage("Registro existente en el Periodo Seleccionado.");
		    	 return;
			}
			CursoParaleloDTO curPar= new CursoParaleloDTO();
			curPar.setCpaCurso(matCur.getCursoDTO().getCurCodigo());
			curPar.setCpaParalelo(matCur.getParaleloDTO().getParCodigo());
			maD= new MateriaDocenteDTO();
			maD.setNotCursoParalelo(academicoService.readCursoParalelo(curPar).get(0));
			maD.setNotMateria(matCur.getMateriaDTO());
			if(!academicoService.readMateriaDocente(maD).isEmpty()) {
				 JsfUtil.addWarningMessage("Registro existente en el Curso Paralelo.");
		    	 return;
			}
			materiaCursoDataManager.setIsSave(true);
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	private void clear()
	{
		materiaCursoDataManager.setMateriaCurso(new DocenteVO());
	}
	
	
	
	public void onClickCancel()
	{
		clear();
	}
	
	public void onClickEdit(DocenteVO docente)
	{
		materiaCursoDataManager.setMateriaCurso(docente);
		readParalelo();
		materiaCursoDataManager.setIsSave(false);
	}

	
}
