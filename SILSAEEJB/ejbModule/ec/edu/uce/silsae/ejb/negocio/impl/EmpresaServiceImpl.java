package ec.edu.uce.silsae.ejb.negocio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.EmpresaService;
import ec.edu.uce.silsae.ejb.persistence.dao.FactoryDAO;
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
			UsuarioDTO user=new UsuarioDTO();
			user=empresa.getBemUsuario();
			user.setBemPerfil(factoryDAO.getPerfilDAOImpl().find(2));
			user.setUsuLogin(user.getUsuMail());
			return factoryDAO.getEmpresaDAOImpl().create(empresa);
		} catch (Exception e) {
			log.info("Error al registrar Empresa {}", e.toString());
			throw new SilsaeException("Error al registrar Empresa");
		}
	}
}
