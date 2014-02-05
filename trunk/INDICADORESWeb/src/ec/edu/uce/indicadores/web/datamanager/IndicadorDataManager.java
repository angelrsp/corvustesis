package ec.edu.uce.indicadores.web.datamanager;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="indicadorDataManager")
public class IndicadorDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Object ies;
	
	private Object modelo;
	
	public IndicadorDataManager() {
		
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
}
