package ec.edu.uce.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sis_perfil database table.
 * 
 */
@Entity
@Table(name="sis_perfil")
public class SisPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SIS_PERFIL_PRLCODIGO_GENERATOR", sequenceName="SIS_PERFIL_PRL_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SIS_PERFIL_PRLCODIGO_GENERATOR")
	@Column(name="prl_codigo")
	private Integer prlCodigo;

	@Column(name="prl_descripcion")
	private String prlDescripcion;

	//bi-directional many-to-one association to SisPerfilOpcion
	@OneToMany(mappedBy="sisPerfil")
	private List<SisPerfilOpcion> sisPerfilOpcions;

	//bi-directional many-to-one association to SisUsuario
	@OneToMany(mappedBy="sisPerfil")
	private List<SisUsuario> sisUsuarios;

	public SisPerfil() {
	}

	public Integer getPrlCodigo() {
		return this.prlCodigo;
	}

	public void setPrlCodigo(Integer prlCodigo) {
		this.prlCodigo = prlCodigo;
	}

	public String getPrlDescripcion() {
		return this.prlDescripcion;
	}

	public void setPrlDescripcion(String prlDescripcion) {
		this.prlDescripcion = prlDescripcion;
	}

	public List<SisPerfilOpcion> getSisPerfilOpcions() {
		return this.sisPerfilOpcions;
	}

	public void setSisPerfilOpcions(List<SisPerfilOpcion> sisPerfilOpcions) {
		this.sisPerfilOpcions = sisPerfilOpcions;
	}

	public SisPerfilOpcion addSisPerfilOpcion(SisPerfilOpcion sisPerfilOpcion) {
		getSisPerfilOpcions().add(sisPerfilOpcion);
		sisPerfilOpcion.setSisPerfil(this);

		return sisPerfilOpcion;
	}

	public SisPerfilOpcion removeSisPerfilOpcion(SisPerfilOpcion sisPerfilOpcion) {
		getSisPerfilOpcions().remove(sisPerfilOpcion);
		sisPerfilOpcion.setSisPerfil(null);

		return sisPerfilOpcion;
	}

	public List<SisUsuario> getSisUsuarios() {
		return this.sisUsuarios;
	}

	public void setSisUsuarios(List<SisUsuario> sisUsuarios) {
		this.sisUsuarios = sisUsuarios;
	}

	public SisUsuario addSisUsuario(SisUsuario sisUsuario) {
		getSisUsuarios().add(sisUsuario);
		sisUsuario.setSisPerfil(this);

		return sisUsuario;
	}

	public SisUsuario removeSisUsuario(SisUsuario sisUsuario) {
		getSisUsuarios().remove(sisUsuario);
		sisUsuario.setSisPerfil(null);

		return sisUsuario;
	}

}