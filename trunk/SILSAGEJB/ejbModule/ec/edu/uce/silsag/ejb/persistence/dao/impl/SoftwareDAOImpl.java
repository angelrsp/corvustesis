package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.dao.SoftwareDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.SoftwareDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.SoftwareListDTO;

public class SoftwareDAOImpl extends AbstractFacadeImpl<SoftwareDTO> implements SoftwareDAO{

	public SoftwareDAOImpl() {
		super();
	}

	public SoftwareDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<SoftwareListDTO> getAll(CandidatoDTO candidato) throws SilsagException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<SoftwareListDTO> cq=cb.createQuery(SoftwareListDTO.class);
		Root<SoftwareListDTO> from = cq.from(SoftwareListDTO.class);
		
		cq.where(cb.equal(from.get("proCandidato"), candidato.getCanCodigo()));
		
		List<SoftwareListDTO> list=entityManager.createQuery(cq).getResultList();
		
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
