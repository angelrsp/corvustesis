package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


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
	@SequenceGenerator(name="ATE_PROYECTO_INVESTIGACION_PINCODIGO_GENERATOR", sequenceName="ATE_PROYECTO_INVESTIGACION_PIN_CODIGO_SEQ",allocationSize=1)
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

	@Column(name="pin_anio_inicio")
	private Integer pinAnioInicio;

	@Column(name="pin_duracion")
	private String pinDuracion;

	//bi-directional many-to-one association to EntidadDTO
	@OneToMany(mappedBy="ateProyectoInvestigacion",cascade={CascadeType.ALL,CascadeType.PERSIST},fetch=FetchType.EAGER)
	private List<EntidadDTO> ateEntidads;

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

	public Integer getPinAnioInicio() {
		return pinAnioInicio;
	}

	public void setPinAnioInicio(Integer pinAnioInicio) {
		this.pinAnioInicio = pinAnioInicio;
	}

	public String getPinDuracion() {
		return pinDuracion;
	}

	public void setPinDuracion(String pinDuracion) {
		this.pinDuracion = pinDuracion;
	}

	public List<EntidadDTO> getAteEntidads() {
		return this.ateEntidads;
	}

	public void setAteEntidads(List<EntidadDTO> ateEntidads) {
		this.ateEntidads = ateEntidads;
	}

	public EntidadDTO addAteEntidad(EntidadDTO ateEntidad) {
		if(ateEntidad!=null){
			if(getAteEntidads()==null)
				setAteEntidads(new ArrayList<EntidadDTO>());
			getAteEntidads().add(ateEntidad);
			ateEntidad.setAteProyectoInvestigacion(this);
		}
		return ateEntidad;
	}

	public EntidadDTO removeAteEntidad(EntidadDTO ateEntidad) {
		getAteEntidads().remove(ateEntidad);
		ateEntidad.setAteProyectoInvestigacion(null);

		return ateEntidad;
	}

}