package ec.edu.uce.besg.ejb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.uce.besg.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.besg.ejb.entity.ContactoDTO;
import ec.edu.uce.besg.ejb.entity.EmpresaDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.CatalogoDTO;
import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;
import ec.edu.uce.besg.ejb.service.ServicioEmpresa;
import ec.edu.uce.besg.ejb.util.SeguridadesException;
import ec.edu.uce.besg.ejb.vo.EmpresaVO;


@Stateless
public class ServicioEmpresaImpl implements ServicioEmpresa{
	//private static final Logger log = LoggerFactory.getLogger(ServicioEmpresaImpl.class);
	
	@EJB
	private FactoryDAO factoryDAO;
	
	@Override
	public EmpresaDTO registrarEmpresa(EmpresaVO empresa)
			throws SeguridadesException {
		UsuarioDTO user;
		CatalogoDTO sector;
		List<UsuarioDTO> listUsuario;
		try{
			listUsuario=new ArrayList<UsuarioDTO>();
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
			
			empresa.getEmpresaDTO().setEmpUsuario(user.getUsuCodigo());
			//empresa.setEmpActiva(false);
			sector=factoryDAO.getCatalogoDAOImpl().find(empresa.getEmpresaDTO().getEmpSector());
			empresa.getEmpresaDTO().setEmpSector(sector.getCatCodigo());
			return factoryDAO.getEmpresaDAOImpl().create(empresa.getEmpresaDTO());
		} catch (Exception e) {
			//log.info("Error al registrar Empresa {}", e.toString());
			throw new SeguridadesException("Error al registrar Empresa");
		}
	}
	
	
	@Override
	public EmpresaDTO actualizarEmpresa(EmpresaDTO empresa)throws SeguridadesException {
		try {
			return factoryDAO.getEmpresaDAOImpl().edit(empresa);
		} catch (Exception e) {
			//log.info("Error al registrar Empresa {}", e.toString());
			throw new SeguridadesException("Error al registrar Empresa");
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
	public ContactoDTO agregarContacto(ContactoDTO contacto) throws SecurityException
	{
		try {
		return factoryDAO.getContactoDAOImpl().create(contacto);
		} catch (Exception e) {
			//log.info("Error al registrar Aviso {}", e.toString());
			throw new SecurityException("Error al registrar Aviso");
		}		
	}
	
	@Override
	public List<ContactoDTO> obtenerContactos(ContactoDTO contacto) throws SecurityException
	{
		try {
			return factoryDAO.getContactoDAOImpl().getByAnd(contacto);
		} catch (Exception e) {
			//log.info("Error al registrar Aviso {}", e.toString());
			throw new SecurityException("Error al registrar Aviso");
		}				
	}

}
