package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the seg_history_password database table.
 * 
 */
@Entity
@Table(name="seg_history_password")
@NamedQuery(name="HistoryPasswordDTO.findAll", query="SELECT h FROM HistoryPasswordDTO h")
public class HistoryPasswordDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_HISTORY_PASSWORD_HPACODIGO_GENERATOR", sequenceName="SEG_HISTORY_PASSWORD_HPA_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_HISTORY_PASSWORD_HPACODIGO_GENERATOR")
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

	public HistoryPasswordDTO() {
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