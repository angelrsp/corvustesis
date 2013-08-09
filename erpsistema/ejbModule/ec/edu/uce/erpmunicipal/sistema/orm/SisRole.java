package ec.edu.uce.erpmunicipal.sistema.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sis_roles database table.
 * 
 */
@Entity
@Table(name="sis_roles")
public class SisRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SIS_ROLES_ROLCODIGO_GENERATOR", sequenceName="sis_roles_rol_codigo_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SIS_ROLES_ROLCODIGO_GENERATOR")
	@Column(name="rol_codigo")
	private Integer rolCodigo;

	@Column(name="rol_descripcion")
	private String rolDescripcion;

	//bi-directional many-to-one association to SisRolPermiso
	@OneToMany(mappedBy="sisRole")
	private List<SisRolPermiso> sisRolPermisos;

	//bi-directional many-to-one association to SisUsuarioRol
	@OneToMany(mappedBy="sisRole")
	private List<SisUsuarioRol> sisUsuarioRols;

	public SisRole() {
	}

	public Integer getRolCodigo() {
		return this.rolCodigo;
	}

	public void setRolCodigo(Integer rolCodigo) {
		this.rolCodigo = rolCodigo;
	}

	public String getRolDescripcion() {
		return this.rolDescripcion;
	}

	public void setRolDescripcion(String rolDescripcion) {
		this.rolDescripcion = rolDescripcion;
	}

	public List<SisRolPermiso> getSisRolPermisos() {
		return this.sisRolPermisos;
	}

	public void setSisRolPermisos(List<SisRolPermiso> sisRolPermisos) {
		this.sisRolPermisos = sisRolPermisos;
	}

	public List<SisUsuarioRol> getSisUsuarioRols() {
		return this.sisUsuarioRols;
	}

	public void setSisUsuarioRols(List<SisUsuarioRol> sisUsuarioRols) {
		this.sisUsuarioRols = sisUsuarioRols;
	}

}