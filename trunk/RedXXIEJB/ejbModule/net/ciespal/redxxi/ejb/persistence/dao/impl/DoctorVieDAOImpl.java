package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.DoctorVieDAO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorVieDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

public class DoctorVieDAOImpl extends AbstractFacadeImpl<DoctorVieDTO> implements DoctorVieDAO{

	private static final Logger logger = LoggerFactory.getLogger(DoctorVieDAOImpl.class);
	
	public DoctorVieDAOImpl() {
		super();
	}

	public DoctorVieDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<DoctorVieDTO> get(DoctorVieDTO doctorVieDTO) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<DoctorVieDTO> cq;
		Root<DoctorVieDTO> from;
		List<DoctorVieDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		try{
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(DoctorVieDTO.class);
			
			from= cq.from(DoctorVieDTO.class);
			
			predicateList=new ArrayList<Predicate>();
						
			if(doctorVieDTO.getDocCodigo()!=null && doctorVieDTO.getDocCodigo()!=0)
			{
				predicate=cb.equal(from.get("docCodigo"),doctorVieDTO.getDocCodigo());
				predicateList.add(predicate);
			}

			if(doctorVieDTO.getDocPais()!=null && doctorVieDTO.getDocPais()!=0)
			{
				predicate=cb.equal(from.get("docPais"),doctorVieDTO.getDocPais());
				predicateList.add(predicate);
			}

			
			cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<DoctorVieDTO> tq=entityManager.createQuery(cq);
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
