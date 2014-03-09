package com.corvustec.tiempofila.ejb.persistence.dao;

import javax.ejb.Local;

@Local
public interface FactoryDAO {

	AgenciaDAO getAgenciaDAOImpl();
	AsesorDAO getAsesorDAOImpl();
	CatalogoDAO getCatalogoDAOImpl();
	ClienteDAO getClienteDAOImpl();
	DispositivoDAO getDispositivoDAOImpl();
	ParametroDAO getParametroDAOImpl();
	TiempoDAO getTiempoDAOImpl();

}
