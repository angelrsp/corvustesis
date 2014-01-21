 package ec.edu.uce.silsag.ejb.negocio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.uce.silsag.commons.dto.util.CredencialesDTO;
import ec.edu.uce.silsag.commons.util.MailUtil;
import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.LoginService;
import ec.edu.uce.silsag.ejb.persistence.dao.FactoryDAO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;

@Stateless
public class LoginServiceImpl implements LoginService{
	
	@EJB
	private FactoryDAO factoryDAO;
	
	@Override
	public UsuarioDTO autenticarUsuario(CredencialesDTO credencialesDTO) throws SilsagException{
		
		try {
			
			return factoryDAO.getUsuarioDAOImpl().buscarUsuarioLogin(credencialesDTO);
			
		} catch (SilsagException e) {
			throw new SilsagException(e);
		} catch (Exception e) {
			throw new SilsagException(e);
		}
		
	}
	
	@Override
	public Boolean recuperarClave(CredencialesDTO credencialesDTO) throws SilsagException{
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
			
		} catch (SilsagException e) {
			throw new SilsagException(e);
		} catch (Exception e) {
			throw new SilsagException(e);
		}
		
	}
}
