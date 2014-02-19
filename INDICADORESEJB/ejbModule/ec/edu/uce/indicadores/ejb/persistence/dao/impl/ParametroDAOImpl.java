package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import ec.edu.uce.indicadores.ejb.persistence.dao.ParametroDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ParametroDTO;

public class ParametroDAOImpl extends AbstractFacadeImpl<ParametroDTO> implements ParametroDAO {

	public ParametroDAOImpl() {
		super();
	}

	public ParametroDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	
}
