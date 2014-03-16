package net.ciespal.redxxi.ejb.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.corvustec.commons.util.CorvustecException;

import net.ciespal.redxxi.ejb.persistence.dao.ContactoDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CarreraDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoDTO;
import net.ciespal.redxxi.ejb.persistence.entities.ContactoListDTO;
import net.ciespal.redxxi.ejb.persistence.entities.DoctorDTO;
import net.ciespal.redxxi.ejb.persistence.entities.EntidadDTO;
import net.ciespal.redxxi.ejb.persistence.entities.OrganizacionDTO;

public class ContactoDAOImpl extends AbstractFacadeImpl<ContactoDTO> implements ContactoDAO {

	public ContactoDAOImpl() {
		super();
	}

	public ContactoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	

	@Override
	public List<ContactoDTO> getAll2(EntidadDTO entidad) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ContactoDTO> cq=cb.createQuery(ContactoDTO.class);
		Root<ContactoDTO> from = cq.from(ContactoDTO.class);
		
		Path<EntidadDTO> join=from.join("ateEntidad");
		
		cq.where(cb.and(cb.equal(join.get("entCodigo"), entidad.getEntCodigo())));
		
		List<ContactoDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return new ArrayList<ContactoDTO>();
		else
			return list;
	}
	
	@Override
	public List<ContactoListDTO> getAll(EntidadDTO entidad)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ContactoListDTO> cq=cb.createQuery(ContactoListDTO.class);
		Root<ContactoListDTO> from = cq.from(ContactoListDTO.class);
		
		cq.where(cb.equal(from.get("entCodigo"), entidad.getEntCodigo()));
		
		List<ContactoListDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	
	@Override
	public List<ContactoListDTO> getAll(CarreraDTO carrera) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ContactoListDTO> cq=cb.createQuery(ContactoListDTO.class);
		Root<ContactoListDTO> from = cq.from(ContactoListDTO.class);
		
		cq.where(cb.equal(from.get("entCarrera"), carrera.getCarCodigo()));
		
		List<ContactoListDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<ContactoListDTO> getAll(OrganizacionDTO organizacion) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ContactoListDTO> cq=cb.createQuery(ContactoListDTO.class);
		Root<ContactoListDTO> from = cq.from(ContactoListDTO.class);
		
		cq.where(cb.equal(from.get("entOrganizacion"), organizacion.getOrgCodigo()));
		
		List<ContactoListDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public List<ContactoListDTO> getAll(DoctorDTO doctor) throws CorvustecException
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<ContactoListDTO> cq=cb.createQuery(ContactoListDTO.class);
		Root<ContactoListDTO> from = cq.from(ContactoListDTO.class);
		
		cq.where(cb.equal(from.get("entDoctor"), doctor.getDocCodigo()));
		
		List<ContactoListDTO> list=entityManager.createQuery(cq).getResultList();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	@Override
	public void remove2(ContactoDTO contacto) throws CorvustecException
	{
		Query query;
		query=entityManager.createQuery("delete from ContactoDTO con where con.conCodigo=:codigo");
		query.setParameter("codigo", contacto.getConCodigo());
		query.executeUpdate();
	}
}
