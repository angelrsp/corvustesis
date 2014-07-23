package net.ciespal.redxxi.ejb.persistence.entities.security;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the seg_comentario database table.
 * 
 */
@Entity
@Table(name="seg_comentario")
@NamedQuery(name="ComentarioDTO.findAll", query="SELECT c FROM ComentarioDTO c")
public class ComentarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_COMENTARIO_COMCODIGO_GENERATOR", sequenceName="SEG_COMENTARIO_COM_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_COMENTARIO_COMCODIGO_GENERATOR")
	@Column(name="com_codigo")
	private Integer comCodigo;

	@Column(name="com_archivo")
	private byte[] comArchivo;

	@Column(name="com_archivo_nombre")
	private String comArchivoNombre;

	@Column(name="com_descripcion")
	private String comDescripcion;

	@Column(name="com_estado")
	private Boolean comEstado;

	@Column(name="com_fecha")
	private Timestamp comFecha;

	//bi-directional many-to-one association to UsuarioDTO
	@ManyToOne
	@JoinColumn(name="com_usuario")
	private UsuarioDTO segUsuario;

	public ComentarioDTO() {
	}

	public Integer getComCodigo() {
		return this.comCodigo;
	}

	public void setComCodigo(Integer comCodigo) {
		this.comCodigo = comCodigo;
	}

	public byte[] getComArchivo() {
		return this.comArchivo;
	}

	public void setComArchivo(byte[] comArchivo) {
		this.comArchivo = comArchivo;
	}

	public String getComArchivoNombre() {
		return this.comArchivoNombre;
	}

	public void setComArchivoNombre(String comArchivoNombre) {
		this.comArchivoNombre = comArchivoNombre;
	}

	public String getComDescripcion() {
		return this.comDescripcion;
	}

	public void setComDescripcion(String comDescripcion) {
		this.comDescripcion = comDescripcion;
	}

	public Boolean getComEstado() {
		return this.comEstado;
	}

	public void setComEstado(Boolean comEstado) {
		this.comEstado = comEstado;
	}

	public Timestamp getComFecha() {
		return this.comFecha;
	}

	public void setComFecha(Timestamp comFecha) {
		this.comFecha = comFecha;
	}

	public UsuarioDTO getSegUsuario() {
		return this.segUsuario;
	}

	public void setSegUsuario(UsuarioDTO segUsuario) {
		this.segUsuario = segUsuario;
	}

}