package ec.edu.uce.silsag.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.AdministracionService;
import ec.edu.uce.silsag.ejb.persistence.entities.PostulacionDTO;

@ViewScoped
@ManagedBean (name = "reportePostulacionController")
public class ReportePostulacionController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AdministracionService administracionService;

	
	private List<PostulacionDTO> listAll;
	private List<PostulacionDTO> listAcpetado;
	
	public ReportePostulacionController() {
	}
	
	public List<PostulacionDTO> getListAll() {
		try {
			this.listAll=administracionService.obtenerPostulacion();
		} catch (SilsagException e) {
			e.printStackTrace();
		}
		return listAll;
	}
	public void setListAll(List<PostulacionDTO> listAll) {
		this.listAll = listAll;
	}
	public List<PostulacionDTO> getListAcpetado() {
		try {
			this.listAcpetado=administracionService.obtenerPostulacion(true);
		} catch (SilsagException e) {
			e.printStackTrace();
		}
		return listAcpetado;
	}
	public void setListAcpetado(List<PostulacionDTO> listAcpetado) {
		this.listAcpetado = listAcpetado;
	}
	
	
}
