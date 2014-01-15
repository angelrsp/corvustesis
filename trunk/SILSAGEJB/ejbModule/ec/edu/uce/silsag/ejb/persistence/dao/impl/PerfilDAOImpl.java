package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import ec.edu.uce.silsag.ejb.persistence.dao.PerfilDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.PerfilDTO;

public class PerfilDAOImpl extends AbstractFacadeImpl<PerfilDTO> implements  PerfilDAO{

	public PerfilDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PerfilDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	
}
