package ec.edu.uce.besg.ejb.persistence.entity.security;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the seg_registro_login database table.
 * 
 */
@Entity
@Table(name="seg_registro_login")
@NamedQuery(name="RegistroLoginDTO.findAll", query="SELECT r FROM RegistroLoginDTO r")
public class RegistroLoginDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_REGISTRO_LOGIN_RLOCODIGO_GENERATOR", sequenceName="SEG_REGISTRO_LOGIN_RLO_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_REGISTRO_LOGIN_RLOCODIGO_GENERATOR")
	@Column(name="rlo_codigo")
	private Integer rloCodigo;

	@Column(name="rlo_fecha")
	private Timestamp rloFecha;

	//bi-directional many-to-one association to UsuarioDTO
	@ManyToOne
	@JoinColumn(name="rlo_usuario")
	private UsuarioDTO segUsuario;

	public RegistroLoginDTO() {
	}

	public Integer getRloCodigo() {
		return this.rloCodigo;
	}

	public void setRloCodigo(Integer rloCodigo) {
		this.rloCodigo = rloCodigo;
	}

	public Timestamp getRloFecha() {
		return this.rloFecha;
	}

	public void setRloFecha(Timestamp rloFecha) {
		this.rloFecha = rloFecha;
	}

	public UsuarioDTO getSegUsuario() {
		return this.segUsuario;
	}

	public void setSegUsuario(UsuarioDTO segUsuario) {
		this.segUsuario = segUsuario;
	}

}