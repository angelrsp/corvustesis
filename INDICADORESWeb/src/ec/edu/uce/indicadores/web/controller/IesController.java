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

import org.primefaces.event.FileUploadEvent;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.IndicadorService;
import ec.edu.uce.indicadores.ejb.persistence.entities.IesDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RegistroDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalDTO;
import ec.edu.uce.indicadores.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "iesController")
public class IesController extends SelectItemController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IndicadorService indicadorService;
	
	private IesDTO iesDTO;
	
	private Date fechaCreacion;
	
	private List<IesDTO> iesListDTO;
	private List<RegistroDTO> registroList;
	
	private Object representanteLegal;
	
	@PostConstruct
	private void init()
	{
		iesDTO=new IesDTO();
		iesListDTO=new ArrayList<IesDTO>();
		fechaCreacion=new Date();
		registroList=new ArrayList<RegistroDTO>();
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
	
	 
	public List<IesDTO> getIesListDTO() throws IndicadoresException {
		this.iesListDTO=indicadorService.obtenerIes();
		return iesListDTO;
	}

	public void setIesList(List<IesDTO> iesListDTO) {
		this.iesListDTO = iesListDTO;
	}

	public Object getRepresentanteLegal() {
		return representanteLegal;
	}

	public void setRepresentanteLegal(Object representanteLegal) {
		this.representanteLegal = representanteLegal;
	}

	public List<RegistroDTO> getRegistroList() {
		return registroList;
	}

	public void setRegistroList(List<RegistroDTO> registroList) {
		this.registroList = registroList;
	}

	public void guardarIes()
	{
		try {
			getIesDTO().setIesFechaCreacion(new Timestamp(fechaCreacion.getTime()));
			getIesDTO().setIesCodigo(null);
			indicadorService.agregarIes(getIesDTO());
			getIesList();
			iesDTO=new IesDTO();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}	
	}
	
	public void agregarRegistro()
	{
		RegistroDTO registroDTO=new RegistroDTO();
		RepresentanteLegalDTO representanteLegalDTO=new RepresentanteLegalDTO();
		try {
			representanteLegalDTO.setRleCodigo(Integer.valueOf(representanteLegal.toString()));
			registroDTO.setIndy(getIesDTO());
			registroDTO.setIndRepresentanteLegal(representanteLegalDTO);
			registroDTO.setRegFechaInicio(new Date());
			
			indicadorService.agregarRegistro(registroDTO);
			obtenerRegistroLista(getIesDTO());
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void obtenerRegistroLista(IesDTO ies)
	{
		try {
			setIesDTO(ies);
			registroList=indicadorService.obtenerRegistro(getIesDTO());
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void resetIes()
	{
		setIesDTO(new IesDTO());
	}
	
	
	public void handleFileUpload(FileUploadEvent event)
	{
		JsfUtil.addInfoMessage("Archivo "+ event.getFile().getFileName() + " esta en memoria.");
		getIesDTO().setIesImagen(event.getFile().getContents());
		getIesDTO().setIesImagenName(event.getFile().getFileName());
	}

	
}
