package ec.edu.uce.notas.ejb.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.beanutils.BeanUtils;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.notas.ejb.persistence.entity.AlumnoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.CursoAlumnoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.CursoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.CursoParaleloDTO;
import ec.edu.uce.notas.ejb.persistence.entity.DocenteDTO;
import ec.edu.uce.notas.ejb.persistence.entity.MateriaDTO;
import ec.edu.uce.notas.ejb.persistence.entity.MateriaDocenteDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ParaleloDTO;
import ec.edu.uce.notas.ejb.persistence.entity.PeriodoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.AlumnoViewDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.DocenteViewDTO;
import ec.edu.uce.notas.ejb.persistence.vo.AlumnoVO;
import ec.edu.uce.notas.ejb.persistence.vo.DocenteVO;
import ec.edu.uce.notas.ejb.service.AcademicoService;

@Stateless
public class AcademicoServiceImpl implements AcademicoService {

	
	@EJB
	private FactoryDAO factoryDAO;

	/*Docente*/
	@Override
	public void createOrUpdateDocente(DocenteVO docenteVO) throws CorvustecException
	{
		UsuarioDTO usuarioDTO;
		DocenteDTO docenteDTO;
		try {
			usuarioDTO=new UsuarioDTO();
			docenteDTO=new DocenteDTO();
			usuarioDTO.setUsuIdentificacion(docenteVO.getUsuarioDTO().getUsuIdentificacion());
			if(factoryDAO.getUsuarioDAOImpl().getByAnd(usuarioDTO).isEmpty())
			{
				usuarioDTO=(UsuarioDTO)BeanUtils.cloneBean(docenteVO.getUsuarioDTO()) ;
				usuarioDTO= factoryDAO.getUsuarioDAOImpl().create(usuarioDTO);
			}
			else
			{
				usuarioDTO= factoryDAO.getUsuarioDAOImpl().getByAnd(usuarioDTO).get(0);
			}
			docenteDTO.setDocUsuario(usuarioDTO.getUsuCodigo());
			if(docenteVO.getUsuarioDTO().getUsuCodigo()!=null)
			{
				usuarioDTO=docenteVO.getUsuarioDTO();
				factoryDAO.getUsuarioDAOImpl().update(usuarioDTO);
			}
			else
			{
				factoryDAO.getDocenteDAOImpl().create(docenteDTO);
			}
		} catch (CorvustecException e) {
			throw new CorvustecException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new CorvustecException(e);
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new CorvustecException(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new CorvustecException(e);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new CorvustecException(e);
		}
	}

	@Override
	public List<DocenteViewDTO> readDocenteView(DocenteViewDTO docenteViewDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getDocenteViewDAOImpl().getByAnd(docenteViewDTO);
		} catch (CorvustecException e) {
			throw new CorvustecException(e);
		}
	}

	/*Alumno*/
	@Override
	public void createOrUpdateAlumno(AlumnoVO alumnoVO) throws CorvustecException
	{
		UsuarioDTO usuarioDTO;
		AlumnoDTO alumnoDTO;
		try {
			usuarioDTO=new UsuarioDTO();
			alumnoDTO=new AlumnoDTO();
			usuarioDTO.setUsuIdentificacion(alumnoVO.getUsuarioDTO().getUsuIdentificacion());
			if(factoryDAO.getUsuarioDAOImpl().getByAnd(usuarioDTO).isEmpty())
			{
				usuarioDTO=(UsuarioDTO)BeanUtils.cloneBean(alumnoVO.getUsuarioDTO()) ;
				usuarioDTO= factoryDAO.getUsuarioDAOImpl().create(usuarioDTO);
			}
			else
			{
				usuarioDTO= factoryDAO.getUsuarioDAOImpl().getByAnd(usuarioDTO).get(0);
			}
			alumnoDTO.setAluUsuario(usuarioDTO.getUsuCodigo());
			if(alumnoVO.getUsuarioDTO().getUsuCodigo()!=null)
			{
				usuarioDTO=alumnoVO.getUsuarioDTO();
				factoryDAO.getUsuarioDAOImpl().update(usuarioDTO);
			}
			else
			{
				factoryDAO.getAlumnoDAOImpl().create(alumnoDTO);
			}
		} catch (CorvustecException e) {
			throw new CorvustecException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new CorvustecException(e);
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new CorvustecException(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new CorvustecException(e);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new CorvustecException(e);
		}
	}
	
	@Override
	public List<AlumnoViewDTO> readAlumnoView(AlumnoViewDTO alumnoViewDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getAlumnoViewDAOImpl().getByAnd(alumnoViewDTO);
		} catch (CorvustecException e) {
			throw new CorvustecException(e);
		}
	}

	
	@Override
	public List<AlumnoViewDTO> readAutocompleteAlumnoView(AlumnoViewDTO alumnoViewDTO) throws CorvustecException
	{
		try{
			return factoryDAO.getAlumnoViewDAOImpl().getAutocomplete(alumnoViewDTO);
		}
		catch(Exception e)
		{
			throw new CorvustecException("Error al readAlumnoView");
		}
		finally{
			alumnoViewDTO=null;
		}		
	}
	
	/*Curso*/
	@Override
	public CursoDTO createOrUpdateCurso(CursoDTO cursoDTO) throws CorvustecException
	{
		if(cursoDTO.getCurCodigo()!=null)
			return factoryDAO.getCursoDAOImpl().update(cursoDTO);
		else
			return factoryDAO.getCursoDAOImpl().create(cursoDTO);
	}
	
	@Override
	public List<CursoDTO> readCurso(CursoDTO cursoDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getCursoDAOImpl().getByAnd(cursoDTO);
		} catch (CorvustecException e) {
			throw new CorvustecException(e);
		}
	}

	
	/*Materia*/
	@Override
	public MateriaDTO createOrUpdateMateria(MateriaDTO materiaDTO) throws CorvustecException
	{
		if(materiaDTO.getMatCodigo()!=null)
			return factoryDAO.getMateriaDAOImpl().update(materiaDTO);
		else
			return factoryDAO.getMateriaDAOImpl().create(materiaDTO);
	}
	
	@Override
	public List<MateriaDTO> readMateria(MateriaDTO materiaDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getMateriaDAOImpl().getByAnd(materiaDTO);
		} catch (CorvustecException e) {
			throw new CorvustecException(e);
		}
	}
	/*Periodo*/
	@Override
	public PeriodoDTO createOrUpdatePeriodo(PeriodoDTO periodoDTO) throws CorvustecException
	{
		if(periodoDTO.getPerCodigo()!=null)
			return factoryDAO.getPeriodoDAOImpl().update(periodoDTO);
		else
			return factoryDAO.getPeriodoDAOImpl().create(periodoDTO);
	}
	
	@Override
	public List<PeriodoDTO> readPeriodo(PeriodoDTO periodoDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getPeriodoDAOImpl().getByAnd(periodoDTO);
		} catch (CorvustecException e) {
			throw new CorvustecException(e);
		}
	}
	
	/*Paralelo*/
	@Override
	public ParaleloDTO createOrUpdateParalelo(ParaleloDTO paraleloDTO) throws CorvustecException
	{
		if(paraleloDTO.getParCodigo()!=null)
			return factoryDAO.getParaleloDAOImpl().update(paraleloDTO);
		else
			return factoryDAO.getParaleloDAOImpl().create(paraleloDTO);
	}
	
	@Override
	public List<ParaleloDTO> readParalelo(ParaleloDTO paraleloDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getParaleloDAOImpl().getByAnd(paraleloDTO);
		} catch (CorvustecException e) {
			throw new CorvustecException(e);
		}
	}
	
	/*CursoParalelo*/
	@Override
	public CursoParaleloDTO createOrUpdateCursoParalelo(CursoParaleloDTO cursoCursoParaleloDTO) throws CorvustecException
	{
		if(cursoCursoParaleloDTO.getCpaCodigo()!=null)
			return factoryDAO.getCursoParaleloDAOImpl().update(cursoCursoParaleloDTO);
		else
			return factoryDAO.getCursoParaleloDAOImpl().create(cursoCursoParaleloDTO);
	}
	
	@Override
	public List<CursoParaleloDTO> readCursoParalelo(CursoParaleloDTO cursoCursoParaleloDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getCursoParaleloDAOImpl().getByAnd(cursoCursoParaleloDTO);
		} catch (CorvustecException e) {
			throw new CorvustecException(e);
		}
	}
	
	/*MateriaDocente*/
	@Override
	public MateriaDocenteDTO createOrUpdateMateriaDocente(MateriaDocenteDTO cursoMateriaDocenteDTO) throws CorvustecException
	{
		if(cursoMateriaDocenteDTO.getMadCodigo()!=null)
			return factoryDAO.getMateriaDocenteDAOImpl().update(cursoMateriaDocenteDTO);
		else
			return factoryDAO.getMateriaDocenteDAOImpl().create(cursoMateriaDocenteDTO);
	}
	
	@Override
	public List<MateriaDocenteDTO> readMateriaDocente(MateriaDocenteDTO cursoMateriaDocenteDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getMateriaDocenteDAOImpl().getByAnd(cursoMateriaDocenteDTO);
		} catch (CorvustecException e) {
			throw new CorvustecException(e);
		}
	}
	
	/*CursoAlumno*/
	@Override
	public CursoAlumnoDTO createOrUpdateCursoAlumno(CursoAlumnoDTO cursoAlumnoDTO) throws CorvustecException
	{
		if(cursoAlumnoDTO.getCalCodigo()!=null)
			return factoryDAO.getCursoAlumnoDAOImpl().update(cursoAlumnoDTO);
		else
			return factoryDAO.getCursoAlumnoDAOImpl().create(cursoAlumnoDTO);
	}
	
	@Override
	public List<CursoAlumnoDTO> readCursoAlumno(CursoAlumnoDTO cursoAlumnoDTO) throws CorvustecException
	{
		try {
			return factoryDAO.getCursoAlumnoDAOImpl().getByAnd(cursoAlumnoDTO);
		} catch (CorvustecException e) {
			throw new CorvustecException(e);
		}
	}
}
