package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.DoctorDAO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;

import com.corvustec.commons.util.CorvustecException;

public class DoctorDAOImpl extends AbstractFacadeImpl<DoctorDTO> implements DoctorDAO {

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
				
		cq.where(cb.equal(from.get("docUbicacion"), ubicacion));
		
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
	public Integer getCount() throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<DoctorDTO> cq=cb.createQuery(DoctorDTO.class);
		Root<DoctorDTO> from= cq.from(DoctorDTO.class);
		
		cq.multiselect(cb.count(from.get("docCodigo")));
		
		List<DoctorDTO> list=entityManager.createQuery(cq).getResultList();
		if(list!=null)
			return (int)(long)list.get(0).getDocCount();
		else
			return 0;
	}

	@Override
	public Integer getCount(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<DoctorDTO> cq=cb.createQuery(DoctorDTO.class);
		Root<DoctorDTO> from= cq.from(DoctorDTO.class);
		
		cq.multiselect(cb.count(from.get("docCodigo")));
		
		cq.where(cb.equal(from.get("docPais"), pais));
		
		List<DoctorDTO> list=entityManager.createQuery(cq).getResultList();
		if(list!=null)
			return (int)(long)list.get(0).getDocCount();
		else
			return 0;
	}

	
}
