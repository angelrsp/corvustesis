package ec.edu.uce.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the inv_saldos database table.
 * 
 */
@Entity
@Table(name="inv_saldos")
@NamedQuery(name="InvSaldo.findAll", query="SELECT i FROM InvSaldo i")
public class InvSaldo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INV_SALDOS_INVCODIGO_GENERATOR", sequenceName="INV_SALDOS_SAL_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INV_SALDOS_INVCODIGO_GENERATOR")
	@Column(name="inv_codigo")
	private Integer invCodigo;

	@Column(name="inv_cantidad")
	private BigDecimal invCantidad;

	//bi-directional many-to-one association to InvArticulo
	@ManyToOne
	@JoinColumn(name="inv_articulo")
	private InvArticulo invArticuloBean;

	public InvSaldo() {
	}

	public Integer getInvCodigo() {
		return this.invCodigo;
	}

	public void setInvCodigo(Integer invCodigo) {
		this.invCodigo = invCodigo;
	}

	public BigDecimal getInvCantidad() {
		return this.invCantidad;
	}

	public void setInvCantidad(BigDecimal invCantidad) {
		this.invCantidad = invCantidad;
	}

	public InvArticulo getInvArticuloBean() {
		return this.invArticuloBean;
	}

	public void setInvArticuloBean(InvArticulo invArticuloBean) {
		this.invArticuloBean = invArticuloBean;
	}

}