package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.NoticiaArgosDAO;
import net.ciespal.redxxi.ejb.persistence.entities.argos.NoticiaDTO;

public class NoticiaArgosDAOImpl extends AbstractFacadeImpl<NoticiaDTO> implements NoticiaArgosDAO {

	public NoticiaArgosDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoticiaArgosDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
