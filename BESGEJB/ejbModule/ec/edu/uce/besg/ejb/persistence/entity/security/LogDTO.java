package ec.edu.uce.besg.ejb.persistence.entity.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seg_log database table.
 * 
 */
@Entity
@Table(name="seg_log")
@NamedQuery(name="LogDTO.findAll", query="SELECT l FROM LogDTO l")
public class LogDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_LOG_LOGCODIGO_GENERATOR", sequenceName="SEG_LOG_LOG_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_LOG_LOGCODIGO_GENERATOR")
	@Column(name="log_codigo")
	private Integer logCodigo;

	@Column(name="log_control")
	private String logControl;

	@Column(name="log_ip")
	private String logIp;

	@Column(name="log_url")
	private String logUrl;

	//bi-directional many-to-one association to UsuarioDTO
	@ManyToOne
	@JoinColumn(name="log_usuario")
	private UsuarioDTO segUsuario;

	public LogDTO() {
	}

	public Integer getLogCodigo() {
		return this.logCodigo;
	}

	public void setLogCodigo(Integer logCodigo) {
		this.logCodigo = logCodigo;
	}

	public String getLogControl() {
		return this.logControl;
	}

	public void setLogControl(String logControl) {
		this.logControl = logControl;
	}

	public String getLogIp() {
		return this.logIp;
	}

	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}

	public String getLogUrl() {
		return this.logUrl;
	}

	public void setLogUrl(String logUrl) {
		this.logUrl = logUrl;
	}

	public UsuarioDTO getSegUsuario() {
		return this.segUsuario;
	}

	public void setSegUsuario(UsuarioDTO segUsuario) {
		this.segUsuario = segUsuario;
	}

}