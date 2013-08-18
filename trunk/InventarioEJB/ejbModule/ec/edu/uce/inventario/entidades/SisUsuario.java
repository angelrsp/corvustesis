package ec.edu.uce.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sis_usuario database table.
 * 
 */
@Entity
@Table(name="sis_usuario")
public class SisUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SIS_USUARIO_USRCODIGO_GENERATOR", sequenceName="SIS_USUARIO_USR_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SIS_USUARIO_USRCODIGO_GENERATOR")
	@Column(name="usr_codigo")
	private Integer usrCodigo;

	@Column(name="usr__apellido")
	private String usrApellido;

	@Column(name="usr_login")
	private String usrLogin;

	@Column(name="usr_nombre")
	private String usrNombre;

	@Column(name="usr_password")
	private String usrPassword;

	//bi-directional many-to-one association to SisPerfil
	@ManyToOne
	@JoinColumn(name="usr_perfil")
	private SisPerfil sisPerfil;

	public SisUsuario() {
	}

	public Integer getUsrCodigo() {
		return this.usrCodigo;
	}

	public void setUsrCodigo(Integer usrCodigo) {
		this.usrCodigo = usrCodigo;
	}

	public String getUsrApellido() {
		return this.usrApellido;
	}

	public void setUsrApellido(String usrApellido) {
		this.usrApellido = usrApellido;
	}

	public String getUsrLogin() {
		return this.usrLogin;
	}

	public void setUsrLogin(String usrLogin) {
		this.usrLogin = usrLogin;
	}

	public String getUsrNombre() {
		return this.usrNombre;
	}

	public void setUsrNombre(String usrNombre) {
		this.usrNombre = usrNombre;
	}

	public String getUsrPassword() {
		return this.usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public SisPerfil getSisPerfil() {
		return this.sisPerfil;
	}

	public void setSisPerfil(SisPerfil sisPerfil) {
		this.sisPerfil = sisPerfil;
	}

}