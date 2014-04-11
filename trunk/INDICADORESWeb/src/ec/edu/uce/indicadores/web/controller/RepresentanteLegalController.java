package ec.edu.uce.indicadores.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.IndicadorService;
import ec.edu.uce.indicadores.ejb.persistence.entities.ContactoDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.ContactoListDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.RepresentanteLegalListDTO;
import ec.edu.uce.indicadores.web.datamanager.IndicadorDataManager;
import ec.edu.uce.indicadores.web.util.JsfUtil;
import ec.edu.uce.indicadores.web.util.validator.Identification;

@ViewScoped
@ManagedBean(name = "representanteLegalController")
public class RepresentanteLegalController extends SelectItemController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IndicadorService indicadorService;
	
	@ManagedProperty(value="#{indicadorDataManager}")
	private IndicadorDataManager indicadorDataManager;
	
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

	public void setIndicadorDataManager(IndicadorDataManager indicadorDataManager) {
		this.indicadorDataManager = indicadorDataManager;
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
			if(Integer.valueOf(tipoDocumento.toString())==6)
			{
				if(!Identification.isCedula(getRepresentanteLegalDTO().getRleDi()))
				{
					JsfUtil.addErrorMessage("Cedula Invalida");
					return;
				}
			}
			getRepresentanteLegalDTO().setRleTipo(Integer.valueOf(tipoDocumento.toString()));
			indicadorService.createOrUpdateRepresentanteLegal(getRepresentanteLegalDTO());
			getRepresentanteList();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
			setRepresentanteLegalDTO(new RepresentanteLegalDTO());
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void editRepresentante(RepresentanteLegalListDTO representante)
	{
		try {
			setTipoDocumento(representante.getRleTipo());
			setRepresentanteLegalDTO(indicadorService.readRepresentante(representante.getRleCodigo()));
			if(getRepresentanteLegalDTO().getRleFoto()!=null)
				getRepresentanteLegalDTO().setRlePathFoto(JsfUtil.saveToDiskUpdload(getRepresentanteLegalDTO().getRleFoto(), getRepresentanteLegalDTO().getRleFotoNombre()));
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void cancel()
	{
		setRepresentanteLegalDTO(new RepresentanteLegalDTO());
		setTipoDocumento(null);
	}
	
	public void deleteRepresentante(RepresentanteLegalListDTO representante)
	{
		try {
			RepresentanteLegalDTO rep=new RepresentanteLegalDTO();
			rep.setRleApellidos(representante.getRleApellidos());
			rep.setRleNombres(representante.getRleNombres());
			rep.setRleCodigo(representante.getRleCodigo());
			rep.setRleDi(representante.getRleDi());
			indicadorService.deleteRepresentanteLegal(rep);
			getRepresentanteLegalList();
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	
	public void cargarContacto(RepresentanteLegalListDTO rep)
	{
		try {
			getRepresentanteLegalDTO().setRleCodigo(rep.getRleCodigo());
			this.contactoList=indicadorService.obtenerContactos(getRepresentanteLegalDTO());
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}

	public void agregarContacto()
	{
		try {
			contactoDTO.setConTipo(Integer.valueOf(tipoContacto.toString()));
			contactoDTO.setIndRepresentanteLegal(representanteLegalDTO);
			indicadorService.createOrUpdateContacto(contactoDTO);
			RepresentanteLegalListDTO li=new RepresentanteLegalListDTO();
			li.setRleCodigo(representanteLegalDTO.getRleCodigo());
			cargarContacto(li);
			contactoDTO=new ContactoDTO();
			tipoContacto=null;
			JsfUtil.addInfoMessage("Guardado Exitosamente");
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	
	public void editContacto(ContactoListDTO contacto)
	{
		ContactoDTO con=new ContactoDTO();
		con.setConCodigo(contacto.getConCodigo());
		con.setConValor(contacto.getConValor());
		setContactoDTO(con);
		setTipoContacto(contacto.getConTipo());
	}

	
	public void deleteContacto(ContactoListDTO contacto)
	{
		try {
			ContactoDTO con=new ContactoDTO();
			con.setConCodigo(contacto.getConCodigo());
			con.setConValor(contacto.getConValor());
			indicadorService.deleteContacto(con);
			RepresentanteLegalListDTO li=new RepresentanteLegalListDTO();
			li.setRleCodigo(representanteLegalDTO.getRleCodigo());
			cargarContacto(li);
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void cancelContacto()
	{
		setContactoDTO(new ContactoDTO());
		setTipoContacto(null);
	}

	public void handleFileUpload(FileUploadEvent event)	{
		getRepresentanteLegalDTO().setRleFoto(event.getFile().getContents());
		getRepresentanteLegalDTO().setRleFotoNombre(event.getFile().getFileName());
		getRepresentanteLegalDTO().setRlePathFoto(JsfUtil.saveToDiskUpdload(event.getFile().getContents(), event.getFile().getFileName()));
	}

}
