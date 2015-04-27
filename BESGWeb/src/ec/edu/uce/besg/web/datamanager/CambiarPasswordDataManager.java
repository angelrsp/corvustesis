package ec.edu.uce.besg.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.besg.common.util.dto.PasswordDTO;

@ViewScoped
@ManagedBean(name = "cambiarPasswordDataManager")
public class CambiarPasswordDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PasswordDTO passwordDTO;
	
	public CambiarPasswordDataManager() {
		passwordDTO=new PasswordDTO();
	}

	public PasswordDTO getPasswordDTO() {
		return passwordDTO;
	}

	public void setPasswordDTO(PasswordDTO passwordDTO) {
		this.passwordDTO = passwordDTO;
	}
	
}
