package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ate_especalidad database table.
 * 
 */
@Entity
@Table(name="ate_especalidad")
@NamedQuery(name="EspecalidadDTO.findAll", query="SELECT e FROM EspecalidadDTO e")
public class EspecalidadDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_ESPECALIDAD_ESPCODIGO_GENERATOR", sequenceName="ATE_ESPECALIDAD_ESP_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_ESPECALIDAD_ESPCODIGO_GENERATOR")
	@Column(name="esp_codigo")
	private Integer espCodigo;

	@Column(name="esp_nombre")
	private String espNombre;

	//bi-directional many-to-one association to DoctorDTO
	@ManyToOne
	@JoinColumn(name="esp_doctor")
	private DoctorDTO ateDoctor;

	public EspecalidadDTO() {
	}

	public Integer getEspCodigo() {
		return this.espCodigo;
	}

	public void setEspCodigo(Integer espCodigo) {
		this.espCodigo = espCodigo;
	}

	public String getEspNombre() {
		return this.espNombre;
	}

	public void setEspNombre(String espNombre) {
		this.espNombre = espNombre;
	}

	public DoctorDTO getAteDoctor() {
		return this.ateDoctor;
	}

	public void setAteDoctor(DoctorDTO ateDoctor) {
		this.ateDoctor = ateDoctor;
	}

}