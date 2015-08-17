package ec.edu.uce.notas.ejb.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.notas.common.util.CorvustecException;
import com.corvustec.notas.common.util.EncryptionUtility;

import ec.edu.uce.notas.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.notas.ejb.persistence.entity.AccesoDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ComponenteDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ComponenteMenuDTO;
import ec.edu.uce.notas.ejb.persistence.entity.EmpresaDTO;
import ec.edu.uce.notas.ejb.persistence.entity.HistoryPasswordDTO;
import ec.edu.uce.notas.ejb.persistence.entity.MenuDTO;
import ec.edu.uce.notas.ejb.persistence.entity.PerfilDTO;
import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;
import ec.edu.uce.notas.ejb.persistence.entity.UsuarioPerfilDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.AccesoViewDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.ComponenteMenuViewDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.MenuViewDTO;
import ec.edu.uce.notas.ejb.persistence.entity.view.UsuarioViewDTO;
import ec.edu.uce.notas.ejb.persistence.vo.AccesoVO;
import ec.edu.uce.notas.ejb.persistence.vo.UsuarioVO;
import ec.edu.uce.notas.ejb.service.AdministracionService;


@Stateless
public class AdministracionServiceImpl implements AdministracionService{

	private static final Logger slf4jLogger = LoggerFactory.getLogger(AdministracionServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;

	/*Empresa*/
//	@Override
//	public EmpresaDTO createOrUpdateEmpresa(EmpresaDTO empresaDTO) throws CorvustecException {
//		EmpresaDTO emp;
//		try{
//			if(empresaDTO.getEmpCodigo()!=null)
//				return factoryDAO.getEmpresaDAOImpl().update(empresaDTO);
//			else
//			{			
//				emp=new EmpresaDTO();
//				emp.setEmpRuc(empresaDTO.getEmpRuc());
//				if(!factoryDAO.getEmpresaDAOImpl().getByAnd(emp).isEmpty())
//					throw new Exception("Ruc ya registrado");
//				
//				empresaDTO=factoryDAO.getEmpresaDAOImpl().create(empresaDTO);
//												
//				return empresaDTO;
//					
//			}
//		} catch (Exception e) {
//			slf4jLogger.info("Error al registrar Empresa {}", e.toString());
//			throw new CorvustecException(e);
//		}
//		finally{
//			emp=null;
//		}
//	}
//	
//	@Override
//	public List<EmpresaDTO> readEmpresa(EmpresaDTO empresa) throws CorvustecException
//	{
//		try {
//			return factoryDAO.getEmpresaDAOImpl().getByAnd(empresa);
//		} catch (Exception e) {
//			slf4jLogger.info("Error al readEmpresa {}", e.toString());
//			throw new CorvustecException("Error al readEmpresa " +e.toString());
//		}				
//	}
//	
//	@Override
//	public List<EmpresaDTO> readDynamicEmpresa(EmpresaDTO empresaDTO) throws CorvustecException
//	{
//		try {
//			return factoryDAO.getEmpresaDAOImpl().getByOrLike(empresaDTO);
//		} catch (Exception e) {
//			slf4jLogger.info("Error al registrar Aviso {}", e.toString());
//			throw new CorvustecException("Error readDynamicEmpresa");
//		}						
//	}
//	
//	
//	
	/*Usuario*/
	@Override
	public UsuarioDTO readUsuario(UsuarioDTO usuario) throws CorvustecException
	{
		List<UsuarioDTO> usuarioList;
		try {
			usuarioList = factoryDAO.getUsuarioDAOImpl().getByAnd(usuario);
			if(usuarioList.isEmpty())
				return new UsuarioDTO();
			else
				return usuarioList.get(0);	
		} catch (Exception e) {
			slf4jLogger.info("Error al readUsuario {}", e.toString());
			throw new CorvustecException("Error al readUsuario " +e.toString());
		}				
	}

	@Override
	public UsuarioDTO createUpdateUsuario(UsuarioVO usuarioVO) throws CorvustecException {
		UsuarioDTO usuarioDTO;
		HistoryPasswordDTO historialPasswordDTO;
		UsuarioPerfilDTO usuarioPerfilDTO;
		try {
			if(usuarioVO.getUsuarioDTO().getUsuCodigo()!=null)
			{
				if(usuarioVO.getUsuarioDTO().getSegUsuarioPerfils().size()>0)
					factoryDAO.getUsuarioPerfilDAOImpl().remove(usuarioVO.getUsuarioDTO().getSegUsuarioPerfils().get(0));

				usuarioPerfilDTO=new UsuarioPerfilDTO();
				usuarioPerfilDTO.setSegUsuario(usuarioVO.getUsuarioDTO());
				usuarioPerfilDTO.setSegPerfil(usuarioVO.getPerfilDTO());
				
				factoryDAO.getUsuarioPerfilDAOImpl().create(usuarioPerfilDTO);
				
				if(usuarioVO.getPassword()!=null&&usuarioVO.getPassword().trim()!="")
					usuarioVO.getUsuarioDTO().setUsuPassword(EncryptionUtility.getInstance().encriptar(usuarioVO.getPassword()));
				
				return usuarioDTO=factoryDAO.getUsuarioDAOImpl().update(usuarioVO.getUsuarioDTO());
			}
			else
			{
				historialPasswordDTO=new HistoryPasswordDTO();
				if(usuarioVO.getPassword()!=null&&usuarioVO.getPassword().trim()!="")
					usuarioVO.getUsuarioDTO().setUsuPassword(EncryptionUtility.getInstance().encriptar(usuarioVO.getPassword()));
				usuarioDTO= factoryDAO.getUsuarioDAOImpl().create(usuarioVO.getUsuarioDTO());
				historialPasswordDTO.setSegUsuario(usuarioDTO);
				historialPasswordDTO.setHpaFecha(new Timestamp(new Date().getTime()));
				historialPasswordDTO.setHpaPassword(EncryptionUtility.getInstance().encriptar(usuarioDTO.getUsuPassword()));
				factoryDAO.getHistorialPasswordDAOImpl().create(historialPasswordDTO);
				
				usuarioPerfilDTO=new UsuarioPerfilDTO();
				usuarioPerfilDTO.setSegUsuario(usuarioDTO);
				usuarioPerfilDTO.setSegPerfil(usuarioVO.getPerfilDTO());
				
				factoryDAO.getUsuarioPerfilDAOImpl().create(usuarioPerfilDTO);
				
				return usuarioDTO;
			}
		} catch (Exception e) {
			slf4jLogger.info("Error al registrar Usuario {}", e.toString());
			throw new CorvustecException("Error al registrar Usuario");
		}finally{
			usuarioDTO=null;
			historialPasswordDTO=null;	
			usuarioPerfilDTO=null;
		}
		
	}
	
	@Override
	public List<UsuarioDTO> readUsuarios(UsuarioDTO usuario) throws CorvustecException
	{
		try {
			return factoryDAO.getUsuarioDAOImpl().getByAndGreath(usuario);
		} catch (Exception e) {
			slf4jLogger.info("Error al readUsuarios {}", e.toString());
			throw new CorvustecException("Error al obtener usuarios");
		}				
	}
	
	@Override
	public List<UsuarioViewDTO> readUsuarioView(UsuarioViewDTO usuarioViewDTO)	throws CorvustecException
	{
		try {
			return factoryDAO.getUsuarioViewDAOImpl().getByAnd(usuarioViewDTO);
		} catch (Exception e) {
			slf4jLogger.info("Error al readUsuarioView {}", e.toString());
			throw new SecurityException("Error al obtener usuarios");
		}				
	}
	
	@Override
	public List<UsuarioDTO> readUsuarioDynamic(UsuarioDTO usuarioDTO) throws CorvustecException
	{
		try {
			//return factoryDAO.getUsuarioDAOImpl().getByOrLike(usuarioDTO);
			return null;
		} catch (Exception e) {
			slf4jLogger.info("Error al readUsuarios {}", e.toString());
			throw new CorvustecException("Error al obtener usuarios");
		}						
	}
	
	
	
	/*Perfil*/
	@Override
	public List<PerfilDTO> readPerfil(PerfilDTO perfilDTO) throws CorvustecException
	{
		try{
			return factoryDAO.getPerfilDAOImpl().getByAnd(perfilDTO);
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al perfilReadAll" +e.toString());
			throw new CorvustecException(e);
		}		
	}

	@Override
	public PerfilDTO createOrUpdatePerfil(PerfilDTO perfilDTO) throws CorvustecException
	{
		try{
			if(perfilDTO.getPerCodigo()!=null)
				return factoryDAO.getPerfilDAOImpl().update(perfilDTO);
			else
				return factoryDAO.getPerfilDAOImpl().create(perfilDTO);
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al createOrupdateCatalogo" +e.toString());
			throw new CorvustecException(e);
		}
	}

	
	
	/*Menu*/
	@Override
	public MenuDTO createOrUpdateMenu(MenuDTO menuDTO) throws CorvustecException
	{
		try{
			if(menuDTO.getMenCodigo()!=null)
				return factoryDAO.getMenuDAOImpl().update(menuDTO);
			else
				return factoryDAO.getMenuDAOImpl().create(menuDTO);
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al createOrupdateCatalogo" +e.toString());
			throw new CorvustecException("Error al createOrupdateCatalogo");
		}
	}

	@Override
	public List<MenuDTO> readMenuRoot() throws CorvustecException
	{
		try{
			return factoryDAO.getMenuDAOImpl().getRoot();
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al menuRootRead" +e.toString());
			throw new CorvustecException(e);
		}		
	}

	@Override
	public List<MenuDTO> readMenu(MenuDTO menuDTO) throws CorvustecException {
		try{
			return factoryDAO.getMenuDAOImpl().getByAnd(menuDTO);
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al menuReadAll" +e.toString());
			throw new CorvustecException(e);
		}		
	}

	@Override
	public List<MenuViewDTO> menuReadAuthorized(PerfilDTO perfil) throws CorvustecException {
		MenuViewDTO menu;
		try{
			menu=new MenuViewDTO();
			menu.setAccPerfil(perfil.getPerCodigo());
			menu.setCmeComponente(1);
			return factoryDAO.getMenuViewDAOImpl().getByAnd(menu);
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al menuReadAuthorized" +e.toString());
			throw new CorvustecException(e);
		}		
	}

	
	
	/*Componente*/
	@Override
	public ComponenteDTO createOrUpdateComponente(ComponenteDTO componenteDTO) throws CorvustecException
	{
		try{
			if(componenteDTO.getComCodigo()!=null)
				return factoryDAO.getComponenteDAOImpl().update(componenteDTO);
			else
				return factoryDAO.getComponenteDAOImpl().create(componenteDTO);
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al componenteCreateOrUpdate" +e.toString());
			throw new CorvustecException(e);
		}
	}

	@Override
	public List<ComponenteDTO> readComponente(ComponenteDTO componenteDTO) throws CorvustecException {
		try{
			return factoryDAO.getComponenteDAOImpl().getByAnd(componenteDTO);
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al componenteReadAll" +e.toString());
			throw new CorvustecException(e);
		}		
	}

	
	
	/*Componente Menu*/
	@Override
	public ComponenteMenuDTO createOrUpdateComponenteMenu(ComponenteMenuDTO componenteDTO) throws CorvustecException
	{
		try{
			if(componenteDTO.getCmeCodigo()!=null)
				return factoryDAO.getComponenteMenuDAOImpl().update(componenteDTO);
			else
				return factoryDAO.getComponenteMenuDAOImpl().create(componenteDTO);
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al componenteMenuCreateOrUpdate" +e.toString());
			throw new CorvustecException(e);
		}
	}

	@Override
	public List<ComponenteMenuDTO> readComponenteMenu(ComponenteMenuDTO componenteMenuDTO) throws CorvustecException {
		try{
			return factoryDAO.getComponenteMenuDAOImpl().getByAnd(componenteMenuDTO);
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al componenteMenuReadAll" +e.toString());
			throw new CorvustecException(e);
		}
	}

	@Override
	public List<ComponenteMenuViewDTO> readComponanteMenuView(ComponenteMenuViewDTO componenteMenuVieDTO, AccesoViewDTO accesoVieDTO) throws CorvustecException {
		try{
			return factoryDAO.getComponenteMenuViewDAOImpl().getBySubquery(accesoVieDTO, componenteMenuVieDTO);
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al componenteMenuReadAll" +e.toString());
			throw new CorvustecException(e);
		}
	}


	
	/*Acceso*/
	@Override
	public List<AccesoViewDTO> readAccesoView(AccesoViewDTO accesoViewDTO) throws CorvustecException {
		try{
			return factoryDAO.getAccesoViewDAOImpl().getByAnd(accesoViewDTO);
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al accesoVieRead" +e.toString());
			throw new CorvustecException(e);
		}
	}

	@Override
	public List<AccesoViewDTO> readAccesoViewSubquery(AccesoViewDTO accesoViewDTO) throws CorvustecException {
		try{
			return factoryDAO.getAccesoViewDAOImpl().getBySubquery(accesoViewDTO);
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al accesoVieRead" +e.toString());
			throw new CorvustecException(e);
		}
	}

	@Override
	public List<AccesoViewDTO> readAccesoViewPerfilIsNull(AccesoViewDTO accesoViewDTO) throws CorvustecException {
		try{
			return factoryDAO.getAccesoViewDAOImpl().getByAndPerfilIsNull(accesoViewDTO);
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al accesoVieRead" +e.toString());
			throw new CorvustecException("Error al accesoVieRead "+e.toString());
		}
	}
	
	@Override
	public List<AccesoDTO> readAccesoDistincMenu(AccesoDTO accesoDTO) throws CorvustecException {
		try{
			return factoryDAO.getAccesoDAOImpl().getByAndDistinctMenu(accesoDTO);
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al accesoReadDistinctMenu" +e.toString());
			throw new CorvustecException("Error al accesoReadDistinctMenu "+e.toString());
		}
	}
	
	@Override
	public void createOrUpdateAcceso(AccesoVO acceso) throws CorvustecException {
		AccesoDTO acc;
		ComponenteMenuDTO cme;
		try{
			acc=new AccesoDTO();
			acc.setSegPerfil(acceso.getPerfil());
			
			for(AccesoViewDTO a:acceso.getAccesoList())
			{
				cme=new ComponenteMenuDTO();
				acc=new AccesoDTO();
				acc.setSegPerfil(acceso.getPerfil());
				cme.setCmeCodigo(a.getCmeCodigo());
				acc.setSegComponenteMenu(cme);
				
				if(factoryDAO.getAccesoDAOImpl().getByAnd(acc).size()>0)
				{
					acc=factoryDAO.getAccesoDAOImpl().getByAnd(acc).get(0);					
					factoryDAO.getAccesoDAOImpl().remove2(acc);
				}
			}
			
			for(AccesoViewDTO ac:acceso.getAccesoList())
			{
				acc=new AccesoDTO();
				cme=new ComponenteMenuDTO();
				cme.setCmeCodigo(ac.getCmeCodigo());
				acc.setSegComponenteMenu(cme);
				acc.setSegPerfil(acceso.getPerfil());
				factoryDAO.getAccesoDAOImpl().create(acc);				
			}
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al accesoCreateOrUpdate" +e.toString());
			throw new CorvustecException("Error al accesoCreateOrUpdate "+e.toString());
		}
	}

	@Override
	public void deleteAcceso(AccesoVO acceso) throws CorvustecException {
		AccesoDTO acc;
		ComponenteMenuDTO cme;
		try{
			for(AccesoViewDTO a:acceso.getAccesoList())
			{
				cme=new ComponenteMenuDTO();
				acc=new AccesoDTO();
				acc.setSegPerfil(acceso.getPerfil());
				cme.setCmeCodigo(a.getCmeCodigo());
				acc.setSegComponenteMenu(cme);
				
				acc=factoryDAO.getAccesoDAOImpl().getByAnd(acc).get(0);
				
				factoryDAO.getAccesoDAOImpl().remove(acc);
			}
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error al accesoCreateOrUpdate" +e.toString());
			throw new CorvustecException("Error al accesoCreateOrUpdate "+e.toString());
		}
	}

	@Override
	public EmpresaDTO createOrUpdateEmpresa(EmpresaDTO empresaDTO)
			throws CorvustecException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpresaDTO> readEmpresa(EmpresaDTO empresa)
			throws CorvustecException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpresaDTO> readDynamicEmpresa(EmpresaDTO empresaDTO)
			throws CorvustecException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
