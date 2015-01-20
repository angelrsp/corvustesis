package ec.edu.uce.besg.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.besg.common.util.CorvustecException;
import ec.edu.uce.besg.common.util.UtilEncryption;
import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.entity.ContactoDTO;
import ec.edu.uce.besg.ejb.entity.ContactoListDTO;
import ec.edu.uce.besg.ejb.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.service.ServicioEmpresa;
import ec.edu.uce.besg.ejb.vo.EmpresaVO;


@Stateless
public class ServicioEmpresaImpl implements ServicioEmpresa{
	
	private static final Logger logger = LoggerFactory.getLogger(ServicioEmpresaImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;
	
	
	@Override
	public EmpresaDTO registrarActualizarEmpresa(EmpresaVO empresa)
			throws CorvustecException {
		UsuarioDTO usuarioDTO;
		//CatalogoDTO sector;
		//List<UsuarioDTO> listUsuario;
		try{
			/*listUsuario=new ArrayList<UsuarioDTO>();
			user=empresa.getUsuarioDTO();
			if(user.getUsuCodigo()!=null)
			{
				user=factoryDAO.getUsuarioDAOImpl().edit(user);
			}
			else
				{
				listUsuario=factoryDAO.getUsuarioDAOImpl().getByAnd(user);
				if(listUsuario.size()<=0)
					user=factoryDAO.getUsuarioDAOImpl().create(user);
				else
					user=listUsuario.get(0);
				}
			empresa.getEmpresaDTO().setEmpUsuario(user.getUsuCodigo());*/
			//empresa.setEmpActiva(false);
			if(empresa.getEmpresaDTO().getEmpCodigo()!=null)
				return factoryDAO.getEmpresaDAOImpl().edit(empresa.getEmpresaDTO());
			else
			{
				empresa.getUsuarioDTO().setUsuPassword(UtilEncryption.getInstancia().encriptar(empresa.getUsuarioDTO().getUsuPassword()));
				usuarioDTO= factoryDAO.getUsuarioDAOImpl().create(empresa.getUsuarioDTO());
				
				empresa.getEmpresaDTO().setSegUsuario(usuarioDTO);
				return factoryDAO.getEmpresaDAOImpl().create(empresa.getEmpresaDTO());
			}
		} catch (Exception e) {
			logger.info("Error al registrar Empresa {}", e.toString());
			throw new CorvustecException("Error al registrar Empresa");
		}
	}
	
	
	@Override
	public EmpresaDTO actualizarEmpresa(EmpresaDTO empresa)throws CorvustecException {
		try {
			return factoryDAO.getEmpresaDAOImpl().edit(empresa);
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
				return factoryDAO.getContactoDAOImpl().edit(contacto);
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
