package ec.edu.uce.indicadores.web.controller;

import java.io.Serializable;
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
import ec.edu.uce.indicadores.ejb.persistence.entities.RegistroDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalDTO;
import ec.edu.uce.indicadores.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "registroController")
public class RegistroController extends SelectItemController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IndicadorService indicadorService;
	
	private Object representanteLegalObject;
	private Object iesObject;
	
	private RepresentanteLegalDTO representanteLegalDTO;
	private IesDTO iesDTO;

	
	private List<RegistroDTO> registroList;
	
	public RegistroController() {
	
	}
	
	@PostConstruct
	private void init()
	{
		registroList=new ArrayList<RegistroDTO>();
		obtenerRegistroLista();
		representanteLegalDTO=new RepresentanteLegalDTO();
		iesDTO=new IesDTO();
	}

	public List<RegistroDTO> getRegistroList() {
		return registroList;
	}

	public void setRegistroList(List<RegistroDTO> registroList) {
		this.registroList = registroList;
	}
	
	public Object getRepresentanteLegalObject() {
		return representanteLegalObject;
	}

	public void setRepresentanteLegalObject(Object representanteLegalObject) {
		this.representanteLegalObject = representanteLegalObject;
	}

	public Object getIesObject() {
		return iesObject;
	}

	public void setIesObject(Object iesObject) {
		this.iesObject = iesObject;
	}

	public void obtenerRegistroLista()
	{
		if(representanteLegalObject==null)
			return;
		if(iesObject==null)
			return;
		representanteLegalDTO.setRleCodigo(Integer.valueOf(representanteLegalObject.toString()));
		iesDTO.setIesCodigo(Integer.valueOf(iesObject.toString()));
		try {
			registroList=indicadorService.obtenerRegistro(representanteLegalDTO, iesDTO);
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void agregar()
	{
		RegistroDTO registroDTO=new RegistroDTO();
		try {
			registroDTO.setIndy(iesDTO);
			registroDTO.setIndRepresentanteLegal(representanteLegalDTO);
			registroDTO.setRegFechaInicio(new Date());
			representanteLegalDTO.setRleCodigo(Integer.valueOf(representanteLegalObject.toString()));
			iesDTO.setIesCodigo(Integer.valueOf(iesObject.toString()));

			indicadorService.agregarRegistro(registroDTO);
			obtenerRegistroLista();
		} catch (IndicadoresException e) {
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
