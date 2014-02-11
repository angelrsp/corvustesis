package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.PublicacionDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.PublicacionDTO;

import com.corvustec.commons.util.CorvustecException;

public class PublicacionDAOImpl extends AbstractFacadeImpl<PublicacionDTO> implements PublicacionDAO {

	public PublicacionDAOImpl() {
		super();
	}

	public PublicacionDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<PublicacionDTO> getAll(CarreraDTO carrera) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PublicacionDTO> cq=cb.createQuery(PublicacionDTO.class);
		Root<PublicacionDTO> from = cq.from(PublicacionDTO.class);
		
		Path<CarreraDTO> join1=from.join("ateEntidads");
		
		cq.where(cb.equal(join1.get("ateCarrera"), carrera.getCarCodigo()));
		
		List<PublicacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
}
