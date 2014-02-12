package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.CarreraDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;

import com.corvustec.commons.util.CorvustecException;

public class CarreraDAOImpl extends AbstractFacadeImpl<CarreraDTO> implements CarreraDAO{

	public CarreraDAOImpl() {
		super();
	}

	public CarreraDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<CarreraDTO> getAll(CentroDTO centro) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<CarreraDTO> cq=cb.createQuery(CarreraDTO.class);
		Root<CarreraDTO> from = cq.from(CarreraDTO.class);
		
		Path<CentroDTO> join1=from.join("ateCentro");
		
		cq.where(cb.and(cb.equal(join1.get("cenCodigo"), centro.getCenCodigo()),cb.equal(from.get("carTipo"), 6)));
		
		List<CarreraDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}

}
