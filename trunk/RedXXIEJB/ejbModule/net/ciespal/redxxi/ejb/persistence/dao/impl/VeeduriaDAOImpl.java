package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.VeeduriaDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.VeeduriaDTO;

public class VeeduriaDAOImpl extends AbstractFacadeImpl<VeeduriaDTO> implements VeeduriaDAO {

	public VeeduriaDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VeeduriaDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
