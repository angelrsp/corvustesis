package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.dao.ContactoDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;

public class ContactoDAOImpl extends AbstractFacadeImpl<ContactoDTO> implements ContactoDAO{

	public ContactoDAOImpl() {
		super();
	}

	public ContactoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<ContactoDTO> getAll(EmpresaDTO empresa) throws SilsagException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ContactoDTO> cq=cb.createQuery(ContactoDTO.class);
		Root<ContactoDTO> from = cq.from(ContactoDTO.class);
		Path<EmpresaDTO> join=from.join("bemEmpresa").get("empCodigo");
		
		cq.where(cb.and(cb.equal(join, empresa.getEmpCodigo())));
		
		List<ContactoDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}	

}
