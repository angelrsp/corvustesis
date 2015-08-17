package ec.edu.uce.notas.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corvustec.notas.common.util.CorvustecException;

import ec.edu.uce.notas.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.notas.ejb.persistence.entity.CatalogoDTO;
import ec.edu.uce.notas.ejb.service.CatalogoService;

@Stateless
public class CatalogoServiceImpl implements CatalogoService{

	private static final Logger slf4jLogger = LoggerFactory.getLogger(CatalogoServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;

	@Override
	public List<CatalogoDTO> readCatalogo(Integer code) throws CorvustecException
	{
		CatalogoDTO fatherDTO;
		CatalogoDTO catalogoDTO;
		List<CatalogoDTO> catalogoList;
		try {
			fatherDTO=new CatalogoDTO();
			catalogoDTO=new CatalogoDTO();
			
			fatherDTO.setCatCodigo(code);
			
			catalogoDTO.setSegCatalogo(fatherDTO);
			
			catalogoList= factoryDAO.getCatalogoDAOImpl().getByAnd(catalogoDTO);

			return catalogoList;
			
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
		finally{
			catalogoDTO=null;
			fatherDTO=null;
			catalogoList=null;
		}		
	}
		
	@Override
	public CatalogoDTO createOrUpdate(CatalogoDTO catalogoDTO) throws CorvustecException
	{
		try {
			if(catalogoDTO.getCatCodigo()!=null)
				return factoryDAO.getCatalogoDAOImpl().update(catalogoDTO);
			else
				return factoryDAO.getCatalogoDAOImpl().create(catalogoDTO);
		} catch (Exception e) {
			throw new CorvustecException(e);
		}
	}
	
	
	@Override
	public List<CatalogoDTO> readRegion() throws CorvustecException
	{
		try {
			return readCatalogo(1);
		} catch (Exception e) {
			slf4jLogger.info("Error al readRegion {}", e.toString());
			throw new CorvustecException("Error al obtener region");
		}				
	}
	
	@Override
	public List<CatalogoDTO> readProvincia(Integer paisCode) throws CorvustecException
	{
		try {
			return readCatalogo(paisCode);
		} catch (Exception e) {
			slf4jLogger.info("Error al obtener readProvincia {}", e.toString());
			throw new CorvustecException("Error al obtener provincia");
		}				
	}
	
	@Override
	public List<CatalogoDTO> readCiudad(Integer provinciaCode) throws CorvustecException
	{
		try {
			return readCatalogo(provinciaCode);
		} catch (Exception e) {
			slf4jLogger.info("Error al readCiudad {}", e.toString());
			throw new CorvustecException("Error al obtener ciudad");
		}				
	}
	
	@Override
	public List<CatalogoDTO> readAreaTrabajo() throws CorvustecException
	{
		try {
			return readCatalogo(1);
		} catch (Exception e) {
			slf4jLogger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}

	@Override
	public List<CatalogoDTO> readEstadoCivil() throws CorvustecException
	{
		try {
			return readCatalogo(1);
		} catch (Exception e) {
			slf4jLogger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}

	@Override
	public List<CatalogoDTO> readIdentificationType() throws CorvustecException
	{
		try {
			return readCatalogo(1);
		} catch (Exception e) {
			slf4jLogger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}

	@Override
	public List<CatalogoDTO> readSex() throws CorvustecException
	{
		try {
			return readCatalogo(1);
		} catch (Exception e) {
			slf4jLogger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}

	@Override
	public CatalogoDTO readCatalogoById(int id) throws CorvustecException
	{
		try {
			return factoryDAO.getCatalogoDAOImpl().find(id);
		} catch (Exception e) {
			slf4jLogger.info("Error al registrar Aviso {}", e.toString());
			throw new CorvustecException("Error al obtener el catalogo");
		}				
	}
	

	
}
