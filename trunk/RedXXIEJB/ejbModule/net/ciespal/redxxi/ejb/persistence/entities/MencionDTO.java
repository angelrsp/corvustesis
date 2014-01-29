package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ate_menciones database table.
 * 
 */
@Entity
@Table(name="ate_menciones")
@NamedQuery(name="MencionDTO.findAll", query="SELECT m FROM MencionDTO m")
public class MencionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_MENCIONES_MENCODIGO_GENERATOR", sequenceName="ATE_MENCIONES_MEN_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_MENCIONES_MENCODIGO_GENERATOR")
	@Column(name="men_codigo")
	private Integer menCodigo;

	@Column(name="men_nombre")
	private String menNombre;

	//bi-directional many-to-one association to FacultadCarreraDTO
	@ManyToOne
	@JoinColumn(name="men_facultad")
	private FacultadCarreraDTO ateFacultadCarrera;

	public MencionDTO() {
	}

	public Integer getMenCodigo() {
		return this.menCodigo;
	}

	public void setMenCodigo(Integer menCodigo) {
		this.menCodigo = menCodigo;
	}

	public String getMenNombre() {
		return this.menNombre;
	}

	public void setMenNombre(String menNombre) {
		this.menNombre = menNombre;
	}

	public FacultadCarreraDTO getAteFacultadCarrera() {
		return this.ateFacultadCarrera;
	}

	public void setAteFacultadCarrera(FacultadCarreraDTO ateFacultadCarrera) {
		this.ateFacultadCarrera = ateFacultadCarrera;
	}

}