package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.PublicacionVieDAO;
import net.ciespal.redxxi.ejb.persistence.entities.PublicacionVieDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

public class PublicacionVieDAOImpl extends AbstractFacadeImpl<PublicacionVieDTO> implements PublicacionVieDAO{

	private static final Logger logger = LoggerFactory.getLogger(DoctorVieDAOImpl.class);
	
	public PublicacionVieDAOImpl() {
		super();
	}

	public PublicacionVieDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<PublicacionVieDTO> get(PublicacionVieDTO publicacion) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<PublicacionVieDTO> cq;
		Root<PublicacionVieDTO> from;
		List<PublicacionVieDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(PublicacionVieDTO.class);
			
			from= cq.from(PublicacionVieDTO.class);
			
			predicateList=new ArrayList<Predicate>();
						
			if(publicacion.getPubCodigo()!=null && publicacion.getPubCodigo()!=0)
			{
				predicate=cb.equal(from.get("pubCodigo"),publicacion.getPubCodigo());
				predicateList.add(predicate);
			}
			
			cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<PublicacionVieDTO> tq=entityManager.createQuery(cq);
			list=tq.getResultList();
			
			return list;
			
		}catch(Exception e){
			logger.info(e.toString());
			throw new CorvustecException(e);
		}finally{
			predicate=null;
			predicateList=null;
		}		
	}

}
