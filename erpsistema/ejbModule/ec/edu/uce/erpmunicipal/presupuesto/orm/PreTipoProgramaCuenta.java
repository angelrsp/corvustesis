package ec.edu.uce.erpmunicipal.presupuesto.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pre_tipo_programa_cuenta database table.
 * 
 */
@Entity
@Table(name="pre_tipo_programa_cuenta")
public class PreTipoProgramaCuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_TIPO_PROGRAMA_CUENTA_TPCCODIGO_GENERATOR", sequenceName="PRE_TIPO_PROGRAMA_CUENTA_TPC_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_TIPO_PROGRAMA_CUENTA_TPCCODIGO_GENERATOR")
	@Column(name="tpc_codigo")
	private Integer tpcCodigo;

	@Column(name="tpc_descripcion")
	private String tpcDescripcion;

	//bi-directional many-to-one association to PreProgramaCuenta
	@OneToMany(mappedBy="preTipoProgramaCuenta")
	private List<PreProgramaCuenta> preProgramaCuentas;

	public PreTipoProgramaCuenta() {
	}

	public Integer getTpcCodigo() {
		return this.tpcCodigo;
	}

	public void setTpcCodigo(Integer tpcCodigo) {
		this.tpcCodigo = tpcCodigo;
	}

	public String getTpcDescripcion() {
		return this.tpcDescripcion;
	}

	public void setTpcDescripcion(String tpcDescripcion) {
		this.tpcDescripcion = tpcDescripcion;
	}

	public List<PreProgramaCuenta> getPreProgramaCuentas() {
		return this.preProgramaCuentas;
	}

	public void setPreProgramaCuentas(List<PreProgramaCuenta> preProgramaCuentas) {
		this.preProgramaCuentas = preProgramaCuentas;
	}

}