package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.dao.PostulacionDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.AvisoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PostulacionDTO;

@Stateless
public class PostulacionDAOImpl extends AbstractFacadeImpl<PostulacionDTO> implements PostulacionDAO{

	public PostulacionDAOImpl() {
		super();
	}

	public PostulacionDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<PostulacionDTO> getAll(EmpresaDTO empresa) throws SilsagException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PostulacionDTO> cq=cb.createQuery(PostulacionDTO.class);
		Root<PostulacionDTO> from = cq.from(PostulacionDTO.class);
		Join<PostulacionDTO, AvisoDTO> join1=from.join("bemAviso");
		Path<EmpresaDTO> join2=join1.get("bemEmpresa");
		
		cq.where(cb.equal(join2.get("empCodigo"), empresa.getEmpCodigo()));
		
		List<PostulacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<PostulacionDTO> getAll(CandidatoDTO candidatoDTO) throws SilsagException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PostulacionDTO> cq=cb.createQuery(PostulacionDTO.class);
		Root<PostulacionDTO> from = cq.from(PostulacionDTO.class);
		Path<CandidatoDTO> join1=from.join("bemCandidato");
		
		
		cq.where(cb.equal(join1.get("canCodigo"), candidatoDTO.getCanCodigo()));
		
		List<PostulacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	

	@Override
	public List<PostulacionDTO> getAll() throws SilsagException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PostulacionDTO> cq=cb.createQuery(PostulacionDTO.class);
		cq.from(PostulacionDTO.class);
		
		List<PostulacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	@Override
	public List<PostulacionDTO> getAll(Boolean estado) throws SilsagException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<PostulacionDTO> cq=cb.createQuery(PostulacionDTO.class);
		Root<PostulacionDTO> from = cq.from(PostulacionDTO.class);
		
		cq.where(cb.equal(from.get("posAceptado"), estado));
		
		List<PostulacionDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}

}
