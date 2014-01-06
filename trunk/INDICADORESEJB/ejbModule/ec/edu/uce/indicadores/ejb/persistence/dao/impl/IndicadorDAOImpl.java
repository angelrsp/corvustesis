package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.indicadores.ejb.persistence.dao.IndicadorDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IndicadorDTO;

public class IndicadorDAOImpl extends AbstractFacadeImpl<IndicadorDTO> implements IndicadorDAO{
	
	private static final Logger log = LoggerFactory
			.getLogger(IndicadorDAOImpl.class);
	
	public IndicadorDAOImpl() {
	}

	public IndicadorDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<IndicadorDTO> getRoot(IndicadorDTO indicadorDTO)
	{
		log.info("getRoot");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<IndicadorDTO> cq=cb.createQuery(IndicadorDTO.class);
		Root<IndicadorDTO> from= cq.from(IndicadorDTO.class);
		//from.join("indIndicador",JoinType.LEFT).get("indCodigo").isNull();
		
		cq.where(cb.isNull(from.join("indIndicador",JoinType.LEFT)));
		
		List<IndicadorDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	@Override
	public List<IndicadorDTO> getChildren(IndicadorDTO indicadorDTO)
	{
		log.info("getChildren");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<IndicadorDTO> cq=cb.createQuery(IndicadorDTO.class);
		Root<IndicadorDTO> from= cq.from(IndicadorDTO.class);
		
		cq.where(cb.equal(from.get("indPredecesor"),indicadorDTO.getIndCodigo()));
		
		List<IndicadorDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	@Override
	public List<IndicadorDTO> getAll()
	{
		log.info("getAll");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<IndicadorDTO> cq=cb.createQuery(IndicadorDTO.class);
		cq.from(IndicadorDTO.class);
		
		List<IndicadorDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
