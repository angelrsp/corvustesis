package net.ciespal.redxxi.ejb.negocio.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EventoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.MencionDTO;
import net.ciespal.redxxi.ejb.persistence.entities.NoticiaDTO;
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
	public List<CentroDTO> obtenerCentroPadre(Object ubicacion) throws CorvustecException
	{
		logger.info("obtenerCentroPadre");
		try{
			return factoryDAO.getCentroDAOImpl().findAllPather(ubicacion);
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
	

	
	/* Contacto */
	@Override
	public ContactoDTO createOrUpdateContacto(ContactoDTO contactoDTO) throws CorvustecException
	{
		logger.info("createOrUpdateContacto");
		try{
			if(contactoDTO.getConCodigo()!=null)
				return factoryDAO.getContactoDAOImpl().edit(contactoDTO);
			else
				return factoryDAO.getContactoDAOImpl().create(contactoDTO);
		}
		catch(Exception e)
		{
			logger.info("Error createOrUpdateContacto {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateContacto");
		}		
	}

	@Override
	public void deleteContacto(ContactoDTO contactoDTO) throws CorvustecException
	{
		logger.info("deleteContacto");
		try{
			factoryDAO.getContactoDAOImpl().remove(contactoDTO);
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
	public List<ContactoListDTO> readContacto(OrganizacionDTO organizacion) throws CorvustecException
	{
		logger.info("readContacto");
		try{
			return factoryDAO.getContactoDAOImpl().getAll(organizacion);
		}
		catch(Exception e)
		{
			logger.info("Error readContacto {}",e.toString());
			throw new CorvustecException("Error al readContacto");
		}		
	}	
	
	@Override
	public List<ContactoListDTO> readContacto(DoctorDTO doctor) throws CorvustecException
	{
		logger.info("readContacto");
		try{
			return factoryDAO.getContactoDAOImpl().getAll(doctor);
		}
		catch(Exception e)
		{
			logger.info("Error readContacto {}",e.toString());
			throw new CorvustecException("Error al readContacto");
		}		
	}	
	/* Mencion */
	@Override
	public MencionDTO createOrUpdateMencion(MencionDTO mencion) throws CorvustecException
	{
		logger.info("createMencion");
		try{
			if(mencion.getMenCodigo()!=null)
				return factoryDAO.getMencionDAOImpl().edit(mencion);
			else
				return factoryDAO.getMencionDAOImpl().create(mencion);
		}
		catch(Exception e)
		{
			logger.info("Error createMencion {}",e.toString());
			throw new CorvustecException("Error al createMencion");
		}		
	}
	
	@Override
	public void deleteMencion(MencionDTO mencion) throws CorvustecException
	{
		logger.info("deleteMencion");
		try{
			factoryDAO.getMencionDAOImpl().remove(mencion);
		}
		catch(Exception e)
		{
			logger.info("Error deleteMencion {}",e.toString());
			throw new CorvustecException("Error al deleteMencion");
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
	
	/* Proyecto */
	@Override
	public ProyectoInvestigacionDTO createOrUpdateProyectoInvestigacion(ProyectoInvestigacionDTO proyecto) throws CorvustecException
	{
		logger.info("createOrUpdateProyectoInvestigacion");
		try{
			if(proyecto.getPinCodigo()!=null)
				return factoryDAO.getProyectoInvestigacionDAOImpl().edit(proyecto);
			else	
				return factoryDAO.getProyectoInvestigacionDAOImpl().create(proyecto);
		}
		catch(Exception e){
			logger.info("Error createOrUpdateProyectoInvestigacion {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateProyectoInvestigacion");
		}
	}

	@Override
	public void deleteProyectoInvestigacion(ProyectoInvestigacionDTO proyecto) throws CorvustecException
	{
		logger.info("deleteProyectoInvestigacion");
		try{
			factoryDAO.getProyectoInvestigacionDAOImpl().remove2(proyecto);
		}
		catch(Exception e){
			logger.info("Error deleteProyectoInvestigacion {}",e.toString());
			throw new CorvustecException("Error al deleteProyectoInvestigacion");
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
	public List<ProyectoInvestigacionDTO> readProyectoInvestigacion(OrganizacionDTO org) throws CorvustecException
	{
		logger.info("obtenerProyectoInvestigacion");
		try{
			return factoryDAO.getProyectoInvestigacionDAOImpl().getAll(org);
		}
		catch(Exception e)
		{
			logger.info("Error obtenerProyectoInvestigacion {}",e.toString());
			throw new CorvustecException("Error al obtenerProyectoInvestigacion");
		}
	}
	
	
	/* Evento */
	@Override
	public EventoDTO createOrUpdateEvento(EventoDTO evento) throws CorvustecException
	{
		logger.info("createProyectoInvestigacion");
		try{
			if(evento.getEveCodigo()!=null)
				return factoryDAO.getEventoDAOImpl().edit(evento);
			else
				return factoryDAO.getEventoDAOImpl().create(evento);
		}
		catch(Exception e){
			logger.info("Error createProyectoInvestigacion {}",e.toString());
			throw new CorvustecException("Error al createProyectoInvestigacion");
		}
	}
	
	@Override
	public void deleteEvento(EventoDTO evento) throws CorvustecException
	{
		logger.info("createProyectoInvestigacion");
		try{
			factoryDAO.getEventoDAOImpl().remove2(evento);
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
	public List<EventoDTO> readEvento(OrganizacionDTO org) throws CorvustecException
	{
		logger.info("readEvento");
		try{
			return factoryDAO.getEventoDAOImpl().getAll(org);
		}
		catch(Exception e)
		{
			logger.info("Error readEvento {}",e.toString());
			throw new CorvustecException("Error al readEvento");
		}
	}
	
	
	/* Publicacion */
	@Override
	public PublicacionDTO createOrUpdatePublicacion(PublicacionDTO publicacion) throws CorvustecException
	{
		logger.info("createOrUpdatePublicacion");
		try{
			if(publicacion.getPubCodigo()!=null)
				return factoryDAO.getPublicacionDAOImpl().edit(publicacion);
			else			
			{
				publicacion.addAteEntidad(new EntidadDTO());
				return factoryDAO.getPublicacionDAOImpl().create(publicacion);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdatePublicacion {}",e.toString());
			throw new CorvustecException("Error al createOrUpdatePublicacion");
		}
	}

	
	@Override
	public void deletePublicacion(PublicacionDTO publicacion) throws CorvustecException
	{
		logger.info("createOrUpdatePublicacion");
		try{
			factoryDAO.getPublicacionDAOImpl().remove2(publicacion);
		}
		catch(Exception e){
			logger.info("Error createOrUpdatePublicacion {}",e.toString());
			throw new CorvustecException("Error al createOrUpdatePublicacion");
		}
	}
	
	@Override
	public List<PublicacionDTO> readPublicacion(CarreraDTO carrera) throws CorvustecException
	{
		logger.info("readPublicacion");
		try{
			return factoryDAO.getPublicacionDAOImpl().getAll(carrera);
		}
		catch(Exception e)
		{
			logger.info("Error readPublicacion {}",e.toString());
			throw new CorvustecException("Error al readPublicacion");
		}
	}

	@Override
	public List<PublicacionDTO> readPublicacion(Object ubicacion) throws CorvustecException
	{
		logger.info("readPublicacion");
		try{
			return factoryDAO.getPublicacionDAOImpl().getAll(ubicacion);
		}
		catch(Exception e)
		{
			logger.info("Error readPublicacion {}",e.toString());
			throw new CorvustecException("Error al readPublicacion");
		}
	}

	@Override
	public List<PublicacionDTO> readPublicacion() throws CorvustecException
	{
		logger.info("readPublicacion");
		try{
			return factoryDAO.getPublicacionDAOImpl().getAll();
		}
		catch(Exception e)
		{
			logger.info("Error readPublicacion {}",e.toString());
			throw new CorvustecException("Error al readPublicacion");
		}
	}
	/* Organizacion */
	@Override
	public OrganizacionDTO createOrUpdateOrganizacion(OrganizacionDTO organizacion) throws CorvustecException
	{
		logger.info("createOrganizacion");
		try{
			if(organizacion.getOrgCodigo()!=null)
				return factoryDAO.getOrganizacioDAOImpl().edit(organizacion);
			else
			{
				organizacion.addAteEntidad(new EntidadDTO());
				return factoryDAO.getOrganizacioDAOImpl().create(organizacion);
			}
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
	
	

	
	/* Doctor */
	@Override
	public DoctorDTO createOrUpdateDoctor(DoctorDTO doctor) throws CorvustecException
	{
		logger.info("createOrUpdateDoctor");
		try{
			if(doctor.getDocCodigo()!=null)
				return factoryDAO.getDoctorDAOImpl().edit(doctor);
			else
			{
				doctor.addAteEntidad(new EntidadDTO());
				return factoryDAO.getDoctorDAOImpl().create(doctor);
			}
		}
		catch(Exception e){
			logger.info("Error createOrUpdateDoctor {}",e.toString());
			throw new CorvustecException("Error al createOrUpdateDoctor");
		}
	}
	
	
	
	@Override
	public List<DoctorDTO> readDoctor(Object ubicacion) throws CorvustecException
	{
		logger.info("readDoctor");
		try{
			return factoryDAO.getDoctorDAOImpl().getAll(ubicacion);
		}
		catch(Exception e)
		{
			logger.info("Error readDoctor {}",e.toString());
			throw new CorvustecException("Error al readDoctor");
		}
	}
	
	/* Noticia */	
	@Override
	public NoticiaDTO createOrUpdateNoticia(NoticiaDTO noticia) throws CorvustecException
	{
		logger.info("createNoticia");
		try{
			noticia.setNotFecha(new Timestamp(new Date().getTime()));
			if(noticia.getNotCodigo()!=null)
				return factoryDAO.getNoticiaDAOImpl().edit(noticia);
			else
				return factoryDAO.getNoticiaDAOImpl().create(noticia);
		}
		catch(Exception e){
			logger.info("Error createNoticia {}",e.toString());
			throw new CorvustecException("Error al createNoticia");
		}
	}

	@Override
	public void deleteNoticia(NoticiaDTO noticia) throws CorvustecException
	{
		logger.info("createNoticia");
		try{
			factoryDAO.getNoticiaDAOImpl().remove2(noticia);
		}
		catch(Exception e){
			logger.info("Error createNoticia {}",e.toString());
			throw new CorvustecException("Error al createNoticia");
		}
	}

	@Override
	public List<NoticiaDTO> readNoticia() throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaDAOImpl().getAll();
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

	@Override
	public List<NoticiaDTO> readNoticiaPublic() throws CorvustecException
	{
		logger.info("readNoticia");
		try{
			return factoryDAO.getNoticiaDAOImpl().getAllPublic();
		}
		catch(Exception e)
		{
			logger.info("Error readNoticia {}",e.toString());
			throw new CorvustecException("Error al readNoticia");
		}
	}

}
