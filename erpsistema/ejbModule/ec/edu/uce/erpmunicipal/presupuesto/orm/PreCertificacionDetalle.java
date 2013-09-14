package ec.edu.uce.erpmunicipal.presupuesto.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the pre_certificacion_detalle database table.
 * 
 */
@Entity
@Table(name="pre_certificacion_detalle")
public class PreCertificacionDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_CERTIFICACION_DETALLE_CDECODIGO_GENERATOR", sequenceName="PRE_CERTIFICACION_DETALLE_CDE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_CERTIFICACION_DETALLE_CDECODIGO_GENERATOR")
	@Column(name="cde_codigo")
	private Integer cdeCodigo;

	@Column(name="cde_cuenta")
	private Integer cdeCuenta;

	@Column(name="cde_monto")
	private BigDecimal cdeMonto;

	//bi-directional many-to-one association to PreCertificacion
	@ManyToOne
	@JoinColumn(name="cde_certificacion")
	private PreCertificacion preCertificacion;

	//bi-directional many-to-one association to PreTipoCertificacion
	@ManyToOne
	@JoinColumn(name="cde_tipo_certificacion")
	private PreTipoCertificacion preTipoCertificacion;

	public PreCertificacionDetalle() {
	}

	public Integer getCdeCodigo() {
		return this.cdeCodigo;
	}

	public void setCdeCodigo(Integer cdeCodigo) {
		this.cdeCodigo = cdeCodigo;
	}

	public Integer getCdeCuenta() {
		return this.cdeCuenta;
	}

	public void setCdeCuenta(Integer cdeCuenta) {
		this.cdeCuenta = cdeCuenta;
	}

	public BigDecimal getCdeMonto() {
		return this.cdeMonto;
	}

	public void setCdeMonto(BigDecimal cdeMonto) {
		this.cdeMonto = cdeMonto;
	}

	public PreCertificacion getPreCertificacion() {
		return this.preCertificacion;
	}

	public void setPreCertificacion(PreCertificacion preCertificacion) {
		this.preCertificacion = preCertificacion;
	}

	public PreTipoCertificacion getPreTipoCertificacion() {
		return this.preTipoCertificacion;
	}

	public void setPreTipoCertificacion(PreTipoCertificacion preTipoCertificacion) {
		this.preTipoCertificacion = preTipoCertificacion;
	}

}