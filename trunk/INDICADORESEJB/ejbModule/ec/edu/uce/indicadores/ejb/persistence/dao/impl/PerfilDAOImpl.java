package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.dao.PerfilDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;

public class PerfilDAOImpl extends AbstractFacadeImpl<PerfilDTO> implements PerfilDAO {

	private static final Logger log = LoggerFactory
			.getLogger(PerfilDAOImpl.class);
	
	
	public PerfilDAOImpl() {
		super();
	}

	public PerfilDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	@Override
	public List<PerfilDTO> getByName(PerfilDTO perfil) throws IndicadoresException
	{
		log.info("getByName");
		
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PerfilDTO> cq=cb.createQuery(PerfilDTO.class);
		Root<PerfilDTO> from= cq.from(PerfilDTO.class);
		
		cq.where(cb.equal(from.get("perDescripcion"), perfil.getPerDescripcion()));
		
		List<PerfilDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	
	
	@Override
	public void remove2(PerfilDTO perfil) throws IndicadoresException
	{
		Query query;
		query=entityManager.createQuery("delete from PerfilDTO where perCodigo=:codigo");
		query.setParameter("codigo", perfil.getPerCodigo());
		query.executeUpdate();
	}
	
	
}
