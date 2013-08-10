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
public class InvSaldo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INV_SALDOS_SALCODIGO_GENERATOR", sequenceName="INV_SALDOS_SAL_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INV_SALDOS_SALCODIGO_GENERATOR")
	@Column(name="sal_codigo")
	private Integer salCodigo;

	@Column(name="sal_cantidad")
	private BigDecimal salCantidad;

	//bi-directional many-to-one association to InvArticulo
	@ManyToOne
	@JoinColumn(name="sal_articulo")
	private InvArticulo invArticulo;

	public InvSaldo() {
	}

	public Integer getSalCodigo() {
		return this.salCodigo;
	}

	public void setSalCodigo(Integer salCodigo) {
		this.salCodigo = salCodigo;
	}

	public BigDecimal getSalCantidad() {
		return this.salCantidad;
	}

	public void setSalCantidad(BigDecimal salCantidad) {
		this.salCantidad = salCantidad;
	}

	public InvArticulo getInvArticulo() {
		return this.invArticulo;
	}

	public void setInvArticulo(InvArticulo invArticulo) {
		this.invArticulo = invArticulo;
	}

}