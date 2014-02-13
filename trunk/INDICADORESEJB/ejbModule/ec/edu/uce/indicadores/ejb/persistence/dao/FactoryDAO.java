package ec.edu.uce.indicadores.ejb.persistence.dao;

import javax.ejb.Local;

@Local
public interface FactoryDAO {

	UsuarioDAO getUsuarioDAOImpl();

	RepresentanteLegalDAO getRepresentanteLegalDAOImpl();

	ContactoDAO getContactoDAOImpl();

	IesDAO getIesDAOImpl();

	ModeloDAO getModeloDAOImpl();

	IndicadorDAO getIndicadorDAOImpl();

	HistoricoIndicadorDAO getHistoricoIndicadorDAOImpl();

	EvidenciaDAO getEvidenciaDAOImpl();

	RegistroDAO getRegistroDAOImpl();

	CatalogoDAO getCatalogoImpl();

	PerfilDAO getPerfilDAOImpl();

	AccesoDAO getAccesoDAOImpl();

	OpcionDAO getOpcionDAOImpl();

	
}
