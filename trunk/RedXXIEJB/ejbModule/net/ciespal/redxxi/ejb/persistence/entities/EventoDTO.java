package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ate_eventos database table.
 * 
 */
@Entity
@Table(name="ate_eventos")
@NamedQuery(name="EventoDTO.findAll", query="SELECT e FROM EventoDTO e")
public class EventoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_EVENTOS_EVECODIGO_GENERATOR", sequenceName="ATE_EVENTOS_EVE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_EVENTOS_EVECODIGO_GENERATOR")
	@Column(name="eve_codigo")
	private Integer eveCodigo;

	@Column(name="eve_nombre")
	private String eveNombre;

	//bi-directional many-to-one association to FacultadCarreraDTO
	@ManyToOne
	@JoinColumn(name="eve_facultad")
	private FacultadCarreraDTO ateFacultadCarrera;

	public EventoDTO() {
	}

	public Integer getEveCodigo() {
		return this.eveCodigo;
	}

	public void setEveCodigo(Integer eveCodigo) {
		this.eveCodigo = eveCodigo;
	}

	public String getEveNombre() {
		return this.eveNombre;
	}

	public void setEveNombre(String eveNombre) {
		this.eveNombre = eveNombre;
	}

	public FacultadCarreraDTO getAteFacultadCarrera() {
		return this.ateFacultadCarrera;
	}

	public void setAteFacultadCarrera(FacultadCarreraDTO ateFacultadCarrera) {
		this.ateFacultadCarrera = ateFacultadCarrera;
	}

}