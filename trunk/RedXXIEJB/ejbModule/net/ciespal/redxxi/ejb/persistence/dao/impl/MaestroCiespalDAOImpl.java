package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.MaestroCiespalDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalDTO;

public class MaestroCiespalDAOImpl extends AbstractFacadeImpl<MaestroCiespalDTO> implements MaestroCiespalDAO {

	public MaestroCiespalDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MaestroCiespalDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
