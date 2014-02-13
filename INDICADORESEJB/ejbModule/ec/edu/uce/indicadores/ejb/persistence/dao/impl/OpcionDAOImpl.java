package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import ec.edu.uce.indicadores.ejb.persistence.dao.OpcionDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.AccesoDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.OpcionDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;

public class OpcionDAOImpl extends AbstractFacadeImpl<OpcionDTO> implements OpcionDAO{

	public OpcionDAOImpl() {
		super();
	}

	public OpcionDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<OpcionDTO> getAll(PerfilDTO perfil)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<OpcionDTO> cq=cb.createQuery(OpcionDTO.class);
		Root<OpcionDTO> from= cq.from(OpcionDTO.class);
		Join<OpcionDTO, AccesoDTO> join1=from.join("indAccesos",JoinType.LEFT);
		//Join<AccesoDTO, PerfilDTO> join2=join1.join("indPerfil");
		
		cq.where(cb.equal(join1.get("indPerfil").get("perCodigo"),perfil.getPerCodigo()));
		
		List<OpcionDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return new ArrayList<OpcionDTO>();
		else
			return list;
	}
	
}
