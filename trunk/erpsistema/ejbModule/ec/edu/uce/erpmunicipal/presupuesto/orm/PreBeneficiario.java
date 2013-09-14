package ec.edu.uce.erpmunicipal.presupuesto.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pre_beneficiario database table.
 * 
 */
@Entity
@Table(name="pre_beneficiario")
public class PreBeneficiario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRE_BENEFICIARIO_BENCODIGO_GENERATOR", sequenceName="PRE_BENEFICIARIO_BEN_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRE_BENEFICIARIO_BENCODIGO_GENERATOR")
	@Column(name="ben_codigo")
	private Integer benCodigo;

	@Column(name="ben_identificacion")
	private String benIdentificacion;

	@Column(name="ben_nombres")
	private String benNombres;

	@Column(name="ben_tipo")
	private String benTipo;

	//bi-directional many-to-one association to PreCertificacion
	@OneToMany(mappedBy="preBeneficiario")
	private List<PreCertificacion> preCertificacions;

	public PreBeneficiario() {
	}

	public Integer getBenCodigo() {
		return this.benCodigo;
	}

	public void setBenCodigo(Integer benCodigo) {
		this.benCodigo = benCodigo;
	}

	public String getBenIdentificacion() {
		return this.benIdentificacion;
	}

	public void setBenIdentificacion(String benIdentificacion) {
		this.benIdentificacion = benIdentificacion;
	}

	public String getBenNombres() {
		return this.benNombres;
	}

	public void setBenNombres(String benNombres) {
		this.benNombres = benNombres;
	}

	public String getBenTipo() {
		return this.benTipo;
	}

	public void setBenTipo(String benTipo) {
		this.benTipo = benTipo;
	}

	public List<PreCertificacion> getPreCertificacions() {
		return this.preCertificacions;
	}

	public void setPreCertificacions(List<PreCertificacion> preCertificacions) {
		this.preCertificacions = preCertificacions;
	}

}