package ec.edu.uce.besg.ejb.persistence.entity.security;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the seg_historial_password database table.
 * 
 */
@Entity
@Table(name="seg_historial_password")
@NamedQuery(name="HistorialPasswordDTO.findAll", query="SELECT h FROM HistorialPasswordDTO h")
public class HistorialPasswordDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_HISTORIAL_PASSWORD_HPACODIGO_GENERATOR", sequenceName="SEG_HISTORIAL_PASSWORD_HPA_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_HISTORIAL_PASSWORD_HPACODIGO_GENERATOR")
	@Column(name="hpa_codigo")
	private Integer hpaCodigo;

	@Column(name="hpa_fecha")
	private Timestamp hpaFecha;

	@Column(name="hpa_password")
	private String hpaPassword;

	//bi-directional many-to-one association to UsuarioDTO
	@ManyToOne
	@JoinColumn(name="hpa_usuario")
	private UsuarioDTO segUsuario;

	public HistorialPasswordDTO() {
	}

	public Integer getHpaCodigo() {
		return this.hpaCodigo;
	}

	public void setHpaCodigo(Integer hpaCodigo) {
		this.hpaCodigo = hpaCodigo;
	}

	public Timestamp getHpaFecha() {
		return this.hpaFecha;
	}

	public void setHpaFecha(Timestamp hpaFecha) {
		this.hpaFecha = hpaFecha;
	}

	public String getHpaPassword() {
		return this.hpaPassword;
	}

	public void setHpaPassword(String hpaPassword) {
		this.hpaPassword = hpaPassword;
	}

	public UsuarioDTO getSegUsuario() {
		return this.segUsuario;
	}

	public void setSegUsuario(UsuarioDTO segUsuario) {
		this.segUsuario = segUsuario;
	}

}