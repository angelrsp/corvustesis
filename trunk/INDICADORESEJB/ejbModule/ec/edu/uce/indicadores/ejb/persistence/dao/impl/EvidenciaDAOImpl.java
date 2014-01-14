package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.dao.EvidenciaDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.EvidenciaDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.HistoricoIndicadorDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IndicadorDTO;

public class EvidenciaDAOImpl extends AbstractFacadeImpl<EvidenciaDTO> implements EvidenciaDAO{

	private static final Logger logger = LoggerFactory
			.getLogger(IesDAOImpl.class);

	
	public EvidenciaDAOImpl() {
		super();
	}

	public EvidenciaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<EvidenciaDTO> getAll(HistoricoIndicadorDTO historicoIndicadorDTO) throws IndicadoresException
	{
		logger.info("getAll");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EvidenciaDTO> cq=cb.createQuery(EvidenciaDTO.class);
		Root<EvidenciaDTO> from= cq.from(EvidenciaDTO.class);
		Path<HistoricoIndicadorDTO> join=from.join("indHistoricoIndicador");
		
		cq.where(cb.equal(join.get("hinCodigo"), historicoIndicadorDTO.getHinCodigo()));
		
		List<EvidenciaDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
