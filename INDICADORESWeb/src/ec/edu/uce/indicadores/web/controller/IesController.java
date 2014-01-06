package ec.edu.uce.indicadores.web.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.IndicadorService;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "iesController")
public class IesController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IndicadorService indicadorService;
	
	private IesDTO iesDTO;
	
	private Date fechaCreacion;
	
	private List<IesDTO> iesList;
	
	@PostConstruct
	private void init()
	{
		iesDTO=new IesDTO();
		iesList=new ArrayList<IesDTO>();
		fechaCreacion=new Date();
	}

	public IesDTO getIesDTO() {
		return iesDTO;
	}

	public void setIesDTO(IesDTO iesDTO) {
		this.iesDTO = iesDTO;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	 
	public List<IesDTO> getIesList() throws IndicadoresException {
		this.iesList=indicadorService.obtenerIes();
		return iesList;
	}

	public void setIesList(List<IesDTO> iesList) {
		this.iesList = iesList;
	}

	public void guardarIes()
	{
		try {
			getIesDTO().setIesFechaCreacion(new Timestamp(fechaCreacion.getTime()));
			indicadorService.agregarIes(getIesDTO());
			getIesList();
			iesDTO=new IesDTO();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (IndicadoresException e) {
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
		}	
	}
}
