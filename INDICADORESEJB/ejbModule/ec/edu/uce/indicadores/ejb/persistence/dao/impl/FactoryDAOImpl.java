package ec.edu.uce.indicadores.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.uce.indicadores.ejb.persistence.dao.ContactoDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.IesDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.ModeloDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.RepresentanteLegalDAO;
import ec.edu.uce.indicadores.ejb.persistence.dao.UsuarioDAO;


@Stateless
public class FactoryDAOImpl implements FactoryDAO{
	
	@PersistenceContext(unitName = "indicadoresPU")
	private EntityManager entityManager;

	private UsuarioDAO usuarioDAO;
	
	private RepresentanteLegalDAO representanteLegalDAO;

	private ContactoDAO contactoDAO;
	
	private IesDAO iesDAO;
	
	private ModeloDAO modeloDAO;
	
	@Override
	public UsuarioDAO getUsuarioDAOImpl() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAOImpl(entityManager);
		}
		return usuarioDAO;
	}
	
	@Override
	public RepresentanteLegalDAO getRepresentanteLegalDAOImpl() {
		if (representanteLegalDAO == null) {
			representanteLegalDAO = new RepresentanteLegalDAOImpl(entityManager);
		}
		return representanteLegalDAO;
	}

	@Override
	public ContactoDAO getContactoDAOImpl() {
		if (contactoDAO == null) {
			contactoDAO = new ContactoDAOImpl(entityManager);
		}
		return contactoDAO;
	}

	@Override
	public IesDAO getIesDAOImpl() {
		if (iesDAO == null) {
			iesDAO = new IesDAOImpl(entityManager);
		}
		return iesDAO;
	}

	@Override
	public ModeloDAO getModeloDAOImpl() {
		if (modeloDAO == null) {
			modeloDAO = new ModeloDAOImpl(entityManager);
		}
		return modeloDAO;
	}
}
