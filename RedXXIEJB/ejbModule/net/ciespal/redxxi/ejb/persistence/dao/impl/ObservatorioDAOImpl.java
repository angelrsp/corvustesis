package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.ObservatorioDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ObservatorioDTO;

import com.corvustec.commons.util.CorvustecException;

public class ObservatorioDAOImpl extends AbstractFacadeImpl<ObservatorioDTO> implements ObservatorioDAO {

	public ObservatorioDAOImpl() {
		super();
	}

	public ObservatorioDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<ObservatorioDTO> findAll(Object ubicacion) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ObservatorioDTO> cq=cb.createQuery(ObservatorioDTO.class);
		Root<ObservatorioDTO> from= cq.from(ObservatorioDTO.class);
		
		cq.where(cb.equal(from.get("obsCiudad"), ubicacion));
		
		List<ObservatorioDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	
	private void remove2(ObservatorioDTO observatorio)
	{
		Query query;
		query=entityManager.createQuery("delete from ");
	}
}
