package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.dao.ExperienciaDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ExperienciaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ExperienciaListDTO;

public class ExperienciaDAOImpl extends AbstractFacadeImpl<ExperienciaDTO> implements ExperienciaDAO{

	public ExperienciaDAOImpl() {
		super();
	}

	public ExperienciaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<ExperienciaListDTO> getAll(CandidatoDTO candidato) throws SilsaeException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ExperienciaListDTO> cq=cb.createQuery(ExperienciaListDTO.class);
		Root<ExperienciaListDTO> from = cq.from(ExperienciaListDTO.class);
		cq.where(cb.equal(from.get("expCandidato"), candidato.getCanCodigo()));
		List<ExperienciaListDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
