package ec.edu.uce.erpmunicipal.sistema.orm;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the sis_rol_permiso database table.
 * 
 */
@Entity
@Table(name = "sis_rol_permiso")
public class SisRolPermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SIS_ROL_PERMISO_ROPCODIGO_GENERATOR", sequenceName = "sis_rol_permiso_rop_codigo_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SIS_ROL_PERMISO_ROPCODIGO_GENERATOR")
	@Column(name = "rop_codigo")
	private Integer ropCodigo;

	@ManyToOne
	@JoinColumn(name = "rop_pantalla")
	private SisPantalla sisPantalla;

	// bi-directional many-to-one association to SisRole
	@ManyToOne
	@JoinColumn(name = "rop_rol")
	private SisRole sisRole;

	public SisRolPermiso() {
	}

	public Integer getRopCodigo() {
		return this.ropCodigo;
	}

	public void setRopCodigo(Integer ropCodigo) {
		this.ropCodigo = ropCodigo;
	}

	public SisPantalla getSisPantalla() {
		return this.sisPantalla;
	}

	public void setSisPantalla(SisPantalla sisPantalla) {
		this.sisPantalla = sisPantalla;
	}

	public SisRole getSisRole() {
		return this.sisRole;
	}

	public void setSisRole(SisRole sisRole) {
		this.sisRole = sisRole;
	}

}