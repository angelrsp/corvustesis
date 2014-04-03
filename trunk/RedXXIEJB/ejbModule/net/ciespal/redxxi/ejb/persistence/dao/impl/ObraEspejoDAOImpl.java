package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.ObraEspejoDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.ObraEspejoDTO;

import com.corvustec.commons.util.CorvustecException;

public class ObraEspejoDAOImpl extends AbstractFacadeImpl<ObraEspejoDTO> implements ObraEspejoDAO {

	public ObraEspejoDAOImpl() {
		super();
	}

	public ObraEspejoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<ObraEspejoDTO> findAll(GranMaestroDTO mestro,Object type) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ObraEspejoDTO> cq=cb.createQuery(ObraEspejoDTO.class);
		Root<ObraEspejoDTO> from= cq.from(ObraEspejoDTO.class);
		
		cq.where(cb.and(cb.equal(from.get("espEntidad"), mestro.getEspEntidad()),cb.equal(from.get("obrTipo"), type)));
		
		List<ObraEspejoDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	@Override
	public List<ObraEspejoDTO> findAll(MaestroCiespalDTO mestro,Object type) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ObraEspejoDTO> cq=cb.createQuery(ObraEspejoDTO.class);
		Root<ObraEspejoDTO> from= cq.from(ObraEspejoDTO.class);
		
		cq.where(cb.and(cb.equal(from.get("espEntidad"), mestro.getEspEntidad()),cb.equal(from.get("obrTipo"), type)));
		
		List<ObraEspejoDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

}
