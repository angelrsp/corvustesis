 package ec.edu.uce.silsae.ejb.negocio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.uce.silsae.commons.dto.util.CredencialesDTO;
import ec.edu.uce.silsae.commons.util.MailUtil;
import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.LoginService;
import ec.edu.uce.silsae.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.silsae.ejb.persistence.entities.UsuarioDTO;

@Stateless
public class LoginServiceImpl implements LoginService{
	
	@EJB
	private FactoryDAO factoryDAO;
	
	@Override
	public UsuarioDTO autenticarUsuario(CredencialesDTO credencialesDTO) throws SilsaeException{
		
		try {
			
			return factoryDAO.getUsuarioDAOImpl().buscarUsuarioLogin(credencialesDTO);
			
		} catch (SilsaeException e) {
			throw new SilsaeException(e);
		} catch (Exception e) {
			throw new SilsaeException(e);
		}
		
	}
	
	@Override
	public Boolean recuperarClave(CredencialesDTO credencialesDTO) throws SilsaeException{
		try {
			UsuarioDTO user=factoryDAO.getUsuarioDAOImpl().buscarUsuario(credencialesDTO);
			if(user!=null)
			{
				StringBuilder sb=new StringBuilder();
				sb.append("La solicitud de recuperación de la clave de acceso he sido procesada.<br/>");
				sb.append("Su credencial de acceso es: "+user.getUsuPassword()+"<br/>");
				sb.append("Se recomienda actualizar su contraseña.<br/>");
				sb.append("Facultad de Odontología");
				
				new MailUtil().send(user.getUsuMail(), "SILSAG: Recuperación de su credencial de acceso", sb.toString());
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (SilsaeException e) {
			throw new SilsaeException(e);
		} catch (Exception e) {
			throw new SilsaeException(e);
		}
		
	}
}
