package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.dao.PostulacionDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PostulacionDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PostulacionListDTO;

@Stateless
public class PostulacionDAOImpl extends AbstractFacadeImpl<PostulacionDTO> implements PostulacionDAO{

	public PostulacionDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostulacionDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PostulacionListDTO> getAll(EmpresaDTO empresa) throws SilsagException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PostulacionListDTO> cq=cb.createQuery(PostulacionListDTO.class);
		Root<PostulacionListDTO> from = cq.from(PostulacionListDTO.class);
		
		cq.where(cb.equal(from.get("empCodigo"), empresa.getEmpCodigo()));
		
		List<PostulacionListDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}	
	
}
