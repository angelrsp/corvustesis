package ec.edu.uce.erpmunicipal.presupuesto.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pre_programa database table.
 * 
 */
@Entity
@Table(name="pre_programa")
@NamedQuery(name="PrePrograma.findAll", query="SELECT p FROM PrePrograma p")
public class PrePrograma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_PROGRAMA_PROCODIGO_GENERATOR", sequenceName="PRE_PROGRAMA_PRO_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_PROGRAMA_PROCODIGO_GENERATOR")
	@Column(name="pro_codigo")
	private Integer proCodigo;

	@Column(name="pro_descripcion")
	private String proDescripcion;

	//bi-directional many-to-one association to PreProgramaCuenta
	@OneToMany(mappedBy="prePrograma")
	private List<PreProgramaCuenta> preProgramaCuentas;

	public PrePrograma() {
	}

	public Integer getProCodigo() {
		return this.proCodigo;
	}

	public void setProCodigo(Integer proCodigo) {
		this.proCodigo = proCodigo;
	}

	public String getProDescripcion() {
		return this.proDescripcion;
	}

	public void setProDescripcion(String proDescripcion) {
		this.proDescripcion = proDescripcion;
	}

	public List<PreProgramaCuenta> getPreProgramaCuentas() {
		return this.preProgramaCuentas;
	}

	public void setPreProgramaCuentas(List<PreProgramaCuenta> preProgramaCuentas) {
		this.preProgramaCuentas = preProgramaCuentas;
	}

	public PreProgramaCuenta addPreProgramaCuenta(PreProgramaCuenta preProgramaCuenta) {
		getPreProgramaCuentas().add(preProgramaCuenta);
		preProgramaCuenta.setPrePrograma(this);

		return preProgramaCuenta;
	}

	public PreProgramaCuenta removePreProgramaCuenta(PreProgramaCuenta preProgramaCuenta) {
		getPreProgramaCuentas().remove(preProgramaCuenta);
		preProgramaCuenta.setPrePrograma(null);

		return preProgramaCuenta;
	}

}