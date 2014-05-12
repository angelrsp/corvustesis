package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.VeeduriaDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.VeeduriaDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

public class VeeduriaDAOImpl extends AbstractFacadeImpl<VeeduriaDTO> implements VeeduriaDAO {

	private static final Logger logger = LoggerFactory.getLogger(VeeduriaDAOImpl.class);
	
	public VeeduriaDAOImpl() {
		super();
	}

	public VeeduriaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<VeeduriaDTO> findAll(Object ubicacion) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<VeeduriaDTO> cq=cb.createQuery(VeeduriaDTO.class);
		Root<VeeduriaDTO> from= cq.from(VeeduriaDTO.class);
		
		cq.where(cb.equal(from.get("veeCiudad"), ubicacion));
		
		List<VeeduriaDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	
	@Override	
	public int count(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<VeeduriaDTO> cq;
		Root<VeeduriaDTO> from;
		List<VeeduriaDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		try{
		
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(VeeduriaDTO.class);
			
			from= cq.from(VeeduriaDTO.class);
			
			cq.multiselect(cb.count(from.get("veeCodigo")));
			
			predicateList=new ArrayList<Predicate>();
			if(pais!=null)
			{
				predicate=cb.equal(from.get("veePais"),pais);
				predicateList.add(predicate);
			}
			
			cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<VeeduriaDTO> tq=entityManager.createQuery(cq);
			
			list=tq.getResultList();
			
			if(!list.isEmpty())
				return (int)(long)list.get(0).getVeeCount();
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
