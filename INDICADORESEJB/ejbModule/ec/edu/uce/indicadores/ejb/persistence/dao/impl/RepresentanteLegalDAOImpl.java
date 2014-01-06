package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.dao.RepresentanteLegalDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalDTO;

public class RepresentanteLegalDAOImpl extends AbstractFacadeImpl<RepresentanteLegalDTO> implements RepresentanteLegalDAO{

	
	private static final Logger log = LoggerFactory
			.getLogger(RepresentanteLegalDAOImpl.class);

	public RepresentanteLegalDAOImpl() {
	}

	public RepresentanteLegalDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	

	@Override
	public List<RepresentanteLegalDTO> getAll() throws IndicadoresException
	{
		log.info("getAll");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<RepresentanteLegalDTO> cq=cb.createQuery(RepresentanteLegalDTO.class);
		cq.from(RepresentanteLegalDTO.class);
			
		List<RepresentanteLegalDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
}
