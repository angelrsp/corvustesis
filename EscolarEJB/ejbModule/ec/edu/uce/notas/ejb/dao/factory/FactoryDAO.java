package ec.edu.uce.notas.ejb.dao.factory;

import javax.ejb.Local;

import ec.edu.uce.notas.ejb.persistence.dao.AccesoDAO;
import ec.edu.uce.notas.ejb.persistence.dao.AccesoViewDAO;
import ec.edu.uce.notas.ejb.persistence.dao.AlumnoDAO;
import ec.edu.uce.notas.ejb.persistence.dao.AlumnoViewDAO;
import ec.edu.uce.notas.ejb.persistence.dao.CatalogoDAO;
import ec.edu.uce.notas.ejb.persistence.dao.ComponenteDAO;
import ec.edu.uce.notas.ejb.persistence.dao.ComponenteMenuDAO;
import ec.edu.uce.notas.ejb.persistence.dao.ComponenteMenuViewDAO;
import ec.edu.uce.notas.ejb.persistence.dao.CursoDAO;
import ec.edu.uce.notas.ejb.persistence.dao.DocenteDAO;
import ec.edu.uce.notas.ejb.persistence.dao.DocenteViewDAO;
import ec.edu.uce.notas.ejb.persistence.dao.EvidenciaDAO;
import ec.edu.uce.notas.ejb.persistence.dao.HistorialPasswordDAO;
import ec.edu.uce.notas.ejb.persistence.dao.HistoricoIndicadorDAO;
import ec.edu.uce.notas.ejb.persistence.dao.IndicadorDAO;
import ec.edu.uce.notas.ejb.persistence.dao.MenuDAO;
import ec.edu.uce.notas.ejb.persistence.dao.MenuViewDAO;
import ec.edu.uce.notas.ejb.persistence.dao.ModeloDAO;
import ec.edu.uce.notas.ejb.persistence.dao.PerfilDAO;
import ec.edu.uce.notas.ejb.persistence.dao.UsuarioDAO;
import ec.edu.uce.notas.ejb.persistence.dao.UsuarioPerfilDAO;
import ec.edu.uce.notas.ejb.persistence.dao.UsuarioViewDAO;

@Local
public interface FactoryDAO {

	ModeloDAO getModeloDAOImpl();

	IndicadorDAO getIndicadorDAOImpl();

	HistoricoIndicadorDAO getHistoricoIndicadorDAOImpl();

	EvidenciaDAO getEvidenciaDAOImpl();

	UsuarioDAO getUsuarioDAOImpl();

	DocenteViewDAO getDocenteViewDAOImpl();

	DocenteDAO getDocenteDAOImpl();

	PerfilDAO getPerfilDAOImpl();

	MenuDAO getMenuDAOImpl();

	MenuViewDAO getMenuViewDAOImpl();

	ComponenteDAO getComponenteDAOImpl();

	ComponenteMenuDAO getComponenteMenuDAOImpl();

	ComponenteMenuViewDAO getComponenteMenuViewDAOImpl();

	AccesoDAO getAccesoDAOImpl();

	AccesoViewDAO getAccesoViewDAOImpl();

	UsuarioPerfilDAO getUsuarioPerfilDAOImpl();

	HistorialPasswordDAO getHistorialPasswordDAOImpl();

	UsuarioViewDAO getUsuarioViewDAOImpl();

	CatalogoDAO getCatalogoDAOImpl();

	AlumnoDAO getAlumnoDAOImpl();

	AlumnoViewDAO getAlumnoViewDAOImpl();

	CursoDAO getCursoDAOImpl();

	
}
