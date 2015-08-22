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

import org.primefaces.event.SelectEvent;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.web.util.JsfUtil;

import ec.edu.uce.notas.ejb.persistence.entity.AlumnoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.CursoAlumnoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.CursoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.CursoParaleloDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ParaleloDTO;
import ec.edu.uce.notas.ejb.persistence.entity.PeriodoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.AlumnoViewDTO;
import ec.edu.uce.notas.ejb.persistence.vo.AlumnoVO;
import ec.edu.uce.notas.ejb.service.AcademicoService;
import ec.edu.uce.notas.web.datamanager.EstudianteCursoDataManager;
import ec.edu.uce.notas.web.service.AlumnoService;

@ViewScoped
@ManagedBean(name = "estudianteCursoController")
public class EstudianteCursoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AcademicoService academicoService;
	
	@ManagedProperty(value="#{estudianteCursoDataManager}")
	private EstudianteCursoDataManager estudianteCursoDataManager;

	public EstudianteCursoController() {
	
	}



	public EstudianteCursoDataManager getEstudianteCursoDataManager() {
		return estudianteCursoDataManager;
	}



	public void setEstudianteCursoDataManager(
			EstudianteCursoDataManager estudianteCursoDataManager) {
		this.estudianteCursoDataManager = estudianteCursoDataManager;
	}


	@PostConstruct
	private void init()
	{
		readPeriodo();
		readCurso();
		read();
	}
	
	private void read()
	{
		List<AlumnoVO> estCurList;
		try {
			estCurList=new ArrayList<AlumnoVO>();
			for (CursoAlumnoDTO estCu : academicoService.readCursoAlumno(new CursoAlumnoDTO())) {
				   AlumnoVO estCurs= new AlumnoVO();
				   estCurs.setPeriodoDTO(estCu.getNotPeriodo());
				   CursoDTO cur=new CursoDTO();
				   cur.setCurCodigo(estCu.getNotCursoParalelo().getCpaCurso());
				   estCurs.setCursoDTO(academicoService.readCurso(cur).get(0));
				   ParaleloDTO par=new ParaleloDTO();
				   par.setParCodigo(estCu.getNotCursoParalelo().getCpaParalelo());
				   estCurs.setParaleloDTO(academicoService.readParalelo(par).get(0));
				   AlumnoViewDTO alu= new AlumnoViewDTO();
				   alu.setAluCodigo(estCu.getNotAlumno().getAluCodigo());
				   estCurs.setAlumnoViewDTO(academicoService.readAlumnoView(alu).get(0));
				   estCurs.setCursoAlumnoDTO(estCu);
				   estCurList.add(estCurs);
			}
			estudianteCursoDataManager.setEstudianteCursoList(estCurList);
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	private void readPeriodo()
	{
		try {

			estudianteCursoDataManager.setPeriodoList(academicoService.readPeriodo(new PeriodoDTO()));
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	private void readCurso()
	{
		try {
			estudianteCursoDataManager.setCursoList(academicoService.readCurso(new CursoDTO()));
			
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
			curPar.setCpaCurso(estudianteCursoDataManager.getEstudianteCurso().getCursoDTO().getCurCodigo());
			for (CursoParaleloDTO curPa : academicoService.readCursoParalelo(curPar)) {
				ParaleloDTO par=new ParaleloDTO();
				par.setParCodigo(curPa.getCpaParalelo());
				paraleloList.add(academicoService.readParalelo(par).get(0));
				
			}
			estudianteCursoDataManager.setParaleloList(paraleloList);
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	public List<AlumnoViewDTO> readAlumno(String filter)
	{
		List<AlumnoViewDTO> alumnoList = null;
		AlumnoService alumnoService;
		try {
			estudianteCursoDataManager.getEstudianteCurso().setAlumnoViewDTO(new AlumnoViewDTO());
			estudianteCursoDataManager.getEstudianteCurso().getAlumnoViewDTO().setUsuIdentificacion(filter);
			alumnoList= academicoService.readAutocompleteAlumnoView(estudianteCursoDataManager.getEstudianteCurso().getAlumnoViewDTO());
			alumnoService=(AlumnoService)FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("alumnoService");
			alumnoService.setAlumnoList(alumnoList);
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		finally{
			alumnoService=null;
		}
		return alumnoList;
	}
	
	public void onItemSelectIdentification(SelectEvent selectEvent)
	{
		try {
			estudianteCursoDataManager.getEstudianteCurso().setAlumnoViewDTO((AlumnoViewDTO)selectEvent.getObject());
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	 
	public void save()
	{
		try {
			validarRegistro(estudianteCursoDataManager.getEstudianteCurso());
			if(estudianteCursoDataManager.getIsSave()){
			CursoAlumnoDTO estC= new CursoAlumnoDTO();
			if(estudianteCursoDataManager.getEstudianteCurso().getCursoAlumnoDTO().getCalCodigo()!=null)
				estC.setCalCodigo(estudianteCursoDataManager.getEstudianteCurso().getCursoAlumnoDTO().getCalCodigo());
			estC.setNotPeriodo(estudianteCursoDataManager.getEstudianteCurso().getPeriodoDTO());
			CursoParaleloDTO curPar= new CursoParaleloDTO();
			curPar.setCpaCurso(estudianteCursoDataManager.getEstudianteCurso().getCursoDTO().getCurCodigo());
			curPar.setCpaParalelo(estudianteCursoDataManager.getEstudianteCurso().getParaleloDTO().getParCodigo());
			//curso
			estC.setNotCursoParalelo(academicoService.readCursoParalelo(curPar).get(0));
			AlumnoDTO alu= new AlumnoDTO();
			if(estudianteCursoDataManager.getEstudianteCurso().getAlumnoViewDTO()==null)
				alu.setAluCodigo(estudianteCursoDataManager.getEstudianteCurso().getAlumnoDTO().getAluCodigo());
			else   alu.setAluCodigo(estudianteCursoDataManager.getEstudianteCurso().getAlumnoViewDTO().getAluCodigo());
			estC.setNotAlumno(alu);
			academicoService.createOrUpdateCursoAlumno(estC);
			JsfUtil.addInfoMessage("Registrado Correctamete.");
			read();
			clear();
			}
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		
	}
	
	private void validarRegistro(AlumnoVO estCur)
	{
		
		 
			try {
				CursoAlumnoDTO cuA= new CursoAlumnoDTO();
				cuA.setNotPeriodo(estCur.getPeriodoDTO());
				AlumnoDTO alu=new AlumnoDTO();
				if(estCur.getAlumnoViewDTO()==null)
					alu.setAluCodigo(estCur.getAlumnoDTO().getAluCodigo());
				else
				alu.setAluCodigo(estCur.getAlumnoViewDTO().getAluCodigo());
				cuA.setNotAlumno(alu);
				CursoParaleloDTO curPar=new CursoParaleloDTO();
				curPar.setCpaCurso(estCur.getCursoDTO().getCurCodigo());
				curPar.setCpaParalelo(estCur.getParaleloDTO().getParCodigo());
				cuA.setNotCursoParalelo(academicoService.readCursoParalelo(curPar).get(0));
				if(!academicoService.readCursoAlumno(cuA).isEmpty()) {
					 JsfUtil.addWarningMessage("Registro existente en el Curso Paralelo del Periodo.");
			    	 return;
				}
				cuA= new CursoAlumnoDTO();
				cuA.setNotPeriodo(estCur.getPeriodoDTO());
				alu=new AlumnoDTO();
				if(estCur.getAlumnoViewDTO()==null)
					alu.setAluCodigo(estCur.getAlumnoDTO().getAluCodigo());
				else
				alu.setAluCodigo(estCur.getAlumnoViewDTO().getAluCodigo());
				cuA.setNotAlumno(alu);
				if(estCur.getCursoAlumnoDTO().getCalCodigo()==null && !academicoService.readCursoAlumno(cuA).isEmpty()){
					 JsfUtil.addWarningMessage("Registro existente busque y edite el alumno en cuesti\u00F3n.");
			    	 return;
				}
					
				estudianteCursoDataManager.setIsSave(true);
			} catch (CorvustecException e) {
				JsfUtil.addErrorMessage(e.toString());
			}
		
		
	
	}
	
	
	private void clear()
	{
		estudianteCursoDataManager.setEstudianteCurso(new AlumnoVO());
	}
	
	
	
	public void onClickCancel()
	{
		clear();
	}
	
	public void onClickEdit(AlumnoVO estudiante)
	{
		estudianteCursoDataManager.setEstudianteCurso(estudiante);
		estudianteCursoDataManager.getEstudianteCurso().getAlumnoDTO().setAluCodigo(estudianteCursoDataManager.getEstudianteCurso().getAlumnoViewDTO().getAluCodigo());
		readParalelo();
		estudianteCursoDataManager.setIsSave(false);
	}

	
	//opciones de busqueda
	public void readIdentificacion()
	{
		List<AlumnoVO> estCurList;
		List<AlumnoViewDTO> estList;
		try {
			estCurList=new ArrayList<AlumnoVO>();
			if(estudianteCursoDataManager.getEstudianteCurso().getAlumnoViewDTO().getUsuIdentificacion().length()!=10){
				JsfUtil.addWarningMessage("C\u00E9dula de estudiante no existente.");
	    	 return;
			}
			CursoAlumnoDTO curA=new CursoAlumnoDTO();
			AlumnoViewDTO alu=new AlumnoViewDTO();
			alu.setUsuIdentificacion(estudianteCursoDataManager.getEstudianteCurso().getAlumnoViewDTO().getUsuIdentificacion());
			estList=academicoService.readAlumnoView(alu);
			if(estList.isEmpty()){
				JsfUtil.addWarningMessage("C\u00E9dula de estudiante no existente.");
		    	 return;
		   }else{
			   AlumnoDTO al=new AlumnoDTO();
			   al.setAluCodigo(estList.get(0).getAluCodigo());
			   curA.setNotAlumno(academicoService.readAlumno(al).get(0));
			   for (CursoAlumnoDTO estCu : academicoService.readCursoAlumno(curA)) {
				   AlumnoVO estCurs= new AlumnoVO();
				   estCurs.setPeriodoDTO(estCu.getNotPeriodo());
				   CursoDTO cur=new CursoDTO();
				   cur.setCurCodigo(estCu.getNotCursoParalelo().getCpaCurso());
				   estCurs.setCursoDTO(academicoService.readCurso(cur).get(0));
				   ParaleloDTO par=new ParaleloDTO();
				   par.setParCodigo(estCu.getNotCursoParalelo().getCpaParalelo());
				   estCurs.setParaleloDTO(academicoService.readParalelo(par).get(0));
				   AlumnoViewDTO aluV= new AlumnoViewDTO();
				   aluV.setAluCodigo(estCu.getNotAlumno().getAluCodigo());
				   estCurs.setAlumnoViewDTO(academicoService.readAlumnoView(aluV).get(0));
				   estCurs.setCursoAlumnoDTO(estCu);
				   estCurList.add(estCurs);
			}
			estudianteCursoDataManager.setEstudianteCursoList(estCurList);
		   }
			   
			
			
			
			
			
		} catch (CorvustecException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
}
