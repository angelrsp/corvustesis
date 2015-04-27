package ec.edu.uce.besg.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.besg.common.util.Const;
import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.service.CatalogoService;

@Stateless
public class CatalogoServiceImpl implements CatalogoService{

	private static final Logger logger = LoggerFactory.getLogger(CatalogoServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;

	private List<CatalogoDTO> readCatalogo(Integer code) throws CorvustecException
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
	public List<CatalogoDTO> readSector() throws CorvustecException
	{
		try {
			return readCatalogo(Const.SECTOR);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}
	
	@Override
	public List<CatalogoDTO> readPais() throws CorvustecException
	{
		try {
			return readCatalogo(Const.PAIS);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}
	
	@Override
	public List<CatalogoDTO> readCargo() throws CorvustecException
	{
		try {
			return readCatalogo(Const.CARGO);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}

	@Override
	public List<CatalogoDTO> readEstadoCivil() throws CorvustecException
	{
		try {
			return readCatalogo(Const.ESTADO_CIVIL);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}

	@Override
	public List<CatalogoDTO> readIdentificationType() throws CorvustecException
	{
		try {
			return readCatalogo(Const.TIPO_IDENTIFICACION);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}

	@Override
	public List<CatalogoDTO> readSexo() throws CorvustecException
	{
		try {
			return readCatalogo(Const.SEXO);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}

	
	@Override
	public List<CatalogoDTO> readNivelEstudio() throws CorvustecException
	{
		try {
			return readCatalogo(Const.NIVEL_ESTUDIO);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}

	@Override
	public List<CatalogoDTO> readFacultad() throws CorvustecException
	{
		try {
			return readCatalogo(Const.FACULTADES);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}
}
