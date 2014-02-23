package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.dao.RepresentanteLegalDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalListDTO;

public class RepresentanteLegalDAOImpl extends AbstractFacadeImpl<RepresentanteLegalDTO> implements RepresentanteLegalDAO{

	
	private static final Logger log = LoggerFactory
			.getLogger(RepresentanteLegalDAOImpl.class);

	public RepresentanteLegalDAOImpl() {
	}

	public RepresentanteLegalDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	

	@Override
	public List<RepresentanteLegalListDTO> getAll() throws IndicadoresException
	{
		log.info("getAll");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<RepresentanteLegalListDTO> cq=cb.createQuery(RepresentanteLegalListDTO.class);
		cq.from(RepresentanteLegalListDTO.class);
			
		List<RepresentanteLegalListDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public void remove2(RepresentanteLegalDTO representante)
	{
		Query query;
		
		query=entityManager.createQuery("delete from ContactoDTO con where con.indRepresentanteLegal.rleCodigo=:codigo");
		query.setParameter("codigo", representante.getRleCodigo());
		query.executeUpdate();
		
		
		query=entityManager.createQuery("delete from RepresentanteLegalDTO rep where rep.rleCodigo=:codigo");
		query.setParameter("codigo", representante.getRleCodigo());
		query.executeUpdate();
	}
	
}
