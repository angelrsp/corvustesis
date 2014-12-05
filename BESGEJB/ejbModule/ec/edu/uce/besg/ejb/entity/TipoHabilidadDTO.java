package ec.edu.uce.besg.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bem_tipo_habilidad database table.
 * 
 */
@Entity
@Table(name="bem_tipo_habilidad")
@NamedQuery(name="TipoHabilidadDTO.findAll", query="SELECT t FROM TipoHabilidadDTO t")
public class TipoHabilidadDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_TIPO_HABILIDAD_THACODIGO_GENERATOR", sequenceName="BEM_TIPO_HABILIDAD_THA_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_TIPO_HABILIDAD_THACODIGO_GENERATOR")
	@Column(name="tha_codigo")
	private Integer thaCodigo;

	@Column(name="tha_descripcion")
	private String thaDescripcion;

	//bi-directional many-to-one association to HabilidadDTO
	@OneToMany(mappedBy="bemTipoHabilidad")
	private List<HabilidadDTO> bemHabilidads;

	public TipoHabilidadDTO() {
	}

	public Integer getThaCodigo() {
		return this.thaCodigo;
	}

	public void setThaCodigo(Integer thaCodigo) {
		this.thaCodigo = thaCodigo;
	}

	public String getThaDescripcion() {
		return this.thaDescripcion;
	}

	public void setThaDescripcion(String thaDescripcion) {
		this.thaDescripcion = thaDescripcion;
	}

	public List<HabilidadDTO> getBemHabilidads() {
		return this.bemHabilidads;
	}

	public void setBemHabilidads(List<HabilidadDTO> bemHabilidads) {
		this.bemHabilidads = bemHabilidads;
	}

	public HabilidadDTO addBemHabilidad(HabilidadDTO bemHabilidad) {
		getBemHabilidads().add(bemHabilidad);
		bemHabilidad.setBemTipoHabilidad(this);

		return bemHabilidad;
	}

	public HabilidadDTO removeBemHabilidad(HabilidadDTO bemHabilidad) {
		getBemHabilidads().remove(bemHabilidad);
		bemHabilidad.setBemTipoHabilidad(null);

		return bemHabilidad;
	}

}