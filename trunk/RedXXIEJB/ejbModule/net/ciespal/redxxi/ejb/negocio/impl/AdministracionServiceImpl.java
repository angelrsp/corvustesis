package net.ciespal.redxxi.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.AccesoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.AccesoVieDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.ComponenteDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.ComponenteMenuDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.MenuDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.MenuVieDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.PerfilDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioDTO;
import net.ciespal.redxxi.ejb.persistence.entities.util.dto.CredencialesDTO;
import net.ciespal.redxxi.ejb.persistence.entities.vo.AccesoVO;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.ApplicationUtil;
import com.corvustec.commons.util.CorvustecException;
import com.corvustec.commons.util.EncryptionUtil;


@Stateless
public class AdministracionServiceImpl implements AdministracionService{

	private static final Logger logger = LoggerFactory.getLogger(AdministracionServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;
	
	@Override
	public List<CatalogoDTO> getCatalogo(CatalogoDTO catalogo) throws CorvustecException
	{
		logger.info("getCatalogo");
		try{
			return factoryDAO.getCatalogoImpl().getAll(catalogo);
		}
		catch(Exception e)
		{
			logger.info("Error al obtener catalogo" +e.toString());
			throw new CorvustecException("Error al obtener catalogo");
		}
	}
	
	@Override
	public CatalogoDTO createOrUpdateCatalogo(CatalogoDTO catalogo) throws CorvustecException
	{
		logger.info("createOrupdateCatalogo");
		try{
			if(catalogo.getCatImagenNombre()!=null)
				ApplicationUtil.deletefile(catalogo.getCatImagenNombre());
			if(catalogo.getCatCodigo()!=null)
				return factoryDAO.getCatalogoImpl().edit(catalogo);
			else
				return factoryDAO.getCatalogoImpl().create(catalogo);
		}
		catch(Exception e)
		{
			logger.info("Error al createOrupdateCatalogo" +e.toString());
			throw new CorvustecException("Error al createOrupdateCatalogo");
		}
	}
		
	@Override
	public CatalogoDTO getCatalogo(Object id) throws CorvustecException
	{
		logger.info("getCatalogo");
		try{
			return factoryDAO.getCatalogoImpl().find(id);
		}
		catch(Exception e)
		{
			logger.info("Error al obtener catalogo" +e.toString());
			throw new CorvustecException("Error al obtener catalogo");
		}
	}
	
	@Override
	public void deleteCatalogo(CatalogoDTO catalogo) throws CorvustecException
	{
		logger.info("deleteCatalogo");
		try{
			if(getCatalogo(catalogo).size()<=0)
				factoryDAO.getCatalogoImpl().remove2(catalogo);
			else
				throw new CorvustecException("No se pudo eliminar existen dependencias");
		}
		catch(Exception e)
		{
			logger.info("Error al deleteCatalogo" +e.toString());
			throw new CorvustecException("Error al deleteCatalogo");
		}
	}
	
	
	/*Usuario*/
	@Override
	public UsuarioDTO userAuthentication(CredencialesDTO credenciales) throws CorvustecException
	{
		logger.info("userAuthentication");
		UsuarioDTO usuario;
		List<UsuarioDTO> userList;
		try{
			usuario=new UsuarioDTO();
			usuario.setUsuLogin(credenciales.getUser());
			usuario.setUsuClave(EncryptionUtil.getInstancia().encriptar(credenciales.getPassword()));
			userList= factoryDAO.getUsuarioDAOImpl().getByAnd(usuario);
			if(!userList.isEmpty())
				return userList.get(0);
			else
				return null;
		}
		catch(Exception e)
		{
			logger.info("Error al userAuthentication" +e.toString());
			throw new CorvustecException("Error al userAuthentication "+e.toString());
		}		
	}
	
	@Override
	public UsuarioDTO createOrUpdateUsuario(UsuarioDTO usuarioDTO) throws CorvustecException
	{
		logger.info("createOrUpdateUsuario");
		try{
			if(StringUtils.isNoneBlank(usuarioDTO.getUsuClave()))
				usuarioDTO.setUsuClave(EncryptionUtil.getInstancia().encriptar(usuarioDTO.getUsuClave()));
			if(usuarioDTO.getUsuCodigo()!=null)
				return factoryDAO.getUsuarioDAOImpl().edit(usuarioDTO);
			else
				return factoryDAO.getUsuarioDAOImpl().create(usuarioDTO);
		}
		catch(Exception e)
		{
			logger.info("Error al createOrupdateCatalogo" +e.toString());
			throw new CorvustecException("Error al createOrupdateCatalogo");
		}
	}
	
	@Override
	public List<UsuarioDTO> readUser(UsuarioDTO usuarioDTO) throws CorvustecException
	{
		logger.info("readUser");
		try{
			return factoryDAO.getUsuarioDAOImpl().getByAnd(usuarioDTO);
		}
		catch(Exception e)
		{
			logger.info("Error al createOrupdateCatalogo" +e.toString());
			throw new CorvustecException("Error al createOrupdateCatalogo");
		}		
	}

	@Override
	public List<UsuarioDTO> readAllUser() throws CorvustecException
	{
		logger.info("readUser");
		try{
			return factoryDAO.getUsuarioDAOImpl().getByAnd(new UsuarioDTO());
		}
		catch(Exception e)
		{
			logger.info("Error al createOrupdateCatalogo" +e.toString());
			throw new CorvustecException("Error al createOrupdateCatalogo");
		}		
	}

	/*Perfil*/
	@Override
	public List<PerfilDTO> perfilReadAll() throws CorvustecException
	{
		logger.info("readUser");
		try{
			return factoryDAO.getPerfilDAOImpl().getByAnd(new PerfilDTO());
		}
		catch(Exception e)
		{
			logger.info("Error al perfilReadAll" +e.toString());
			throw new CorvustecException("Error al perfilReadAll");
		}		
	}

	@Override
	public PerfilDTO perfilCreateOrUpdate(PerfilDTO perfilDTO) throws CorvustecException
	{
		logger.info("createOrUpdateUsuario");
		try{
			if(perfilDTO.getPerCodigo()!=null)
				return factoryDAO.getPerfilDAOImpl().edit(perfilDTO);
			else
				return factoryDAO.getPerfilDAOImpl().create(perfilDTO);
		}
		catch(Exception e)
		{
			logger.info("Error al createOrupdateCatalogo" +e.toString());
			throw new CorvustecException("Error al createOrupdateCatalogo");
		}
	}

	/*Menu*/
	@Override
	public MenuDTO menuCreateOrUpdate(MenuDTO menuDTO) throws CorvustecException
	{
		logger.info("menuCreateOrUpdate");
		try{
			if(menuDTO.getMenCodigo()!=null)
				return factoryDAO.getMenuDAOImpl().edit(menuDTO);
			else
				return factoryDAO.getMenuDAOImpl().create(menuDTO);
		}
		catch(Exception e)
		{
			logger.info("Error al createOrupdateCatalogo" +e.toString());
			throw new CorvustecException("Error al createOrupdateCatalogo");
		}
	}


	@Override
	public List<MenuDTO> menuRootRead() throws CorvustecException
	{
		logger.info("menuRootRead");
		try{
			return factoryDAO.getMenuDAOImpl().getRoot();
		}
		catch(Exception e)
		{
			logger.info("Error al menuRootRead" +e.toString());
			throw new CorvustecException("Error al menuRootRead");
		}		
	}

	@Override
	public List<MenuDTO> menuReadAll() throws CorvustecException {
		logger.info("menuReadAll");
		try{
			return factoryDAO.getMenuDAOImpl().getByAnd(new MenuDTO());
		}
		catch(Exception e)
		{
			logger.info("Error al menuReadAll" +e.toString());
			throw new CorvustecException("Error al menuReadAll");
		}		
	}

	@Override
	public List<MenuVieDTO> menuReadAuthorized(PerfilDTO perfil) throws CorvustecException {
		logger.info("menuReadAuthorized");
		MenuVieDTO menu;
		try{
			menu=new MenuVieDTO();
			menu.setAccPerfil(perfil.getPerCodigo());
			menu.setCmeComponente(1);
			return factoryDAO.getMenuVieDAOImpl().getByAnd(menu);
		}
		catch(Exception e)
		{
			logger.info("Error al menuReadAuthorized" +e.toString());
			throw new CorvustecException("Error al menuReadAuthorized "+e.toString());
		}		
	}

	
	
	/*Componente*/
	@Override
	public ComponenteDTO componenteCreateOrUpdate(ComponenteDTO componenteDTO) throws CorvustecException
	{
		logger.info("componenteCreateOrUpdate");
		try{
			if(componenteDTO.getComCodigo()!=null)
				return factoryDAO.getComponenteDAOImpl().edit(componenteDTO);
			else
				return factoryDAO.getComponenteDAOImpl().create(componenteDTO);
		}
		catch(Exception e)
		{
			logger.info("Error al componenteCreateOrUpdate" +e.toString());
			throw new CorvustecException("Error al componenteCreateOrUpdate");
		}
	}

	@Override
	public List<ComponenteDTO> componenteReadAll() throws CorvustecException {
		logger.info("componenteReadAll");
		try{
			return factoryDAO.getComponenteDAOImpl().getByAnd(new ComponenteDTO());
		}
		catch(Exception e)
		{
			logger.info("Error al componenteReadAll" +e.toString());
			throw new CorvustecException("Error al componenteReadAll");
		}		
	}

	/*Componente Menu*/
	@Override
	public ComponenteMenuDTO componenteMenuCreateOrUpdate(ComponenteMenuDTO componenteDTO) throws CorvustecException
	{
		logger.info("componenteMenuCreateOrUpdate");
		try{
			if(componenteDTO.getCmeCodigo()!=null)
				return factoryDAO.getComponenteMenuDAOImpl().edit(componenteDTO);
			else
				return factoryDAO.getComponenteMenuDAOImpl().create(componenteDTO);
		}
		catch(Exception e)
		{
			logger.info("Error al componenteMenuCreateOrUpdate" +e.toString());
			throw new CorvustecException("Error al componenteMenuCreateOrUpdate "+e.toString());
		}
	}

	@Override
	public List<ComponenteMenuDTO> componenteMenuReadAll() throws CorvustecException {
		logger.info("componenteMenuReadAll");
		try{
			return factoryDAO.getComponenteMenuDAOImpl().getByAnd(new ComponenteMenuDTO());
		}
		catch(Exception e)
		{
			logger.info("Error al componenteMenuReadAll" +e.toString());
			throw new CorvustecException("Error al componenteMenuReadAll "+e.toString());
		}
	}

	/*Acceso*/
	@Override
	public List<AccesoVieDTO> accesoVieRead(AccesoVieDTO acceso) throws CorvustecException {
		logger.info("accesoVieRead");
		try{
			return factoryDAO.getAccesoVieDAOImpl().getByAnd(acceso);
		}
		catch(Exception e)
		{
			logger.info("Error al accesoVieRead" +e.toString());
			throw new CorvustecException("Error al accesoVieRead "+e.toString());
		}
	}

	@Override
	public List<AccesoVieDTO> accesoVieReadPerfilIsNull(AccesoVieDTO acceso) throws CorvustecException {
		logger.info("accesoVieRead");
		try{
			return factoryDAO.getAccesoVieDAOImpl().getByAndPerfilIsNull(acceso);
		}
		catch(Exception e)
		{
			logger.info("Error al accesoVieRead" +e.toString());
			throw new CorvustecException("Error al accesoVieRead "+e.toString());
		}
	}

	@Override
	public List<AccesoDTO> accesoReadDistinctMenu(AccesoDTO acceso) throws CorvustecException {
		logger.info("accesoReadDistinctMenu");
		try{
			return factoryDAO.getAccesoDAOImpl().getByAndDistinctMenu(acceso);
		}
		catch(Exception e)
		{
			logger.info("Error al accesoReadDistinctMenu" +e.toString());
			throw new CorvustecException("Error al accesoReadDistinctMenu "+e.toString());
		}
	}

	
	@Override
	public void accesoCreateOrUpdate(AccesoVO acceso) throws CorvustecException {
		logger.info("accesoCreateOrUpdate");
		AccesoDTO acc;
		ComponenteMenuDTO cme;
		try{
			acc=new AccesoDTO();
			acc.setSegPerfil(acceso.getPerfil());
			
			List<AccesoDTO> accList= factoryDAO.getAccesoDAOImpl().getByAnd(acc);

			for(AccesoDTO a:accList)
				factoryDAO.getAccesoDAOImpl().remove(a);
			
			for(AccesoVieDTO a:acceso.getAccesoList())
			{
				cme=new ComponenteMenuDTO();
				cme.setCmeCodigo(a.getCmeCodigo());
				acc.setSegComponenteMenu(cme);
				factoryDAO.getAccesoDAOImpl().create(acc);				
			}
		}
		catch(Exception e)
		{
			logger.info("Error al accesoCreateOrUpdate" +e.toString());
			throw new CorvustecException("Error al accesoCreateOrUpdate "+e.toString());
		}
	}

	@Override
	public void accesoDelete(AccesoVO acceso) throws CorvustecException {
		logger.info("accesoCreateOrUpdate");
		AccesoDTO acc;
		ComponenteMenuDTO cme;
		try{
			for(AccesoVieDTO a:acceso.getAccesoList())
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
			logger.info("Error al accesoCreateOrUpdate" +e.toString());
			throw new CorvustecException("Error al accesoCreateOrUpdate "+e.toString());
		}
	}
	
}
