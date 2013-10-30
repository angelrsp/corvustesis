package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import ec.edu.uce.silsae.ejb.persistence.dao.CandidatoDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;

@Stateless
public class CandidatoDAOImpl extends AbstractFacadeImpl<CandidatoDTO> implements CandidatoDAO{
	
	public CandidatoDAOImpl () {}
	
	public CandidatoDAOImpl (EntityManager entityManager) {
		super(entityManager);
	}
	
}
