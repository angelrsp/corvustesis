package ec.edu.uce.notas.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.notas.ejb.persistence.dao.IndicadorDAO;
import ec.edu.uce.notas.ejb.persistence.entity.IndicadorDTO;
import ec.edu.uce.notas.ejb.persistence.entity.ModeloDTO;

public class IndicadorDAOImpl extends AbstractFacadeImpl<IndicadorDTO> implements IndicadorDAO{
	
	public IndicadorDAOImpl() {
	}

	public IndicadorDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<IndicadorDTO> getRoot(IndicadorDTO indicadorDTO)
	{
		//log.info("getRoot");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<IndicadorDTO> cq=cb.createQuery(IndicadorDTO.class);
		Root<IndicadorDTO> from= cq.from(IndicadorDTO.class);
		//from.join("indIndicador",JoinType.LEFT).get("indCodigo").isNull();
		Path<ModeloDTO> join2=from.join("indModeloBean");
		
		cq.where(cb.equal(join2.get("modCodigo"), indicadorDTO.getIndModeloBean().getModCodigo()),cb.isNull(from.join("indIndicador",JoinType.LEFT)));
		
		cq.orderBy(cb.asc(from.get("indOrden")));
		
		List<IndicadorDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	@Override
	public List<IndicadorDTO> getChildren(IndicadorDTO indicadorDTO)
	{
		//log.info("getChildren");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<IndicadorDTO> cq=cb.createQuery(IndicadorDTO.class);
		Root<IndicadorDTO> from= cq.from(IndicadorDTO.class);
		
		cq.where(cb.equal(from.get("indIndicador"),indicadorDTO));
		
		cq.orderBy(cb.asc(from.get("indOrden")));
		
		List<IndicadorDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return new ArrayList<IndicadorDTO>();
		else
			return list;
	}

	@Override
	public List<IndicadorDTO> getAll()
	{
		//log.info("getAll");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<IndicadorDTO> cq=cb.createQuery(IndicadorDTO.class);
		cq.from(IndicadorDTO.class);
		
		List<IndicadorDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<IndicadorDTO> getAll(ModeloDTO modeloDTO)
	{
		//log.info("getRoot");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<IndicadorDTO> cq=cb.createQuery(IndicadorDTO.class);
		Root<IndicadorDTO> from= cq.from(IndicadorDTO.class);
		//from.join("indIndicador",JoinType.LEFT).get("indCodigo").isNull();
		Path<ModeloDTO> join2=from.join("indModeloBean");
		
		cq.where(cb.equal(join2.get("modCodigo"), modeloDTO.getModCodigo()));
		
		List<IndicadorDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public void remove2(IndicadorDTO indicador)
	{
		Query query;
		query=entityManager.createQuery("delete from IndicadorDTO ind where ind.indCodigo=:codigo");
		query.setParameter("codigo", indicador.getIndCodigo());
		query.executeUpdate();
	}
}
