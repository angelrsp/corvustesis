package ec.edu.uce.erpmunicipal.contabilidad.bsl.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import ec.edu.uce.erpmunicipal.contabilidad.bsl.JournalService;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConClase;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConCuenta;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConMovimiento;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConMovimientoDetalle;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConSaldo;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConTipoMovimiento;
import ec.edu.uce.erpmunicipal.util.orm.SessionObject;

@Stateless(name = "journalService")
public class JournalServiceBean implements JournalService {

	@PersistenceContext(name = "erpmunicipalPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@Override
	public void create(SessionObject sessionObject, int claseCode, int tipoMovimientoCode, ConMovimiento movimiento,List<ConMovimientoDetalle> details) {
		
		Double debe, haber, saldo;
		ConSaldo objSaldo;
		ConCuenta objCuenta;
	
		Date date=new Date();
		
		ConClase clase= entityManager.find(ConClase.class, claseCode);
		
		ConTipoMovimiento tipoMovimiento= entityManager.find(ConTipoMovimiento.class, tipoMovimientoCode);
		
		movimiento.setConClase(clase);
		movimiento.setConTipoMovimiento(tipoMovimiento);
		movimiento.setMovEntidad(sessionObject.getUser().getSisInstitucion().getInsCodigo());
		movimiento.setMovEstado(true);
		movimiento.setMovFecha(new Timestamp(date.getTime()));
		
		
		entityManager.persist(movimiento);
		entityManager.flush();
		entityManager.refresh(movimiento);
		
		
		for (ConMovimientoDetalle detail : details) {
			objCuenta = findAccountByNum(detail.getConCuenta().getCueNumero());
			objSaldo = readSaldo(objCuenta);
			if (objSaldo != null) {
				
				detail.setConCuenta(objCuenta);
				detail.setConMovimiento(movimiento);
				detail.setConPeriodo(sessionObject.getPeriodo());
				detail.setMdeEntidad(sessionObject.getUser().getSisInstitucion().getInsCodigo());
				
				debe = objSaldo.getSalDebe().doubleValue()
						+ detail.getMdeDebe().doubleValue();
				haber = objSaldo.getSalHaber().doubleValue()
						+ detail.getMdeHaber().doubleValue();
				saldo=debe-haber;
				objSaldo.setSalDebe(BigDecimal.valueOf(debe));
				objSaldo.setSalHaber(BigDecimal.valueOf(haber));
				objSaldo.setSalSaldo(BigDecimal.valueOf(saldo));
				entityManager.merge(objSaldo);
				
			} else {
				saldo = detail.getMdeDebe().doubleValue()
						- detail.getMdeHaber().doubleValue();
				objSaldo=new ConSaldo();
				objSaldo.setConCuenta(objCuenta);
				objSaldo.setSalDebe(detail.getMdeDebe());
				objSaldo.setSalDebe(detail.getMdeHaber());
				objSaldo.setSalSaldo(BigDecimal.valueOf(saldo));
				entityManager.persist(objSaldo);
			}
			
		}
	}

	private ConCuenta findAccountByNum(String num) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ConCuenta> cq = cb.createQuery(ConCuenta.class);

		Root<ConCuenta> root = cq.from(ConCuenta.class);
		cq.where(cb.equal(root.get("cueNumero"), num));

		List<ConCuenta> list = entityManager.createQuery(cq).getResultList();
		if (list.isEmpty())
			return null;
		else
			return list.get(0);

	}

	private ConSaldo readSaldo(ConCuenta cuenta) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ConSaldo> cq = cb.createQuery(ConSaldo.class);

		Root<ConSaldo> from = cq.from(ConSaldo.class);
		Path<ConCuenta> path = from.join("conCuenta").get("cueCodigo");

		cq.where(cb.equal(path, cuenta.getCueCodigo()));

		List<ConSaldo> list = entityManager.createQuery(cq).getResultList();

		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}
	
	

}
