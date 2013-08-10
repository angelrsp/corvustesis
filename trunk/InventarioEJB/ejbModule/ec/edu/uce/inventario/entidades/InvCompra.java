package ec.edu.uce.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the inv_compras database table.
 * 
 */
@Entity
@Table(name="inv_compras")
public class InvCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INV_COMPRAS_COMCODIGO_GENERATOR", sequenceName="INV_COMPRAS_COM_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INV_COMPRAS_COMCODIGO_GENERATOR")
	@Column(name="com_codigo")
	private Integer comCodigo;

	@Column(name="com_fecha")
	private Timestamp comFecha;

	@Column(name="com_numero")
	private String comNumero;

	@Column(name="com_total")
	private BigDecimal comTotal;

	//bi-directional many-to-one association to InvDetalleCompra
	@OneToMany(mappedBy="invCompra")
	private List<InvDetalleCompra> invDetalleCompras;

	public InvCompra() {
	}

	public Integer getComCodigo() {
		return this.comCodigo;
	}

	public void setComCodigo(Integer comCodigo) {
		this.comCodigo = comCodigo;
	}

	public Timestamp getComFecha() {
		return this.comFecha;
	}

	public void setComFecha(Timestamp comFecha) {
		this.comFecha = comFecha;
	}

	public String getComNumero() {
		return this.comNumero;
	}

	public void setComNumero(String comNumero) {
		this.comNumero = comNumero;
	}

	public BigDecimal getComTotal() {
		return this.comTotal;
	}

	public void setComTotal(BigDecimal comTotal) {
		this.comTotal = comTotal;
	}

	public List<InvDetalleCompra> getInvDetalleCompras() {
		return this.invDetalleCompras;
	}

	public void setInvDetalleCompras(List<InvDetalleCompra> invDetalleCompras) {
		this.invDetalleCompras = invDetalleCompras;
	}

	public InvDetalleCompra addInvDetalleCompra(InvDetalleCompra invDetalleCompra) {
		getInvDetalleCompras().add(invDetalleCompra);
		invDetalleCompra.setInvCompra(this);

		return invDetalleCompra;
	}

	public InvDetalleCompra removeInvDetalleCompra(InvDetalleCompra invDetalleCompra) {
		getInvDetalleCompras().remove(invDetalleCompra);
		invDetalleCompra.setInvCompra(null);

		return invDetalleCompra;
	}

}