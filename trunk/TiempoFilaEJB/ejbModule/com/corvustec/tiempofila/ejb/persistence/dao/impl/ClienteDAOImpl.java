package com.corvustec.tiempofila.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.corvustec.tiempofila.ejb.persistence.dao.ClienteDAO;
import com.corvustec.tiempofila.ejb.persistence.entities.ClienteDTO;


public class ClienteDAOImpl extends AbstractFacadeImpl<ClienteDTO> implements ClienteDAO{

	public ClienteDAOImpl() {
		super();
	}

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public ClienteDTO getByIdentificator(ClienteDTO cliente)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ClienteDTO> cq=cb.createQuery(ClienteDTO.class);
		Root<ClienteDTO> from= cq.from(ClienteDTO.class);
				
		cq.where(cb.equal(from.get("cliNumero"), cliente.getCliNumero()));
		
		List<ClienteDTO> list=entityManager.createQuery(cq).getResultList();
		
		if(list.isEmpty())
			return null;
		else
			return list.get(0);

	}
}
