package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.uce.silsae.ejb.persistence.dao.AvisoDAO;
import ec.edu.uce.silsae.ejb.persistence.dao.CandidatoDAO;
import ec.edu.uce.silsae.ejb.persistence.dao.CatalogoDAO;
import ec.edu.uce.silsae.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.silsae.ejb.persistence.dao.PerfilDAO;
import ec.edu.uce.silsae.ejb.persistence.dao.UsuarioDAO;

@Stateless
public class FactoryDAOImpl implements FactoryDAO{
	
	@PersistenceContext(unitName = "silsaePU")
	private EntityManager entityManager;

	private UsuarioDAO usuarioDAO;
	
	private CandidatoDAO candidatoDAO;
	
	private AvisoDAO avisoDAO;
	
	private PerfilDAO perfilDAO;
	
	private CatalogoDAO catalogoDAO; 
	
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

	@Override
	public AvisoDAO getAvisoDAOImpl() {
		if (avisoDAO == null) {
			avisoDAO = new AvisoDAOImpl(entityManager);
		}
		return avisoDAO;
	}

	@Override
	public PerfilDAO getPerfilDAOImpl() {
		if (perfilDAO == null) {
			perfilDAO = new PerfilDAOImpl(entityManager);
		}
		return perfilDAO;	
	}

	@Override
	public CatalogoDAO getCatalogoImpl() {
		if (catalogoDAO == null) {
			catalogoDAO = new CatalogoDAOImpl(entityManager);
		}
		return catalogoDAO;	
	}

}
