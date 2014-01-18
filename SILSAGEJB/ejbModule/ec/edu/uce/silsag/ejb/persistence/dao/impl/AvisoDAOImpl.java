package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsag.commons.util.CalendarUtil;
import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.persistence.dao.AvisoDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.AvisoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;

@Stateless
public class AvisoDAOImpl extends AbstractFacadeImpl<AvisoDTO> implements AvisoDAO{

	public AvisoDAOImpl () {}
	
	public AvisoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<AvisoDTO> getAll(EmpresaDTO empresa) throws SilsagException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<AvisoDTO> cq=cb.createQuery(AvisoDTO.class);
		Root<AvisoDTO> from = cq.from(AvisoDTO.class);
		Path<EmpresaDTO> join =from.join("bemEmpresa");
		
		cq.where(cb.equal(join.get("empCodigo"), empresa.getEmpCodigo()));
		
		List<AvisoDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<AvisoDTO> getOfertas(CandidatoDTO candidatoDTO) throws SilsagException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<AvisoDTO> cq=cb.createQuery(AvisoDTO.class);
		Root<AvisoDTO> from = cq.from(AvisoDTO.class);
		
//		Subquery<Integer> sub=cq.subquery(Integer.class);
//		Root<PostulacionDTO> fromSub=sub.from(PostulacionDTO.class);
//		Path<CandidatoDTO> join1=from.join("bemCandidato");
//		
//		sub.where(cb.equal(join1.get("canCodigo"),candidatoDTO.getCanCodigo()));
		
//		Join<AvisoDTO, PostulacionDTO> join1=from.join("bemPostulacions",JoinType.LEFT);
//		Path<CandidatoDTO> join2=join1.join("bemCandidato",JoinType.LEFT);

		
		cq.where(cb.greaterThanOrEqualTo(from.get("aviFechaCaducidad").as(Date.class),CalendarUtil.getTimeNowTimestamp()));
				

		
//		cq.where(cb.and(cb.greaterThanOrEqualTo(from.get("aviFechaCaducidad").as(Date.class),CalendarUtil.getTimeNowTimestamp()),
//				cb.or(cb.notEqual(join2.get("canCodigo"),candidatoDTO.getCanCodigo()),cb.isNull(join2.get("canCodigo")))));
		
		List<AvisoDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}

}
