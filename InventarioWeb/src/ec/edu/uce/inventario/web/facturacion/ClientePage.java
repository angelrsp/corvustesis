package ec.edu.uce.inventario.web.facturacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import ec.edu.uce.inventario.entidades.FacCliente;
import ec.edu.uce.inventario.facturacion.servicio.ClienteService;

@ManagedBean(name = "clientePage")
@ViewScoped
public class ClientePage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "clienteService/local")
	private ClienteService clienteService;

	private List<FacCliente> clientes;

	private FacCliente cliente;

	public ClientePage() {
		cliente = new FacCliente();
		clientes = new ArrayList<FacCliente>();
	}

	public FacCliente getCliente() {
		return cliente;
	}

	public void setCliente(FacCliente cliente) {
		this.cliente = cliente;
	}

	public List<FacCliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<FacCliente> clientes) {
		this.clientes = clientes;
	}

	public void clean() {
		cliente = new FacCliente();
	}

	public void create() {
		try {
			if (cliente.getCliCodigo() == null)
				clienteService.create(cliente);
			else
				clienteService.update(cliente);
			clean();
			readAll();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion",
							"Guardado Exitosamente"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e
							.toString()));
		}
	}
	public void onRowSelect(SelectEvent event) {
		this.cliente=(FacCliente)event.getObject();
	}
	
	public void onRowDeleting(FacCliente cliente) {
	
	}
	
	public void readAll() {
		clientes = clienteService.readAll();
	}

	@PostConstruct
	private void init() {
		readAll();
	}
}
