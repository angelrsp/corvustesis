package ec.edu.uce.silsag.web.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.EmpresaService;
import ec.edu.uce.silsag.ejb.persistence.entities.AvisoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.AvisoListDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.EmpresaDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

@ViewScoped
@ManagedBean (name = "avisoEmpresaController")
public class AvisoEmpresaController extends SelectItemController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory
			.getLogger(AvisoEmpresaController.class);

	
	@EJB
	private EmpresaService empresaService;
	
	private UsuarioDTO user;
	private EmpresaDTO empresa;
	private AvisoDTO aviso;
	private List<AvisoListDTO> avisoList;

	private Object puesto;
	private Date fecha;
	
	
	@PostConstruct
	private void init()
	{
		aviso=new AvisoDTO();
		user=(UsuarioDTO)JsfUtil.getObject("UsuarioDTO");
		empresa=user.getBemEmpresas().get(0);
		avisoList=new ArrayList<AvisoListDTO>(); 
	}
	
	public AvisoDTO getAviso() {
		return aviso;
	}

	public void setAviso(AvisoDTO aviso) {
		this.aviso = aviso;
	}
	
	
	public Object getPuesto() {
		return puesto;
	}

	public void setPuesto(Object puesto) {
		this.puesto = puesto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<AvisoListDTO> getAvisoList() {
		try {
			this.avisoList=empresaService.obtenerAviso(empresa);
		} catch (SilsagException e) {
			// TODO Auto-generated catch block
			JsfUtil.addErrorMessage(e.toString());
		}
		return avisoList;
	}

	public void guardar()
	{
		try{
			aviso.setAviPuesto(Integer.valueOf(puesto.toString()));
			aviso.setBemEmpresa(empresa);
			aviso.setAviFechaCaducidad(new Timestamp(fecha.getTime()));
			empresaService.registrarAviso(aviso);
			getAvisoList();
			JsfUtil.addInfoMessage("Guardado Exitosamente");
			resetAviso();
		}
		catch(Exception e){
			log.info("Error al registrar el Candidato {}", e.toString());
			JsfUtil.addErrorMessage(e.toString());

		}
	}
	
	private void resetAviso()
	{
		aviso=new AvisoDTO();
		setPuesto(null);
	}
}
