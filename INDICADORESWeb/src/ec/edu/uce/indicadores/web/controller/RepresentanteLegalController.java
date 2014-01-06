package ec.edu.uce.indicadores.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.IndicadorService;
import ec.edu.uce.indicadores.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalDTO;
import ec.edu.uce.indicadores.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "representanteLegalController")
public class RepresentanteLegalController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IndicadorService indicadorService;
	
	private RepresentanteLegalDTO representanteLegalDTO;
	private ContactoDTO contactoDTO;
	
	private List<RepresentanteLegalDTO> representanteList;
	private List<ContactoDTO> contactoList;
	
	@PostConstruct
	private void init()
	{
		representanteLegalDTO=new RepresentanteLegalDTO();
		contactoDTO=new ContactoDTO();
		representanteList=new ArrayList<RepresentanteLegalDTO>();
		contactoList=new ArrayList<ContactoDTO>();
	}

	public RepresentanteLegalDTO getRepresentanteLegalDTO() {
		return representanteLegalDTO;
	}

	public void setRepresentanteLegalDTO(RepresentanteLegalDTO representanteLegalDTO) {
		this.representanteLegalDTO = representanteLegalDTO;
	}

	public ContactoDTO getContactoDTO() {
		return contactoDTO;
	}

	public void setContactoDTO(ContactoDTO contactoDTO) {
		this.contactoDTO = contactoDTO;
	}

	public List<RepresentanteLegalDTO> getRepresentanteList() throws IndicadoresException {
		this.representanteList=indicadorService.obtenerRepresentantes();
		return representanteList;
	}

	public void setRepresentanteList(List<RepresentanteLegalDTO> representanteList) {
		this.representanteList = representanteList;
	}

	public List<ContactoDTO> getContactoList() {
		return contactoList;
	}

	public void setContactoList(List<ContactoDTO> contactoList) {
		this.contactoList = contactoList;
	}

	public void guardarRepresentante()
	{
		try {
			indicadorService.agregarRepresentanteLegal(getRepresentanteLegalDTO());
			getRepresentanteList();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (IndicadoresException e) {
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void cargarContacto(RepresentanteLegalDTO rep)
	{
		try {
			this.representanteLegalDTO=rep;
			this.contactoList=indicadorService.obtenerContactos(rep);
		} catch (IndicadoresException e) {
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void agregarContacto()
	{
		try {
			contactoDTO.setIndRepresentanteLegal(representanteLegalDTO);
			indicadorService.agregarContacto(contactoDTO);
			cargarContacto(representanteLegalDTO);
			contactoDTO=new ContactoDTO();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (IndicadoresException e) {
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
