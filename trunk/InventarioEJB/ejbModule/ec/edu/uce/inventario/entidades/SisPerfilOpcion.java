package ec.edu.uce.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sis_perfil_opcion database table.
 * 
 */
@Entity
@Table(name="sis_perfil_opcion")
public class SisPerfilOpcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SIS_PERFIL_OPCION_POPCODIGO_GENERATOR", sequenceName="SIS_PERFIL_OPCION_POP_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SIS_PERFIL_OPCION_POPCODIGO_GENERATOR")
	@Column(name="pop_codigo")
	private Integer popCodigo;

	//bi-directional many-to-one association to SisOpcion
	@ManyToOne
	@JoinColumn(name="pop_opcion")
	private SisOpcion sisOpcion;

	//bi-directional many-to-one association to SisPerfil
	@ManyToOne
	@JoinColumn(name="pop_perfil")
	private SisPerfil sisPerfil;

	public SisPerfilOpcion() {
	}

	public Integer getPopCodigo() {
		return this.popCodigo;
	}

	public void setPopCodigo(Integer popCodigo) {
		this.popCodigo = popCodigo;
	}

	public SisOpcion getSisOpcion() {
		return this.sisOpcion;
	}

	public void setSisOpcion(SisOpcion sisOpcion) {
		this.sisOpcion = sisOpcion;
	}

	public SisPerfil getSisPerfil() {
		return this.sisPerfil;
	}

	public void setSisPerfil(SisPerfil sisPerfil) {
		this.sisPerfil = sisPerfil;
	}

}