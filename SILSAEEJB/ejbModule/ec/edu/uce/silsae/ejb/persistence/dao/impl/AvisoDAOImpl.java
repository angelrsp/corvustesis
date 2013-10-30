package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import ec.edu.uce.silsae.ejb.persistence.dao.AvisoDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.AvisoDTO;

@Stateless
public class AvisoDAOImpl extends AbstractFacadeImpl<AvisoDTO> implements AvisoDAO{

	public AvisoDAOImpl () {}
	
	public AvisoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
