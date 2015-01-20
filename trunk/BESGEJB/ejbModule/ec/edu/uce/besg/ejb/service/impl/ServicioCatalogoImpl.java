package ec.edu.uce.besg.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.besg.common.util.ConstApplication;
import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.service.ServicioCatalogo;

@Stateless
public class ServicioCatalogoImpl implements ServicioCatalogo{

	private static final Logger logger = LoggerFactory.getLogger(ServicioCatalogoImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;

	private List<CatalogoDTO> readCatalogo(CatalogoDTO catalogoDTO) throws CorvustecException
	{
		CatalogoDTO catalogoChild;
		try {
			catalogoChild=new CatalogoDTO();
			catalogoChild.setSegCatalogo(catalogoDTO);			
			return factoryDAO.getCatalogoDAOImpl().getByAnd(catalogoChild);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}

		
	@Override
	public List<CatalogoDTO> readSector() throws CorvustecException
	{
		CatalogoDTO catalogoDTO;
		try {
			catalogoDTO=new CatalogoDTO();
			catalogoDTO.setCatCodigo(ConstApplication.SECTOR);
			return readCatalogo(catalogoDTO);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}
	
	@Override
	public List<CatalogoDTO> readPais() throws CorvustecException
	{
		CatalogoDTO catalogoDTO;
		try {
			catalogoDTO=new CatalogoDTO();
			catalogoDTO.setCatCodigo(ConstApplication.PAIS);
			return readCatalogo(catalogoDTO);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}
	
	@Override
	public List<CatalogoDTO> readCargo() throws CorvustecException
	{
		CatalogoDTO catalogoDTO;
		try {
			catalogoDTO=new CatalogoDTO();
			catalogoDTO.setCatCodigo(ConstApplication.CARGO);
			return readCatalogo(catalogoDTO);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}

	@Override
	public List<CatalogoDTO> readEstadoCivil() throws CorvustecException
	{
		CatalogoDTO catalogoDTO;
		try {
			catalogoDTO=new CatalogoDTO();
			catalogoDTO.setCatCodigo(ConstApplication.ESTADO_CIVIL);
			return readCatalogo(catalogoDTO);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}

	@Override
	public List<CatalogoDTO> readTipoDocumento() throws CorvustecException
	{
		CatalogoDTO catalogoDTO;
		try {
			catalogoDTO=new CatalogoDTO();
			catalogoDTO.setCatCodigo(ConstApplication.TIPO_DOCUMENTO);
			return readCatalogo(catalogoDTO);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}

	@Override
	public List<CatalogoDTO> readSexo() throws CorvustecException
	{
		CatalogoDTO catalogoDTO;
		try {
			catalogoDTO=new CatalogoDTO();
			catalogoDTO.setCatCodigo(ConstApplication.SEXO);
			return readCatalogo(catalogoDTO);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}

	
	@Override
	public List<CatalogoDTO> readNivelEstudio() throws CorvustecException
	{
		CatalogoDTO catalogoDTO;
		try {
			catalogoDTO=new CatalogoDTO();
			catalogoDTO.setCatCodigo(ConstApplication.NIVEL_ESTUDIO);
			return readCatalogo(catalogoDTO);
		} catch (Exception e) {
			logger.info("Error al obtener sector {}", e.toString());
			throw new CorvustecException("Error al obtener sector");
		}				
	}

	
}
