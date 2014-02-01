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
	@SequenceGenerator(name="ATE_OBRAS_OBRCODIGO_GENERATOR", sequenceName="ATE_OBRAS_OBR_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_OBRAS_OBRCODIGO_GENERATOR")
	@Column(name="obr_codigo")
	private Integer obrCodigo;

	@Column(name="obr_campo_conocimiento")
	private Integer obrCampoConocimiento;

	@Column(name="obr_nombre")
	private String obrNombre;

	@Column(name="obr_tipo")
	private Integer obrTipo;

	@Column(name="obr_ubicacion")
	private Integer obrUbicacion;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="obr_entidad")
	private EntidadDTO ateEntidad;

	public ObraDTO() {
	}

	public Integer getObrCodigo() {
		return this.obrCodigo;
	}

	public void setObrCodigo(Integer obrCodigo) {
		this.obrCodigo = obrCodigo;
	}

	public Integer getObrCampoConocimiento() {
		return this.obrCampoConocimiento;
	}

	public void setObrCampoConocimiento(Integer obrCampoConocimiento) {
		this.obrCampoConocimiento = obrCampoConocimiento;
	}

	public String getObrNombre() {
		return this.obrNombre;
	}

	public void setObrNombre(String obrNombre) {
		this.obrNombre = obrNombre;
	}

	public Integer getObrTipo() {
		return this.obrTipo;
	}

	public void setObrTipo(Integer obrTipo) {
		this.obrTipo = obrTipo;
	}

	public Integer getObrUbicacion() {
		return this.obrUbicacion;
	}

	public void setObrUbicacion(Integer obrUbicacion) {
		this.obrUbicacion = obrUbicacion;
	}

	public EntidadDTO getAteEntidad() {
		return this.ateEntidad;
	}

	public void setAteEntidad(EntidadDTO ateEntidad) {
		this.ateEntidad = ateEntidad;
	}

}