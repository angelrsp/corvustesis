package ec.edu.uce.indicadores.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ModeloDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.UsuarioDTO;

@SessionScoped
@ManagedBean(name="indicadorDataManager")
public class IndicadorDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Object ies;
	private Object modelo;

	
	private IesDTO iesDTO;
	private ModeloDTO modeloDTO;

	private UsuarioDTO user;
	
	
	
	
	public IndicadorDataManager() {
		
		user=new UsuarioDTO();
	}

	public Object getIes() {
		return ies;
	}

	public void setIes(Object ies) {
		this.ies = ies;
	}

	public Object getModelo() {
		return modelo;
	}

	public void setModelo(Object modelo) {
		this.modelo = modelo;
	}

	public IesDTO getIesDTO() {
		return iesDTO;
	}

	public void setIesDTO(IesDTO iesDTO) {
		this.iesDTO = iesDTO;
	}

	public ModeloDTO getModeloDTO() {
		return modeloDTO;
	}

	public void setModeloDTO(ModeloDTO modeloDTO) {
		this.modeloDTO = modeloDTO;
	}



	public UsuarioDTO getUser() {
		return user;
	}

	public void setUser(UsuarioDTO user) {
		this.user = user;
	}
}
