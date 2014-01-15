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
	IdiomaDAO getIdiomaDAOImpl();
	ReferenciaDAO getReferenciaDAOImpl();
	SoftwareDAO getSoftwareDAOImpl();
	EmpresaDAO getEmpresaDAOImpl();
	PostulacionDAO getPostulacionDAOImpl();
	ContactoDAO getContactoDAOImpl();
	
	
}
