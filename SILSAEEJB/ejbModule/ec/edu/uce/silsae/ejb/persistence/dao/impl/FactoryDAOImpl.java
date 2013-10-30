package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.uce.silsae.ejb.persistence.dao.CandidatoDAO;
import ec.edu.uce.silsae.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.silsae.ejb.persistence.dao.UsuarioDAO;

@Stateless
public class FactoryDAOImpl implements FactoryDAO{
	
	@PersistenceContext(unitName = "silsaePU")
	private EntityManager entityManager;

	private UsuarioDAO usuarioDAO;
	
	private CandidatoDAO candidatoDAO;
	
	@Override
	public UsuarioDAO getUsuarioDAOImpl() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAOImpl(entityManager);
		}
		return usuarioDAO;
	}

	@Override
	public CandidatoDAO getCandidatoDAOImpl() {
		if (candidatoDAO == null) {
			candidatoDAO = new CandidatoDAOImpl(entityManager);
		}
		return candidatoDAO;
	}
	
}
