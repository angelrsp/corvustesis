package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import net.ciespal.redxxi.ejb.persistence.dao.ObraDAO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ObraDTO;

import com.corvustec.commons.util.CorvustecException;

public class ObraDAOImpl extends AbstractFacadeImpl<ObraDTO> implements ObraDAO{

	public ObraDAOImpl() {
		super();
	}

	public ObraDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}


	@Override
	public List<ObraDTO> getAll(DoctorDTO doctor) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ObraDTO> cq=cb.createQuery(ObraDTO.class);
		Root<ObraDTO> from = cq.from(ObraDTO.class);
		
		Path<DoctorDTO> join1=from.join("ateEntidads");
		
		cq.where(cb.equal(join1.get("ateDoctor"), doctor.getDocCodigo()));
		
		List<ObraDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}

	@Override
	public void remove2(ObraDTO obra) throws CorvustecException
	{
		Query query;
		for(EntidadDTO ent:obra.getAteEntidads())
		{	 
			query= entityManager.createQuery("delete from EntidadDTO where entCodigo=:codigo");
			query.setParameter("codigo", ent.getEntCodigo());
			query.executeUpdate();
		}
		
		query= entityManager.createQuery("delete from ObraDTO where obrCodigo=:codigo");
		query.setParameter("codigo", obra.getObrCodigo());
		query.executeUpdate();
	}

}
