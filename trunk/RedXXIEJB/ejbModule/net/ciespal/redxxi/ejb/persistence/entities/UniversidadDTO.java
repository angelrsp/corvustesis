package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ate_universidad database table.
 * 
 */
@Entity
@Table(name="ate_universidad")
@NamedQuery(name="UniversidadDTO.findAll", query="SELECT u FROM UniversidadDTO u")
public class UniversidadDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_UNIVERSIDAD_UNICODIGO_GENERATOR", sequenceName="ATE_UNIVERSIDAD_UNI_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_UNIVERSIDAD_UNICODIGO_GENERATOR")
	@Column(name="uni_codigo")
	private Integer uniCodigo;

	@Column(name="uni_acreditacion")
	private String uniAcreditacion;

	@Column(name="uni_nombre")
	private String uniNombre;

	//bi-directional many-to-one association to FacultadCarreraDTO
	@OneToMany(mappedBy="ateUniversidad")
	private List<FacultadCarreraDTO> ateFacultadCarreras;

	public UniversidadDTO() {
	}

	public Integer getUniCodigo() {
		return this.uniCodigo;
	}

	public void setUniCodigo(Integer uniCodigo) {
		this.uniCodigo = uniCodigo;
	}

	public String getUniAcreditacion() {
		return this.uniAcreditacion;
	}

	public void setUniAcreditacion(String uniAcreditacion) {
		this.uniAcreditacion = uniAcreditacion;
	}

	public String getUniNombre() {
		return this.uniNombre;
	}

	public void setUniNombre(String uniNombre) {
		this.uniNombre = uniNombre;
	}

	public List<FacultadCarreraDTO> getAteFacultadCarreras() {
		return this.ateFacultadCarreras;
	}

	public void setAteFacultadCarreras(List<FacultadCarreraDTO> ateFacultadCarreras) {
		this.ateFacultadCarreras = ateFacultadCarreras;
	}

	public FacultadCarreraDTO addAteFacultadCarrera(FacultadCarreraDTO ateFacultadCarrera) {
		getAteFacultadCarreras().add(ateFacultadCarrera);
		ateFacultadCarrera.setAteUniversidad(this);

		return ateFacultadCarrera;
	}

	public FacultadCarreraDTO removeAteFacultadCarrera(FacultadCarreraDTO ateFacultadCarrera) {
		getAteFacultadCarreras().remove(ateFacultadCarrera);
		ateFacultadCarrera.setAteUniversidad(null);

		return ateFacultadCarrera;
	}

}