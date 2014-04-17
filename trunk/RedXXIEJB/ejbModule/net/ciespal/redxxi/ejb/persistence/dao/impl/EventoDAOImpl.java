package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.EventoDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EventoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;

import com.corvustec.commons.util.CorvustecException;

public class EventoDAOImpl extends AbstractFacadeImpl<EventoDTO> implements EventoDAO{

	public EventoDAOImpl() {
		super();
	}

	public EventoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<EventoDTO> getAll(CarreraDTO carrera) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EventoDTO> cq=cb.createQuery(EventoDTO.class);
		Root<EventoDTO> from = cq.from(EventoDTO.class);
		
		Path<CarreraDTO> join1=from.join("ateEntidads");
		
		cq.where(cb.equal(join1.get("ateCarrera"), carrera.getCarCodigo()));
		
		List<EventoDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<EventoDTO> getAll(OrganizacionDTO organizacion) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EventoDTO> cq=cb.createQuery(EventoDTO.class);
		Root<EventoDTO> from = cq.from(EventoDTO.class);
		
		Path<OrganizacionDTO> join1=from.join("ateEntidads");
		
		cq.where(cb.equal(join1.get("ateOrganizacion"), organizacion.getOrgCodigo()));
		
		List<EventoDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<EventoDTO> getAll() throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EventoDTO> cq=cb.createQuery(EventoDTO.class);
		cq.from(EventoDTO.class);
		
		List<EventoDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<EventoDTO>();
		else
			return list;
	}

	@Override
	public Integer getCount() throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EventoDTO> cq=cb.createQuery(EventoDTO.class);
		Root<EventoDTO> from= cq.from(EventoDTO.class);
		
		cq.multiselect(cb.count(from.get("eveCodigo")));
		
		List<EventoDTO> list=entityManager.createQuery(cq).getResultList();
		if(list!=null)
			return (int)(long)list.get(0).getEveCount();
		else
			return 0;
	}
	
	@Override
	public Integer getCount(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EventoDTO> cq=cb.createQuery(EventoDTO.class);
		Root<EventoDTO> from= cq.from(EventoDTO.class);
		
		cq.multiselect(cb.count(from.get("eveCodigo")));
		
		cq.where(cb.equal(from.get("evePais"), pais));
		
		List<EventoDTO> list=entityManager.createQuery(cq).getResultList();
		if(list!=null)
			return (int)(long)list.get(0).getEveCount();
		else
			return 0;
	}


	@Override
	public List<EventoDTO> getAll(Object pais) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EventoDTO> cq=cb.createQuery(EventoDTO.class);
		Root<EventoDTO> from= cq.from(EventoDTO.class);
				
		cq.where(cb.equal(from.get("evePais"), pais));
		
		List<EventoDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<EventoDTO>();
		else
			return list;
	}
	
	
	@Override
	public void remove2(EventoDTO eve)
	{
		Query query;
		for(EntidadDTO ent:eve.getAteEntidads())
		{	 
			query= entityManager.createQuery("delete from EntidadDTO where entCodigo=:codigo");
			query.setParameter("codigo", ent.getEntCodigo());
			query.executeUpdate();
		}
		
		query= entityManager.createQuery("delete from EventoDTO where eveCodigo=:codigo");
		query.setParameter("codigo", eve.getEveCodigo());
		query.executeUpdate();
	}
}
