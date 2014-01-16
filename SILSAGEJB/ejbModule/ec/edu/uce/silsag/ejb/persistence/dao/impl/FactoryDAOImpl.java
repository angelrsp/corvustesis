package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.uce.silsag.ejb.persistence.dao.AvisoDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.CandidatoDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.CatalogoDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.ContactoDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.EmpresaDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.EstudioDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.ExperienciaDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.PerfilDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.PostulacionDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.ReferenciaDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.UsuarioDAO;

@Stateless
public class FactoryDAOImpl implements FactoryDAO {

	@PersistenceContext(unitName = "silsaePU")
	private EntityManager entityManager;

	private UsuarioDAO usuarioDAO;

	private CandidatoDAO candidatoDAO;

	private AvisoDAO avisoDAO;

	private PerfilDAO perfilDAO;

	private CatalogoDAO catalogoDAO;

	private EstudioDAO estudioDAO;

	private ExperienciaDAO experienciaDAO;

	private ReferenciaDAO referenciaDAO;

	private EmpresaDAO empresaDAO;
	
	private PostulacionDAO postulacionDAO;
	
	private ContactoDAO contactoDAO;

	@Override
	public UsuarioDAO getUsuarioDAOImpl() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAOImpl(entityManager);
		}
		return usuarioDAO;
	}

	@Override
	public CandidatoDAO getCandidatoDAOImpl() {
		if (candidatoDAO == null) {
			candidatoDAO = new CandidatoDAOImpl(entityManager);
		}
		return candidatoDAO;
	}

	@Override
	public AvisoDAO getAvisoDAOImpl() {
		if (avisoDAO == null) {
			avisoDAO = new AvisoDAOImpl(entityManager);
		}
		return avisoDAO;
	}

	@Override
	public PerfilDAO getPerfilDAOImpl() {
		if (perfilDAO == null) {
			perfilDAO = new PerfilDAOImpl(entityManager);
		}
		return perfilDAO;
	}

	@Override
	public CatalogoDAO getCatalogoImpl() {
		if (catalogoDAO == null) {
			catalogoDAO = new CatalogoDAOImpl(entityManager);
		}
		return catalogoDAO;
	}

	@Override
	public EstudioDAO getEstudioDAOImpl() {
		if (estudioDAO == null) {
			estudioDAO = new EstudioDAOImpl(entityManager);
		}
		return estudioDAO;
	}

	@Override
	public ExperienciaDAO getExperienciaDAOImpl() {
		if (experienciaDAO == null) {
			experienciaDAO = new ExperienciaDAOImpl(entityManager);
		}
		return experienciaDAO;
	}

	@Override
	public ReferenciaDAO getReferenciaDAOImpl() {
		if (referenciaDAO == null) {
			referenciaDAO = new ReferenciaDAOImpl(entityManager);
		}
		return referenciaDAO;
	}

	@Override
	public EmpresaDAO getEmpresaDAOImpl() {
		if (empresaDAO == null) {
			empresaDAO = new EmpresaDAOImpl(entityManager);
		}
		return empresaDAO;
	}

	@Override
	public PostulacionDAO getPostulacionDAOImpl() {
		if (postulacionDAO == null) {
			postulacionDAO = new PostulacionDAOImpl(entityManager);
		}
		return postulacionDAO;
	}

	@Override
	public ContactoDAO getContactoDAOImpl() {
		if (contactoDAO == null) {
			contactoDAO = new ContactoDAOImpl(entityManager);
		}
		return contactoDAO;
	}
}
