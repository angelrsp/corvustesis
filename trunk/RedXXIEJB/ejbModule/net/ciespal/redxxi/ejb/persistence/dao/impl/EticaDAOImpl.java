package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.EticaDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaDTO;

import com.corvustec.commons.util.CorvustecException;

public class EticaDAOImpl extends AbstractFacadeImpl<EticaDTO> implements EticaDAO{

	public EticaDAOImpl() {
		super();
	}

	public EticaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	@Override
	public List<EticaDTO> findAll(Object ciudad) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EticaDTO> cq=cb.createQuery(EticaDTO.class);
		Root<EticaDTO> from= cq.from(EticaDTO.class);
		
		cq.where(cb.equal(from.get("etiCiudad"), ciudad));
		
		List<EticaDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

}
