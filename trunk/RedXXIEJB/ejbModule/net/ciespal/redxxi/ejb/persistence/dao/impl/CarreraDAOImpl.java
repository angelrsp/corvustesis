package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.CarreraDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;

import com.corvustec.commons.util.CorvustecException;

public class CarreraDAOImpl extends AbstractFacadeImpl<CarreraDTO> implements CarreraDAO{

	public CarreraDAOImpl() {
		super();
	}

	public CarreraDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<CarreraDTO> getAll(CentroDTO centro,Object tipo) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CarreraDTO> cq=cb.createQuery(CarreraDTO.class);
		Root<CarreraDTO> from = cq.from(CarreraDTO.class);
		
		Path<CentroDTO> join1=from.join("ateCentro");
		
		cq.where(cb.and(cb.equal(join1.get("cenCodigo"), centro.getCenCodigo()),cb.equal(from.get("carTipo"), tipo)));
		
		List<CarreraDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	
	@Override
	public List<CarreraDTO> getByType(Object type) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CarreraDTO> cq=cb.createQuery(CarreraDTO.class);
		Root<CarreraDTO> from = cq.from(CarreraDTO.class);
		
		cq.where(cb.equal(from.get("carTipo"), type));
		
		List<CarreraDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<CarreraDTO>();
		else
			return list;
	}
	
	@Override
	public Integer getPregradoCount() throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CarreraDTO> cq=cb.createQuery(CarreraDTO.class);
		Root<CarreraDTO> from = cq.from(CarreraDTO.class);
		
		cq.multiselect(cb.count(from.get("carCodigo")));
		
		cq.where(cb.equal(from.get("carTipo"), 6));
		
		List<CarreraDTO> list=entityManager.createQuery(cq).getResultList();
		if(list!=null)
			return (int)(long)list.get(0).getCarCount();
		else
			return 0;
	}

	@Override
	public Integer getPregradoCount(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CarreraDTO> cq=cb.createQuery(CarreraDTO.class);
		Root<CarreraDTO> from = cq.from(CarreraDTO.class);
		Path<CentroDTO> join1=from.join("ateCentro");
		
		cq.multiselect(cb.count(from.get("carCodigo")));
		
		cq.where(cb.and(cb.equal(from.get("carTipo"), 6)),cb.equal(join1.get("cenPais"), pais));
		
		List<CarreraDTO> list=entityManager.createQuery(cq).getResultList();
		if(list!=null)
			return (int)(long)list.get(0).getCarCount();
		else
			return 0;
	}
	
	@Override
	public Integer getPosgradoCount() throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CarreraDTO> cq=cb.createQuery(CarreraDTO.class);
		Root<CarreraDTO> from = cq.from(CarreraDTO.class);
		
		cq.multiselect(cb.count(from.get("carCodigo")));
		
		cq.where(cb.equal(from.get("carTipo"), 7));
		
		List<CarreraDTO> list=entityManager.createQuery(cq).getResultList();
		if(list!=null)
			return (int)(long)list.get(0).getCarCount();
		else
			return 0;
	}
	
	@Override
	public Integer getPosgradoCount(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CarreraDTO> cq=cb.createQuery(CarreraDTO.class);
		Root<CarreraDTO> from = cq.from(CarreraDTO.class);
		Path<CentroDTO> join1=from.join("ateCentro");
		
		cq.multiselect(cb.count(from.get("carCodigo")));
		
		cq.where(cb.and(cb.equal(from.get("carTipo"), 7)),cb.equal(join1.get("cenPais"), pais));
		
		List<CarreraDTO> list=entityManager.createQuery(cq).getResultList();
		if(list!=null)
			return (int)(long)list.get(0).getCarCount();
		else
			return 0;
	}
	
	@Override
	public List<CarreraDTO> getAll(Object type,Object pais) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CarreraDTO> cq=cb.createQuery(CarreraDTO.class);
		Root<CarreraDTO> from = cq.from(CarreraDTO.class);
		
		Path<CentroDTO> join1=from.join("ateCentro");
		
		cq.where(cb.and(cb.equal(join1.get("cenPais"), pais),cb.equal(from.get("carTipo"), type)));
		
		List<CarreraDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<CarreraDTO>();
		else
			return list;
	}
	
	@Override
	public List<CentroDTO> distinctPais(Object type,Object pais) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroDTO> cq=cb.createQuery(CentroDTO.class);
		Root<CentroDTO> from = cq.from(CentroDTO.class);
		
		Path<CarreraDTO> join1= from.join("ateCarreras");
		
		cq.multiselect(from.get("cenPais")).distinct(true);
		
		cq.where(cb.and(cb.equal(from.get("cenPais"), pais),cb.equal(join1.get("carTipo"), type)));
		
		List<CentroDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<CentroDTO>();
		else
			return list;
	}
	
	@Override
	public List<CentroDTO> distinctPais(Object type) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CentroDTO> cq=cb.createQuery(CentroDTO.class);
		Root<CentroDTO> from = cq.from(CentroDTO.class);
		
		Path<CarreraDTO> join1= from.join("ateCarreras");
		
		cq.multiselect(from.get("cenPais")).distinct(true);
		
		cq.where(cb.equal(join1.get("carTipo"), type));
		
		List<CentroDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<CentroDTO>();
		else
			return list;
	}
}
