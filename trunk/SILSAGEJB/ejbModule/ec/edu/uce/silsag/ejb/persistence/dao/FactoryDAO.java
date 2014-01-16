package ec.edu.uce.silsag.ejb.persistence.dao;

import javax.ejb.Local;

@Local
public interface FactoryDAO {
	
	UsuarioDAO getUsuarioDAOImpl();
	CandidatoDAO getCandidatoDAOImpl();
	AvisoDAO getAvisoDAOImpl();
	PerfilDAO getPerfilDAOImpl();
	CatalogoDAO getCatalogoImpl();
	EstudioDAO getEstudioDAOImpl();
	ExperienciaDAO getExperienciaDAOImpl();
	ReferenciaDAO getReferenciaDAOImpl();
	EmpresaDAO getEmpresaDAOImpl();
	PostulacionDAO getPostulacionDAOImpl();
	ContactoDAO getContactoDAOImpl();
	ResultadoDAO getResultadoDAOImpl();
	
	
}
