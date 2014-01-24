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
import ec.edu.uce.indicadores.ejb.persistence.entities.ContactoListDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalListDTO;
import ec.edu.uce.indicadores.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name = "representanteLegalController")
public class RepresentanteLegalController extends SelectItemController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IndicadorService indicadorService;
	
	private RepresentanteLegalDTO representanteLegalDTO;
	private ContactoDTO contactoDTO;
	
	private List<RepresentanteLegalListDTO> representanteList;
	private List<ContactoListDTO> contactoList;
	
	private Object tipoContacto;
	private Object tipoDocumento;
	
	@PostConstruct
	private void init()
	{
		representanteLegalDTO=new RepresentanteLegalDTO();
		contactoDTO=new ContactoDTO();
		representanteList=new ArrayList<RepresentanteLegalListDTO>();
		contactoList=new ArrayList<ContactoListDTO>();
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

	public List<RepresentanteLegalListDTO> getRepresentanteList() throws IndicadoresException {
		this.representanteList=indicadorService.obtenerRepresentantes();
		return representanteList;
	}

	public void setRepresentanteList(List<RepresentanteLegalListDTO> representanteList) {
		this.representanteList = representanteList;
	}

	public List<ContactoListDTO> getContactoList() {
		return contactoList;
	}

	public void setContactoList(List<ContactoListDTO> contactoList) {
		this.contactoList = contactoList;
	}

	public Object getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(Object tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public Object getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Object tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void guardarRepresentante()
	{
		try {
			getRepresentanteLegalDTO().setRleTipo(Integer.valueOf(tipoDocumento.toString()));
			getRepresentanteLegalDTO().setRleCodigo(null);
			indicadorService.agregarRepresentanteLegal(getRepresentanteLegalDTO());
			getRepresentanteList();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
			setRepresentanteLegalDTO(new RepresentanteLegalDTO());
		} catch (IndicadoresException e) {
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void cargarContacto(RepresentanteLegalListDTO rep)
	{
		try {
			getRepresentanteLegalDTO().setRleCodigo(rep.getRleCodigo());
			this.contactoList=indicadorService.obtenerContactos(getRepresentanteLegalDTO());
		} catch (IndicadoresException e) {
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void agregarContacto()
	{
		try {
			contactoDTO.setConTipo(Integer.valueOf(tipoContacto.toString()));
			contactoDTO.setIndRepresentanteLegal(representanteLegalDTO);
			indicadorService.agregarContacto(contactoDTO);
			RepresentanteLegalListDTO li=new RepresentanteLegalListDTO();
			li.setRleCodigo(representanteLegalDTO.getRleCodigo());
			cargarContacto(li);
			contactoDTO=new ContactoDTO();
			tipoContacto=null;
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (IndicadoresException e) {
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
