package ec.edu.uce.erpmunicipal.sistema.bsl.impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ec.edu.uce.erpmunicipal.sistema.bsl.AuditService;
import ec.edu.uce.erpmunicipal.sistema.orm.SisAuditoriaMenu;

@Stateless(name="auditService")
public class AuditServiceBean implements AuditService{

	@PersistenceContext(name = "erpmunicipalPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@Override
	public void create(SisAuditoriaMenu object)
	{
		Date date=new Date();
		object.setAmeFecha(new Timestamp(date.getTime()));
		entityManager.persist(object);
	}
}
