package ec.edu.uce.erpmunicipal.sistema.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sis_usuario_rol database table.
 * 
 */
@Entity
@Table(name="sis_usuario_rol")
public class SisUsuarioRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SIS_USUARIO_ROL_USRCODIGO_GENERATOR", sequenceName="sis_usuario_rol_usr_codigo_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SIS_USUARIO_ROL_USRCODIGO_GENERATOR")
	@Column(name="usr_codigo")
	private Integer usrCodigo;

	@Column(name="usr_activo")
	private Boolean usrActivo;

	@Column(name="usr_fecha_cambio")
	private Timestamp usrFechaCambio;

	//bi-directional many-to-one association to SisRole
	@ManyToOne
	@JoinColumn(name="usr_rol")
	private SisRole sisRole;

	//bi-directional many-to-one association to SisUsuario
	@ManyToOne
	@JoinColumn(name="usr_usuario")
	private SisUsuario sisUsuario;

	public SisUsuarioRol() {
	}

	public Integer getUsrCodigo() {
		return this.usrCodigo;
	}

	public void setUsrCodigo(Integer usrCodigo) {
		this.usrCodigo = usrCodigo;
	}

	public Boolean getUsrActivo() {
		return this.usrActivo;
	}

	public void setUsrActivo(Boolean usrActivo) {
		this.usrActivo = usrActivo;
	}

	public Timestamp getUsrFechaCambio() {
		return this.usrFechaCambio;
	}

	public void setUsrFechaCambio(Timestamp usrFechaCambio) {
		this.usrFechaCambio = usrFechaCambio;
	}

	public SisRole getSisRole() {
		return this.sisRole;
	}

	public void setSisRole(SisRole sisRole) {
		this.sisRole = sisRole;
	}

	public SisUsuario getSisUsuario() {
		return this.sisUsuario;
	}

	public void setSisUsuario(SisUsuario sisUsuario) {
		this.sisUsuario = sisUsuario;
	}

}