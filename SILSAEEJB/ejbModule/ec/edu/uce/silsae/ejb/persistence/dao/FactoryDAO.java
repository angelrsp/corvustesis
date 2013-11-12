package ec.edu.uce.silsae.ejb.persistence.dao;

import javax.ejb.Local;

@Local
public interface FactoryDAO {
	
	UsuarioDAO getUsuarioDAOImpl();
	CandidatoDAO getCandidatoDAOImpl();
	AvisoDAO getAvisoDAOImpl();
	PerfilDAO getPerfilDAOImpl();
	
}
