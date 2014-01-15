package ec.edu.uce.silsag.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.EmpresaService;
import ec.edu.uce.silsag.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.AvisoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.AvisoListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.PostulacionListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;

@Stateless
public class EmpresaServiceImpl implements EmpresaService {

	private static final Logger log = LoggerFactory
			.getLogger(EmpresaServiceImpl.class);

	@EJB
	private FactoryDAO factoryDAO;

	@Override
	public EmpresaDTO registrarEmpresa(EmpresaDTO empresa)
			throws SilsagException {
		try {
			UsuarioDTO user=empresa.getBemUsuario();
			user.setBemPerfil(factoryDAO.getPerfilDAOImpl().find(2));
			user.setUsuLogin(user.getUsuMail());
			empresa.setEmpActiva(false);
			return factoryDAO.getEmpresaDAOImpl().create(empresa);
		} catch (Exception e) {
			log.info("Error al registrar Empresa {}", e.toString());
			throw new SilsagException("Error al registrar Empresa");
		}
	}
	
	
	@Override
	public EmpresaDTO actualizarEmpresa(EmpresaDTO empresa)throws SilsagException {
		try {
			return factoryDAO.getEmpresaDAOImpl().edit(empresa);
		} catch (Exception e) {
			log.info("Error al registrar Empresa {}", e.toString());
			throw new SilsagException("Error al registrar Empresa");
		}
	}
	
	@Override
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
	public List<AvisoListDTO> obtenerAviso(EmpresaDTO empresa) throws SilsagException
	{
		try {
		return factoryDAO.getAvisoDAOImpl().getAll(empresa);
		} catch (Exception e) {
			log.info("Error al registrar Aviso {}", e.toString());
			throw new SilsagException("Error al registrar Aviso");
		}				
	}
	
	@Override
	public ContactoDTO agregarContacto(ContactoDTO contacto) throws SilsagException
	{
		try {
		return factoryDAO.getContactoDAOImpl().create(contacto);
		} catch (Exception e) {
			log.info("Error al registrar Aviso {}", e.toString());
			throw new SilsagException("Error al registrar Aviso");
		}		
	}
	
	@Override
	public List<ContactoDTO> obtenerContactos(EmpresaDTO empresa) throws SilsagException
	{
		try {
			return factoryDAO.getContactoDAOImpl().getAll(empresa);
		} catch (Exception e) {
			log.info("Error al registrar Aviso {}", e.toString());
			throw new SilsagException("Error al registrar Aviso");
		}				
	}

	@Override
	public List<PostulacionListDTO> obtenerPostulacion(EmpresaDTO empresa) throws SilsagException
	{
		try {
			return factoryDAO.getPostulacionDAOImpl().getAll(empresa);
		} catch (Exception e) {
			log.info("Error al registrar Aviso {}", e.toString());
			throw new SilsagException("Error al registrar Aviso");
		}				
	}

	
}
