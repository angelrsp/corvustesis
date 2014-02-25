package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
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

	@Column(name="not_resumen")
	private String notResumen;

	@Column(name="not_destacado")
	private Boolean notDestacado;

	@Column(name="not_activo")
	private Boolean notActivo;
	
	@Column(name="not_fecha")
	private Timestamp notFecha;

	@Column(name="not_titulo")
	private String notTitulo;


	//bi-directional many-to-one association to EntidadDTO
	@OneToMany(mappedBy="ateNoticia")
	private List<EntidadDTO> ateEntidads;

	public NoticiaDTO() {
		this.notActivo=true;
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

	public String getNotResumen() {
		return notResumen;
	}

	public void setNotResumen(String notResumen) {
		this.notResumen = notResumen;
	}

	public Boolean getNotDestacado() {
		return notDestacado;
	}

	public void setNotDestacado(Boolean notDestacado) {
		this.notDestacado = notDestacado;
	}

	public Boolean getNotActivo() {
		return notActivo;
	}

	public void setNotActivo(Boolean notActivo) {
		this.notActivo = notActivo;
	}

	public Timestamp getNotFecha() {
		return notFecha;
	}

	public void setNotFecha(Timestamp notFecha) {
		this.notFecha = notFecha;
	}

	public String getNotTitulo() {
		return notTitulo;
	}

	public void setNotTitulo(String notTitulo) {
		this.notTitulo = notTitulo;
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