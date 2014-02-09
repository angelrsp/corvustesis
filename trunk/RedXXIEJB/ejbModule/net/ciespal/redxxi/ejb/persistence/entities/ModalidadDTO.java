package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ate_modalidad database table.
 * 
 */
@Entity
@Table(name="ate_modalidad")
@NamedQuery(name="ModalidadDTO.findAll", query="SELECT m FROM ModalidadDTO m")
public class ModalidadDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_MODALIDAD_MODCODIGO_GENERATOR", sequenceName="ATE_MODALIDAD_MOD_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_MODALIDAD_MODCODIGO_GENERATOR")
	@Column(name="mod_codigo")
	private Integer modCodigo;

	@Column(name="mod_modalidad")
	private Integer modModalidad;

	//bi-directional many-to-one association to CarreraDTO
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="mod_carrera")
	private CarreraDTO ateCarrera;

	public ModalidadDTO() {
	}

	public Integer getModCodigo() {
		return this.modCodigo;
	}

	public void setModCodigo(Integer modCodigo) {
		this.modCodigo = modCodigo;
	}

	public Integer getModModalidad() {
		return this.modModalidad;
	}

	public void setModModalidad(Integer modModalidad) {
		this.modModalidad = modModalidad;
	}

	public CarreraDTO getAteCarrera() {
		return this.ateCarrera;
	}

	public void setAteCarrera(CarreraDTO ateCarrera) {
		this.ateCarrera = ateCarrera;
	}

}