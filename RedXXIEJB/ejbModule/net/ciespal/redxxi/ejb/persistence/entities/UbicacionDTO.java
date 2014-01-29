package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ate_ubicacion database table.
 * 
 */
@Entity
@Table(name="ate_ubicacion")
@NamedQuery(name="UbicacionDTO.findAll", query="SELECT u FROM UbicacionDTO u")
public class UbicacionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_UBICACION_UBICODIGO_GENERATOR", sequenceName="ATE_UBICACION_UBI_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_UBICACION_UBICODIGO_GENERATOR")
	@Column(name="ubi_codigo")
	private Integer ubiCodigo;

	@Column(name="ubi_nombre")
	private String ubiNombre;

	//bi-directional many-to-one association to EntidadDTO
	@OneToMany(mappedBy="ateUbicacion")
	private List<EntidadDTO> ateEntidads;

	//bi-directional many-to-one association to UbicacionDTO
	@ManyToOne
	@JoinColumn(name="ubi_predecesor")
	private UbicacionDTO ateUbicacion;

	//bi-directional many-to-one association to UbicacionDTO
	@OneToMany(mappedBy="ateUbicacion")
	private List<UbicacionDTO> ateUbicacions;

	public UbicacionDTO() {
	}

	public Integer getUbiCodigo() {
		return this.ubiCodigo;
	}

	public void setUbiCodigo(Integer ubiCodigo) {
		this.ubiCodigo = ubiCodigo;
	}

	public String getUbiNombre() {
		return this.ubiNombre;
	}

	public void setUbiNombre(String ubiNombre) {
		this.ubiNombre = ubiNombre;
	}

	public List<EntidadDTO> getAteEntidads() {
		return this.ateEntidads;
	}

	public void setAteEntidads(List<EntidadDTO> ateEntidads) {
		this.ateEntidads = ateEntidads;
	}

	public EntidadDTO addAteEntidad(EntidadDTO ateEntidad) {
		getAteEntidads().add(ateEntidad);
		ateEntidad.setAteUbicacion(this);

		return ateEntidad;
	}

	public EntidadDTO removeAteEntidad(EntidadDTO ateEntidad) {
		getAteEntidads().remove(ateEntidad);
		ateEntidad.setAteUbicacion(null);

		return ateEntidad;
	}

	public UbicacionDTO getAteUbicacion() {
		return this.ateUbicacion;
	}

	public void setAteUbicacion(UbicacionDTO ateUbicacion) {
		this.ateUbicacion = ateUbicacion;
	}

	public List<UbicacionDTO> getAteUbicacions() {
		return this.ateUbicacions;
	}

	public void setAteUbicacions(List<UbicacionDTO> ateUbicacions) {
		this.ateUbicacions = ateUbicacions;
	}

	public UbicacionDTO addAteUbicacion(UbicacionDTO ateUbicacion) {
		getAteUbicacions().add(ateUbicacion);
		ateUbicacion.setAteUbicacion(this);

		return ateUbicacion;
	}

	public UbicacionDTO removeAteUbicacion(UbicacionDTO ateUbicacion) {
		getAteUbicacions().remove(ateUbicacion);
		ateUbicacion.setAteUbicacion(null);

		return ateUbicacion;
	}

}