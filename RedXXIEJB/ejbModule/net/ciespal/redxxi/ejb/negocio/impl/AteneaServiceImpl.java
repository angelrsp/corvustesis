package net.ciespal.redxxi.ejb.negocio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.ciespal.redxxi.ejb.negocio.AteneaService;
import net.ciespal.redxxi.ejb.persistence.dao.FactoryDAO;
import net.ciespal.redxxi.ejb.persistence.entities.CentroDTO;

import com.corvustec.commons.util.CorvustecException;

@Stateless
public class AteneaServiceImpl implements AteneaService{

	
	@EJB
	private FactoryDAO factoryDAO;
	
	@Override
	public CentroDTO centroCreate(CentroDTO centro) throws CorvustecException
	{
		try{
			return factoryDAO.getCentroDAOImpl().create(centro);
		}
		catch(Exception e)
		{
			throw new CorvustecException("Error al obtener catalogo");
		}
	}
	
}
