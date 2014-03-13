package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.PublicacionDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PublicacionDTO;

import com.corvustec.commons.util.CorvustecException;

public class PublicacionDAOImpl extends AbstractFacadeImpl<PublicacionDTO> implements PublicacionDAO {

	public PublicacionDAOImpl() {
		super();
	}

	public PublicacionDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<PublicacionDTO> getAll(CarreraDTO carrera) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PublicacionDTO> cq=cb.createQuery(PublicacionDTO.class);
		Root<PublicacionDTO> from = cq.from(PublicacionDTO.class);
		
		Path<CarreraDTO> join1=from.join("ateEntidads");
		
		cq.where(cb.equal(join1.get("ateCarrera"), carrera.getCarCodigo()));
		
		List<PublicacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	
	@Override
	public List<PublicacionDTO> getAll(Object ubicacion) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PublicacionDTO> cq=cb.createQuery(PublicacionDTO.class);
		Root<PublicacionDTO> from = cq.from(PublicacionDTO.class);
		
		cq.where(cb.equal(from.get("pubCiudad"),ubicacion));
		
		List<PublicacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	
	@Override
	public List<PublicacionDTO> getAllNoEntity(Object ubicacion) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PublicacionDTO> cq=cb.createQuery(PublicacionDTO.class);
		Root<PublicacionDTO> from = cq.from(PublicacionDTO.class);
		
		Path<EntidadDTO> join1=from.join("ateEntidads",JoinType.LEFT);
		
		cq.where(cb.and(cb.equal(from.get("pubCiudad"),ubicacion),cb.isNull(join1.get("atePublicacion").get("pubCodigo"))));
		
		List<PublicacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<PublicacionDTO> getAll() throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PublicacionDTO> cq=cb.createQuery(PublicacionDTO.class);
		cq.from(PublicacionDTO.class);
		
		List<PublicacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}	
	
	@Override
	public List<PublicacionDTO> getByType(Object type) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PublicacionDTO> cq=cb.createQuery(PublicacionDTO.class);
		Root<PublicacionDTO>from =cq.from(PublicacionDTO.class);
		
		cq.where(cb.equal(from.get("pubTipo"), type));
		
		List<PublicacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<PublicacionDTO>();
		else
			return list;
	}	

	@Override
	public Integer getCountByType(Object type) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PublicacionDTO> cq=cb.createQuery(PublicacionDTO.class);
		Root<PublicacionDTO>from =cq.from(PublicacionDTO.class);
		
		cq.multiselect(cb.count(from.get("pubCodigo")));
		
		cq.where(cb.equal(from.get("pubTipo"), type));
		
		List<PublicacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list!=null)
			return (int)(long)list.get(0).getPubCount();
		else
			return 0;
	}	

	@Override
	public Integer getCountByType(Object type,Object pais) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PublicacionDTO> cq=cb.createQuery(PublicacionDTO.class);
		Root<PublicacionDTO>from =cq.from(PublicacionDTO.class);
		
		cq.multiselect(cb.count(from.get("pubCodigo")));
		
		cq.where(cb.and(cb.equal(from.get("pubTipo"), type),cb.equal(from.get("pubPais"), pais)));
		
		List<PublicacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list!=null)
			return (int)(long)list.get(0).getPubCount();
		else
			return 0;
	}	

	
	@Override
	public void remove2(PublicacionDTO pub)
	{
		Query query;
		for(EntidadDTO ent:pub.getAteEntidads())
		{	 
			query= entityManager.createQuery("delete from EntidadDTO where entCodigo=:codigo");
			query.setParameter("codigo", ent.getEntCodigo());
			query.executeUpdate();
		}
		
		query= entityManager.createQuery("delete from PublicacionDTO where pubCodigo=:codigo");
		query.setParameter("codigo", pub.getPubCodigo());
		query.executeUpdate();
	}
}
