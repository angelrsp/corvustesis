package ec.edu.uce.besg.ejb.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.common.util.EncryptionUtility;
import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.persistence.entity.ContactoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.ContactoListDTO;
import ec.edu.uce.besg.ejb.persistence.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.HistorialPasswordDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.service.EmpresaService;
import ec.edu.uce.besg.ejb.vo.EmpresaVO;


@Stateless
public class EmpresaServiceImpl implements EmpresaService{
	
	private static final Logger logger = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;
	
	
	@Override
	public EmpresaDTO registrarActualizarEmpresa(EmpresaVO empresa)	throws CorvustecException {
		UsuarioDTO usuarioDTO;
		HistorialPasswordDTO historialPasswordDTO;
		try{
			if(empresa.getEmpresaDTO().getEmpCodigo()!=null)
				return factoryDAO.getEmpresaDAOImpl().update(empresa.getEmpresaDTO());
			else
			{
				historialPasswordDTO=new HistorialPasswordDTO();
				empresa.getUsuarioDTO().setUsuPassword(EncryptionUtility.getInstance().encriptar(empresa.getUsuarioDTO().getUsuPassword()));
				usuarioDTO= factoryDAO.getUsuarioDAOImpl().create(empresa.getUsuarioDTO());
				
				historialPasswordDTO.setSegUsuario(usuarioDTO);
				historialPasswordDTO.setHpaFecha(new Timestamp(new Date().getTime()));
				historialPasswordDTO.setHpaPassword(EncryptionUtility.getInstance().encriptar(empresa.getUsuarioDTO().getUsuPassword()));
				
				factoryDAO.getHistorialPasswordDAOImpl().create(historialPasswordDTO);
				
				empresa.getEmpresaDTO().setSegUsuario(usuarioDTO);
				return factoryDAO.getEmpresaDAOImpl().create(empresa.getEmpresaDTO());
			}
		} catch (Exception e) {
			logger.info("Error al registrar Empresa {}", e.toString());
			throw new CorvustecException("Error al registrar Empresa");
		}
		finally{
			usuarioDTO=null;
			historialPasswordDTO=null;
		}
	}
	
	
	@Override
	public EmpresaDTO actualizarEmpresa(EmpresaDTO empresa)throws CorvustecException {
		try {
			return factoryDAO.getEmpresaDAOImpl().update(empresa);
		} catch (Exception e) {
			logger.info("Error al registrar Empresa {}", e.toString());
			throw new CorvustecException("Error al registrar Empresa");
		}
	}

	@Override
	public EmpresaDTO updateEmpresa(EmpresaDTO empresa)throws CorvustecException {
		try {
			return factoryDAO.getEmpresaDAOImpl().update(empresa);
		} catch (Exception e) {
			logger.info("Error al registrar Empresa {}", e.toString());
			throw new CorvustecException("Error al registrar Empresa");
		}
	}

	
	
	/*@Override
	public AvisoDTO registrarAviso(AvisoDTO aviso) throws SilsagException
	{
		try {
		return factoryDAO.getAvisoDAOImpl().create(aviso);
		} catch (Exception e) {
			log.info("Error al registrar Aviso {}", e.toString());
			throw new SilsagException("Error al registrar Aviso");
		}		
	}
	
	@Override
	public List<AvisoDTO> obtenerAviso(EmpresaDTO empresa) throws SilsagException
	{
		try {
		return factoryDAO.getAvisoDAOImpl().getAll(empresa);
		} catch (Exception e) {
			log.info("Error al registrar Aviso {}", e.toString());
			throw new SilsagException("Error al registrar Aviso");
		}				
	}
	*/
	@Override
	public ContactoDTO agregarContacto(ContactoDTO contacto) throws CorvustecException
	{
		try {
			if(contacto.getConCodigo()!=null)
				return factoryDAO.getContactoDAOImpl().update(contacto);
			else
				return factoryDAO.getContactoDAOImpl().create(contacto);
			
			} catch (Exception e) {
			//log.info("Error al registrar Aviso {}", e.toString());
			throw new CorvustecException("Error al registrar Aviso");
		}		
	}
	
	@Override
	public ContactoDTO obtenerContactos(ContactoListDTO contacto) throws CorvustecException
	{
		try {
			ContactoDTO contactoEncontrado=factoryDAO.getContactoDAOImpl().find(contacto.getConCodigo());
			return contactoEncontrado;
		} catch (Exception e) {
			//log.info("Error al registrar Aviso {}", e.toString());
			throw new CorvustecException("Error al obtener el contacto");
		}				
	}
	
	@Override
	public EmpresaDTO readEmpresa(EmpresaDTO empresa) throws CorvustecException
	{
		List<EmpresaDTO> empresaList;
		try {
			empresaList = factoryDAO.getEmpresaDAOImpl().getByAnd(empresa);
			if(empresaList.isEmpty())
				return new EmpresaDTO();
			else
				return empresaList.get(0);	
		} catch (Exception e) {
			logger.info("Error al readEmpresa {}", e.toString());
			throw new CorvustecException("Error al readEmpresa " +e.toString());
		}				
	}
	
	@Override
	public List<EmpresaDTO> obtenerEmpresa(EmpresaDTO empresa) throws SecurityException
	{
		try {
			return factoryDAO.getEmpresaDAOImpl().getByAnd(empresa);
		} catch (Exception e) {
			logger.info("Error al registrar Aviso {}", e.toString());
			throw new SecurityException("Error al obtener empresa");
		}				
	}
	
	@Override
	public List<ContactoListDTO> buscarContacto(ContactoListDTO contacto) throws CorvustecException
	{
		try {
			return factoryDAO.getContactoDAOImpl().getByAnd(contacto);
		} catch (Exception e) {
			logger.info("Error al registrar Aviso {}", e.toString());
			throw new CorvustecException("Error al buscar contactos");
		}				
	}
	
	
	
	@Override
	public CatalogoDTO obtenerCatalogoId(int id) throws CorvustecException
	{
		try {
			CatalogoDTO catalogoEncontrado=factoryDAO.getCatalogoDAOImpl().find(id);
			return catalogoEncontrado;
		} catch (Exception e) {
			logger.info("Error al registrar Aviso {}", e.toString());
			throw new CorvustecException("Error al obtener el catalogo");
		}				
	}
	
	
	
	
}
