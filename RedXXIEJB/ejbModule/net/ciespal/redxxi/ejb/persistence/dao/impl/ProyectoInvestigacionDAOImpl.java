package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.ProyectoInvestigacionDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ProyectoInvestigacionDTO;

import com.corvustec.commons.util.CorvustecException;

public class ProyectoInvestigacionDAOImpl extends AbstractFacadeImpl<ProyectoInvestigacionDTO> implements ProyectoInvestigacionDAO {

	public ProyectoInvestigacionDAOImpl() {
		super();
	}

	public ProyectoInvestigacionDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<ProyectoInvestigacionDTO> getAll(CarreraDTO carrera) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ProyectoInvestigacionDTO> cq=cb.createQuery(ProyectoInvestigacionDTO.class);
		Root<ProyectoInvestigacionDTO> from = cq.from(ProyectoInvestigacionDTO.class);
		
		Path<CarreraDTO> join1=from.join("ateEntidads");
		
		cq.where(cb.equal(join1.get("ateCarrera"), carrera.getCarCodigo()));
		
		List<ProyectoInvestigacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	
}
