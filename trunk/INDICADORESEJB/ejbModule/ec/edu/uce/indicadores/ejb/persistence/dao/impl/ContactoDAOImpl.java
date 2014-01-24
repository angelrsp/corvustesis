package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.persistence.dao.ContactoDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ContactoListDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalDTO;

public class ContactoDAOImpl extends AbstractFacadeImpl<ContactoDTO> implements ContactoDAO{

	private static final Logger log = LoggerFactory
			.getLogger(ContactoDAOImpl.class);
	
	public ContactoDAOImpl() {
	}

	public ContactoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

//	@Override
//	public List<ContactoDTO> getAll(RepresentanteLegalDTO representanteLegalDTO) throws IndicadoresException
//	{
//		log.info("getAll");
//		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
//		CriteriaQuery<ContactoDTO> cq=cb.createQuery(ContactoDTO.class);
//		Root<ContactoDTO> from= cq.from(ContactoDTO.class);
//		
//		cq.where(cb.equal(from.get("indRepresentanteLegal"), representanteLegalDTO.getRleCodigo()));
//		
//		List<ContactoDTO> list=entityManager.createQuery(cq).getResultList();	
//		if(list.isEmpty())
//			return null;
//		else
//			return list;
//	}

	
	@Override
	public List<ContactoListDTO> getAll(RepresentanteLegalDTO representanteLegalDTO) throws IndicadoresException
	{
		log.info("getAll");
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ContactoListDTO> cq=cb.createQuery(ContactoListDTO.class);
		Root<ContactoListDTO> from= cq.from(ContactoListDTO.class);
		
		cq.where(cb.equal(from.get("conRepresentanteLegal"), representanteLegalDTO.getRleCodigo()));
		
		List<ContactoListDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	
	
}
