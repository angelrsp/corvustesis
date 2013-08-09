package ec.edu.uce.erpmunicipal.contabilidad.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the con_tipo_movimiento database table.
 * 
 */
@Entity
@Table(name="con_tipo_movimiento")
public class ConTipoMovimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CON_TIPO_MOVIMIENTO_TMOCODIGO_GENERATOR", sequenceName="CON_TIPO_MOVIMIENTO_TMO_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CON_TIPO_MOVIMIENTO_TMOCODIGO_GENERATOR")
	@Column(name="tmo_codigo")
	private Integer tmoCodigo;

	@Column(name="tmo_descripcion")
	private String tmoDescripcion;

	//bi-directional many-to-one association to ConMovimiento
	@OneToMany(mappedBy="conTipoMovimiento")
	private List<ConMovimiento> conMovimientos;

	public ConTipoMovimiento() {
	}

	public Integer getTmoCodigo() {
		return this.tmoCodigo;
	}

	public void setTmoCodigo(Integer tmoCodigo) {
		this.tmoCodigo = tmoCodigo;
	}

	public String getTmoDescripcion() {
		return this.tmoDescripcion;
	}

	public void setTmoDescripcion(String tmoDescripcion) {
		this.tmoDescripcion = tmoDescripcion;
	}

	public List<ConMovimiento> getConMovimientos() {
		return this.conMovimientos;
	}

	public void setConMovimientos(List<ConMovimiento> conMovimientos) {
		this.conMovimientos = conMovimientos;
	}

}