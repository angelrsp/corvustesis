package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ind_usuario_perfil database table.
 * 
 */
@Entity
@Table(name="ind_usuario_perfil")
@NamedQuery(name="UsuarioPerfilDTO.findAll", query="SELECT u FROM UsuarioPerfilDTO u")
public class UsuarioPerfilDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_USUARIO_PERFIL_UPECODIGO_GENERATOR", sequenceName="IND_USUARIO_PERFIL_UPE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IND_USUARIO_PERFIL_UPECODIGO_GENERATOR")
	@Column(name="upe_codigo")
	private Integer upeCodigo;

	@Column(name="upe_usuario")
	private Integer upeUsuario;

	//bi-directional many-to-one association to PerfilDTO
	@ManyToOne
	@JoinColumn(name="upe_perfil")
	private PerfilDTO indPerfil;

	public UsuarioPerfilDTO() {
	}

	public Integer getUpeCodigo() {
		return this.upeCodigo;
	}

	public void setUpeCodigo(Integer upeCodigo) {
		this.upeCodigo = upeCodigo;
	}

	public Integer getUpeUsuario() {
		return this.upeUsuario;
	}

	public void setUpeUsuario(Integer upeUsuario) {
		this.upeUsuario = upeUsuario;
	}

	public PerfilDTO getIndPerfil() {
		return this.indPerfil;
	}

	public void setIndPerfil(PerfilDTO indPerfil) {
		this.indPerfil = indPerfil;
	}

}