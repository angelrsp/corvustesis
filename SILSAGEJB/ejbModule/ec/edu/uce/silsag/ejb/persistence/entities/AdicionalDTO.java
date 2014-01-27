package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bem_adicional database table.
 * 
 */
@Entity
@Table(name="bem_adicional")
@NamedQuery(name="AdicionalDTO.findAll", query="SELECT a FROM AdicionalDTO a")
public class AdicionalDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_ADICIONAL_ADICODIGO_GENERATOR", sequenceName="BEM_ADICIONAL_ADI_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_ADICIONAL_ADICODIGO_GENERATOR")
	@Column(name="adi_codigo")
	private Integer adiCodigo;

	@Column(name="pro_descripcion")
	private String proDescripcion;

	@Column(name="pro_nombre")
	private String proNombre;

	@Column(name="adi_archivo")
	private byte[] adiArchivo;
	
	
	//bi-directional many-to-one association to CandidatoDTO
	@ManyToOne
	@JoinColumn(name="pro_candidato")
	private CandidatoDTO bemCandidato;

	public AdicionalDTO() {
	}

	public Integer getAdiCodigo() {
		return this.adiCodigo;
	}

	public void setAdiCodigo(Integer adiCodigo) {
		this.adiCodigo = adiCodigo;
	}

	public String getProDescripcion() {
		return this.proDescripcion;
	}

	public void setProDescripcion(String proDescripcion) {
		this.proDescripcion = proDescripcion;
	}

	public String getProNombre() {
		return this.proNombre;
	}

	public void setProNombre(String proNombre) {
		this.proNombre = proNombre;
	}

	public byte[] getAdiArchivo() {
		return adiArchivo;
	}

	public void setAdiArchivo(byte[] adiArchivo) {
		this.adiArchivo = adiArchivo;
	}

	public CandidatoDTO getBemCandidato() {
		return this.bemCandidato;
	}

	public void setBemCandidato(CandidatoDTO bemCandidato) {
		this.bemCandidato = bemCandidato;
	}

}