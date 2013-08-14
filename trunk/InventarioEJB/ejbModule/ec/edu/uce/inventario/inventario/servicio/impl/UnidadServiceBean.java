package ec.edu.uce.inventario.inventario.servicio.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import ec.edu.uce.inventario.entidades.InvUnidad;
import ec.edu.uce.inventario.inventario.servicio.UnidadService;

@Stateless(name = "unidadService")
public class UnidadServiceBean implements UnidadService {

	@PersistenceContext(name = "inventarioPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@Override
	public void create(InvUnidad unidad) {
		entityManager.persist(unidad);
	}

	@Override
	public void update(InvUnidad unidad) {
		entityManager.merge(unidad);
	}

	@Override
	public Boolean delete(InvUnidad unidad) {
		Boolean flag = null;
		try {
			if (entityManager.find(InvUnidad.class, unidad.getUniCodigo())
					.getInvArticulos().isEmpty()) {
				entityManager.remove(entityManager.find(InvUnidad.class, unidad.getUniCodigo()));
				flag=true;
			} else {
				flag= false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<InvUnidad> readAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<InvUnidad> cq = cb.createQuery(InvUnidad.class);
		cq.from(InvUnidad.class);

		List<InvUnidad> list = entityManager.createQuery(cq).getResultList();
		if (list.isEmpty())
			return null;
		else
			return list;
	}

}
