package com.corvustec.tiempofila.ejb.negocio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;
import com.corvustec.tiempofila.ejb.negocio.AdministracionService;
import com.corvustec.tiempofila.ejb.persistence.dao.FactoryDAO;
import com.corvustec.tiempofila.ejb.persistence.util.dto.CredencialesDTO;


@Stateless
public class AdministracionServiceImpl implements AdministracionService{

	private static final Logger slf4jLogger = LoggerFactory.getLogger(AdministracionServiceImpl.class);
	
	@EJB 
	private FactoryDAO factoryDAO;

	@Override
	public Boolean authentication(CredencialesDTO credencialesDTO) throws CorvustecException
	{
		slf4jLogger.info("authentication");
		try
		{
			if(credencialesDTO.getUser().equals("admin"))
				return Boolean.TRUE;
			else
				return Boolean.FALSE;
		}
		catch(Exception e)
		{
			slf4jLogger.info("Error en authentication {}",e.toString());
			throw new CorvustecException(e.toString());
		}
	}
}
