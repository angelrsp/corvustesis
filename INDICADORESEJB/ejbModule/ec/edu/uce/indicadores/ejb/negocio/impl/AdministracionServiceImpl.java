package ec.edu.uce.indicadores.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.AdministracionService;
import ec.edu.uce.indicadores.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.indicadores.ejb.persistence.entities.CatalogoDTO;

@Stateless
public class AdministracionServiceImpl implements AdministracionService{

	private static final Logger log = LoggerFactory.getLogger(AdministracionServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;

	
	
	@Override
	public List<CatalogoDTO> getCatalogo(CatalogoDTO catalogo) throws IndicadoresException
	{
		log.info("obtener catalogo");
		log.info("Valor codigo catalogo "+catalogo.getCatCodigo());
		try{
			return factoryDAO.getCatalogoImpl().getAll(catalogo);
		}
		catch(Exception e)
		{
			log.info("Error al obtener catalogo" +e.toString());
			throw new IndicadoresException("Error al obtener catalogo");
		}
	}
	
}
