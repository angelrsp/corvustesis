package ec.edu.uce.silsae.ejb.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.uce.silsae.commons.util.CalendarUtil;
import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.persistence.dao.AvisoDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.AvisoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.AvisoListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;

@Stateless
public class AvisoDAOImpl extends AbstractFacadeImpl<AvisoDTO> implements AvisoDAO{

	public AvisoDAOImpl () {}
	
	public AvisoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<AvisoListDTO> getAll(EmpresaDTO empresa) throws SilsaeException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<AvisoListDTO> cq=cb.createQuery(AvisoListDTO.class);
		Root<AvisoListDTO> from = cq.from(AvisoListDTO.class);
		cq.where(cb.equal(from.get("aviEmpresa"), empresa.getEmpCodigo()));
		List<AvisoListDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<AvisoListDTO> getOfertas() throws SilsaeException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<AvisoListDTO> cq=cb.createQuery(AvisoListDTO.class);
		Root<AvisoListDTO> from = cq.from(AvisoListDTO.class);
		cq.where(cb.greaterThanOrEqualTo(from.get("aviFechaCaducidad").as(Date.class),CalendarUtil.getTimeNowTimestamp()));
		List<AvisoListDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}

}
