package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.ciespal.redxxi.ejb.persistence.dao.CarreraDAO;
import net.ciespal.redxxi.ejb.persistence.dao.CatalogoDAO;
import net.ciespal.redxxi.ejb.persistence.dao.CentroDAO;
import net.ciespal.redxxi.ejb.persistence.dao.EntidadDAO;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;


@Stateless
public class FactoryDAOImpl implements FactoryDAO{
	
	@PersistenceContext(unitName = "redXXIPU")
	private EntityManager entityManager;

	private CatalogoDAO catalogoDAO;
	private CentroDAO centroDAO;
	private CarreraDAO carreraDAO;
	private EntidadDAO entidadDAO;
	
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
	public EntidadDAO getEntidadImpl() {
		if (entidadDAO == null) {
			entidadDAO = new EntidadDAOImpl(entityManager);
		}
		return entidadDAO;
	}
}
