package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.dao.IesDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;

public class IesDAOImpl extends AbstractFacadeImpl<IesDTO> implements IesDAO{

	private static final Logger log = LoggerFactory
			.getLogger(IesDAOImpl.class);

	
	public IesDAOImpl() {
	}

	public IesDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}


	@Override
	public List<IesDTO> getAll() throws IndicadoresException
	{
		log.info("getAll");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<IesDTO> cq=cb.createQuery(IesDTO.class);
		Root<IesDTO> from= cq.from(IesDTO.class);
		
		cq.where(cb.greaterThan(from.get("iesCodigo").as(Integer.class), 1));
		
		List<IesDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	
	
}
