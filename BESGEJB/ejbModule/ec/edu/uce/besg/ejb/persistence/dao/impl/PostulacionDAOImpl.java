package ec.edu.uce.besg.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import ec.edu.uce.besg.ejb.persistence.dao.PostulacionDAO;
import ec.edu.uce.besg.ejb.persistence.entity.PostulacionDTO;


@Stateless
public class PostulacionDAOImpl extends AbstractFacadeImpl<PostulacionDTO> implements PostulacionDAO{

	public PostulacionDAOImpl() {
		super();
	}

	public PostulacionDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	

}
