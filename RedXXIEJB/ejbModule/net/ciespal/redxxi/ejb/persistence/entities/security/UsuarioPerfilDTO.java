package net.ciespal.redxxi.ejb.persistence.entities.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seg_usuario_perfil database table.
 * 
 */
@Entity
@Table(name="seg_usuario_perfil")
@NamedQuery(name="UsuarioPerfilDTO.findAll", query="SELECT u FROM UsuarioPerfilDTO u")
public class UsuarioPerfilDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_USUARIO_PERFIL_UPECODIGO_GENERATOR", sequenceName="SEG_USUARIO_PERFIL_UPE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_USUARIO_PERFIL_UPECODIGO_GENERATOR")
	@Column(name="upe_codigo")
	private Integer upeCodigo;

	//bi-directional many-to-one association to PerfilDTO
	@ManyToOne
	@JoinColumn(name="upe_perfil")
	private PerfilDTO segPerfil;

	//bi-directional many-to-one association to UsuarioDTO
	@ManyToOne
	@JoinColumn(name="upe_usuario")
	private UsuarioDTO segUsuario;

	public UsuarioPerfilDTO() {
	}

	public Integer getUpeCodigo() {
		return this.upeCodigo;
	}

	public void setUpeCodigo(Integer upeCodigo) {
		this.upeCodigo = upeCodigo;
	}

	public PerfilDTO getSegPerfil() {
		return this.segPerfil;
	}

	public void setSegPerfil(PerfilDTO segPerfil) {
		this.segPerfil = segPerfil;
	}

	public UsuarioDTO getSegUsuario() {
		return this.segUsuario;
	}

	public void setSegUsuario(UsuarioDTO segUsuario) {
		this.segUsuario = segUsuario;
	}

}