package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.dao.CandidatoDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDatoDTO;

@Stateless
public class CandidatoDAOImpl extends AbstractFacadeImpl<CandidatoDTO> implements CandidatoDAO{
	
	public CandidatoDAOImpl () {}
	
	public CandidatoDAOImpl (EntityManager entityManager) {
		super(entityManager);
	}

	
	
	@Override
	public List<CandidatoDTO> getAll() throws SilsaeException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CandidatoDTO> cq=cb.createQuery(CandidatoDTO.class);
		cq.from(CandidatoDTO.class);
				
		List<CandidatoDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<CandidatoDatoDTO> getData(CandidatoDTO can) throws SilsaeException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CandidatoDatoDTO> cq=cb.createQuery(CandidatoDatoDTO.class);
		Root<CandidatoDatoDTO> from =cq.from(CandidatoDatoDTO.class);
		
		cq.where(cb.equal(from.get("canCodigo"), can.getCanCodigo()));
				
		List<CandidatoDatoDTO> list=entityManager.createQuery(cq).getResultList();
		
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
