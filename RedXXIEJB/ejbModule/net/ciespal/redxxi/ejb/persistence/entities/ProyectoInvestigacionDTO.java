package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ate_proyecto_investigacion database table.
 * 
 */
@Entity
@Table(name="ate_proyecto_investigacion")
@NamedQuery(name="ProyectoInvestigacionDTO.findAll", query="SELECT p FROM ProyectoInvestigacionDTO p")
public class ProyectoInvestigacionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_PROYECTO_INVESTIGACION_PINCODIGO_GENERATOR", sequenceName="ATE_PROYECTO_INVESTIGACION_PIN_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_PROYECTO_INVESTIGACION_PINCODIGO_GENERATOR")
	@Column(name="pin_codigo")
	private Integer pinCodigo;

	@Column(name="pin_coordinador")
	private String pinCoordinador;

	@Column(name="pin_nombre")
	private String pinNombre;

	@Column(name="pin_perfil")
	private String pinPerfil;

	@Column(name="pin_tipo")
	private Integer pinTipo;

	@Column(name="pin_ubicacion")
	private Integer pinUbicacion;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="pin_entidad")
	private EntidadDTO ateEntidad;

	public ProyectoInvestigacionDTO() {
	}

	public Integer getPinCodigo() {
		return this.pinCodigo;
	}

	public void setPinCodigo(Integer pinCodigo) {
		this.pinCodigo = pinCodigo;
	}

	public String getPinCoordinador() {
		return this.pinCoordinador;
	}

	public void setPinCoordinador(String pinCoordinador) {
		this.pinCoordinador = pinCoordinador;
	}

	public String getPinNombre() {
		return this.pinNombre;
	}

	public void setPinNombre(String pinNombre) {
		this.pinNombre = pinNombre;
	}

	public String getPinPerfil() {
		return this.pinPerfil;
	}

	public void setPinPerfil(String pinPerfil) {
		this.pinPerfil = pinPerfil;
	}

	public Integer getPinTipo() {
		return this.pinTipo;
	}

	public void setPinTipo(Integer pinTipo) {
		this.pinTipo = pinTipo;
	}

	public Integer getPinUbicacion() {
		return this.pinUbicacion;
	}

	public void setPinUbicacion(Integer pinUbicacion) {
		this.pinUbicacion = pinUbicacion;
	}

	public EntidadDTO getAteEntidad() {
		return this.ateEntidad;
	}

	public void setAteEntidad(EntidadDTO ateEntidad) {
		this.ateEntidad = ateEntidad;
	}

}