package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ate_publicaciones_periodicas database table.
 * 
 */
@Entity
@Table(name="ate_publicaciones_periodicas")
@NamedQuery(name="PublicacionPeriodicaDTO.findAll", query="SELECT p FROM PublicacionPeriodicaDTO p")
public class PublicacionPeriodicaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_PUBLICACIONES_PERIODICAS_PPECODIGO_GENERATOR", sequenceName="ATE_PUBLICACIONES_PERIODICAS_PPE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_PUBLICACIONES_PERIODICAS_PPECODIGO_GENERATOR")
	@Column(name="ppe_codigo")
	private Integer ppeCodigo;

	@Column(name="ppe_nombre")
	private Integer ppeNombre;

	//bi-directional many-to-one association to FacultadCarreraDTO
	@ManyToOne
	@JoinColumn(name="ppe_facultad")
	private FacultadCarreraDTO ateFacultadCarrera;

	public PublicacionPeriodicaDTO() {
	}

	public Integer getPpeCodigo() {
		return this.ppeCodigo;
	}

	public void setPpeCodigo(Integer ppeCodigo) {
		this.ppeCodigo = ppeCodigo;
	}

	public Integer getPpeNombre() {
		return this.ppeNombre;
	}

	public void setPpeNombre(Integer ppeNombre) {
		this.ppeNombre = ppeNombre;
	}

	public FacultadCarreraDTO getAteFacultadCarrera() {
		return this.ateFacultadCarrera;
	}

	public void setAteFacultadCarrera(FacultadCarreraDTO ateFacultadCarrera) {
		this.ateFacultadCarrera = ateFacultadCarrera;
	}

}