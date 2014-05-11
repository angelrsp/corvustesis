package ec.edu.uce.indicadores.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.AdministracionService;
import ec.edu.uce.indicadores.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.AccesoDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.CatalogoDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.OpcionDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PermisoIndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.UsuarioDTO;

@Stateless
public class AdministracionServiceImpl implements AdministracionService{

	private static final Logger log = LoggerFactory.getLogger(AdministracionServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;

	
	@Override
	public List<CatalogoDTO> getCatalogo(CatalogoDTO catalogo) throws IndicadoresException
	{
		log.info("obtener catalogo");
		log.info("Valor codigo catalogo "+catalogo.getCatCodigo());
		try{
			return factoryDAO.getCatalogoImpl().getAll(catalogo);
		}
		catch(Exception e)
		{
			log.info("Error al obtener catalogo" +e.toString());
			throw new IndicadoresException("Error al obtener catalogo");
		}
	}
	
	@Override
	public UsuarioDTO createOrUpdateUser(UsuarioDTO user) throws IndicadoresException
	{
		log.info("createOrUpdateUser");
		try{
			if(user.getUsuCodigo()!=null)
			{
				factoryDAO.getUsuarioPerfilDAOImpl().remove2(user.getIndUsuarioPerfils().get(0));
				return factoryDAO.getUsuarioDAOImpl().edit(user);
			}
			else
			{
				if(factoryDAO.getUsuarioDAOImpl().buscarUsuario(user)!=null)
					throw new IndicadoresException("El usuario ya existe");
				return factoryDAO.getUsuarioDAOImpl().create(user);
			}
		}
		catch(Exception e)
		{
			log.info("Error al createOrUpdateUser" +e.toString());
			throw new IndicadoresException("Error al crear o acualizar usuario "+e.toString());
		}		
	}
	
	
	@Override
	public void createAcceso(List<String> option,Object perfil,List<IndicadorDTO> indicadorList) throws IndicadoresException
	{
		log.info("createAcceso");
		AccesoDTO acc;
		OpcionDTO op;
		PermisoIndicadorDTO perInd;
		try{
			factoryDAO.getAccesoDAOImpl().remove(new PerfilDTO(Integer.valueOf(perfil.toString())));
			for(String opt:option){
				acc=new AccesoDTO();
				op=new OpcionDTO();
				op.setOpcCodigo(Integer.valueOf(opt));
				acc.setIndOpcion(op);
				acc.setIndPerfil(new PerfilDTO(Integer.valueOf(perfil.toString())));
				factoryDAO.getAccesoDAOImpl().create(acc);
			}
			factoryDAO.getPermisoIndicadorDAOImpl().remove2(new PerfilDTO(Integer.valueOf(perfil.toString())));
			for(IndicadorDTO ind:indicadorList)
			{
				perInd=new PermisoIndicadorDTO();
				perInd.setIndPerfil(new PerfilDTO(Integer.valueOf(perfil.toString())));
				perInd.setPeiIndicador(ind.getIndCodigo());
				factoryDAO.getPermisoIndicadorDAOImpl().create(perInd);
			}
			
		}
		catch(Exception e)
		{
			log.info("Error al createUser" +e.toString());
			throw new IndicadoresException("Error al createUser");
		}
	}
	
	@Override
	public Boolean existsPermisoIndicador(IndicadorDTO indicador,PerfilDTO perfil) throws IndicadoresException
	{
		log.info("existsPermisoIndicador");
		Boolean flag;
		try{
			flag=factoryDAO.getPermisoIndicadorDAOImpl().existe(indicador,perfil);
			log.info("valor {}",flag);
		}
		catch(Exception e)
		{
			log.info("Error al existsPermisoIndicador" +e.toString());
			throw new IndicadoresException("Error al existsPermisoIndicador");
		}	
		return flag;
	}
	
	@Override
	public List<UsuarioDTO> readUser(IesDTO ies) throws IndicadoresException
	{
		log.info("readUser");
		try{
			return factoryDAO.getUsuarioDAOImpl().getAll(ies);
		}
		catch(Exception e)
		{
			log.info("Error al readUser" +e.toString());
			throw new IndicadoresException("Error al readUser");
		}		
	}
	
	@Override
	public List<OpcionDTO> readOpcion(PerfilDTO perfil) throws IndicadoresException
	{
		log.info("readOpcion");
		try{
			return factoryDAO.getOpcionDAOImpl().getAll(perfil);
		}
		catch(Exception e){
			log.info("Error al readOpcion" +e.toString());
			throw new IndicadoresException("Error al readOpcion");
		}
	}
	
	@Override
	public List<OpcionDTO> readOpcion() throws IndicadoresException
	{
		log.info("readOpcion");
		try{
			return factoryDAO.getOpcionDAOImpl().findAll();
		}
		catch(Exception e){
			log.info("Error al readOpcion" +e.toString());
			throw new IndicadoresException("Error al readOpcion");
		}
	}
	
	@Override
	public void deleteUsuario(UsuarioDTO user) throws IndicadoresException
	{
		try {
			factoryDAO.getUsuarioDAOImpl().remove2(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IndicadoresException(e);
		}
	}

	/*Perfil*/
	@Override
	public PerfilDTO createOrUpdatePerfil(PerfilDTO perfil) throws IndicadoresException
	{
		log.info("createPerfil");
		try{
			if(factoryDAO.getPerfilDAOImpl().getByName(perfil)!=null)
			{
				if(perfil.getPerCodigo()!=null)
					return factoryDAO.getPerfilDAOImpl().edit(perfil);
				else
					return factoryDAO.getPerfilDAOImpl().create(perfil);
			}
			else
			{
				throw new IndicadoresException("Ya existe el nombre");
			}
		}
		catch(Exception e)
		{
			log.info("Error al createPerfil" +e.toString());
			throw new IndicadoresException(e.toString());
		}		
		
	}
	
	@Override
	public void deletePerfil(PerfilDTO perfil) throws IndicadoresException
	{
		try {
			List<OpcionDTO> opt= factoryDAO.getOpcionDAOImpl().getAll(perfil);
			if(opt.isEmpty())			
				factoryDAO.getPerfilDAOImpl().remove2(perfil);
			else
				throw new IndicadoresException("No se puede eliminar existen dependencias");
		} catch (IndicadoresException e) {
			log.error("Error agregarModelo {}",e.toString());
			throw new IndicadoresException(e);
		}
	}
	
	@Override
	public List<PerfilDTO> readPerfil() throws IndicadoresException
	{
		log.info("readUser");
		try{
			return factoryDAO.getPerfilDAOImpl().findAll();
		}
		catch(Exception e)
		{
			log.info("Error al readUser" +e.toString());
			throw new IndicadoresException("Error al readUser");
		}		
	}
}
