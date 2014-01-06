package ec.edu.uce.indicadores.ejb.persistence.dao;

import javax.ejb.Local;

@Local
public interface FactoryDAO {

	UsuarioDAO getUsuarioDAOImpl();

	RepresentanteLegalDAO getRepresentanteLegalDAOImpl();

	ContactoDAO getContactoDAOImpl();

	IesDAO getIesDAOImpl();
	
}
