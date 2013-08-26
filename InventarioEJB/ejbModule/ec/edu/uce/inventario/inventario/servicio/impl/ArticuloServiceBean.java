package ec.edu.uce.inventario.inventario.servicio.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.edu.uce.inventario.entidades.InvArticulo;
import ec.edu.uce.inventario.entidades.InvKardex;
import ec.edu.uce.inventario.entidades.InvUnidad;
import ec.edu.uce.inventario.inventario.servicio.ArticuloService;
import ec.edu.uce.inventario.inventario.servicio.KardexService;
import ec.edu.uce.inventario.util.ReflectionUtil;

@Stateless(name = "articuloService")
public class ArticuloServiceBean implements ArticuloService {

	@PersistenceContext(name = "inventarioPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@EJB(name = "kardexService/local")
	private KardexService kardexService;

	@Override
	public void create(InvArticulo art, int unidad) throws Exception {
		
		if(findByValue(art, "artCodigoManual")!=null)
		{
			throw new Exception("El codigo ya existe");
		}
		Calendar cal = Calendar.getInstance();
		InvUnidad uni = new InvUnidad();
		uni.setUniCodigo(unidad);

		art.setInvUnidad(uni);

		InvKardex kardex = new InvKardex();
		kardex.setKarCantidad(art.getArtPaquete());
		kardex.setKarValorUnitario(art.getArtPrecio());
		kardex.setKarValorTotal(BigDecimal.valueOf(art.getArtPaquete()
				.doubleValue() * art.getArtPrecio().doubleValue()));
		kardex.setKarFecha(new Timestamp(cal.getTimeInMillis()));

		kardexService.create2(1, kardex, art);

		entityManager.persist(art);
	}

	@Override
	public void updateEstado(InvArticulo art) {

		art.setArtEstado(false);

		entityManager.merge(art);
	}

	@Override
	public void update(InvArticulo art, int unidad) {

		InvUnidad uni = new InvUnidad();
		uni.setUniCodigo(unidad);

		art.setInvUnidad(uni);

		entityManager.merge(art);
	}

	@Override
	public Boolean delete(InvArticulo art) {
		Query query = entityManager
				.createQuery("from InvKardex kar inner join kar.invArticulo art where art.artCodigo=:code");
		query.setParameter("code", art.getArtCodigo());
		if (!query.getResultList().isEmpty())
			return false;
		else {
			art = entityManager.find(InvArticulo.class, art.getArtCodigo());
			entityManager.remove(art);
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InvUnidad> readUnidades() {
		return (List<InvUnidad>) entityManager.createQuery("from InvUnidad")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InvArticulo> readAll() {
		return (List<InvArticulo>) entityManager
				.createQuery("from InvArticulo").getResultList();
	}

	@Override
	public List<InvArticulo> dynamicSearch(String par) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<InvArticulo> cq = cb.createQuery(InvArticulo.class);
		Root<InvArticulo> from = cq.from(InvArticulo.class);

		cq.select(from);

		Predicate like1 = cb.like(
				cb.lower(from.get("artTipo").as(String.class)),
				"%" + par.toLowerCase() + "%");
		Predicate like2 = cb.like(
				cb.lower(from.get("artNombreLargo").as(String.class)), "%"
						+ par.toLowerCase() + "%");

		cq.where(cb.or(like1, like2));

		TypedQuery<InvArticulo> typed = entityManager.createQuery(cq);
		typed.setMaxResults(100);
		return typed.getResultList();
	}

	@Override
	public InvArticulo readArticulo(InvArticulo articulo) {
		InvArticulo art = entityManager.find(InvArticulo.class,
				articulo.getArtCodigo());
		return art;
	}

	public List<InvArticulo> findByValue(InvArticulo art, String value) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<InvArticulo> cq = cb.createQuery(InvArticulo.class);
		Root<InvArticulo> from = cq.from(InvArticulo.class);

		cq.where(cb.equal(from.get(value),
				ReflectionUtil.getValorGet(art, value)));

		List<InvArticulo> list = entityManager.createQuery(cq).getResultList();

		if (list.isEmpty())
			return null;
		else
			return list;
	}
}
