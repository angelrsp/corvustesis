package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.ciespal.redxxi.ejb.persistence.dao.CarreraDAO;
import net.ciespal.redxxi.ejb.persistence.dao.CatalogoDAO;
import net.ciespal.redxxi.ejb.persistence.dao.CentroDAO;
import net.ciespal.redxxi.ejb.persistence.dao.ContactoDAO;
import net.ciespal.redxxi.ejb.persistence.dao.DoctorDAO;
import net.ciespal.redxxi.ejb.persistence.dao.EntidadDAO;
import net.ciespal.redxxi.ejb.persistence.dao.EventoDAO;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.dao.MencionDAO;
import net.ciespal.redxxi.ejb.persistence.dao.ModalidadDAO;
import net.ciespal.redxxi.ejb.persistence.dao.NoticiaDAO;
import net.ciespal.redxxi.ejb.persistence.dao.ObservatorioDAO;
import net.ciespal.redxxi.ejb.persistence.dao.OrganizacioDAO;
import net.ciespal.redxxi.ejb.persistence.dao.ProyectoInvestigacionDAO;
import net.ciespal.redxxi.ejb.persistence.dao.PublicacionDAO;
import net.ciespal.redxxi.ejb.persistence.dao.RedDAO;
import net.ciespal.redxxi.ejb.persistence.dao.VeeduriaDAO;


@Stateless
public class FactoryDAOImpl implements FactoryDAO{
	
	@PersistenceContext(unitName = "redXXIPU")
	private EntityManager entityManager;

	private CatalogoDAO catalogoDAO;
	private CentroDAO centroDAO;
	private CarreraDAO carreraDAO;
	private EntidadDAO entidadDAO;
	private ContactoDAO contactoDAO;
	private MencionDAO mensionDAO;
	private ProyectoInvestigacionDAO proyectoInvestigacionDAO;
	private PublicacionDAO publicacionDAO;
	private EventoDAO eventoDAO;
	private OrganizacioDAO organizacioDAO;
	private DoctorDAO doctorDAO;
	private NoticiaDAO noticiaDAO;
	private ModalidadDAO modalidadDAO;
	
	private RedDAO redDAO; 
	private ObservatorioDAO observatorioDAO;
	private VeeduriaDAO veeduriaDAO;
	
	
	@Override
	public CatalogoDAO getCatalogoImpl() {
		if (catalogoDAO == null) {
			catalogoDAO = new CatalogoDAOImpl(entityManager);
		}
		return catalogoDAO;
	}

	@Override
	public CentroDAO getCentroDAOImpl() {
		if (centroDAO == null) {
			centroDAO = new CentroDAOImpl(entityManager);
		}
		return centroDAO;
	}

	@Override
	public CarreraDAO getCarreraDAOImpl() {
		if (carreraDAO == null) {
			carreraDAO = new CarreraDAOImpl(entityManager);
		}
		return carreraDAO;
	}

	@Override
	public EntidadDAO getEntidadDAOImpl() {
		if (entidadDAO == null) {
			entidadDAO = new EntidadDAOImpl(entityManager);
		}
		return entidadDAO;
	}
	
	@Override
	public ContactoDAO getContactoDAOImpl() {
		if (contactoDAO == null) {
			contactoDAO = new ContactoDAOImpl(entityManager);
		}
		return contactoDAO;
	}
	
	@Override
	public MencionDAO getMencionDAOImpl() {
		if (mensionDAO == null) {
			mensionDAO = new MencionDAOImpl(entityManager);
		}
		return mensionDAO;
	}
	
	@Override
	public ProyectoInvestigacionDAO getProyectoInvestigacionDAOImpl() {
		if (proyectoInvestigacionDAO == null) {
			proyectoInvestigacionDAO = new ProyectoInvestigacionDAOImpl(entityManager);
		}
		return proyectoInvestigacionDAO;
	}

	@Override
	public EventoDAO getEventoDAOImpl() {
		if (eventoDAO == null) {
			eventoDAO = new EventoDAOImpl(entityManager);
		}
		return eventoDAO;
	}
	
	@Override
	public PublicacionDAO getPublicacionDAOImpl() {
		if (publicacionDAO == null) {
			publicacionDAO = new PublicacionDAOImpl(entityManager);
		}
		return publicacionDAO;
	}
	
	@Override
	public OrganizacioDAO getOrganizacioDAOImpl() {
		if (organizacioDAO == null) {
			organizacioDAO = new OrganizacioDAOImpl(entityManager);
		}
		return organizacioDAO;
	}
	
	@Override
	public DoctorDAO getDoctorDAOImpl() {
		if (doctorDAO == null) {
			doctorDAO = new DoctorDAOImpl(entityManager);
		}
		return doctorDAO;
	}
	
	@Override
	public NoticiaDAO getNoticiaDAOImpl() {
		if (noticiaDAO == null) {
			noticiaDAO = new NoticiaDAOImpl(entityManager);
		}
		return noticiaDAO;
	}

	@Override
	public ModalidadDAO getModalidadDAOImpl() {
		if (modalidadDAO == null) {
			modalidadDAO = new ModalidadDAOImpl(entityManager);
		}
		return modalidadDAO;
	}
	
	@Override
	public RedDAO getRedDAOImpl() {
		if (redDAO == null) {
			redDAO = new RedDAOImpl(entityManager);
		}
		return redDAO;
	}

	@Override
	public ObservatorioDAO getObservatorioDAOImpl() {
		if (observatorioDAO == null) {
			observatorioDAO = new ObservatorioDAOImpl(entityManager);
		}
		return observatorioDAO;
	}

	@Override
	public VeeduriaDAO getVeeduriaDAOImpl() {
		if (veeduriaDAO == null) {
			veeduriaDAO = new VeeduriaDAOImpl(entityManager);
		}
		return veeduriaDAO;
	}

}
