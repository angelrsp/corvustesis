package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.dao.NoticiaDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.NoticiaDTO;

public class NoticiaDAOImpl extends AbstractFacadeImpl<NoticiaDTO> implements NoticiaDAO{

	public NoticiaDAOImpl() {
		super();
	}

	public NoticiaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<NoticiaDTO> getAll()
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<NoticiaDTO> cq=cb.createQuery(NoticiaDTO.class);
		Root<NoticiaDTO> from = cq.from(NoticiaDTO.class);
		
		Path<CarreraDTO> join1=from.join("ateEntidads",JoinType.LEFT);
		
		cq.where(cb.isNull(join1.get("entCodigo")));
		
		cq.orderBy(cb.desc(from.get("notDestacado")),cb.desc(from.get("notFecha")));
		
		List<NoticiaDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<NoticiaDTO> getAllPublic()
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<NoticiaDTO> cq=cb.createQuery(NoticiaDTO.class);
		Root<NoticiaDTO> from = cq.from(NoticiaDTO.class);
		
		Path<CarreraDTO> join1=from.join("ateEntidads",JoinType.LEFT);
		
		cq.where(cb.equal(from.get("notActivo"), true),cb.isNull(join1.get("entCodigo")));
		
		cq.orderBy(cb.desc(from.get("notDestacado")),cb.desc(from.get("notFecha")));
		
		List<NoticiaDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	
	@Override
	public void remove2(NoticiaDTO noticia) throws CorvustecException
	{
		Query query;
		query=entityManager.createQuery("delete from NoticiaDTO noti where noti.notCodigo=:codigo");
		query.setParameter("codigo", noticia.getNotCodigo());
		query.executeUpdate();
	}
}
