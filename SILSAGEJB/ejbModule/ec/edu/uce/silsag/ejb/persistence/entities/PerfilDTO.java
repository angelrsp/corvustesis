package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bem_perfil database table.
 * 
 */
@Entity
@Table(name="bem_perfil")
@NamedQuery(name="PerfilDTO.findAll", query="SELECT p FROM PerfilDTO p")
public class PerfilDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_PERFIL_PERCODIGO_GENERATOR", sequenceName="BEM_PERFIL_PER_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_PERFIL_PERCODIGO_GENERATOR")
	@Column(name="per_codigo")
	private Integer perCodigo;

	@Column(name="per_descripcion")
	private String perDescripcion;

	//bi-directional many-to-one association to PerfilPermisoDTO
	@OneToMany(mappedBy="bemPerfil")
	private List<PerfilPermisoDTO> bemPerfilPermisos;

	//bi-directional many-to-one association to UsuarioDTO
	@OneToMany(mappedBy="bemPerfil")
	private List<UsuarioDTO> bemUsuarios;

	public PerfilDTO() {
	}

	public Integer getPerCodigo() {
		return this.perCodigo;
	}

	public void setPerCodigo(Integer perCodigo) {
		this.perCodigo = perCodigo;
	}

	public String getPerDescripcion() {
		return this.perDescripcion;
	}

	public void setPerDescripcion(String perDescripcion) {
		this.perDescripcion = perDescripcion;
	}

	public List<PerfilPermisoDTO> getBemPerfilPermisos() {
		return this.bemPerfilPermisos;
	}

	public void setBemPerfilPermisos(List<PerfilPermisoDTO> bemPerfilPermisos) {
		this.bemPerfilPermisos = bemPerfilPermisos;
	}

	public PerfilPermisoDTO addBemPerfilPermiso(PerfilPermisoDTO bemPerfilPermiso) {
		getBemPerfilPermisos().add(bemPerfilPermiso);
		bemPerfilPermiso.setBemPerfil(this);

		return bemPerfilPermiso;
	}

	public PerfilPermisoDTO removeBemPerfilPermiso(PerfilPermisoDTO bemPerfilPermiso) {
		getBemPerfilPermisos().remove(bemPerfilPermiso);
		bemPerfilPermiso.setBemPerfil(null);

		return bemPerfilPermiso;
	}

	public List<UsuarioDTO> getBemUsuarios() {
		return this.bemUsuarios;
	}

	public void setBemUsuarios(List<UsuarioDTO> bemUsuarios) {
		this.bemUsuarios = bemUsuarios;
	}

	public UsuarioDTO addBemUsuario(UsuarioDTO bemUsuario) {
		getBemUsuarios().add(bemUsuario);
		bemUsuario.setBemPerfil(this);

		return bemUsuario;
	}

	public UsuarioDTO removeBemUsuario(UsuarioDTO bemUsuario) {
		getBemUsuarios().remove(bemUsuario);
		bemUsuario.setBemPerfil(null);

		return bemUsuario;
	}

}