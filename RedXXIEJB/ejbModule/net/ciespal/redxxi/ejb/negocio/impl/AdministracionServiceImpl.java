package net.ciespal.redxxi.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.ciespal.redxxi.ejb.negocio.AdministracionService;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CatalogoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.ComponenteDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.MenuDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.PerfilDTO;
import net.ciespal.redxxi.ejb.persistence.entities.security.UsuarioDTO;
import net.ciespal.redxxi.ejb.persistence.entities.util.dto.CredencialesDTO;

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
		logger.info("perfilReadAll");
		try{
			return factoryDAO.getComponenteDAOImpl().getByAnd(new ComponenteDTO());
		}
		catch(Exception e)
		{
			logger.info("Error al perfilReadAll" +e.toString());
			throw new CorvustecException("Error al perfilReadAll");
		}		
	}

}
