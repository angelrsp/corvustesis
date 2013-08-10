package ec.edu.uce.inventario.web.inventario;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.inventario.entidades.InvCompra;

@ManagedBean(name = "compraPage")
@ViewScoped
public class CompraPage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private InvCompra compra;
	
	public CompraPage()
	{
		compra=new InvCompra();
	}

	public InvCompra getCompra() {
		return compra;
	}

	public void setCompra(InvCompra compra) {
		this.compra = compra;
	}
	
	
}
