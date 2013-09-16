package ec.edu.uce.erpmunicipal.presupuesto.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pre_tipo_certificacion database table.
 * 
 */
@Entity
@Table(name="pre_tipo_certificacion")
public class PreTipoCertificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_TIPO_CERTIFICACION_TCECODIGO_GENERATOR", sequenceName="PRE_TIPO_CERTIFICACION_TCE_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_TIPO_CERTIFICACION_TCECODIGO_GENERATOR")
	@Column(name="tce_codigo")
	private Integer tceCodigo;

	@Column(name="tce_descripcion")
	private String tceDescripcion;

	//bi-directional many-to-one association to PreCertificacionDetalle
	@OneToMany(mappedBy="preTipoCertificacion")
	private List<PreCertificacionDetalle> preCertificacionDetalles;

	public PreTipoCertificacion() {
	}

	public Integer getTceCodigo() {
		return this.tceCodigo;
	}

	public void setTceCodigo(Integer tceCodigo) {
		this.tceCodigo = tceCodigo;
	}

	public String getTceDescripcion() {
		return this.tceDescripcion;
	}

	public void setTceDescripcion(String tceDescripcion) {
		this.tceDescripcion = tceDescripcion;
	}

	public List<PreCertificacionDetalle> getPreCertificacionDetalles() {
		return this.preCertificacionDetalles;
	}

	public void setPreCertificacionDetalles(List<PreCertificacionDetalle> preCertificacionDetalles) {
		this.preCertificacionDetalles = preCertificacionDetalles;
	}

}