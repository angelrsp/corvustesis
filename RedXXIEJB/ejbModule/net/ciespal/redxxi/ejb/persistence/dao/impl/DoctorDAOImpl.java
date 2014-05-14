package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.DoctorDAO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;

public class DoctorDAOImpl extends AbstractFacadeImpl<DoctorDTO> implements DoctorDAO {

	
	private static final Logger logger = LoggerFactory.getLogger(DoctorDAOImpl.class);
	
	public DoctorDAOImpl() {
		super();
	}

	public DoctorDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<DoctorDTO> getAll(Object ubicacion) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<DoctorDTO> cq=cb.createQuery(DoctorDTO.class);
		Root<DoctorDTO> from = cq.from(DoctorDTO.class);
				
		cq.where(cb.equal(from.get("docCiudad"), ubicacion));
		
		List<DoctorDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<DoctorDTO> getAll() throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<DoctorDTO> cq=cb.createQuery(DoctorDTO.class);
		cq.from(DoctorDTO.class);
				
		List<DoctorDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<DoctorDTO>();
		else
			return list;
	}

	@Override
	public Integer getCount(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb;
		CriteriaQuery<DoctorDTO> cq;
		Root<DoctorDTO> from;
		List<DoctorDTO> list;
		Predicate predicate;
		List<Predicate> predicateList = null;
		try{
		
			cb=entityManager.getCriteriaBuilder();
			cq=cb.createQuery(DoctorDTO.class);
			
			from= cq.from(DoctorDTO.class);
			
			cq.multiselect(cb.count(from.get("docCodigo")));
			
			predicateList=new ArrayList<Predicate>();
			if(pais!=null)
			{
				predicate=cb.equal(from.get("docPais"),pais);
				predicateList.add(predicate);
			}
			
			cq.where(cb.and(predicateList.toArray(new Predicate[0])));		
			
			TypedQuery<DoctorDTO> tq=entityManager.createQuery(cq);
			
			list=tq.getResultList();
			
			if(!list.isEmpty())
				return (int)(long)list.get(0).getDocCount();
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
	
	@Override
	public List<DoctorDTO> getAll2(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<DoctorDTO> cq=cb.createQuery(DoctorDTO.class);
		Root<DoctorDTO> from= cq.from(DoctorDTO.class);
		
		cq.where(cb.equal(from.get("docPais"), pais));
		
		List<DoctorDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<DoctorDTO>();
		else
			return list;
	}


	
//	@Override
//	public List<DoctorListDTO> get(Object codigo) throws CorvustecException
//	{
//		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
//		CriteriaQuery<DoctorListDTO> cq=cb.createQuery(DoctorListDTO.class);
//		Root<DoctorListDTO> from= cq.from(DoctorListDTO.class);
//		
//		cq.where(cb.equal(from.get("docCodigo"), codigo));
//		
//		List<DoctorListDTO> list=entityManager.createQuery(cq).getResultList();
//		if(list.isEmpty())
//			return new ArrayList<DoctorListDTO>();
//		else
//			return list;
//	}	
	
	@Override
	public void remove2(DoctorDTO doctor)
	{
		Query query;
		query=entityManager.createQuery("delete from DoctorDTO doc where doc.docCodigo=:codigo");
		query.setParameter("codigo", doctor.getDocCodigo());
		query.executeUpdate();
	}

}
