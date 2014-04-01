package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.NoticiaEspejoDAO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.EticaDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.GranMaestroDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.LeyDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.MaestroCiespalDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.NoticiaEspejoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioCiespalDTO;
import net.ciespal.redxxi.ejb.persistence.entities.espejo.PremioDTO;

import com.corvustec.commons.util.CorvustecException;

public class NoticiaEspejoDAOImpl extends AbstractFacadeImpl<NoticiaEspejoDTO> implements NoticiaEspejoDAO{

	public NoticiaEspejoDAOImpl() {
		super();
	}

	public NoticiaEspejoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<NoticiaEspejoDTO> findAll(NoticiaEspejoDTO noticia) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<NoticiaEspejoDTO> cq=cb.createQuery(NoticiaEspejoDTO.class);
		Root<NoticiaEspejoDTO> from= cq.from(NoticiaEspejoDTO.class);
		
		cq.where(cb.equal(from.get("espEntidad"), noticia.getEspEntidad()));
		
		List<NoticiaEspejoDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;

	}

	@Override
	public List<NoticiaEspejoDTO> findAll(EticaDTO etica) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<NoticiaEspejoDTO> cq=cb.createQuery(NoticiaEspejoDTO.class);
		Root<NoticiaEspejoDTO> from= cq.from(NoticiaEspejoDTO.class);
		
		cq.where(cb.equal(from.get("espEntidad"), etica.getEspEntidad()));
		
		List<NoticiaEspejoDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;

	}

	@Override
	public List<NoticiaEspejoDTO> findAll(GranMaestroDTO mestro) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<NoticiaEspejoDTO> cq=cb.createQuery(NoticiaEspejoDTO.class);
		Root<NoticiaEspejoDTO> from= cq.from(NoticiaEspejoDTO.class);
		
		cq.where(cb.equal(from.get("espEntidad"), mestro.getEspEntidad()));
		
		List<NoticiaEspejoDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	@Override
	public List<NoticiaEspejoDTO> findAll(MaestroCiespalDTO mestro) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<NoticiaEspejoDTO> cq=cb.createQuery(NoticiaEspejoDTO.class);
		Root<NoticiaEspejoDTO> from= cq.from(NoticiaEspejoDTO.class);
		
		cq.where(cb.equal(from.get("espEntidad"), mestro.getEspEntidad()));
		
		List<NoticiaEspejoDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<NoticiaEspejoDTO> findAll(PremioDTO premio) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<NoticiaEspejoDTO> cq=cb.createQuery(NoticiaEspejoDTO.class);
		Root<NoticiaEspejoDTO> from= cq.from(NoticiaEspejoDTO.class);
		
		cq.where(cb.equal(from.get("espEntidad"), premio.getEspEntidad()));
		
		List<NoticiaEspejoDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<NoticiaEspejoDTO> findAll(PremioCiespalDTO premio) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<NoticiaEspejoDTO> cq=cb.createQuery(NoticiaEspejoDTO.class);
		Root<NoticiaEspejoDTO> from= cq.from(NoticiaEspejoDTO.class);
		
		cq.where(cb.equal(from.get("espEntidad"), premio.getEspEntidad()));
		
		List<NoticiaEspejoDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}


	@Override
	public List<NoticiaEspejoDTO> findAll(LeyDTO ley) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<NoticiaEspejoDTO> cq=cb.createQuery(NoticiaEspejoDTO.class);
		Root<NoticiaEspejoDTO> from= cq.from(NoticiaEspejoDTO.class);
		
		cq.where(cb.equal(from.get("espEntidad"), ley.getEspEntidad()));
		
		List<NoticiaEspejoDTO> list=entityManager.createQuery(cq).getResultList();	
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
}
