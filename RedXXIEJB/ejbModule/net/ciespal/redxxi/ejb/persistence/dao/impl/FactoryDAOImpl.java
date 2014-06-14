package net.ciespal.redxxi.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.ciespal.redxxi.ejb.persistence.dao.AccesoDAO;
import net.ciespal.redxxi.ejb.persistence.dao.CarreraDAO;
import net.ciespal.redxxi.ejb.persistence.dao.CatalogoDAO;
import net.ciespal.redxxi.ejb.persistence.dao.CentroDAO;
import net.ciespal.redxxi.ejb.persistence.dao.ComponenteDAO;
import net.ciespal.redxxi.ejb.persistence.dao.ComponenteMenuDAO;
import net.ciespal.redxxi.ejb.persistence.dao.ContactoArgosDAO;
import net.ciespal.redxxi.ejb.persistence.dao.ContactoDAO;
import net.ciespal.redxxi.ejb.persistence.dao.DefensorDAO;
import net.ciespal.redxxi.ejb.persistence.dao.DefensorVieDAO;
import net.ciespal.redxxi.ejb.persistence.dao.DoctorDAO;
import net.ciespal.redxxi.ejb.persistence.dao.DoctorVieDAO;
import net.ciespal.redxxi.ejb.persistence.dao.EntidadDAO;
import net.ciespal.redxxi.ejb.persistence.dao.EticaDAO;
import net.ciespal.redxxi.ejb.persistence.dao.EticaVieDAO;
import net.ciespal.redxxi.ejb.persistence.dao.EventoDAO;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.dao.GranMaestroDAO;
import net.ciespal.redxxi.ejb.persistence.dao.GranMaestroVieDAO;
import net.ciespal.redxxi.ejb.persistence.dao.LeyDAO;
import net.ciespal.redxxi.ejb.persistence.dao.MaestroCiespalDAO;
import net.ciespal.redxxi.ejb.persistence.dao.MencionDAO;
import net.ciespal.redxxi.ejb.persistence.dao.MenuDAO;
import net.ciespal.redxxi.ejb.persistence.dao.ModalidadDAO;
import net.ciespal.redxxi.ejb.persistence.dao.NoticiaDAO;
import net.ciespal.redxxi.ejb.persistence.dao.NoticiaEspejoDAO;
import net.ciespal.redxxi.ejb.persistence.dao.ObraDAO;
import net.ciespal.redxxi.ejb.persistence.dao.ObraEspejoDAO;
import net.ciespal.redxxi.ejb.persistence.dao.ObservatorioDAO;
import net.ciespal.redxxi.ejb.persistence.dao.OpinionDAO;
import net.ciespal.redxxi.ejb.persistence.dao.OrganizacioDAO;
import net.ciespal.redxxi.ejb.persistence.dao.PerfilDAO;
import net.ciespal.redxxi.ejb.persistence.dao.PremioCiespalDAO;
import net.ciespal.redxxi.ejb.persistence.dao.PremioDAO;
import net.ciespal.redxxi.ejb.persistence.dao.ProyectoInvestigacionDAO;
import net.ciespal.redxxi.ejb.persistence.dao.PublicacionDAO;
import net.ciespal.redxxi.ejb.persistence.dao.PublicacionVieDAO;
import net.ciespal.redxxi.ejb.persistence.dao.RedDAO;
import net.ciespal.redxxi.ejb.persistence.dao.UsuarioDAO;
import net.ciespal.redxxi.ejb.persistence.dao.UsuarioPerfilDAO;
import net.ciespal.redxxi.ejb.persistence.dao.VeeduriaDAO;


@Stateless
public class FactoryDAOImpl implements FactoryDAO{
	
	@PersistenceContext(unitName = "redXXIPU")
	private EntityManager entityManager;

	private UsuarioDAO usuarioDAO;
	private PerfilDAO perfilDAO;
	private MenuDAO menuDAO;
	private ComponenteDAO componenteDAO;
	private ComponenteMenuDAO componenteMenuDAO;
	private AccesoDAO accesoDAO;
	private UsuarioPerfilDAO usuarioPerfilDAO;
	
	private CatalogoDAO catalogoDAO;
	private CentroDAO centroDAO;
	private CarreraDAO carreraDAO;
	private EntidadDAO entidadDAO;
	private ContactoDAO contactoDAO;
	private MencionDAO mensionDAO;
	private ProyectoInvestigacionDAO proyectoInvestigacionDAO;
	private PublicacionDAO publicacionDAO;
	private EventoDAO eventoDAO;
	private OrganizacioDAO organizacioDAO;
	private DoctorDAO doctorDAO;
	private NoticiaDAO noticiaDAO;
	private ModalidadDAO modalidadDAO;
	private ObraDAO obraDAO;
	private DoctorVieDAO doctorVieDAO;
	private PublicacionVieDAO publicacionVieDAO;
	
	private RedDAO redDAO; 
	private ObservatorioDAO observatorioDAO;
	private VeeduriaDAO veeduriaDAO;
	private ContactoArgosDAO contactoArgosDAO;
	private DefensorDAO defensorDAO;
	private DefensorVieDAO defensorVieDAO;
	private OpinionDAO opinionDAO;
	
	private EticaDAO eticaDAO;
	private EticaVieDAO eticaVieDAO;
	private GranMaestroDAO granMaestroDAO;
	private GranMaestroVieDAO granMaestroVieDAO;
	private MaestroCiespalDAO maestroCiespalDAO;
	private PremioDAO premioDAO;
	private PremioCiespalDAO premioCiespalDAO;
	private LeyDAO leyDAO;
	private ObraEspejoDAO obraEspejoDAO;
	private NoticiaEspejoDAO noticiaEspejoDAO;
	
	
	@Override
	public CatalogoDAO getCatalogoImpl() {
		if (catalogoDAO == null) {
			catalogoDAO = new CatalogoDAOImpl(entityManager);
		}
		return catalogoDAO;
	}

	@Override
	public CentroDAO getCentroDAOImpl() {
		if (centroDAO == null) {
			centroDAO = new CentroDAOImpl(entityManager);
		}
		return centroDAO;
	}

	@Override
	public CarreraDAO getCarreraDAOImpl() {
		if (carreraDAO == null) {
			carreraDAO = new CarreraDAOImpl(entityManager);
		}
		return carreraDAO;
	}

	@Override
	public EntidadDAO getEntidadDAOImpl() {
		if (entidadDAO == null) {
			entidadDAO = new EntidadDAOImpl(entityManager);
		}
		return entidadDAO;
	}
	
	@Override
	public ContactoDAO getContactoDAOImpl() {
		if (contactoDAO == null) {
			contactoDAO = new ContactoDAOImpl(entityManager);
		}
		return contactoDAO;
	}
	
	@Override
	public MencionDAO getMencionDAOImpl() {
		if (mensionDAO == null) {
			mensionDAO = new MencionDAOImpl(entityManager);
		}
		return mensionDAO;
	}
	
	@Override
	public ProyectoInvestigacionDAO getProyectoInvestigacionDAOImpl() {
		if (proyectoInvestigacionDAO == null) {
			proyectoInvestigacionDAO = new ProyectoInvestigacionDAOImpl(entityManager);
		}
		return proyectoInvestigacionDAO;
	}

	@Override
	public EventoDAO getEventoDAOImpl() {
		if (eventoDAO == null) {
			eventoDAO = new EventoDAOImpl(entityManager);
		}
		return eventoDAO;
	}
	
	@Override
	public PublicacionDAO getPublicacionDAOImpl() {
		if (publicacionDAO == null) {
			publicacionDAO = new PublicacionDAOImpl(entityManager);
		}
		return publicacionDAO;
	}
	
	@Override
	public OrganizacioDAO getOrganizacioDAOImpl() {
		if (organizacioDAO == null) {
			organizacioDAO = new OrganizacioDAOImpl(entityManager);
		}
		return organizacioDAO;
	}
	
	@Override
	public DoctorDAO getDoctorDAOImpl() {
		if (doctorDAO == null) {
			doctorDAO = new DoctorDAOImpl(entityManager);
		}
		return doctorDAO;
	}
	
	@Override
	public NoticiaDAO getNoticiaDAOImpl() {
		if (noticiaDAO == null) {
			noticiaDAO = new NoticiaDAOImpl(entityManager);
		}
		return noticiaDAO;
	}

	@Override
	public ModalidadDAO getModalidadDAOImpl() {
		if (modalidadDAO == null) {
			modalidadDAO = new ModalidadDAOImpl(entityManager);
		}
		return modalidadDAO;
	}
	
	@Override
	public RedDAO getRedDAOImpl() {
		if (redDAO == null) {
			redDAO = new RedDAOImpl(entityManager);
		}
		return redDAO;
	}

	@Override
	public ObservatorioDAO getObservatorioDAOImpl() {
		if (observatorioDAO == null) {
			observatorioDAO = new ObservatorioDAOImpl(entityManager);
		}
		return observatorioDAO;
	}

	@Override
	public VeeduriaDAO getVeeduriaDAOImpl() {
		if (veeduriaDAO == null) {
			veeduriaDAO = new VeeduriaDAOImpl(entityManager);
		}
		return veeduriaDAO;
	}

	@Override
	public EticaDAO getEticaDAOImpl() {
		if (eticaDAO == null) {
			eticaDAO = new EticaDAOImpl(entityManager);
		}
		return eticaDAO;
	}

	@Override
	public GranMaestroDAO getGranMaestroDAOImpl() {
		if (granMaestroDAO == null) {
			granMaestroDAO = new GranMaestroDAOImpl(entityManager);
		}
		return granMaestroDAO;
	}

	@Override
	public MaestroCiespalDAO getMaestroCiespalDAOImpl() {
		if (maestroCiespalDAO == null) {
			maestroCiespalDAO = new MaestroCiespalDAOImpl(entityManager);
		}
		return maestroCiespalDAO;
	}
	
	@Override
	public PremioDAO getPremioDAOImpl() {
		if (premioDAO == null) {
			premioDAO = new PremioDAOImpl(entityManager);
		}
		return premioDAO;
	}

	
	@Override
	public PremioCiespalDAO getPremioCiespalDAOImpl() {
		if (premioCiespalDAO == null) {
			premioCiespalDAO = new PremioCiespalDAOImpl(entityManager);
		}
		return premioCiespalDAO;
	}
	
	@Override
	public LeyDAO getLeyDAOImpl() {
		if (leyDAO == null) {
			leyDAO = new LeyDAOImpl(entityManager);
		}
		return leyDAO;
	}
	
	@Override
	public ObraEspejoDAO getObraEspejoDAOImpl() {
		if (obraEspejoDAO == null) {
			obraEspejoDAO = new ObraEspejoDAOImpl(entityManager);
		}
		return obraEspejoDAO;
	}

	@Override
	public ObraDAO getObraDAOImpl() {
		if (obraDAO == null) {
			obraDAO = new ObraDAOImpl(entityManager);
		}
		return obraDAO;
	}

	@Override
	public NoticiaEspejoDAO getNoticiaEspejoDAOImpl() {
		if (noticiaEspejoDAO == null) {
			noticiaEspejoDAO = new NoticiaEspejoDAOImpl(entityManager);
		}
		return noticiaEspejoDAO;
	}

	@Override
	public ContactoArgosDAO getContactoArgosDAOImpl() {
		if (contactoArgosDAO == null) {
			contactoArgosDAO = new ContactoArgosDAOImpl(entityManager);
		}
		return contactoArgosDAO;
	}

	@Override
	public DoctorVieDAO getDoctorVieDAOImpl() {
		if (doctorVieDAO == null) {
			doctorVieDAO = new DoctorVieDAOImpl(entityManager);
		}
		return doctorVieDAO;
	}

	@Override
	public PublicacionVieDAO getPublicacionVieDAOImpl() {
		if (publicacionVieDAO == null) {
			publicacionVieDAO = new PublicacionVieDAOImpl(entityManager);
		}
		return publicacionVieDAO;
	}

	@Override
	public UsuarioDAO getUsuarioDAOImpl() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAOImpl(entityManager);
		}
		return usuarioDAO;
	}

	@Override
	public PerfilDAO getPerfilDAOImpl() {
		if (perfilDAO == null) {
			perfilDAO = new PerfilDAOImpl(entityManager);
		}
		return perfilDAO;
	}

	@Override
	public MenuDAO getMenuDAOImpl() {
		if (menuDAO == null) {
			menuDAO = new MenuDAOImpl(entityManager);
		}
		return menuDAO;
	}

	@Override
	public ComponenteDAO getComponenteDAOImpl() {
		if (componenteDAO == null) {
			componenteDAO = new ComponenteDAOImpl(entityManager);
		}
		return componenteDAO;
	}

	@Override
	public ComponenteMenuDAO getComponenteMenuDAOImpl() {
		if (componenteMenuDAO == null) {
			componenteMenuDAO = new ComponenteMenuDAOImpl(entityManager);
		}
		return componenteMenuDAO;
	}

	@Override
	public AccesoDAO getAccesoDAOImpl() {
		if (accesoDAO == null) {
			accesoDAO = new AccesoDAOImpl(entityManager);
		}
		return accesoDAO;
	}

	@Override
	public DefensorDAO getDefensorDAOImpl() {
		if (defensorDAO == null) {
			defensorDAO = new DefensorDAOImpl(entityManager);
		}
		return defensorDAO;
	}

	@Override
	public UsuarioPerfilDAO getUsuarioPerfilDAOImpl() {
		if (usuarioPerfilDAO == null) {
			usuarioPerfilDAO = new UsuarioPerfilDAOImpl(entityManager);
		}
		return usuarioPerfilDAO;
	}

	@Override
	public OpinionDAO getOpinionDAOImpl() {
		if (opinionDAO == null) {
			opinionDAO = new OpinionDAOImpl(entityManager);
		}
		return opinionDAO;
	}

	@Override
	public DefensorVieDAO getDefensorVieDAOImpl() {
		if (defensorVieDAO == null) {
			defensorVieDAO = new DefensorVieDAOImpl(entityManager);
		}
		return defensorVieDAO;
	}

	@Override
	public EticaVieDAO getEticaVieDAOImpl() {
		if (eticaVieDAO == null) {
			eticaVieDAO = new EticaVieDAOImpl(entityManager);
		}
		return eticaVieDAO;
	}

	@Override
	public GranMaestroVieDAO getGranMaestroVieDAOImpl() {
		if (granMaestroVieDAO == null) {
			granMaestroVieDAO = new GranMaestroVieDAOImpl(entityManager);
		}
		return granMaestroVieDAO;
	}
}
