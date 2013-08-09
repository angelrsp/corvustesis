package ec.edu.uce.erpmunicipal.sistema.bsl.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import ec.edu.uce.erpmunicipal.sistema.bsl.EntityService;
import ec.edu.uce.erpmunicipal.sistema.orm.SisInstitucion;
import ec.edu.uce.erpmunicipal.sistema.orm.SisUsuario;

@Stateless(name = "entityService")
public class EntityServiceBean implements EntityService {

	@PersistenceContext(name = "erpmunicipalPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	public EntityServiceBean() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SisInstitucion> readAll() {
		List<SisInstitucion> objects;
		try {
			Query query = entityManager.createQuery("from " + "SisInstitucion");
			objects = query.getResultList();

		} catch (PersistenceException e) {
			e.printStackTrace();
			objects = null;
			throw new RuntimeException(e);

		} catch (Exception e) {
			e.printStackTrace();
			objects = null;
		}
		return objects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SisInstitucion> readAll(SisUsuario user, int rolCode) {
		List<SisInstitucion> objects;
		try {

			Query query;

			if (rolCode > 1) {

				query = entityManager
						.createQuery("from "
								+ "SisInstitucion ins where ins.insActivo=:true and ins.insCodigo=:code");
				query.setParameter("code", user.getSisInstitucion()
						.getInsCodigo());

			} else {

				query = entityManager.createQuery("from "
						+ "SisInstitucion ins where ins.insActivo=true");

			}

			objects = query.getResultList();

		} catch (PersistenceException e) {
			e.printStackTrace();
			objects = null;
			throw new RuntimeException(e);

		} catch (Exception e) {
			e.printStackTrace();
			objects = null;
		}
		return objects;
	}

	@Override
	public Boolean delete(SisInstitucion ent) {
		Boolean flag;
		try {
			Query query = entityManager
					.createQuery("from SisUsuario usu inner join usu.sisInstitucion ins where ins.insCodigo=:code");
			query.setParameter("code", ent.getInsCodigo());
			if (query.getResultList().isEmpty()) {
				ent = entityManager.find(SisInstitucion.class,
						ent.getInsCodigo());
				entityManager.remove(ent);
				flag = true;
			} else {
				flag = false;
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
			flag = false;

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

}
