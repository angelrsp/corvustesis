package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ate_noticia database table.
 * 
 */
@Entity
@Table(name="ate_noticia")
@NamedQuery(name="NoticiaDTO.findAll", query="SELECT n FROM NoticiaDTO n")
public class NoticiaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_NOTICIA_NOTCODIGO_GENERATOR", sequenceName="ATE_NOTICIA_NOT_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_NOTICIA_NOTCODIGO_GENERATOR")
	@Column(name="not_codigo")
	private Integer notCodigo;

	@Column(name="not_descripcion")
	private String notDescripcion;

	//bi-directional many-to-one association to EntidadDTO
	@OneToMany(mappedBy="ateNoticia")
	private List<EntidadDTO> ateEntidads;

	public NoticiaDTO() {
	}

	public Integer getNotCodigo() {
		return this.notCodigo;
	}

	public void setNotCodigo(Integer notCodigo) {
		this.notCodigo = notCodigo;
	}

	public String getNotDescripcion() {
		return this.notDescripcion;
	}

	public void setNotDescripcion(String notDescripcion) {
		this.notDescripcion = notDescripcion;
	}

	public List<EntidadDTO> getAteEntidads() {
		return this.ateEntidads;
	}

	public void setAteEntidads(List<EntidadDTO> ateEntidads) {
		this.ateEntidads = ateEntidads;
	}

	public EntidadDTO addAteEntidad(EntidadDTO ateEntidad) {
		getAteEntidads().add(ateEntidad);
		ateEntidad.setAteNoticia(this);

		return ateEntidad;
	}

	public EntidadDTO removeAteEntidad(EntidadDTO ateEntidad) {
		getAteEntidads().remove(ateEntidad);
		ateEntidad.setAteNoticia(null);

		return ateEntidad;
	}

}