package ec.edu.uce.besg.ejb.dao.factory;

import javax.ejb.Local;

import ec.edu.uce.besg.ejb.persistence.dao.AvisoDAO;
import ec.edu.uce.besg.ejb.persistence.dao.AvisoViewDAO;
import ec.edu.uce.besg.ejb.persistence.dao.CandidatoDAO;
import ec.edu.uce.besg.ejb.persistence.dao.CatalogoDAO;
import ec.edu.uce.besg.ejb.persistence.dao.ContactoDAO;
import ec.edu.uce.besg.ejb.persistence.dao.EmpresaDAO;
import ec.edu.uce.besg.ejb.persistence.dao.ExperienciaDAO;
import ec.edu.uce.besg.ejb.persistence.dao.HabilidadDAO;
import ec.edu.uce.besg.ejb.persistence.dao.HabilidadViewDAO;
import ec.edu.uce.besg.ejb.persistence.dao.HistorialPasswordDAO;
import ec.edu.uce.besg.ejb.persistence.dao.ReferenciaDAO;
import ec.edu.uce.besg.ejb.persistence.dao.UsuarioDAO;

@Local
public interface FactoryDAO {

	UsuarioDAO getUsuarioDAOImpl();

	ContactoDAO getContactoDAOImpl();

	EmpresaDAO getEmpresaDAOImpl();

	CatalogoDAO getCatalogoDAOImpl();

	ReferenciaDAO getReferenciaDAOImpl();

	HabilidadDAO getHabilidadDAOImpl();

	ExperienciaDAO getExperienciaDAOImpl();

	CandidatoDAO getCandidatoDAOImpl();

	HistorialPasswordDAO getHistorialPasswordDAOImpl();

	HabilidadViewDAO getHabilidadViewDAOImpl();

	AvisoDAO getAvisoDAOImpl();

	AvisoViewDAO getAvisoViewDAOImpl();
}
