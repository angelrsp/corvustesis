package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import ec.edu.uce.silsae.ejb.persistence.dao.PostulacionDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.PostulacionDTO;

@Stateless
public class PostulacionDAOImpl extends AbstractFacadeImpl<PostulacionDTO> implements PostulacionDAO{

	public PostulacionDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostulacionDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}


	
}
