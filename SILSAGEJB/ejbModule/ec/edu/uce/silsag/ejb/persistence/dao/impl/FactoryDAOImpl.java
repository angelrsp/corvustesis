package ec.edu.uce.silsag.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.uce.silsag.ejb.persistence.dao.AdicionalDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.AvisoDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.CandidatoDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.CatalogoDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.ContactoDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.CursoDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.EmpresaDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.EstudioDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.ExperienciaDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.ParametroDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.PerfilDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.PostulacionDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.PreguntaDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.ReferenciaDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.RespuestaDAO;
import ec.edu.uce.silsag.ejb.persistence.dao.ResultadoDAO;
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
	
	private ResultadoDAO resultadoDAO;
	
	private PreguntaDAO preguntaDAO;

	private RespuestaDAO respuestaDAO;
	
	private CursoDAO cursoDAO;
	
	private AdicionalDAO adicionalDAO;
	
	private ParametroDAO parametroDAO;
	
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
	
	@Override
	public ResultadoDAO getResultadoDAOImpl() {
		if (resultadoDAO == null) {
			resultadoDAO = new ResultadoDAOImpl(entityManager);
		}
		return resultadoDAO;
	}
	
	@Override
	public PreguntaDAO getPreguntaDAOImpl() {
		if (preguntaDAO == null) {
			preguntaDAO = new PreguntaDAOImpl(entityManager);
		}
		return preguntaDAO;
	}
	
	@Override
	public RespuestaDAO getRespuestaDAOImpl() {
		if (respuestaDAO == null) {
			respuestaDAO = new RespuestaDAOImpl(entityManager);
		}
		return respuestaDAO;
	}

	@Override
	public CursoDAO getCursoDAOImpl() {
		if (cursoDAO == null) {
			cursoDAO = new CursoDAOImpl(entityManager);
		}
		return cursoDAO;
	}
	
	@Override
	public AdicionalDAO getAdicionalDAOImpl() {
		if (adicionalDAO == null) {
			adicionalDAO = new AdicionalDAOImpl(entityManager);
		}
		return adicionalDAO;
	}
	
	@Override
	public ParametroDAO getParametroDAOImpl() {
		if (parametroDAO == null) {
			parametroDAO = new ParametroDAOImpl(entityManager);
		}
		return parametroDAO;
	}
}
