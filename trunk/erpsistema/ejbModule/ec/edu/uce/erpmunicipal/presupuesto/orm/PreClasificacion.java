package ec.edu.uce.erpmunicipal.presupuesto.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pre_clasificacion database table.
 * 
 */
@Entity
@Table(name="pre_clasificacion")
public class PreClasificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_CLASIFICACION_CLACODIGO_GENERATOR", sequenceName="PRE_CLASIFICACION_CLA_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_CLASIFICACION_CLACODIGO_GENERATOR")
	@Column(name="cla_codigo")
	private Integer claCodigo;

	@Column(name="cla_descripcion")
	private String claDescripcion;

	//bi-directional many-to-one association to PreCertificacion
	@OneToMany(mappedBy="preClasificacion")
	private List<PreCertificacion> preCertificacions;

	public PreClasificacion() {
	}

	public Integer getClaCodigo() {
		return this.claCodigo;
	}

	public void setClaCodigo(Integer claCodigo) {
		this.claCodigo = claCodigo;
	}

	public String getClaDescripcion() {
		return this.claDescripcion;
	}

	public void setClaDescripcion(String claDescripcion) {
		this.claDescripcion = claDescripcion;
	}

	public List<PreCertificacion> getPreCertificacions() {
		return this.preCertificacions;
	}

	public void setPreCertificacions(List<PreCertificacion> preCertificacions) {
		this.preCertificacions = preCertificacions;
	}

}