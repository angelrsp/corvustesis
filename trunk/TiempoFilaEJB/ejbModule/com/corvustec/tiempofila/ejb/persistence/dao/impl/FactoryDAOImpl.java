package com.corvustec.tiempofila.ejb.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.corvustec.tiempofila.ejb.persistence.dao.AgenciaDAO;
import com.corvustec.tiempofila.ejb.persistence.dao.AsesorDAO;
import com.corvustec.tiempofila.ejb.persistence.dao.CatalogoDAO;
import com.corvustec.tiempofila.ejb.persistence.dao.ClienteDAO;
import com.corvustec.tiempofila.ejb.persistence.dao.DispositivoDAO;
import com.corvustec.tiempofila.ejb.persistence.dao.FactoryDAO;
import com.corvustec.tiempofila.ejb.persistence.dao.ParametroDAO;
import com.corvustec.tiempofila.ejb.persistence.dao.TiempoDAO;

@Stateless
public class FactoryDAOImpl implements FactoryDAO{

	
	@PersistenceContext(unitName = "tiempoFilaPU")
	private EntityManager entityManager;

	private AgenciaDAO agenciaDAO;
	private AsesorDAO asesorDAO;
	private CatalogoDAO catalogoDAO;
	private ClienteDAO clienteDAO;
	private DispositivoDAO dispositivoDAO;
	private ParametroDAO parametroDAO;
	private TiempoDAO tiempoDAO;

	@Override
	public AgenciaDAO getAgenciaDAOImpl() {
		if(agenciaDAO==null)
			agenciaDAO=new AgenciaDAOImpl(entityManager);
		return agenciaDAO;
	}

	@Override
	public AsesorDAO getAsesorDAOImpl() {
		if(asesorDAO==null)
			asesorDAO=new AsesorDAOImpl(entityManager);
		return asesorDAO;
	}
	
	@Override
	public CatalogoDAO getCatalogoDAOImpl() {
		if(catalogoDAO==null)
			catalogoDAO=new CatalogoDAOImpl(entityManager);
		return catalogoDAO;
	}

	@Override
	public ClienteDAO getClienteDAOImpl() {
		if(clienteDAO==null)
			clienteDAO=new ClienteDAOImpl(entityManager);
		return clienteDAO;
	}
	
	@Override
	public DispositivoDAO getDispositivoDAOImpl() {
		if(dispositivoDAO==null)
			dispositivoDAO=new DispositivoDAOImpl(entityManager);
		return dispositivoDAO;
	}
	
	@Override
	public ParametroDAO getParametroDAOImpl() {
		if(parametroDAO==null)
			parametroDAO=new ParametroDAOImpl(entityManager);
		return parametroDAO;
	}
	
	@Override
	public TiempoDAO getTiempoDAOImpl() {
		if(tiempoDAO==null)
			tiempoDAO=new TiempoDAOImpl(entityManager);
		return tiempoDAO;
	}
	
}
