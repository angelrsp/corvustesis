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
import ec.edu.uce.indicadores.ejb.persistence.dao.RegistroDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RegistroDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalDTO;

public class RegistroDAOImpl extends AbstractFacadeImpl<RegistroDTO> implements RegistroDAO{

	private static final Logger logger = LoggerFactory
			.getLogger(RegistroDAOImpl.class);

	
	public RegistroDAOImpl() {
		super();
	}

	public RegistroDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<RegistroDTO> getAll(RepresentanteLegalDTO representanteLegalDTO,IesDTO iesDTO) throws IndicadoresException
	{
		logger.info("getAll");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<RegistroDTO> cq=cb.createQuery(RegistroDTO.class);
		Root<RegistroDTO> from= cq.from(RegistroDTO.class);
		Path<RepresentanteLegalDTO> join1=from.join("indRepresentanteLegal");
		Path<IesDTO> join2=from.join("indy");
		
		cq.where(cb.and(cb.equal(join1.get("rleCodigo"), representanteLegalDTO.getRleCodigo()),cb.equal(join2.get("iesCodigo"), iesDTO.getIesCodigo())));
		
		List<RegistroDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	
	@Override
	public List<RegistroDTO> getAll(IesDTO iesDTO) throws IndicadoresException
	{
		logger.info("getAll");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<RegistroDTO> cq=cb.createQuery(RegistroDTO.class);
		Root<RegistroDTO> from= cq.from(RegistroDTO.class);
		Path<IesDTO> join2=from.join("indy");
		
		cq.where(cb.equal(join2.get("iesCodigo"), iesDTO.getIesCodigo()));
		
		List<RegistroDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
