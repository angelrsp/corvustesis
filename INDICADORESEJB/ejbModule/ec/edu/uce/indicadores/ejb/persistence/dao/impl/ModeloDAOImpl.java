package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.dao.ModeloDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ModeloDTO;

public class ModeloDAOImpl extends AbstractFacadeImpl<ModeloDTO> implements ModeloDAO{

	private static final Logger log = LoggerFactory
			.getLogger(ModeloDAOImpl.class);
	
	public ModeloDAOImpl() {
	
	}

	public ModeloDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ModeloDTO> getAll() throws IndicadoresException
	{
		log.info("getAll");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ModeloDTO> cq=cb.createQuery(ModeloDTO.class);
		cq.from(ModeloDTO.class);
		
		//cq.where(cb.greaterThan(from.get("iesCodigo").as(Integer.class), 1));
		
		List<ModeloDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public void remove2(ModeloDTO modelo)
	{
		Query query;
		query=entityManager.createQuery("delete from ModeloDTO mod where mod.modCodigo=:codigo");
		query.setParameter("codigo", modelo.getModCodigo());
		query.executeUpdate();

	}
}
