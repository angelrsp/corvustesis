package ec.edu.uce.silsae.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bem_perfil database table.
 * 
 */
@Entity
@Table(name="bem_perfil")
public class PerfilDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_PERFIL_PERCODIGO_GENERATOR", sequenceName="BEM_PERFIL_PER_CODIGO_SEQ", allocationSize=1)
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
	
	public List<UsuarioDTO> getBemUsuarios() {
		return this.bemUsuarios;
	}

	public void setBemUsuarios(List<UsuarioDTO> bemUsuarios) {
		this.bemUsuarios = bemUsuarios;
	}
	
}