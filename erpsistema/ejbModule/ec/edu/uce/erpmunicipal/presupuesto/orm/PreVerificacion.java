package ec.edu.uce.erpmunicipal.presupuesto.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pre_verificacion database table.
 * 
 */
@Entity
@Table(name="pre_verificacion")
public class PreVerificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_VERIFICACION_VERCODIGO_GENERATOR", sequenceName="PRE_VERIFICACION_VER_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_VERIFICACION_VERCODIGO_GENERATOR")
	@Column(name="ver_codigo")
	private Integer verCodigo;

	@Column(name="ver_descripcion")
	private String verDescripcion;

	//bi-directional many-to-one association to PreReforma
	@OneToMany(mappedBy="preVerificacion")
	private List<PreReforma> preReformas;

	public PreVerificacion() {
	}

	public Integer getVerCodigo() {
		return this.verCodigo;
	}

	public void setVerCodigo(Integer verCodigo) {
		this.verCodigo = verCodigo;
	}

	public String getVerDescripcion() {
		return this.verDescripcion;
	}

	public void setVerDescripcion(String verDescripcion) {
		this.verDescripcion = verDescripcion;
	}

	public List<PreReforma> getPreReformas() {
		return this.preReformas;
	}

	public void setPreReformas(List<PreReforma> preReformas) {
		this.preReformas = preReformas;
	}

}