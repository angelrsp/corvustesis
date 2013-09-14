package ec.edu.uce.erpmunicipal.presupuesto.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the pre_certificacion database table.
 * 
 */
@Entity
@Table(name="pre_certificacion")
public class PreCertificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_CERTIFICACION_CERCODIGO_GENERATOR", sequenceName="PRE_CERTIFICACION_CER_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_CERTIFICACION_CERCODIGO_GENERATOR")
	@Column(name="cer_codigo")
	private Integer cerCodigo;

	@Column(name="cer_fecha")
	private Timestamp cerFecha;

	//bi-directional many-to-one association to PreBeneficiario
	@ManyToOne
	@JoinColumn(name="cer_beneficiario")
	private PreBeneficiario preBeneficiario;

	//bi-directional many-to-one association to PreClasificacion
	@ManyToOne
	@JoinColumn(name="cer_clasificacion")
	private PreClasificacion preClasificacion;

	//bi-directional many-to-one association to PreCertificacionDetalle
	@OneToMany(mappedBy="preCertificacion")
	private List<PreCertificacionDetalle> preCertificacionDetalles;

	public PreCertificacion() {
	}

	public Integer getCerCodigo() {
		return this.cerCodigo;
	}

	public void setCerCodigo(Integer cerCodigo) {
		this.cerCodigo = cerCodigo;
	}

	public Timestamp getCerFecha() {
		return this.cerFecha;
	}

	public void setCerFecha(Timestamp cerFecha) {
		this.cerFecha = cerFecha;
	}

	public PreBeneficiario getPreBeneficiario() {
		return this.preBeneficiario;
	}

	public void setPreBeneficiario(PreBeneficiario preBeneficiario) {
		this.preBeneficiario = preBeneficiario;
	}

	public PreClasificacion getPreClasificacion() {
		return this.preClasificacion;
	}

	public void setPreClasificacion(PreClasificacion preClasificacion) {
		this.preClasificacion = preClasificacion;
	}

	public List<PreCertificacionDetalle> getPreCertificacionDetalles() {
		return this.preCertificacionDetalles;
	}

	public void setPreCertificacionDetalles(List<PreCertificacionDetalle> preCertificacionDetalles) {
		this.preCertificacionDetalles = preCertificacionDetalles;
	}

}