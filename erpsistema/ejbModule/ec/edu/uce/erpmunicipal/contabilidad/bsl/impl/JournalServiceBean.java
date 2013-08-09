package ec.edu.uce.erpmunicipal.contabilidad.bsl.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ec.edu.uce.erpmunicipal.contabilidad.bsl.JournalService;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConCuenta;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConMovimientoDetalle;

@Stateless(name = "journalService")
public class JournalServiceBean implements JournalService{

	
	@PersistenceContext(name = "erpmunicipalPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	
	
	public void create(List<ConMovimientoDetalle> details)
	{
		BigDecimal saldo;
		for(ConMovimientoDetalle detail:details)
		{
			saldo= detail.getMdeDebe();
		}
	}
	
	private ConCuenta findCuenta()
	{
		return null;
	}
	
}
