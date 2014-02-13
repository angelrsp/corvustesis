package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import ec.edu.uce.indicadores.ejb.persistence.dao.PerfilDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;

public class PerfilDAOImpl extends AbstractFacadeImpl<PerfilDTO> implements PerfilDAO {

	public PerfilDAOImpl() {
		super();
	}

	public PerfilDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
}
