package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsae.ejb.persistence.dao.IdiomaDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.IdiomaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.IdiomaListDTO;

public class IdiomaDAOImpl extends AbstractFacadeImpl<IdiomaDTO> implements IdiomaDAO{

	public IdiomaDAOImpl() {
		super();
	}

	public IdiomaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	@Override
	public List<IdiomaListDTO> getAll(CandidatoDTO candidato)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<IdiomaListDTO> cq=cb.createQuery(IdiomaListDTO.class);
		Root<IdiomaListDTO> from = cq.from(IdiomaListDTO.class);
		
		cq.where(cb.equal(from.get("idiCandidato"), candidato.getCanCodigo()));
		
		List<IdiomaListDTO> list=entityManager.createQuery(cq).getResultList();
		
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
}
