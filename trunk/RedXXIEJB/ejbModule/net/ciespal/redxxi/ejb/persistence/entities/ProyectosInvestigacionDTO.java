package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ate_proyectos_investigacion database table.
 * 
 */
@Entity
@Table(name="ate_proyectos_investigacion")
@NamedQuery(name="ProyectosInvestigacionDTO.findAll", query="SELECT p FROM ProyectosInvestigacionDTO p")
public class ProyectosInvestigacionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_PROYECTOS_INVESTIGACION_PINCODIGO_GENERATOR", sequenceName="ATE_PROYECTOS_INVESTIGACION_PIN_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_PROYECTOS_INVESTIGACION_PINCODIGO_GENERATOR")
	@Column(name="pin_codigo")
	private Integer pinCodigo;

	@Column(name="pin_nombre")
	private String pinNombre;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="pin_entidad")
	private EntidadDTO ateEntidad;

	public ProyectosInvestigacionDTO() {
	}

	public Integer getPinCodigo() {
		return this.pinCodigo;
	}

	public void setPinCodigo(Integer pinCodigo) {
		this.pinCodigo = pinCodigo;
	}

	public String getPinNombre() {
		return this.pinNombre;
	}

	public void setPinNombre(String pinNombre) {
		this.pinNombre = pinNombre;
	}

	public EntidadDTO getAteEntidad() {
		return this.ateEntidad;
	}

	public void setAteEntidad(EntidadDTO ateEntidad) {
		this.ateEntidad = ateEntidad;
	}

}