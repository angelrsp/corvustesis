package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.EntidadDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ObraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;

import com.corvustec.commons.util.CorvustecException;

public class EntidadDAOImpl extends AbstractFacadeImpl<EntidadDTO> implements EntidadDAO{

	public EntidadDAOImpl() {
		super();
	}

	public EntidadDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<EntidadDTO> getAll(CarreraDTO carrera) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EntidadDTO> cq=cb.createQuery(EntidadDTO.class);
		Root<EntidadDTO> from = cq.from(EntidadDTO.class);
		
		Path<CarreraDTO> join1=from.join("ateCarrera");
		
		cq.where(cb.equal(join1.get("carCodigo"),carrera.getCarCodigo()));
		
		List<EntidadDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<EntidadDTO>();
		else
			return list;
	}
	
	@Override	
	public void remove2(EntidadDTO entidad) throws CorvustecException
	{
		Query query;
		query=entityManager.createQuery("delete from EntidadDTO ent where ent.entCodigo=:codigo");
		query.setParameter("codigo", entidad.getEntCodigo());
		query.executeUpdate();
	}
	
	@Override
	public EntidadDTO get(DoctorDTO doctor)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EntidadDTO> cq=cb.createQuery(EntidadDTO.class);
		Root<EntidadDTO> from = cq.from(EntidadDTO.class);
		
		Path<DoctorDTO> join1=from.join("ateDoctor");
		
		cq.where(cb.equal(join1.get("docCodigo"),doctor.getDocCodigo()));
		
		List<EntidadDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list.get(0);		
	}

	@Override
	public EntidadDTO get(ObraDTO obra)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EntidadDTO> cq=cb.createQuery(EntidadDTO.class);
		Root<EntidadDTO> from = cq.from(EntidadDTO.class);
		
		Path<ObraDTO> join1=from.join("ateObra");
		
		cq.where(cb.equal(join1.get("obrCodigo"),obra.getObrCodigo()));
		
		List<EntidadDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list.get(0);		
	}

	@Override
	public List<EntidadDTO> getAll(OrganizacionDTO organizacion) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<EntidadDTO> cq=cb.createQuery(EntidadDTO.class);
		Root<EntidadDTO> from = cq.from(EntidadDTO.class);
		
		Path<OrganizacionDTO> join1=from.join("ateOrganizacion");
		
		cq.where(cb.equal(join1.get("orgCodigo"),organizacion.getOrgCodigo()));
		
		List<EntidadDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<EntidadDTO>();
		else
			return list;
	}

	
}
