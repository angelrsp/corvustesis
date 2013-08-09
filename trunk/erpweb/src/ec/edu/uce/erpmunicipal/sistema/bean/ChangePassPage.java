package ec.edu.uce.erpmunicipal.sistema.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ec.edu.uce.erpmunicipal.sistema.bsl.UserService;
import ec.edu.uce.erpmunicipal.sistema.orm.SisUsuario;

@ManagedBean(name = "changePassPage")
@ViewScoped
public class ChangePassPage {

	@EJB(name = "userService/local")
	private UserService userService;

	String passOld;
	String passNew;
	String passConfirmNew;

	/**
	 * @return the passOld
	 */
	public String getPassOld() {
		return passOld;
	}

	/**
	 * @param passOld
	 *            the passOld to set
	 */
	public void setPassOld(String passOld) {
		this.passOld = passOld;
	}

	/**
	 * @return the passNew
	 */
	public String getPassNew() {
		return passNew;
	}

	/**
	 * @param passNew
	 *            the passNew to set
	 */
	public void setPassNew(String passNew) {
		this.passNew = passNew;
	}

	/**
	 * @return the passConfirmNew
	 */
	public String getPassConfirmNew() {
		return passConfirmNew;
	}

	/**
	 * @param passConfirmNew
	 *            the passConfirmNew to set
	 */
	public void setPassConfirmNew(String passConfirmNew) {
		this.passConfirmNew = passConfirmNew;
	}

	public ChangePassPage() {

	}

	public void changeClick() {
		SisUsuario user = new SisUsuario();
		FacesMessage msg = null;
		try {
			if (passNew.equals(passConfirmNew)) {
				user = ((SisUsuario) FacesContext.getCurrentInstance()
						.getExternalContext().getSessionMap().get("user"));
				
				user.setUsuClave(passConfirmNew);
				
				userService.updatePass(user);
			} else {
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
						"Las contraseña nueva y confirmar contraseña nueva no son iguales");

				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		} catch (Exception e) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					e.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void cancelClick() {
		passOld="";
		passNew="";
		passConfirmNew="";
	}

}
