package ec.edu.uce.notas.ejb.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.beanutils.BeanUtils;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.notas.ejb.persistence.entity.AlumnoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.CursoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.DocenteDTO;
import ec.edu.uce.notas.ejb.persistence.entity.MateriaDTO;
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

}
