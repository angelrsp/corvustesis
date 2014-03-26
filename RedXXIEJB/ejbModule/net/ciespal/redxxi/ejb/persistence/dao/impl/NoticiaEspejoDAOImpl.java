package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import net.ciespal.redxxi.ejb.persistence.dao.NoticiaEspejoDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaDTO;

public class NoticiaEspejoDAOImpl extends AbstractFacadeImpl<NoticiaDTO> implements NoticiaEspejoDAO{

	public NoticiaEspejoDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoticiaEspejoDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
