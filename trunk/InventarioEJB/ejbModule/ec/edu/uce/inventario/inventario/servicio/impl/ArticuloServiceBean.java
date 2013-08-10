package ec.edu.uce.inventario.inventario.servicio.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ec.edu.uce.inventario.entidades.InvArticulo;
import ec.edu.uce.inventario.entidades.InvUnidad;
import ec.edu.uce.inventario.inventario.servicio.ArticuloService;

@Stateless(name = "articuloService")
public class ArticuloServiceBean implements ArticuloService {

	@PersistenceContext(name = "inventarioPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@Override
	public void create(InvArticulo art, int unidad) {
		InvUnidad uni = new InvUnidad();
		uni.setUniCodigo(unidad);

		art.setInvUnidad(uni);

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
		Query query=entityManager.createQuery("from InvKardex kar inner join kar.invArticulo art where art.artCodigo=:code");
		query.setParameter("code", art.getArtCodigo());
		if (!query.getResultList().isEmpty())
			return false;
		else {
			art=entityManager.find(InvArticulo.class, art.getArtCodigo());
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
}
