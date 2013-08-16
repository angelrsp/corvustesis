package ec.edu.uce.inventario.web.inventario;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.inventario.entidades.InvKardex;
import ec.edu.uce.inventario.inventario.servicio.KardexService;

@ManagedBean(name = "ingresoPage")
@ViewScoped
public class IngresoPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB(name = "kardexService/local")
	private KardexService kardexService;

	private InvKardex kardex;
	
	private String codigoManual;

	public IngresoPage() {
		kardex = new InvKardex();
	}

	public InvKardex getKardex() {
		return kardex;
	}

	public void setKardex(InvKardex kardex) {
		this.kardex = kardex;
	}

	public String getCodigoManual() {
		return codigoManual;
	}

	public void setCodigoManual(String codigoManual) {
		this.codigoManual = codigoManual;
	}

	public void calcularTotal() {
		if (this.kardex.getKarCantidad() != null
				&& this.kardex.getKarValorUnitario() != null)
			this.kardex.setKarValorTotal(BigDecimal.valueOf(this.redondear(this.kardex.getKarCantidad().doubleValue()* this.kardex.getKarValorUnitario().doubleValue(),4)));
	}
	
	public void clean()
	{
		kardex=new InvKardex();
	}
	
	public void create()
	{
		//1 . Ingreso
		kardexService.create(1, kardex);
	}

	private double redondear(double valor, int decimales)
	{
		long mult=(long)Math.pow(10, decimales);
		double resultado=(Math.round(valor*mult))/(double)mult;
		return resultado;
	}
}