package ec.edu.uce.erpmunicipal.contabilidad.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the con_clase database table.
 * 
 */
@Entity
@Table(name="con_clase")
public class ConClase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CON_CLASE_CLACODIGO_GENERATOR", sequenceName="CON_CLASE_CLA_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CON_CLASE_CLACODIGO_GENERATOR")
	@Column(name="cla_codigo")
	private Integer claCodigo;

	@Column(name="cla_descripcion")
	private String claDescripcion;

	//bi-directional many-to-one association to ConMovimiento
	@OneToMany(mappedBy="conClase")
	private List<ConMovimiento> conMovimientos;

	public ConClase() {
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

	public List<ConMovimiento> getConMovimientos() {
		return this.conMovimientos;
	}

	public void setConMovimientos(List<ConMovimiento> conMovimientos) {
		this.conMovimientos = conMovimientos;
	}

}