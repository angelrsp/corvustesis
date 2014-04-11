package net.ciespal.redxxi.ejb.persistence.dao;





public interface FactoryDAO {

	CatalogoDAO getCatalogoImpl();
	CentroDAO getCentroDAOImpl();
	CarreraDAO getCarreraDAOImpl();
	EntidadDAO getEntidadDAOImpl();
	ContactoDAO getContactoDAOImpl();
	MencionDAO getMencionDAOImpl();
	ProyectoInvestigacionDAO getProyectoInvestigacionDAOImpl();
	EventoDAO getEventoDAOImpl();
	PublicacionDAO getPublicacionDAOImpl();
	OrganizacioDAO getOrganizacioDAOImpl();
	DoctorDAO getDoctorDAOImpl();
	NoticiaDAO getNoticiaDAOImpl();
	ModalidadDAO getModalidadDAOImpl();
	RedDAO getRedDAOImpl();
	ObservatorioDAO getObservatorioDAOImpl();
	VeeduriaDAO getVeeduriaDAOImpl();
	EticaDAO getEticaDAOImpl();
	GranMaestroDAO getGranMaestroDAOImpl();
	MaestroCiespalDAO getMaestroCiespalDAOImpl();
	PremioDAO getPremioDAOImpl();
	PremioCiespalDAO getPremioCiespalDAOImpl();
	LeyDAO getLeyDAOImpl();
	ObraEspejoDAO getObraEspejoDAOImpl();
	ObraDAO getObraDAOImpl();
	NoticiaEspejoDAO getNoticiaEspejoDAOImpl();
	ContactoArgosDAO getContactoArgosDAOImpl();
	
	

}
