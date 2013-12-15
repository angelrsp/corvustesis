package ec.edu.uce.silsae.ejb.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.EmpresaService;
import ec.edu.uce.silsae.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.AvisoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.AvisoListDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;

@Stateless
public class EmpresaServiceImpl implements EmpresaService {

	private static final Logger log = LoggerFactory
			.getLogger(EmpresaServiceImpl.class);

	@EJB
	private FactoryDAO factoryDAO;

	@Override
	public EmpresaDTO registrarEmpresa(EmpresaDTO empresa)
			throws SilsaeException {
		try {
			UsuarioDTO user=empresa.getBemUsuario();
			user.setBemPerfil(factoryDAO.getPerfilDAOImpl().find(2));
			user.setUsuLogin(user.getUsuMail());
			return factoryDAO.getEmpresaDAOImpl().create(empresa);
		} catch (Exception e) {
			log.info("Error al registrar Empresa {}", e.toString());
			throw new SilsaeException("Error al registrar Empresa");
		}
	}
	
	@Override
	public AvisoDTO registrarAviso(AvisoDTO aviso) throws SilsaeException
	{
		try {
		return factoryDAO.getAvisoDAOImpl().create(aviso);
		} catch (Exception e) {
			log.info("Error al registrar Aviso {}", e.toString());
			throw new SilsaeException("Error al registrar Aviso");
		}		
	}
	
	@Override
	public List<AvisoListDTO> obtenerAviso(EmpresaDTO empresa) throws SilsaeException
	{
		try {
		return factoryDAO.getAvisoDAOImpl().getAll(empresa);
		} catch (Exception e) {
			log.info("Error al registrar Aviso {}", e.toString());
			throw new SilsaeException("Error al registrar Aviso");
		}				
	}
	
	@Override
	public ContactoDTO agregarContacto(ContactoDTO contacto) throws SilsaeException
	{
		try {
		return factoryDAO.getContactoDAOImpl().create(contacto);
		} catch (Exception e) {
			log.info("Error al registrar Aviso {}", e.toString());
			throw new SilsaeException("Error al registrar Aviso");
		}		
	}
	
	@Override
	public List<ContactoDTO> obtenerContactos(EmpresaDTO empresa) throws SilsaeException
	{
		try {
			return factoryDAO.getContactoDAOImpl().getAll(empresa);
		} catch (Exception e) {
			log.info("Error al registrar Aviso {}", e.toString());
			throw new SilsaeException("Error al registrar Aviso");
		}				
	}
	
}
