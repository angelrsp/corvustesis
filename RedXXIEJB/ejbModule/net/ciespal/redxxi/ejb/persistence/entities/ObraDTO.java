package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ate_obra database table.
 * 
 */
@Entity
@Table(name="ate_obra")
@NamedQuery(name="ObraDTO.findAll", query="SELECT o FROM ObraDTO o")
public class ObraDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_OBRA_OBRCODIGO_GENERATOR", sequenceName="ATE_OBRA_OBR_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_OBRA_OBRCODIGO_GENERATOR")
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
	@OneToMany(mappedBy="ateObra")
	private List<EntidadDTO> ateEntidads;

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

	public List<EntidadDTO> getAteEntidads() {
		return this.ateEntidads;
	}

	public void setAteEntidads(List<EntidadDTO> ateEntidads) {
		this.ateEntidads = ateEntidads;
	}

	public EntidadDTO addAteEntidad(EntidadDTO ateEntidad) {
		getAteEntidads().add(ateEntidad);
		ateEntidad.setAteObra(this);

		return ateEntidad;
	}

	public EntidadDTO removeAteEntidad(EntidadDTO ateEntidad) {
		getAteEntidads().remove(ateEntidad);
		ateEntidad.setAteObra(null);

		return ateEntidad;
	}

}