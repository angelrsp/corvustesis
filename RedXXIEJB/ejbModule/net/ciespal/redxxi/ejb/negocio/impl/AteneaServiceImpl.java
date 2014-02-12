package net.ciespal.redxxi.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EventoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.MencionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ProyectoInvestigacionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PublicacionDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

@Stateless
public class AteneaServiceImpl implements AteneaService{

	private static final Logger logger = LoggerFactory.getLogger(AteneaServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;
	
	/* Centro */
	@Override
	public CentroDTO createCentro(CentroDTO centro) throws CorvustecException
	{
		logger.info("createCentro");
		try{
			return factoryDAO.getCentroDAOImpl().create(centro);
		}
		catch(Exception e)
		{
			logger.info("Error createCentro {}",e.toString());
			throw new CorvustecException("Error al createCentro");
		}
	}
	
	@Override
	public void deleteCentro(CentroDTO centro) throws CorvustecException
	{
		logger.info("deleteCentro");
		try{
			factoryDAO.getCentroDAOImpl().remove(centro);
		}
		catch(Exception e){
			logger.info("Error eliminarCentro {}",e.toString());
			throw new CorvustecException("Error al eliminarCentro");
		}
	}
	
	@Override
	public void updateCentro(CentroDTO centro) throws CorvustecException
	{
		logger.info("updateCentro");
		try{
			factoryDAO.getCentroDAOImpl().edit(centro);
		}
		catch(Exception e){
			logger.info("Error updateCentro {}",e.toString());
			throw new CorvustecException("Error al updateCentro");
		}		
	}
	
	/* Carrera */
	@Override
	public CarreraDTO createCarrera(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("createCarrera");
		try{
			return factoryDAO.getCarreraDAOImpl().create(carrera);
		}
		catch(Exception e)
		{
			logger.info("Error createCarrera {}",e.toString());
			throw new CorvustecException("Error al createCarrera");
		}
	}	
	
	@Override
	public List<CarreraDTO> readCarrera(CentroDTO centro,Object tipo) throws CorvustecException
	{
		logger.info("readCarrera");
		try{
			return factoryDAO.getCarreraDAOImpl().getAll(centro,tipo);
		}
		catch(Exception e)
		{
			logger.info("Error readCarrera {}",e.toString());
			throw new CorvustecException("Error al readCarrera");
		}
	}	
	
	
	/* Entidad */
	@Override
	public EntidadDTO createEntidad(EntidadDTO entidad) throws CorvustecException
	{
		logger.info("createEntidad");
		try{
			return factoryDAO.getEntidadDAOImpl().create(entidad);
		}
		catch(Exception e)
		{
			logger.info("Error createEntidad {}",e.toString());
			throw new CorvustecException("Error al createEntidad");
		}		
	}
	
	@Override
	public void updateEntidad(EntidadDTO entidad) throws CorvustecException
	{
		logger.info("updateEntidad");
		try{
			factoryDAO.getEntidadDAOImpl().edit(entidad);
		}
		catch(Exception e){
			logger.info("Error updateEntidad {}",e.toString());
			throw new CorvustecException("Error al updateEntidad");
		}
	}
	
	@Override
	public MencionDTO createMencion(MencionDTO mencion) throws CorvustecException
	{
		logger.info("createMencion");
		try{
			return factoryDAO.getMencionDAOImpl().create(mencion);
		}
		catch(Exception e)
		{
			logger.info("Error createMencion {}",e.toString());
			throw new CorvustecException("Error al createMencion");
		}		
	}
	
	/* Contacto */
	@Override
	public ContactoDTO createContacto(ContactoDTO contactoDTO) throws CorvustecException
	{
		logger.info("createEntidad");
		try{
			return factoryDAO.getContactoDAOImpl().create(contactoDTO);
		}
		catch(Exception e)
		{
			logger.info("Error createEntidad {}",e.toString());
			throw new CorvustecException("Error al createEntidad");
		}		
	}

	@Override
	public List<ContactoListDTO> readContacto(EntidadDTO entidad) throws CorvustecException
	{
		logger.info("readContacto");
		try{
			return factoryDAO.getContactoDAOImpl().getAll(entidad);
		}
		catch(Exception e)
		{
			logger.info("Error readContacto {}",e.toString());
			throw new CorvustecException("Error al readContacto");
		}		
	}

	@Override
	public List<ContactoListDTO> readContacto(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("readContacto");
		try{
			return factoryDAO.getContactoDAOImpl().getAll(carrera);
		}
		catch(Exception e)
		{
			logger.info("Error readContacto {}",e.toString());
			throw new CorvustecException("Error al readContacto");
		}		
	}
	
	@Override
	public List<MencionDTO> readMencion(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("readContacto");
		try{
			return factoryDAO.getMencionDAOImpl().getAll(carrera);
		}
		catch(Exception e)
		{
			logger.info("Error readContacto {}",e.toString());
			throw new CorvustecException("Error al readContacto");
		}		
	}

	
	
	
	
	@Override
	public List<CentroDTO> obtenerCentroPadre() throws CorvustecException
	{
		logger.info("obtenerCentroPadre");
		try{
			return factoryDAO.getCentroDAOImpl().findAllPather();
		}
		catch(Exception e)
		{
			logger.info("Error obtenerCentroPadre {}",e.toString());
			throw new CorvustecException("Error al obtenerCentroPadre");
		}
	}
	
	@Override
	public List<CentroDTO> obtenerCentroHijo(CentroDTO centro) throws CorvustecException
	{
		logger.info("obtenerCentroHijo");
		try{
			return factoryDAO.getCentroDAOImpl().findAllChild(centro);
		}
		catch(Exception e)
		{
			logger.info("Error obtenerCentroHijo {}",e.toString());
			throw new CorvustecException("Error al obtenerCentroHijo");
		}
	}
	
	@Override
	public List<ProyectoInvestigacionDTO> readProyectoInvestigacion(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("obtenerProyectoInvestigacion");
		try{
			return factoryDAO.getProyectoInvestigacionDAOImpl().getAll(carrera);
		}
		catch(Exception e)
		{
			logger.info("Error obtenerProyectoInvestigacion {}",e.toString());
			throw new CorvustecException("Error al obtenerProyectoInvestigacion");
		}
	}

	@Override
	public ProyectoInvestigacionDTO createProyectoInvestigacion(ProyectoInvestigacionDTO proyecto) throws CorvustecException
	{
		logger.info("createProyectoInvestigacion");
		try{
			return factoryDAO.getProyectoInvestigacionDAOImpl().create(proyecto);
		}
		catch(Exception e){
			logger.info("Error createProyectoInvestigacion {}",e.toString());
			throw new CorvustecException("Error al createProyectoInvestigacion");
		}
	}

	
	@Override
	public List<EventoDTO> readEvento(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("readEvento");
		try{
			return factoryDAO.getEventoDAOImpl().getAll(carrera);
		}
		catch(Exception e)
		{
			logger.info("Error readEvento {}",e.toString());
			throw new CorvustecException("Error al readEvento");
		}
	}

	@Override
	public EventoDTO createEvento(EventoDTO evento) throws CorvustecException
	{
		logger.info("createProyectoInvestigacion");
		try{
			return factoryDAO.getEventoDAOImpl().create(evento);
		}
		catch(Exception e){
			logger.info("Error createProyectoInvestigacion {}",e.toString());
			throw new CorvustecException("Error al createProyectoInvestigacion");
		}
	}
	
	@Override
	public List<PublicacionDTO> readPublicacion(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("readEvento");
		try{
			return factoryDAO.getPublicacionDAOImpl().getAll(carrera);
		}
		catch(Exception e)
		{
			logger.info("Error readEvento {}",e.toString());
			throw new CorvustecException("Error al readEvento");
		}
	}

	@Override
	public PublicacionDTO createPublicacion(PublicacionDTO publicacion) throws CorvustecException
	{
		logger.info("createProyectoInvestigacion");
		try{
			return factoryDAO.getPublicacionDAOImpl().create(publicacion);
		}
		catch(Exception e){
			logger.info("Error createProyectoInvestigacion {}",e.toString());
			throw new CorvustecException("Error al createProyectoInvestigacion");
		}
	}

	/* Organizacion */
	@Override
	public OrganizacionDTO createOrganizacion(OrganizacionDTO organizacion) throws CorvustecException
	{
		logger.info("createOrganizacion");
		try{
			return factoryDAO.getOrganizacioDAOImpl().create(organizacion);
		}
		catch(Exception e){
			logger.info("Error createOrganizacion {}",e.toString());
			throw new CorvustecException("Error al createOrganizacion");
		}
	}

	@Override
	public List<OrganizacionDTO> readOrganizacion(Object ubicacion) throws CorvustecException
	{
		logger.info("readOrganizacion");
		try{
			return factoryDAO.getOrganizacioDAOImpl().getAll(ubicacion);
		}
		catch(Exception e){
			logger.info("Error readOrganizacion {}",e.toString());
			throw new CorvustecException("Error al readOrganizacion");
		}
	}
}
