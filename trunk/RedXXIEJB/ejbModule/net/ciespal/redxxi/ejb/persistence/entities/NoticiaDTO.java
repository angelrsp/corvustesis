package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ate_noticias database table.
 * 
 */
@Entity
@Table(name="ate_noticias")
@NamedQuery(name="NoticiaDTO.findAll", query="SELECT n FROM NoticiaDTO n")
public class NoticiaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_NOTICIAS_NOTCODIGO_GENERATOR", sequenceName="ATE_NOTICIAS_NOT_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_NOTICIAS_NOTCODIGO_GENERATOR")
	@Column(name="not_codigo")
	private Integer notCodigo;

	@Column(name="not_descripcion")
	private String notDescripcion;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="not_entidad")
	private EntidadDTO ateEntidad;

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

	public EntidadDTO getAteEntidad() {
		return this.ateEntidad;
	}

	public void setAteEntidad(EntidadDTO ateEntidad) {
		this.ateEntidad = ateEntidad;
	}

}