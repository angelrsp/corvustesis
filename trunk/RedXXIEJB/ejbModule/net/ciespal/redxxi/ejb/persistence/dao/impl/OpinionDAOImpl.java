package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.OpinionDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.OpinionDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

public class OpinionDAOImpl extends AbstractFacadeImpl<OpinionDTO> implements OpinionDAO{

	private static final Logger logger = LoggerFactory.getLogger(OpinionDAOImpl.class);
	
	public OpinionDAOImpl() {
		super();
	}

	public OpinionDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override	
	public int count(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<OpinionDTO> cq;
		Root<OpinionDTO> from;
		List<OpinionDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		try{
		
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(OpinionDTO.class);
			
			from= cq.from(OpinionDTO.class);
			
			cq.multiselect(cb.count(from.get("opiCodigo")));
			
			predicateList=new ArrayList<Predicate>();
			if(pais!=null)
			{
				predicate=cb.equal(from.get("opiPais"),pais);
				predicateList.add(predicate);
			}
			
			cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<OpinionDTO> tq=entityManager.createQuery(cq);
			
			list=tq.getResultList();
			
			if(!list.isEmpty())
				return (int)(long)list.get(0).getOpiCount();
			else
				return 0;
			
		}catch(Exception e){
			logger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
			predicate=null;
			predicateList=null;
		}
	}

}
