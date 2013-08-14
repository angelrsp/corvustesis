package ec.edu.uce.inventario.web.inventario;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.inventario.entidades.InvKardex;

@ManagedBean(name = "ingresoPage")
@ViewScoped
public class IngresoPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private InvKardex kardex;

	public IngresoPage() {
		kardex = new InvKardex();
	}

	public InvKardex getKardex() {
		return kardex;
	}

	public void setKardex(InvKardex kardex) {
		this.kardex = kardex;
	}

	public void calcularTotal() {
		if (this.kardex.getKarCantidad() != null
				&& this.kardex.getKarValorUnitario() != null)
			this.kardex.setKarValorTotal(BigDecimal.valueOf(this.kardex
					.getKarCantidad().doubleValue()
					* this.kardex.getKarCantidad().doubleValue()));
	}
}
