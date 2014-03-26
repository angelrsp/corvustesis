package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.ContactoArgosDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.ContactoDTO;

public class ContactoArgosDAOImpl extends AbstractFacadeImpl<ContactoDTO> implements ContactoArgosDAO {

	public ContactoArgosDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactoArgosDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
