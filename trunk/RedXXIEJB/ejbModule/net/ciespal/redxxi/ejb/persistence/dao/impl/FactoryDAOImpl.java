package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.ciespal.redxxi.ejb.persistence.dao.CarreraDAO;
import net.ciespal.redxxi.ejb.persistence.dao.CatalogoDAO;
import net.ciespal.redxxi.ejb.persistence.dao.CentroDAO;
import net.ciespal.redxxi.ejb.persistence.dao.ContactoDAO;
import net.ciespal.redxxi.ejb.persistence.dao.EntidadDAO;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.dao.MencionDAO;
import net.ciespal.redxxi.ejb.persistence.dao.ProyectoInvestigacionDAO;


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

}
