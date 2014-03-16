package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.dao.ModalidadDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ModalidadDTO;

public class ModalidadDAOImpl extends AbstractFacadeImpl<ModalidadDTO> implements ModalidadDAO{

	public ModalidadDAOImpl() {
		super();
	}

	public ModalidadDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<ModalidadDTO> getAll(CarreraDTO carrera)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ModalidadDTO> cq=cb.createQuery(ModalidadDTO.class);
		Root<ModalidadDTO> from = cq.from(ModalidadDTO.class);
		
		Path<CarreraDTO> join1=from.join("ateCarrera");
		
		cq.where(cb.equal(join1.get("carCodigo"),carrera.getCarCodigo()));
		
		List<ModalidadDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<ModalidadDTO>();
		else
			return list;
	}
	
	@Override
	public void remove2(ModalidadDTO moda) throws CorvustecException
	{
		Query query;
		query=entityManager.createQuery("delete from ModalidadDTO mod where mod.modCodigo=:codigo");
		query.setParameter("codigo", moda.getModCodigo());
		query.executeUpdate();
	}
	
}
