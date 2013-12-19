package ec.edu.uce.silsae.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.AdministracionService;
import ec.edu.uce.silsae.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.CatalogoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;

@Stateless
public class AdministracionServiceImpl implements AdministracionService{
	
	
	private static final Logger log = LoggerFactory.getLogger(CandidatosServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;

	@Override
	public List<CatalogoDTO> getCatalogo(CatalogoDTO catalogo) throws SilsaeException
	{
		log.info("obtener catalogo");
		log.info("Valor codigo catalogo "+catalogo.getCatCodigo());
		try{
			factoryDAO.getCatalogoImpl().getAll(catalogo);
			return factoryDAO.getCatalogoImpl().getAll(catalogo);
		}
		catch(Exception e)
		{
			log.info("Error al obtener catalogo" +e.toString());
			throw new SilsaeException("Error al obtener catalogo");
		}
	}

	
	@Override
	public List<EmpresaDTO> obtenerEmpresas() throws SilsaeException
	{
		log.info("obtenerEmpresas");
		try{
			return factoryDAO.getEmpresaDAOImpl().getAll();
		}
		catch(Exception e)
		{
			log.info("Error al obtener catalogo" +e.toString());
			throw new SilsaeException("Error al obtener catalogo");
		}
	}

	@Override
	public List<ContactoDTO> obtenerContactos(EmpresaDTO empresa) throws SilsaeException
	{
		log.info("obtenerEmpresas");
		try{
			return factoryDAO.getContactoDAOImpl().getAll(empresa);
		}
		catch(Exception e)
		{
			log.info("Error al obtener catalogo" +e.toString());
			throw new SilsaeException("Error al obtener catalogo");
		}
	}
	
	@Override
	public void cambiarEstadoEmpresa(EmpresaDTO empresa) throws SilsaeException
	{
		log.info("cambiarEstadoEmpresa");
		try{
			factoryDAO.getEmpresaDAOImpl().edit(empresa);
		}
		catch(Exception e)
		{
			log.info("Error al obtener catalogo" +e.toString());
			throw new SilsaeException("Error al obtener catalogo");
		}
	}

//	@Override
//	public EmpresaDTO obtenerEmpresa(UsuarioDTO user) throws SilsaeException
//	{
//		log.info("obtenerEmpresa");
//		try{
//			return factoryDAO.getUsuarioDAOImpl().find(user.getUsuCodigo()).getBemEmpresas().get(0);
//		}
//		catch(Exception e)
//		{
//			log.info("Error al obtener catalogo" +e.toString());
//			throw new SilsaeException("Error al obtener catalogo");
//		}
//	}
	
	
}
