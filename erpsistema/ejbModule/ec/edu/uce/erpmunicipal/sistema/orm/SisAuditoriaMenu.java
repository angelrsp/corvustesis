package ec.edu.uce.erpmunicipal.sistema.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sis_auditoria_menu database table.
 * 
 */
@Entity
@Table(name="sis_auditoria_menu")
public class SisAuditoriaMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SIS_AUDITORIA_MENU_AMECODIGO_GENERATOR", sequenceName="sis_auditoria_menu_ame_codigo_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SIS_AUDITORIA_MENU_AMECODIGO_GENERATOR")
	@Column(name="ame_codigo")
	private Integer ameCodigo;

	@Column(name="ame_dipositivo")
	private String ameDipositivo;

	@Column(name="ame_fecha")
	private Timestamp ameFecha;

	@Column(name="ame_opcion")
	private Integer ameOpcion;

	//bi-directional many-to-one association to SisUsuario
	@ManyToOne
	@JoinColumn(name="ame_usuario")
	private SisUsuario sisUsuario;

	public SisAuditoriaMenu() {
	}

	public Integer getAmeCodigo() {
		return this.ameCodigo;
	}

	public void setAmeCodigo(Integer ameCodigo) {
		this.ameCodigo = ameCodigo;
	}

	public String getAmeDipositivo() {
		return this.ameDipositivo;
	}

	public void setAmeDipositivo(String ameDipositivo) {
		this.ameDipositivo = ameDipositivo;
	}

	public Timestamp getAmeFecha() {
		return this.ameFecha;
	}

	public void setAmeFecha(Timestamp ameFecha) {
		this.ameFecha = ameFecha;
	}

	public Integer getAmeOpcion() {
		return this.ameOpcion;
	}

	public void setAmeOpcion(Integer ameOpcion) {
		this.ameOpcion = ameOpcion;
	}

	public SisUsuario getSisUsuario() {
		return this.sisUsuario;
	}

	public void setSisUsuario(SisUsuario sisUsuario) {
		this.sisUsuario = sisUsuario;
	}

}