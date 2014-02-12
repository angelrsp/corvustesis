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

}
