package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsag.ejb.persistence.dao.RespuestaDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.ControlDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.RespuestaDTO;

public class RespuestaDAOImpl extends AbstractFacadeImpl<RespuestaDTO> implements RespuestaDAO{

	public RespuestaDAOImpl() {
		super();
	}

	public RespuestaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}


	@Override
	public List<RespuestaDTO> getAll()
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<RespuestaDTO> cq=cb.createQuery(RespuestaDTO.class);
		Root<RespuestaDTO> from= cq.from(RespuestaDTO.class);
		cq.orderBy(cb.asc(from.get("resCodigo")));
		
		List<RespuestaDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<RespuestaDTO> getByType(int type)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<RespuestaDTO> cq=cb.createQuery(RespuestaDTO.class);
		Root<RespuestaDTO> from= cq.from(RespuestaDTO.class);
		Path<ControlDTO> join=from.join("bemControl");
		
		cq.where(cb.equal(join.get("conCodigo"), type));
		
		cq.orderBy(cb.asc(from.get("resCodigo")));
		
		List<RespuestaDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
}
