package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.ProyectoInvestigacionDAO;
import net.ciespal.redxxi.ejb.persistence.entities.ProyectoInvestigacionDTO;

public class ProyectoInvestigacionDAOImpl extends AbstractFacadeImpl<ProyectoInvestigacionDTO> implements ProyectoInvestigacionDAO {

	public ProyectoInvestigacionDAOImpl() {
		super();
	}

	public ProyectoInvestigacionDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
	
}
