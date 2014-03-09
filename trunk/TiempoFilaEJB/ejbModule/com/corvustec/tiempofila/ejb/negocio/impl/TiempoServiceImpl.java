package com.corvustec.tiempofila.ejb.negocio.impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.commons.util.CorvustecException;
import com.corvustec.tiempofila.ejb.negocio.TiempoService;
import com.corvustec.tiempofila.ejb.persistence.dao.FactoryDAO;
import com.corvustec.tiempofila.ejb.persistence.entities.ClienteDTO;
import com.corvustec.tiempofila.ejb.persistence.vo.TomaVO;

@Stateless
public class TiempoServiceImpl implements TiempoService{

	
	private static final Logger slf4jLogger = LoggerFactory.getLogger(TiempoServiceImpl.class);
	
	@EJB 
	private FactoryDAO factoryDAO;
	
	@Override
	public Boolean createTomaInicio(TomaVO toma) throws CorvustecException
	{
		slf4jLogger.info("createTomaInicio");
		ClienteDTO cliente;
		Boolean flag;
		try
		{
			cliente=factoryDAO.getClienteDAOImpl().getByIdentificator(toma.getCliente());
			if(cliente==null)
				cliente=factoryDAO.getClienteDAOImpl().create(toma.getCliente());
			toma.getTiempo().setTieInicio(new Timestamp(new Date().getTime()));
			toma.getTiempo().setTfiCliente(cliente);
			factoryDAO.getTiempoDAOImpl().create(toma.getTiempo());
			flag=Boolean.TRUE;
		}
		catch(Exception e)
		{
			flag=Boolean.FALSE;
			slf4jLogger.info("Error en createTomaInicio {}",e.toString());
			throw new CorvustecException(e.toString());
		}
		return flag;
	}

}
