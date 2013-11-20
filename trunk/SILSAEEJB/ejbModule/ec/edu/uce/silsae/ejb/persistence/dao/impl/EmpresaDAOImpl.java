package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import javax.persistence.EntityManager;

import ec.edu.uce.silsae.ejb.persistence.dao.EmpresaDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;

public class EmpresaDAOImpl extends AbstractFacadeImpl<EmpresaDTO> implements EmpresaDAO{

	public EmpresaDAOImpl() {
		super();
	}

	public EmpresaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	
}
