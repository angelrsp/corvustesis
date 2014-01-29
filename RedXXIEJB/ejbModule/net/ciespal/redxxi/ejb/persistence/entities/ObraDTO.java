package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ate_obras database table.
 * 
 */
@Entity
@Table(name="ate_obras")
@NamedQuery(name="ObraDTO.findAll", query="SELECT o FROM ObraDTO o")
public class ObraDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_OBRAS_OBRCODIGO_GENERATOR", sequenceName="ATE_OBRAS_OBR_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_OBRAS_OBRCODIGO_GENERATOR")
	@Column(name="obr_codigo")
	private Integer obrCodigo;

	@Column(name="obr_nombre")
	private String obrNombre;

	//bi-directional many-to-one association to DoctorDTO
	@ManyToOne
	@JoinColumn(name="obr_doctor")
	private DoctorDTO ateDoctor;

	public ObraDTO() {
	}

	public Integer getObrCodigo() {
		return this.obrCodigo;
	}

	public void setObrCodigo(Integer obrCodigo) {
		this.obrCodigo = obrCodigo;
	}

	public String getObrNombre() {
		return this.obrNombre;
	}

	public void setObrNombre(String obrNombre) {
		this.obrNombre = obrNombre;
	}

	public DoctorDTO getAteDoctor() {
		return this.ateDoctor;
	}

	public void setAteDoctor(DoctorDTO ateDoctor) {
		this.ateDoctor = ateDoctor;
	}

}