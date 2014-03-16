package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.dao.MencionDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.MencionDTO;

public class MencionDAOImpl extends AbstractFacadeImpl<MencionDTO> implements MencionDAO {

	public MencionDAOImpl() {
		super();
	}

	public MencionDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	@Override
	public List<MencionDTO> getAll(CarreraDTO carrera) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<MencionDTO> cq=cb.createQuery(MencionDTO.class);
		Root<MencionDTO> from = cq.from(MencionDTO.class);
		
		Path<CarreraDTO> join=from.join("ateCarrera");
		
		cq.where(cb.equal(join.get("carCodigo"), carrera.getCarCodigo()));
		
		List<MencionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	@Override
	public void remove2(MencionDTO mencion) throws CorvustecException
	{
		Query query;
		query=entityManager.createQuery("delete from MencionDTO men where men.menCodigo=:codigo");
		query.setParameter("codigo", mencion.getMenCodigo());
		query.executeUpdate();
	}
}
