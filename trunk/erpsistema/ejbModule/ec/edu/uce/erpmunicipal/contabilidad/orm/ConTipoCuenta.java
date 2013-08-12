package ec.edu.uce.erpmunicipal.contabilidad.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the con_tipo_cuenta database table.
 * 
 */
@Entity
@Table(name="con_tipo_cuenta")
public class ConTipoCuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CON_TIPO_CUENTA_TCUCODIGO_GENERATOR", sequenceName="CON_TIPO_CUENTA_TCU_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CON_TIPO_CUENTA_TCUCODIGO_GENERATOR")
	@Column(name="tcu_codigo")
	private Integer tcuCodigo;

	@Column(name="tcu_descripcion")
	private String tcuDescripcion;

	//bi-directional many-to-one association to ConCuenta
	@OneToMany(mappedBy="conTipoCuenta")
	private List<ConCuenta> conCuentas;

	public ConTipoCuenta() {
	}

	public Integer getTcuCodigo() {
		return this.tcuCodigo;
	}

	public void setTcuCodigo(Integer tcuCodigo) {
		this.tcuCodigo = tcuCodigo;
	}

	public String getTcuDescripcion() {
		return this.tcuDescripcion;
	}

	public void setTcuDescripcion(String tcuDescripcion) {
		this.tcuDescripcion = tcuDescripcion;
	}

	public List<ConCuenta> getConCuentas() {
		return this.conCuentas;
	}

	public void setConCuentas(List<ConCuenta> conCuentas) {
		this.conCuentas = conCuentas;
	}

}