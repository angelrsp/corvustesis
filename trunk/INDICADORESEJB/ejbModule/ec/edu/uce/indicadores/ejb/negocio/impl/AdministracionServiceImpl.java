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
import ec.edu.uce.indicadores.ejb.persistence.entities.OpcionDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;
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
	public UsuarioDTO createUser(UsuarioDTO user) throws IndicadoresException
	{
		log.info("createUser");
		try{
			return factoryDAO.getUsuarioDAOImpl().create(user);
		}
		catch(Exception e)
		{
			log.info("Error al createUser" +e.toString());
			throw new IndicadoresException("Error al createUser");
		}		
	}
	
	@Override
	public void createAcceso(List<String> option,Object perfil) throws IndicadoresException
	{
		log.info("createAcceso");
		AccesoDTO acc;
		OpcionDTO op;
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
		}
		catch(Exception e)
		{
			log.info("Error al createUser" +e.toString());
			throw new IndicadoresException("Error al createUser");
		}
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
	public PerfilDTO createPerfil(PerfilDTO perfil) throws IndicadoresException
	{
		log.info("createPerfil");
		try{
			return factoryDAO.getPerfilDAOImpl().create(perfil);
		}
		catch(Exception e)
		{
			log.info("Error al createPerfil" +e.toString());
			throw new IndicadoresException("Error al createPerfil");
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
}
