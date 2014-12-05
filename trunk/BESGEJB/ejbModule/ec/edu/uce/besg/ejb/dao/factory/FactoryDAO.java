package ec.edu.uce.besg.ejb.dao.factory;

import javax.ejb.Local;

import ec.edu.uce.besg.ejb.persistence.dao.CatalogoDAO;
import ec.edu.uce.besg.ejb.persistence.dao.ContactoDAO;
import ec.edu.uce.besg.ejb.persistence.dao.EmpresaDAO;
import ec.edu.uce.besg.ejb.persistence.dao.UsuarioDAO;

@Local
public interface FactoryDAO {

	UsuarioDAO getUsuarioDAOImpl();

	ContactoDAO getContactoDAOImpl();

	EmpresaDAO getEmpresaDAOImpl();

	CatalogoDAO getCatalogoDAOImpl();
}
